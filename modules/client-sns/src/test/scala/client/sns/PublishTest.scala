package com.filippodeluca.jsfacade.awssdk
package client
package sns

import cats.effect.IO
import cats.syntax.all._

import scalajs.js
import models._
import commands._

class PublishTest extends munit.CatsEffectSuite with SnsFixtures {

  ResourceFunFixture {
    for {
      client <- clientR
      tableName <- topicR(client)
    } yield (client, tableName)
  }.test("Publish should return MessageId") { case (client, topicArn) =>
    val response = client
      .sendIO(
        PublishCommand(
          PublishCommandInput(
            Message = "Test",
            TopicArn = topicArn,
            MessageAttributes = js.Dictionary(
              "foo" -> MessageAttributeValue("String", StringValue = "bar")
            )
          )
        )
      )
      .onError { e =>
        IO.println(show"Error publishing: ${e.getMessage()}")
      }

    response.map(_.MessageId.length > 0).assertEquals(true)
  }

}
