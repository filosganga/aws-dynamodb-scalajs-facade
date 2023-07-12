package com.filippodeluca.jsfacade.awssdk
package client
package dynamodb
package models

import com.filippodeluca.jsfacade.awssdk.types.MetadataBearer
import scalajs.js

/** <p>Represents the input of an <code>UpdateItem</code> operation.</p>
  */
@js.native
trait UpdateItemCommandInput extends js.Object {

  /** <p>The name of the table containing the item to update.</p>
    */
  val TableName: String = js.native

  /** <p>The primary key of the item to be updated. Each element consists of an
    * attribute name and a value for that attribute.</p> <p>For the primary key,
    * you must provide all of the attributes. For example, with a simple primary
    * key, you only need to provide a value for the partition key. For a
    * composite primary key, you must provide values for both the partition key
    * and the sort key.</p>
    */
  val Key: js.Dictionary[AttributeValue] = js.native

  /** <p>Use <code>ReturnValues</code> if you want to get the item attributes as
    * they appear before or after they are updated. For <code>UpdateItem</code>,
    * the valid values are:</p> <ul> <li> <p> <code>NONE</code> - If
    * <code>ReturnValues</code> is not specified, or if its value is
    * <code>NONE</code>, then nothing is returned. (This setting is the default
    * for <code>ReturnValues</code>.)</p> </li> <li> <p> <code>ALL_OLD</code> -
    * Returns all of the attributes of the item, as they appeared before the
    * UpdateItem operation.</p> </li> <li> <p> <code>UPDATED_OLD</code> -
    * Returns only the updated attributes, as they appeared before the
    * UpdateItem operation.</p> </li> <li> <p> <code>ALL_NEW</code> - Returns
    * all of the attributes of the item, as they appear after the UpdateItem
    * operation.</p> </li> <li> <p> <code>UPDATED_NEW</code> - Returns only the
    * updated attributes, as they appear after the UpdateItem operation.</p>
    * </li> </ul> <p>There is no additional cost associated with requesting a
    * return value aside from the small network and processing overhead of
    * receiving a larger response. No read capacity units are consumed.</p>
    * <p>The values returned are strongly consistent.</p>
    */
  val ReturnValues: js.UndefOr[ReturnValue] = js.native

  /** <p>Determines the level of detail about either provisioned or on-demand
    * throughput consumption that is returned in the response:</p> <ul> <li> <p>
    * <code>INDEXES</code> - The response includes the aggregate
    * <code>ConsumedCapacity</code> for the operation, together with
    * <code>ConsumedCapacity</code> for each table and secondary index that was
    * accessed.</p> <p>Note that some operations, such as <code>GetItem</code>
    * and <code>BatchGetItem</code>, do not access any indexes at all. In these
    * cases, specifying <code>INDEXES</code> will only return
    * <code>ConsumedCapacity</code> information for table(s).</p> </li> <li> <p>
    * <code>TOTAL</code> - The response includes only the aggregate
    * <code>ConsumedCapacity</code> for the operation.</p> </li> <li> <p>
    * <code>NONE</code> - No <code>ConsumedCapacity</code> details are included
    * in the response.</p> </li> </ul>
    */
  val ReturnConsumedCapacity: js.UndefOr[ReturnConsumedCapacity] = js.native

  /** <p>Determines whether item collection metrics are returned. If set to
    * <code>SIZE</code>, the response includes statistics about item
    * collections, if any, that were modified during the operation are returned
    * in the response. If set to <code>NONE</code> (the default), no statistics
    * are returned.</p>
    */
  val ReturnItemCollectionMetrics: js.UndefOr[ReturnItemCollectionMetrics] =
    js.native

