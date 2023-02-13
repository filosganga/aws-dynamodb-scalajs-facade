package com.filippodeluca.jsfacade.aws
package dynamodb

import scalajs.js
import scalajs.js.annotation.JSImport

@js.native
@JSImport("@aws-sdk/client-dynamodb", "BatchWriteItemCommand")
class BatchWriteItemCommand(override val input: BatchWriteItemCommandInput)
    extends Command[BatchWriteItemCommandInput, BatchWriteItemCommandOutput]

object BatchWriteItemCommand {
  def apply(input: BatchWriteItemCommandInput): BatchWriteItemCommand =
    new BatchWriteItemCommand(
      input
    )
}

@js.native
trait BatchWriteItemCommandInput extends js.Object {
  val RequestItems: js.Dictionary[js.Array[WriteRequest]] = js.native
  val ReturnConsumedCapacity: js.UndefOr[ReturnConsumedCapacity] = js.native
  val ReturnItemCollectionMetrics: js.UndefOr[ReturnItemCollectionMetrics] =
    js.native
}

object BatchWriteItemCommandInput {
  def apply(
      RequestItems: js.Dictionary[js.Array[WriteRequest]],
      ReturnConsumedCapacity: js.UndefOr[ReturnConsumedCapacity] = js.undefined,
      ReturnItemCollectionMetrics: js.UndefOr[ReturnItemCollectionMetrics] =
        js.undefined
  ) = js.Dynamic
    .literal(
      RequestItems = RequestItems,
      ReturnConsumedCapacity = ReturnConsumedCapacity.asInstanceOf[js.Any],
      ReturnItemCollectionMetrics =
        ReturnItemCollectionMetrics.asInstanceOf[js.Any]
    )
    .asInstanceOf[BatchWriteItemCommandInput]

}

@js.native
trait WriteRequest extends js.Object {
  val PutRequest: js.UndefOr[PutRequest] = js.native
  val DeleteRequest: js.UndefOr[DeleteRequest] = js.native
}

object WriteRequest {

  def putRequest(putRequest: PutRequest): WriteRequest =
    apply(PutRequest = putRequest)

  def deleteRequest(deleteRequest: DeleteRequest): WriteRequest =
    apply(DeleteRequest = deleteRequest)

  def apply(
      PutRequest: js.UndefOr[PutRequest] = js.undefined,
      DeleteRequest: js.UndefOr[DeleteRequest] = js.undefined
  ): WriteRequest = {
    js.Dynamic
      .literal(
        PutRequest = PutRequest.asInstanceOf[js.Any],
        DeleteRequest = DeleteRequest.asInstanceOf[js.Any]
      )
      .asInstanceOf[WriteRequest]
  }
}

@js.native
trait PutRequest extends js.Object {
  val Item: js.Dictionary[AttributeValue] = js.native
}

object PutRequest {
  def apply(Item: js.Dictionary[AttributeValue]) = js.Dynamic
    .literal(
      Item = Item
    )
    .asInstanceOf[PutRequest]
}

@js.native
trait DeleteRequest extends js.Object {
  val Key: js.Dictionary[AttributeValue] = js.native
}

object DeleteRequest {
  def apply(Key: js.Dictionary[AttributeValue]) = js.Dynamic
    .literal(
      Key = Key
    )
    .asInstanceOf[DeleteRequest]
}

@js.native
trait BatchWriteItemCommandOutput extends js.Object {
  val $metadata: ResponseMetadata = js.native
  val ConsumedCapacity: js.UndefOr[ConsumedCapacity] = js.native
  val ItemCollectionMetrics: js.UndefOr[js.Dictionary[ItemCollectionMetrics]] =
    js.native
  val UnprocessedKeys: js.UndefOr[js.Dictionary[WriteRequest]] = js.native
}
