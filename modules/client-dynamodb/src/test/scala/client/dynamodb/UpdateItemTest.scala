package com.filippodeluca.jsfacade.awssdkv
package client
package dynamodb

import cats.syntax.all._

import scalajs.js

import models._
import commands._

class UpdateItemTest
    extends munit.CatsEffectSuite
    with DynamoDbFixtures
    with ScalaJsAssertions {

  ResourceFunFixture {
    for {
      client <- clientR
      tableName <- simpleTableR(client, "id")
    } yield (client, tableName)
  }.test("UpdateItem should update an item") { case (client, tableName) =>
    val item = js.Dictionary(
      "id" -> AttributeValue.S("test"),
      "foo" -> AttributeValue.S("bar")
    )

    val expectedItem = js.Dictionary(
      "id" -> AttributeValue.S("test"),
      "foo" -> AttributeValue.S("baz")
    )

    val putItem = client
      .sendIO(
        PutItemCommand(
          PutItemCommandInput(
            TableName = tableName,
            Item = item
          )
        )
      )

    val updateItem = client
      .sendIO(
        UpdateItemCommand(
          UpdateItemCommandInput(
            TableName = tableName,
            Key = js
              .Dictionary(
                "id" -> AttributeValue.S("test")
              ),
            UpdateExpression = "SET #foo = :val",
            ExpressionAttributeNames = js
              .Dictionary(
                "#foo" -> "foo"
              ),
            ExpressionAttributeValues = js
              .Dictionary(
                ":val" -> AttributeValue.S("baz")
              )
          )
        )
      )

    val getItem = client.sendIO(
      GetItemCommand(
        GetItemCommandInput(
          TableName = tableName,
          Key = js
            .Dictionary(
              "id" -> AttributeValue.S("test")
            ),
          ConsistentRead = true
        )
      )
    )

    (for {
      _ <- putItem
      _ <- updateItem
      result <- getItem
    } yield result.Item).map { attributes =>
      assertEquals(attributes.get, expectedItem)
    }
  }

  ResourceFunFixture {
    for {
      client <- clientR
      tableName <- simpleTableR(client, "id")
    } yield (client, tableName)
  }.test("UpdateItem should update return all old attributes") {
    case (client, tableName) =>
      val item = js.Dictionary(
        "id" -> AttributeValue.S("test"),
        "foo" -> AttributeValue.S("bar")
      )

      val putItem = client
        .sendIO(
          PutItemCommand(
            PutItemCommandInput(
              TableName = tableName,
              Item = item
            )
          )
        )

      val updateItem = client
        .sendIO(
          UpdateItemCommand(
            UpdateItemCommandInput(
              TableName = tableName,
              Key = js
                .Dictionary(
                  "id" -> AttributeValue.S("test")
                ),
              UpdateExpression = "SET foo = :val",
              ExpressionAttributeValues = js
                .Dictionary(
                  ":val" -> AttributeValue.S("baz")
                ),
              ReturnValues = ReturnValue.AllOld
            )
          )
        )

      (for {
        _ <- putItem
        result <- updateItem
      } yield result.Attributes).map { attributes =>
        assertEquals(attributes.get, item)
      }
  }

  ResourceFunFixture {
    for {
      client <- clientR
      tableName <- simpleTableR(client, "id")
    } yield (client, tableName)
  }.test("UpdateItem should update return all new attributes") {
    case (client, tableName) =>
      val item = js.Dictionary(
        "id" -> AttributeValue.S("test"),
        "foo" -> AttributeValue.S("bar")
      )

      val expected = js.Dictionary(
        "id" -> AttributeValue.S("test"),
        "foo" -> AttributeValue.S("baz")
      )

      val putItem = client
        .sendIO(
          PutItemCommand(
            PutItemCommandInput(
              TableName = tableName,
              Item = item
            )
          )
        )

      val updateItem = client
        .sendIO(
          UpdateItemCommand(
            UpdateItemCommandInput(
              TableName = tableName,
              Key = js
                .Dictionary(
                  "id" -> AttributeValue.S("test")
                ),
              UpdateExpression = "SET foo = :val",
              ExpressionAttributeValues = js
                .Dictionary(
                  ":val" -> AttributeValue.S("baz")
                ),
              ReturnValues = ReturnValue.AllNew
            )
          )
        )

      (for {
        _ <- putItem
        result <- updateItem
      } yield result.Attributes).map { attributes =>
        assertEquals(attributes.get, expected)
      }
  }

  ResourceFunFixture {
    for {
      client <- clientR
      tableName <- simpleTableR(client, "id")
    } yield (client, tableName)
  }.test("UpdateItem should update return updated old attributes") {
    case (client, tableName) =>
      val item = js.Dictionary(
        "id" -> AttributeValue.S("test"),
        "foo" -> AttributeValue.S("bar")
      )

      val expected = js.Dictionary(
        "foo" -> AttributeValue.S("bar")
      )

      val putItem = client
        .sendIO(
          PutItemCommand(
            PutItemCommandInput(
              TableName = tableName,
              Item = item
            )
          )
        )

      val updateItem = client
        .sendIO(
          UpdateItemCommand(
            UpdateItemCommandInput(
              TableName = tableName,
              Key = js
                .Dictionary(
                  "id" -> AttributeValue.S("test")
                ),
              UpdateExpression = "SET foo = :val",
              ExpressionAttributeValues = js
                .Dictionary(
                  ":val" -> AttributeValue.S("baz")
                ),
              ReturnValues = ReturnValue.UpdatedOld
            )
          )
        )

      (for {
        _ <- putItem
        result <- updateItem
      } yield result.Attributes).map { attributes =>
        assertEquals(attributes.get, expected)
      }
  }

  ResourceFunFixture {
    for {
      client <- clientR
      tableName <- simpleTableR(client, "id")
    } yield (client, tableName)
  }.test("UpdateItem should update return updated new attributes") {
    case (client, tableName) =>
      val item = js.Dictionary(
        "id" -> AttributeValue.S("test"),
        "foo" -> AttributeValue.S("bar")
      )

      val expected = js.Dictionary(
        "foo" -> AttributeValue.S("baz")
      )

      val putItem = client
        .sendIO(
          PutItemCommand(
            PutItemCommandInput(
              TableName = tableName,
              Item = item
            )
          )
        )

      val updateItem = client
        .sendIO(
          UpdateItemCommand(
            UpdateItemCommandInput(
              TableName = tableName,
              Key = js
                .Dictionary(
                  "id" -> AttributeValue.S("test")
                ),
              UpdateExpression = "SET foo = :val",
              ExpressionAttributeValues = js
                .Dictionary(
                  ":val" -> AttributeValue.S("baz")
                ),
              ReturnValues = ReturnValue.UpdatedNew
            )
          )
        )

      (for {
        _ <- putItem
        result <- updateItem
      } yield result.Attributes).map { attributes =>
        assertEquals(attributes.get, expected)
      }
  }
}