  /** <p>An expression that defines one or more attributes to be updated, the
    * action to be performed on them, and new values for them.</p> <p>The
    * following action values are available for
    * <code>UpdateExpression</code>.</p> <ul> <li> <p> <code>SET</code> - Adds
    * one or more attributes and values to an item. If any of these attributes
    * already exist, they are replaced by the new values. You can also use
    * <code>SET</code> to add or subtract from an attribute that is of type
    * Number. For example: <code>SET myNum = myNum + :val</code> </p> <p>
    * <code>SET</code> supports the following functions:</p> <ul> <li> <p>
    * <code>if_not_exists (path, operand)</code> - if the item does not contain
    * an attribute at the specified path, then <code>if_not_exists</code>
    * evaluates to operand; otherwise, it evaluates to path. You can use this
    * function to avoid overwriting an attribute that may already be present in
    * the item.</p> </li> <li> <p> <code>list_append (operand, operand)</code> -
    * evaluates to a list with a new element added to it. You can append the new
    * element to the start or the end of the list by reversing the order of the
    * operands.</p> </li> </ul> <p>These function names are case-sensitive.</p>
    * </li> <li> <p> <code>REMOVE</code> - Removes one or more attributes from
    * an item.</p> </li> <li> <p> <code>ADD</code> - Adds the specified value to
    * the item, if the attribute does not already exist. If the attribute does
    * exist, then the behavior of <code>ADD</code> depends on the data type of
    * the attribute:</p> <ul> <li> <p>If the existing attribute is a number, and
    * if <code>Value</code> is also a number, then <code>Value</code> is
    * mathematically added to the existing attribute. If <code>Value</code> is a
    * negative number, then it is subtracted from the existing attribute.</p>
    * <note> <p>If you use <code>ADD</code> to increment or decrement a number
    * value for an item that doesn't exist before the update, DynamoDB uses
    * <code>0</code> as the initial value.</p> <p>Similarly, if you use
    * <code>ADD</code> for an existing item to increment or decrement an
    * attribute value that doesn't exist before the update, DynamoDB uses
    * <code>0</code> as the initial value. For example, suppose that the item
    * you want to update doesn't have an attribute named <code>itemcount</code>,
    * but you decide to <code>ADD</code> the number <code>3</code> to this
    * attribute anyway. DynamoDB will create the <code>itemcount</code>
    * attribute, set its initial value to <code>0</code>, and finally add
    * <code>3</code> to it. The result will be a new <code>itemcount</code>
    * attribute in the item, with a value of <code>3</code>.</p> </note> </li>
    * <li> <p>If the existing data type is a set and if <code>Value</code> is
    * also a set, then <code>Value</code> is added to the existing set. For
    * example, if the attribute value is the set <code>[1,2]</code>, and the
    * <code>ADD</code> action specified <code>[3]</code>, then the final
    * attribute value is <code>[1,2,3]</code>. An error occurs if an
    * <code>ADD</code> action is specified for a set attribute and the attribute
    * type specified does not match the existing set type. </p> <p>Both sets
    * must have the same primitive data type. For example, if the existing data
    * type is a set of strings, the <code>Value</code> must also be a set of
    * strings.</p> </li> </ul> <important> <p>The <code>ADD</code> action only
    * supports Number and set data types. In addition, <code>ADD</code> can only
    * be used on top-level attributes, not nested attributes.</p> </important>
    * </li> <li> <p> <code>DELETE</code> - Deletes an element from a set.</p>
    * <p>If a set of values is specified, then those values are subtracted from
    * the old set. For example, if the attribute value was the set
    * <code>[a,b,c]</code> and the <code>DELETE</code> action specifies
    * <code>[a,c]</code>, then the final attribute value is <code>[b]</code>.
    * Specifying an empty set is an error.</p> <important> <p>The
    * <code>DELETE</code> action only supports set data types. In addition,
    * <code>DELETE</code> can only be used on top-level attributes, not nested
    * attributes.</p> </important>
    *
    * </li> </ul> <p>You can have many actions in a single expression, such as
    * the following: <code>SET a=:value1, b=:value2 DELETE :value3, :value4,
    * :value5</code> </p> <p>For more information on update expressions, see <a
    * href="https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.Modifying.html">Modifying
    * Items and Attributes</a> in the <i>Amazon DynamoDB Developer
    * Guide</i>.</p>
    */
  val UpdateExpression: String = js.native

  /** <p>A condition that must be satisfied in order for a conditional update to
    * succeed.</p> <p>An expression can contain any of the following:</p> <ul>
    * <li> <p>Functions: <code>attribute_exists | attribute_not_exists |
    * attribute_type | contains | begins_with | size</code> </p> <p>These
    * function names are case-sensitive.</p> </li> <li> <p>Comparison operators:
    * <code>= | <> | < | > | <= | >= | BETWEEN | IN </code> </p> </li> <li> <p>
    * Logical operators: <code>AND | OR | NOT</code> </p> </li> </ul> <p>For
    * more information about condition expressions, see <a
    * href="https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html">Specifying
    * Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.</p>
    */
  val ConditionExpression: js.UndefOr[String] = js.native

  /** <p>One or more substitution tokens for attribute names in an expression.
    * The following are some use cases for using
    * <code>ExpressionAttributeNames</code>:</p> <ul> <li> <p>To access an
    * attribute whose name conflicts with a DynamoDB reserved word.</p> </li>
    * <li> <p>To create a placeholder for repeating occurrences of an attribute
    * name in an expression.</p> </li> <li> <p>To prevent special characters in
    * an attribute name from being misinterpreted in an expression.</p> </li>
    * </ul> <p>Use the <b>#</b> character in an expression to dereference an
    * attribute name. For example, consider the following attribute name:</p>
    * <ul> <li> <p> <code>Percentile</code> </p> </li> </ul> <p>The name of this
    * attribute conflicts with a reserved word, so it cannot be used directly in
    * an expression. (For the complete list of reserved words, see <a
    * href="https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
    * Words</a> in the <i>Amazon DynamoDB Developer Guide</i>.) To work around
    * this, you could specify the following for
    * <code>ExpressionAttributeNames</code>:</p> <ul> <li> <p>
    * <code>{"#P":"Percentile"}</code> </p> </li> </ul> <p>You could then use
    * this substitution in an expression, as in this example:</p> <ul> <li> <p>
    * <code>#P = :val</code> </p> </li> </ul> <note> <p>Tokens that begin with
    * the <b>:</b> character are <i>expression attribute values</i>, which are
    * placeholders for the actual value at runtime.</p> </note> <p>For more
    * information about expression attribute names, see <a
    * href="https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Specifying
    * Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.</p>
    */
  val ExpressionAttributeNames: js.UndefOr[js.Dictionary[String]] = js.native

