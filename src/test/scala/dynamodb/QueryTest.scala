package com.filippodeluca.jsfacade.aws
package dynamodb

import scalajs.js

class QueryTest
    extends munit.CatsEffectSuite
    with DynamoDbFixtures
    with ScalaJsAssertions {

  ResourceFunFixture {
    for {
      client <- clientR
      tableName <- tableR(client)(
        List(
          AttributeDefinition("pk", ScalarAttributeType.S),
          AttributeDefinition("sk", ScalarAttributeType.N)
        ),
        List(
          KeySchemaElement("pk", KeyType.Hash),
          KeySchemaElement("sk", KeyType.Range)
        )
      )
    } yield (client, tableName)
  }.test("Query should return items with the same PK") {
    case (client, tableName) =>
      val itemOne = js.Dictionary(
        "pk" -> AttributeValue.S("test_1"),
        "sk" -> AttributeValue.N("0")
      )

      val itemTwo = js.Dictionary(
        "pk" -> AttributeValue.S("test_1"),
        "sk" -> AttributeValue.N("1")
      )

      val itemThree = js.Dictionary(
        "pk" -> AttributeValue.S("test_2"),
        "sk" -> AttributeValue.N("0")
      )

      val putItems = client
        .sendIO(
          BatchWriteItemCommand(
            BatchWriteItemCommandInput(
              js.Dictionary(
                tableName ->
                  js.Array(
                    WriteRequest.putRequest(PutRequest(itemOne)),
                    WriteRequest.putRequest(PutRequest(itemTwo)),
                    WriteRequest.putRequest(PutRequest(itemThree))
                  )
              )
            )
          )
        )

      val queryItems = client.sendIO(
        QueryCommand(
          QueryCommandInput(
            TableName = tableName,
            KeyConditionExpression = s"#pk = :pk",
            ExpressionAttributeNames = js.Dictionary("#pk" -> "pk"),
            ExpressionAttributeValues =
              js.Dictionary(":pk" -> AttributeValue.S("test_1"))
          )
        )
      )

      (for {
        _ <- putItems
        res <- queryItems
      } yield res.Items).map { items =>
        assert(items.isDefined)
        assertEquals(items.get, js.Array(itemOne, itemTwo))
      }
  }

  ResourceFunFixture {
    for {
      client <- clientR
      tableName <- tableR(client)(
        List(
          AttributeDefinition("pk", ScalarAttributeType.S),
          AttributeDefinition("sk", ScalarAttributeType.N)
        ),
        List(
          KeySchemaElement("pk", KeyType.Hash),
          KeySchemaElement("sk", KeyType.Range)
        )
      )
    } yield (client, tableName)
  }.test("Query should respect Limit") { case (client, tableName) =>
    val itemOne = js.Dictionary(
      "pk" -> AttributeValue.S("test_1"),
      "sk" -> AttributeValue.N("0")
    )

    val itemTwo = js.Dictionary(
      "pk" -> AttributeValue.S("test_1"),
      "sk" -> AttributeValue.N("1")
    )

    val itemThree = js.Dictionary(
      "pk" -> AttributeValue.S("test_2"),
      "sk" -> AttributeValue.N("0")
    )

    val putItems = client
      .sendIO(
        BatchWriteItemCommand(
          BatchWriteItemCommandInput(
            js.Dictionary(
              tableName ->
                js.Array(
                  WriteRequest.putRequest(PutRequest(itemOne)),
                  WriteRequest.putRequest(PutRequest(itemTwo)),
                  WriteRequest.putRequest(PutRequest(itemThree))
                )
            )
          )
        )
      )

    val queryItems = client.sendIO(
      QueryCommand(
        QueryCommandInput(
          TableName = tableName,
          KeyConditionExpression = s"#pk = :pk",
          ExpressionAttributeNames = js.Dictionary("#pk" -> "pk"),
          ExpressionAttributeValues =
            js.Dictionary(":pk" -> AttributeValue.S("test_1")),
          Limit = 1
        )
      )
    )

    (for {
      _ <- putItems
      res <- queryItems
    } yield res.Items).map { items =>
      assert(items.isDefined)
      assertEquals(items.get, js.Array(itemOne))
    }
  }
}
