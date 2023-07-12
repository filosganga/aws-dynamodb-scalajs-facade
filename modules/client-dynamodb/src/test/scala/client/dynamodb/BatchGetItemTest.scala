package com.filippodeluca.jsfacade.awssdk
package client
package dynamodb

import cats.syntax.all._

import scalajs.js
import models._
import commands._

class BatchGetItemTest
    extends munit.CatsEffectSuite
    with DynamoDbFixtures
    with ScalaJsAssertions {

  ResourceFunFixture {
    for {
      client <- clientR
      tableName <- simpleTableR(client, "id")
    } yield (client, tableName)
  }.test("BatchGetItemTest should return multiple Items") {
    case (client, tableName) =>
      val itemOne = js.Dictionary(
        "id" -> AttributeValue.S("testOne"),
        "foo" -> AttributeValue.S("bar")
      )

      val itemTwo = js.Dictionary(
        "id" -> AttributeValue.S("testTwo"),
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
              Item = itemTwo
            )
          )
        )

      val batchGetItems = client
        .sendIO(
          BatchGetItemCommand(
            BatchGetItemCommandInput(
              RequestItems = js.Dictionary(
                tableName -> KeysAndAttributes(
                  Keys = js.Array(
                    js.Dictionary("id" -> AttributeValue.S("testOne")),
                    js.Dictionary("id" -> AttributeValue.S("testTwo"))
                  ),
                  ConsistentRead = true
                )
              )
            )
          )
        )

      val result = (for {
        _ <- putItemOne
        _ <- putItemTwo
        result <- batchGetItems
      } yield result.Responses.get)

      result
        .map { dict =>
          dict(tableName)
        }
        .map { xs =>
          assertEquals(xs.toSet, Set(itemOne, itemTwo))
        }

  }

}
