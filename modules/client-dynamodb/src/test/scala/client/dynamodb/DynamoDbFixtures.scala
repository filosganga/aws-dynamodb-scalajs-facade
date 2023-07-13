package com.filippodeluca.jsfacade.awssdk
package client
package dynamodb

import java.util.concurrent.TimeoutException
import scala.concurrent.duration._

import cats.effect._
import cats.effect.std.Env
import cats.syntax.all._

import scalajs.js.JSConverters._
import models._
import commands._

trait DynamoDbFixtures {
  self: munit.FunSuite =>

  implicit class RichDynamoDbClient(client: DynamoDBClient) {
    def sendIO[Input, Output](cmd: Command[Input, Output]) = IO
      .fromPromise {
        IO {
          client.send(cmd)
        }
      }
      .onError { e =>
        cats.effect.std
          .Console[IO]
          .errorln(s"Error sending DynamoDb request: ${e.getMessage}")
      }

  }

  def clientR =
    Resource.eval(Env[IO].get("DYNAMODB_ENDPOINT")).flatMap { endpoint =>
      Resource.make {
        IO {
          val config =
            DynamoDBClientConfig(
              region = "eu-west-1",
              endpoint = endpoint.orUndefined
            )
          new DynamoDBClient(config)
        }
      }(c => IO(c.destroy()))
    }

  def tableR(client: DynamoDBClient)(
      attributeDefinitions: List[AttributeDefinition],
      keySchema: List[KeySchemaElement],
      globalSecondaryIndexes: Option[List[GlobalSecondaryIndex]] = None,
      localSecondaryIndexes: Option[List[LocalSecondaryIndex]] = None
  ) =
    Resource
      .eval(IO { new java.util.Random().nextInt.abs })
      .map(id => s"test-${id.toString}")
      .flatMap { tableName =>
        Resource.make {

          def waitForTbleToBecomeActive(timeout: FiniteDuration): IO[Unit] = {

            val pause = 5.seconds

            val checkTableIsActive = client
              .sendIO(
                DescribeTableCommand(
                  DescribeTableCommandInput(TableName = tableName)
                )
              )
              .map(
                _.Table.exists(_.TableStatus.exists(_ == TableStatus.Active))
              )

            checkTableIsActive.ifM(
              IO.unit,
              if (timeout <= Duration.Zero) {
                IO.raiseError[Unit](
                  new TimeoutException(
                    s"Table ${tableName} did not become active in time"
                  )
                )
              } else {
                IO.sleep(pause) >> waitForTbleToBecomeActive(
                  timeout - pause // This is a bit sloppy but it is ok
                )
              }
            )
          }

          val createTable = client
            .sendIO(
              CreateTableCommand(
                CreateTableCommandInput(
                  TableName = tableName,
                  AttributeDefinitions = attributeDefinitions.toJSArray,
                  KeySchema = keySchema.toJSArray,
                  BillingMode = BillingMode.PayPerRequest,
                  GlobalSecondaryIndexes =
                    globalSecondaryIndexes.map(_.toJSArray).orUndefined,
                  LocalSecondaryIndexes =
                    localSecondaryIndexes.map(_.toJSArray).orUndefined
                )
              )
            )
            .as(tableName)

          createTable >> waitForTbleToBecomeActive(30.seconds) >> tableName
            .pure[IO]

        } { tableName =>
          val command = DeleteTableCommand(
            DeleteTableCommandInput(TableName = tableName)
          )
          client.sendIO(command).void
        }
      }

  def simpleTableR(client: DynamoDBClient, hashKeyName: String) = tableR(
    client
  )(
    List(
      AttributeDefinition(
        AttributeName = hashKeyName,
        AttributeType = ScalarAttributeType.S
      )
    ),
    List(
      KeySchemaElement(
        AttributeName = hashKeyName,
        KeyType = KeyType.Hash
      )
    )
  )

}
