package com.filippodeluca.jsfacade.aws
package dynamodb

import scalajs.js
import scalajs.js.annotation.JSImport

@js.native
@JSImport("@aws-sdk/client-dynamodb", "PutItemCommand")
class PutItemCommand(override val input: PutItemCommandInput)
    extends Command[PutItemCommandInput, PutItemCommandOutput]

object PutItemCommand {
  def apply(input: PutItemCommandInput): PutItemCommand = new PutItemCommand(
    input
  )
}

@js.native
trait PutItemCommandInput extends js.Object {
  val TableName: String = js.native
  val Item: js.Dictionary[AttributeValue] = js.native

  val ConditionExpression: js.UndefOr[String] = js.native
  val ExpressionAttributeNames: js.UndefOr[js.Dictionary[String]] = js.native
  val ExpressionAttributeValues: js.UndefOr[js.Dictionary[AttributeValue]] =
    js.native
  val ReturnConsumedCapacity: js.UndefOr[String] = js.native

  val ReturnItemCollectionMetrics: js.UndefOr[ReturnItemCollectionMetrics] =
    js.native
  val ReturnValues: js.UndefOr[ReturnValues] = js.native
}

object PutItemCommandInput {

  /** @param ReturnConsumedCapacity:
    *   - INDEXES - The response includes the aggregate ConsumedCapacity for the
    *     operation, together with ConsumedCapacity for each table and secondary
    *     index that was accessed. Note that some operations, such as GetItem
    *     and BatchGetItem, do not access any indexes at all. In these cases,
    *     specifying INDEXES will only return ConsumedCapacity information for
    *     table(s).
    *
    *   - TOTAL - The response includes only the aggregate ConsumedCapacity for
    *     the operation.
    *   - NONE - No ConsumedCapacity details are included in the response.
    *
    * @param ReturnItemCollectionMetrics:
    *   Determines whether item collection metrics are returned.
    *   - If set to SIZE, the response includes statistics about item
    *     collections, if any, that were modified during the operation are
    *     returned in the response.
    *   - If set to NONE (the default), no statistics are returned.
    *
    * @param ReturnValues
    *   Use ReturnValues if you want to get the item attributes as they appeared
    *   before they were updated with the PutItem request. For PutItem, the
    *   valid values are:
    *
    *   - NONE - If ReturnValues is not specified, or if its value is NONE, then
    *     nothing is returned. (This setting is the default for ReturnValues.)
    *
    *   - ALL_OLD - If PutItem overwrote an attribute name-value pair, then the
    *     content of the old item is returned.
    *
    * The values returned are strongly consistent.
    *
    * There is no additional cost associated with requesting a return value
    * aside from the small network and processing overhead of receiving a larger
    * response. No read capacity units are consumed.
    *
    * The ReturnValues parameter is used by several DynamoDB operations;
    * however, PutItem does not recognize any values other than NONE or ALL_OLD.
    */
  def apply(
      TableName: String,
      Item: js.Dictionary[AttributeValue],
      ConditionExpression: js.UndefOr[String] = js.undefined,
      ExpressionAttributeNames: js.UndefOr[js.Dictionary[String]] =
        js.undefined,
      ExpressionAttributeValues: js.UndefOr[js.Dictionary[AttributeValue]] =
        js.undefined,
      ReturnConsumedCapacity: js.UndefOr[ReturnConsumedCapacity] = js.undefined,
      ReturnItemCollectionMetrics: js.UndefOr[ReturnItemCollectionMetrics] =
        js.undefined,
      ReturnValues: js.UndefOr[ReturnValues] = js.undefined
  ): PutItemCommandInput = {
    js.Dynamic
      .literal(
        TableName = TableName,
        Item = Item,
        ConditionExpression = ConditionExpression,
        ExpressionAttributeNames = ExpressionAttributeNames,
        ExpressionAttributeValues = ExpressionAttributeValues,
        ReturnConsumedCapacity = ReturnConsumedCapacity,
        ReturnItemCollectionMetrics = ReturnItemCollectionMetrics,
        ReturnValues = ReturnValues
      )
      .asInstanceOf[PutItemCommandInput]
  }
}

@js.native
trait PutItemCommandOutput extends js.Object {
  val $metadata: ResponseMetadata = js.native

  /** The attribute values as they appeared before the PutItem operation, but
    * only if ReturnValues is specified as ALL_OLD in the request. Each element
    * consists of an attribute name and an attribute valu
    */
  val Attributes: js.UndefOr[js.Dictionary[AttributeValue]] = js.native

  val ConsumedCapacity: js.UndefOr[ConsumedCapacity] = js.native

  val ItemCollectionMetrics: js.UndefOr[ItemCollectionMetrics] = js.native
}
