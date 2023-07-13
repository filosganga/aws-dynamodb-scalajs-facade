package com.filippodeluca.jsfacade.awssdk
package client
package sns

import cats.effect.IO
import cats.syntax.all._

import scalajs.js
import models._
import commands._

class PublishBatchTest extends munit.CatsEffectSuite with SnsFixtures {

  ResourceFunFixture {
    for {
      client <- clientR
      tableName <- topicR(client)
    } yield (client, tableName)
  }.test("PublishBatch should return the successfull Ids") {
    case (client, topicArn) =>
      val response = client
        .sendIO(
          PublishBatchCommand(
            PublishBatchCommandInput(
              TopicArn = topicArn,
              PublishBatchRequestEntries = js.Array(
                PublishBatchRequestEntry(
                  "1",
                  "one"
                ),
                PublishBatchRequestEntry(
                  "2",
                  "two"
                )
              )
            )
          )
        )
        .onError { e =>
          IO.println(show"Error publishing: ${e.getMessage()}")
        }

      response
        .flatMap { response =>
          IO.fromOption(response.Successful.toOption)(new RuntimeException)
        }
        .map { xs =>
          xs.length
        }
        .assertEquals(2)
  }

}
