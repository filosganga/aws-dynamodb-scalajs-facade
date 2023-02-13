package com.filippodeluca.jsfacade.aws
package dynamodb

import scalajs.js
import scalajs.js.annotation.JSImport

@js.native
@JSImport("@aws-sdk/client-dynamodb", "BatchGetItemCommand")
class BatchGetItemCommand(override val input: BatchGetItemCommandInput)
    extends Command[BatchGetItemCommandInput, BatchGetItemCommandOutput]

object BatchGetItemCommand {
  def apply(input: BatchGetItemCommandInput): BatchGetItemCommand =
    new BatchGetItemCommand(
      input
    )
}

@js.native
trait BatchGetItemCommandInput extends js.Object {
  val RequestItems: js.Dictionary[KeysAndAttributes] = js.native
  val ReturnConsumedCapacity: js.UndefOr[ReturnConsumedCapacity] = js.native
}

object BatchGetItemCommandInput {
  def apply(
      RequestItems: js.Dictionary[KeysAndAttributes],
      ReturnConsumedCapacity: js.UndefOr[ReturnConsumedCapacity] = js.undefined
  ) = {
    js.Dynamic
      .literal(
        RequestItems = RequestItems,
        ReturnConsumedCapacity = ReturnConsumedCapacity.asInstanceOf[js.Any]
      )
      .asInstanceOf[BatchGetItemCommandInput]
  }

}

@js.native
trait KeysAndAttributes extends js.Object {
  val Keys: js.Array[js.Dictionary[AttributeValue]] = js.native
  val ConsistentRead: js.UndefOr[Boolean] = js.native
  val ProjectionExpression: js.UndefOr[String] = js.native
  val ExpressionAttributeNames: js.UndefOr[js.Dictionary[String]] = js.native
}

object KeysAndAttributes {

  def apply(
      Keys: js.Array[js.Dictionary[AttributeValue]],
      ConsistentRead: js.UndefOr[Boolean] = js.undefined,
      ProjectionExpression: js.UndefOr[String] = js.undefined,
      ExpressionAttributeNames: js.UndefOr[js.Dictionary[String]] = js.undefined
  ): KeysAndAttributes = {
    js.Dynamic
      .literal(
        Keys = Keys,
        ConsistentRead = ConsistentRead.asInstanceOf[js.Any],
        ProjectionExpression = ProjectionExpression.asInstanceOf[js.Any],
        ExpressionAttributeNames = ExpressionAttributeNames.asInstanceOf[js.Any]
      )
      .asInstanceOf[KeysAndAttributes]
  }
}

@js.native
trait BatchGetItemCommandOutput extends js.Object {
  val $metadata: ResponseMetadata = js.native
  val ConsumedCapacity: js.UndefOr[ConsumedCapacity] = js.native
  val Responses
      : js.UndefOr[js.Dictionary[js.Array[js.Dictionary[AttributeValue]]]] =
    js.native
  val UnprocessedKeys: js.UndefOr[js.Dictionary[KeysAndAttributes]] = js.native
}
