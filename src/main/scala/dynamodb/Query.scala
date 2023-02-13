package com.filippodeluca.jsfacade.aws
package dynamodb

import scalajs.js
import scalajs.js.annotation.JSImport

@js.native
@JSImport("@aws-sdk/client-dynamodb", "QueryCommand")
class QueryCommand(override val input: QueryCommandInput)
    extends Command[QueryCommandInput, QueryCommandOutput]

object QueryCommand {
  def apply(input: QueryCommandInput): QueryCommand = new QueryCommand(
    input
  )
}

trait Select extends js.Any
object Select {
  val AllAttributes = "ALL_ATTRIBUTES".asInstanceOf[Select]
  val AllProjectedAttributes = "ALL_PROJECTED_ATTRIBUTES".asInstanceOf[Select]
  val SpecificAttributes = "SPECIFIC_ATTRIBUTES".asInstanceOf[Select]
  val Count = "COUNT".asInstanceOf[Select]
}

@js.native
trait QueryCommandInput extends js.Object {
  val TableName: String = js.native
  val IndexName: js.UndefOr[String] = js.native
  val ConsistentRead: js.UndefOr[Boolean] = js.native
  val Select: js.UndefOr[Select] = js.native
  val KeyConditionExpression: js.UndefOr[String] = js.native
  val ProjectionExpression: js.UndefOr[String] = js.native
  val FilterExpression: js.UndefOr[String] = js.native
  val ExpressionAttributeNames: js.UndefOr[js.Dictionary[String]] = js.native
  val ExpressionAttributeValues: js.UndefOr[js.Dictionary[AttributeValue]] =
    js.native
  val ExclusiveStartKey: js.UndefOr[js.Dictionary[AttributeValue]] = js.native
  val Limit: js.UndefOr[Int] = js.native
  val ScanIndexForward: js.UndefOr[Boolean] = js.native
  val ReturnConsumedCapacity: js.UndefOr[ReturnConsumedCapacity] = js.native
}

object QueryCommandInput {

  def apply(
      TableName: String,
      IndexName: js.UndefOr[String] = js.undefined,
      ConsistentRead: js.UndefOr[Boolean] = js.undefined,
      Select: js.UndefOr[Select] = js.undefined,
      KeyConditionExpression: js.UndefOr[String] = js.undefined,
      ProjectionExpression: js.UndefOr[String] = js.undefined,
      FilterExpression: js.UndefOr[String] = js.undefined,
      ExpressionAttributeNames: js.UndefOr[js.Dictionary[String]] =
        js.undefined,
      ExpressionAttributeValues: js.UndefOr[js.Dictionary[AttributeValue]] =
        js.undefined,
      ExclusiveStartKey: js.UndefOr[js.Dictionary[AttributeValue]] =
        js.undefined,
      Limit: js.UndefOr[Int] = js.undefined,
      ScanIndexForward: js.UndefOr[Boolean] = js.undefined,
      ReturnConsumedCapacity: js.UndefOr[ReturnConsumedCapacity] = js.undefined
  ): QueryCommandInput = {
    js.Dynamic
      .literal(
        TableName = TableName,
        IndexName = IndexName,
        ConsistentRead = ConsistentRead,
        Select = Select,
        KeyConditionExpression = KeyConditionExpression,
        ProjectionExpression = ProjectionExpression,
        FilterExpression = FilterExpression,
        ExpressionAttributeNames = ExpressionAttributeNames,
        ExpressionAttributeValues = ExpressionAttributeValues,
        ExclusiveStartKey = ExclusiveStartKey,
        Limit = Limit,
        ScanIndexForward = ScanIndexForward,
        ReturnConsumedCapacity = ReturnConsumedCapacity
      )
      .asInstanceOf[QueryCommandInput]
  }
}

@js.native
trait QueryCommandOutput extends js.Object {
  val $metadata: ResponseMetadata = js.native
  val ConsumedCapacity: js.UndefOr[ConsumedCapacity] = js.native

  val Items: js.UndefOr[js.Array[js.Dictionary[AttributeValue]]] = js.native
  val Count: js.UndefOr[Int] = js.native
  val ScannedCount: js.UndefOr[Int] = js.native
  val LastEvaluatedKey: js.UndefOr[js.Dictionary[AttributeValue]] = js.native
}
