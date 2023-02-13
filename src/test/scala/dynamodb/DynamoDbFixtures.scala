package com.filippodeluca.jsfacade.aws
package dynamodb

import cats.effect._
import cats.effect.std.Env

import scalajs.js.JSConverters._

trait DynamoDbFixtures {
  self: munit.FunSuite =>

  implicit class RichDynamoDbClient(client: DynamoDBClient) {
    def sendIO[Input, Output](cmd: Command[Input, Output]) = IO.fromPromise {
      IO {
        client.send(cmd)
      }
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
      .eval(IO { new java.util.Random().nextInt })
      .map(id => s"table-${id.toString}")
      .flatMap { tableName =>
        Resource.make {

          val command = CreateTableCommand(
            CreateTableCommandInput(
              TableName = tableName,
              AttributeDefinitions = attributeDefinitions.toJSArray,
              KeySchema = keySchema.toJSArray,
              BillingMode = "PAY_PER_REQUEST",
              GlobalSecondaryIndexes =
                globalSecondaryIndexes.map(_.toJSArray).orUndefined,
              LocalSecondaryIndexes =
                localSecondaryIndexes.map(_.toJSArray).orUndefined
            )
          )

          client.sendIO(command).as(tableName)
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
    List(AttributeDefinition(AttributeName = hashKeyName, AttributeType = "S")),
    List(
      KeySchemaElement(
        AttributeName = hashKeyName,
        KeyType = "HASH"
      )
    )
  )

}