  /** <p>One or more values that can be substituted in an expression.</p> <p>Use
    * the <b>:</b> (colon) character in an expression to dereference an
    * attribute value. For example, suppose that you wanted to check whether the
    * value of the <code>ProductStatus</code> attribute was one of the
    * following: </p> <p> <code>Available | Backordered | Discontinued</code>
    * </p> <p>You would first need to specify
    * <code>ExpressionAttributeValues</code> as follows:</p> <p> <code>{
    * ":avail":{"S":"Available"}, ":back":{"S":"Backordered"},
    * ":disc":{"S":"Discontinued"} }</code> </p> <p>You could then use these
    * values in an expression, such as this:</p> <p> <code>ProductStatus IN
    * (:avail, :back, :disc)</code> </p> <p>For more information on expression
    * attribute values, see <a
    * href="https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html">Condition
    * Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.</p>
    */
  val ExpressionAttributeValues: js.UndefOr[js.Dictionary[AttributeValue]] =
    js.native
}

object UpdateItemCommandInput {
  def apply(
      TableName: String,
      Key: js.Dictionary[AttributeValue],
      UpdateExpression: String,
      ConditionExpression: js.UndefOr[String] = js.undefined,
      ExpressionAttributeNames: js.UndefOr[js.Dictionary[String]] =
        js.undefined,
      ExpressionAttributeValues: js.UndefOr[js.Dictionary[AttributeValue]] =
        js.undefined,
      ReturnValues: js.UndefOr[ReturnValue] = js.undefined,
      ReturnConsumedCapacity: js.UndefOr[ReturnConsumedCapacity] = js.undefined,
      ReturnItemCollectionMetrics: js.UndefOr[ReturnItemCollectionMetrics] =
        js.undefined
  ): UpdateItemCommandInput = js.Dynamic
    .literal(
      TableName = TableName.asInstanceOf[js.Any],
      Key = Key.asInstanceOf[js.Any],
      UpdateExpression = UpdateExpression.asInstanceOf[js.Any],
      ConditionExpression = ConditionExpression.asInstanceOf[js.Any],
      ExpressionAttributeNames = ExpressionAttributeNames.asInstanceOf[js.Any],
      ExpressionAttributeValues =
        ExpressionAttributeValues.asInstanceOf[js.Any],
      ReturnValues = ReturnValues.asInstanceOf[js.Any],
      ReturnConsumedCapacity = ReturnConsumedCapacity.asInstanceOf[js.Any],
      ReturnItemCollectionMetrics =
        ReturnItemCollectionMetrics.asInstanceOf[js.Any]
    )
    .asInstanceOf[UpdateItemCommandInput]
}

/** <p>Represents the output of an <code>UpdateItem</code> operation.</p>
  */
@js.native
trait UpdateItemCommandOutput extends MetadataBearer {

  /** <p>A map of attribute values as they appear before or after the
    * <code>UpdateItem</code> operation, as determined by the
    * <code>ReturnValues</code> parameter.</p> <p>The <code>Attributes</code>
    * map is only present if <code>ReturnValues</code> was specified as
    * something other than <code>NONE</code> in the request. Each element
    * represents one attribute.</p>
    */
  val Attributes: js.UndefOr[js.Dictionary[AttributeValue]] = js.native

  /** <p>The capacity units consumed by the <code>UpdateItem</code> operation.
    * The data returned includes the total provisioned throughput consumed,
    * along with statistics for the table and any indexes involved in the
    * operation. <code>ConsumedCapacity</code> is only returned if the
    * <code>ReturnConsumedCapacity</code> parameter was specified. For more
    * information, see <a
    * href="https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html">Provisioned
    * Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.</p>
    */
  val ConsumedCapacity: js.UndefOr[ConsumedCapacity] = js.native

  /** <p>Information about item collections, if any, that were affected by the
    * <code>UpdateItem</code> operation. <code>ItemCollectionMetrics</code> is
    * only returned if the <code>ReturnItemCollectionMetrics</code> parameter
    * was specified. If the table does not have any local secondary indexes,
    * this information is not returned in the response.</p> <p>Each
    * <code>ItemCollectionMetrics</code> element consists of:</p> <ul> <li> <p>
    * <code>ItemCollectionKey</code> - The partition key value of the item
    * collection. This is the same as the partition key value of the item
    * itself.</p> </li> <li> <p> <code>SizeEstimateRangeGB</code> - An estimate
    * of item collection size, in gigabytes. This value is a two-element array
    * containing a lower bound and an upper bound for the estimate. The estimate
    * includes the size of all the items in the table, plus the size of all
    * attributes projected into all of the local secondary indexes on that
    * table. Use this estimate to measure whether a local secondary index is
    * approaching its size limit.</p> <p>The estimate is subject to change over
    * time; therefore, do not rely on the precision or accuracy of the
    * estimate.</p> </li> </ul>
    */
  val ItemCollectionMetrics: js.UndefOr[ItemCollectionMetrics] = js.native
}
