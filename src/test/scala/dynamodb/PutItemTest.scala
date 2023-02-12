package com.filippodeluca.jsfacade.aws
package dynamodb

import cats.syntax.all._
import cats.effect._

import scalajs.js
import scalajs.js.JSConverters._

class PutItemTest
    extends munit.CatsEffectSuite
    with DynamoDbFixtures
    with ScalaJsAssertions {

  ResourceFunFixture {
    for {
      client <- clientR
      tableName <- simpleTableR(client, "id")
    } yield (client, tableName)
  }.test("PutItem should return old attributes when ReturnValues = AllOld ") {
    case (client, tableName) =>
      val itemOne = js.Dictionary(
        "id" -> AttributeValue.S("test"),
        "foo" -> AttributeValue.S("bar")
      )

      val itemTwo =
        js.Dictionary(
          "id" -> AttributeValue.S("test"),
          "foo" -> AttributeValue.S("bar")
        )

      val putItemOne = client
        .sendIO(
          PutItemCommand(
            PutItemCommandInput(
              TableName = tableName,
              Item = itemOne
            )
          )
        )

      val putItemTwo = client
        .sendIO(
          PutItemCommand(
            PutItemCommandInput(
              TableName = tableName,
              Item = itemTwo,
              ReturnValues = ReturnValues.AllOld
            )
          )
        )

      (for {
        _ <- putItemOne
        result <- putItemTwo
      } yield result.Attributes).map { attributes =>
        assertEquals(attributes.get, itemOne)
      }

  }

}
