package com.filippodeluca.jsfacade.awssdk
package client
package sns

import cats.effect._
import cats.effect.std.Env
import cats.syntax.all._

import scalajs.js.JSConverters._
import models._
import commands._

trait SnsFixtures {
  self: munit.FunSuite =>

  implicit class RichSNSClient(client: SNSClient) {
    def sendIO[Input, Output](cmd: Command[Input, Output]) = IO.fromPromise {
      IO {
        client.send(cmd)
      }
    }

  }

  def clientR =
    Resource.eval(Env[IO].get("SNS_ENDPOINT")).flatMap { endpoint =>
      Resource.make {
        IO {
          val config =
            SNSClientConfig(
              region = "eu-west-1",
              endpoint = endpoint.orUndefined
            )
          new SNSClient(config)
        }
      }(c => IO(c.destroy()))
    }

  def topicR(client: SNSClient) = Resource
    .eval(IO { new java.util.Random().nextInt.abs })
    .map(id => s"topic-${id.toString}")
    .flatMap { topicName =>
      Resource
        .make {
          val command = CreateTopicCommand(
            CreateTopicCommandInput(
              Name = topicName
            )
          )
          client.sendIO(command).map(_.TopicArn).onError { e =>
            IO.println(show"Error creating topic: ${e.getMessage()}")
          }
        } { topicName =>
          val command = DeleteTopicCommand(
            DeleteTopicCommandInput(TopicArn = topicName)
          )
          client.sendIO(command).void.onError { e =>
            IO.println(show"Error deleting topic: ${e.getMessage()}")
          }
        }
    }
}
