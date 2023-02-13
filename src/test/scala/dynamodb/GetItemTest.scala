package com.filippodeluca.jsfacade.aws
package dynamodb

import scalajs.js

class GetItemTest extends munit.CatsEffectSuite with DynamoDbFixtures {

  ResourceFunFixture {
    for {
      client <- clientR
      tableName <- simpleTableR(client, "id")
    } yield (client, tableName)
  }.test("send GetItem should not fail") { case (client, tableName) =>
    client
      .sendIO(
        GetItemCommand(
          GetItemCommandInput(
            TableName = tableName,
            Key = js.Dictionary("id" -> AttributeValue.S("test"))
          )
        )
      )
      .void
      .assert
  }

  ResourceFunFixture {
    for {
      client <- clientR
      tableName <- simpleTableR(client, "id")
    } yield (client, tableName)
  }.test("send GetItem should retrieve an existing item") {
    case (client, tableName) =>
      val putItem = client.sendIO(
        PutItemCommand(
          PutItemCommandInput(
            TableName = tableName,
            Item = js.Dictionary("id" -> AttributeValue.S("test"))
          )
        )
      )

      val getItem = client
        .sendIO(
          new GetItemCommand(
            GetItemCommandInput(
              TableName = tableName,
              Key = js.Dictionary("id" -> AttributeValue.S("test"))
            )
          )
        )

      (for {
        _ <- putItem
        item <- getItem
      } yield item)
        .map(_.Item)
        .map { item =>
          js.JSON.stringify(item)
        }
        .assertEquals(
          js.JSON.stringify(js.Dictionary("id" -> AttributeValue.S("test")))
        )

  }

}
