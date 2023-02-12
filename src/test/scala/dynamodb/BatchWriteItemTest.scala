package com.filippodeluca.jsfacade.aws
package dynamodb

import cats.syntax.all._
import cats.effect._

import scalajs.js
import scalajs.js.JSConverters._

class BatchWriteItemTest
    extends munit.CatsEffectSuite
    with DynamoDbFixtures
    with ScalaJsAssertions {

  ResourceFunFixture {
    for {
      client <- clientR
      tableName <- simpleTableR(client, "id")
    } yield (client, tableName)
  }.test("BatchWriteItem should write multiple Items") {
    case (client, tableName) =>
      val itemOne = js.Dictionary(
        "id" -> AttributeValue.S("testOne"),
        "foo" -> AttributeValue.S("bar")
      )

      val itemTwo = js.Dictionary(
        "id" -> AttributeValue.S("testTwo"),
        "foo" -> AttributeValue.S("bar")
      )

      val putItems = client
        .sendIO(
          BatchWriteItemCommand(
            BatchWriteItemCommandInput(
              js.Dictionary(
                tableName ->
                  js.Array(
                    WriteRequest.putRequest(PutRequest(itemOne)),
                    WriteRequest.putRequest(PutRequest(itemTwo))
                  )
              )
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
        _ <- putItems
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
