package com.filippodeluca.jsfacade.aws
package dynamodb

import scalajs.js
import scalajs.js.annotation.JSImport

@js.native
@JSImport("@aws-sdk/client-dynamodb", "GetItemCommand")
class GetItemCommand(override val input: GetItemCommandInput)
    extends Command[GetItemCommandInput, GetItemCommandOutput]

object GetItemCommand {
  def apply(input: GetItemCommandInput): GetItemCommand = new GetItemCommand(
    input
  )
}

@js.native
trait GetItemCommandInput extends js.Object {
  val TableName: String = js.native
  val Key: js.Dictionary[AttributeValue] = js.native
  val ConsistentRead: js.UndefOr[Boolean] = js.native
  val ExpressionAttributeNames: js.UndefOr[js.Dictionary[String]] = js.native
  val ProjectionExpression: js.UndefOr[String] = js.native
  val ReturnConsumedCapacity: js.UndefOr[ReturnConsumedCapacity] = js.native
}

object GetItemCommandInput {

  def apply(
      TableName: String,
      Key: js.Dictionary[AttributeValue],
      ConsistentRead: js.UndefOr[Boolean] = js.undefined,
      ExpressionAttributeNames: js.UndefOr[js.Dictionary[String]] =
        js.undefined,
      ProjectionExpression: js.UndefOr[String] = js.undefined,
      ReturnConsumedCapacity: js.UndefOr[ReturnConsumedCapacity] = js.undefined
  ): GetItemCommandInput = {
    js.Dynamic
      .literal(
        TableName = TableName,
        ConsistentRead = ConsistentRead,
        ExpressionAttributeNames = ExpressionAttributeNames,
        Key = Key,
        ProjectionExpression = ProjectionExpression,
        ReturnConsumedCapacity = ReturnConsumedCapacity
      )
      .asInstanceOf[GetItemCommandInput]
  }
}

@js.native
trait GetItemCommandOutput extends js.Object {
  val $metadata: ResponseMetadata = js.native
  val Item: js.UndefOr[js.Dictionary[AttributeValue]] = js.native
  val ConsumedCapacity: js.UndefOr[ConsumedCapacity] = js.native
}
