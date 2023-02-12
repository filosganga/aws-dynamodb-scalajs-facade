package com.filippodeluca.jsfacade.aws
package dynamodb

import scalajs.js
import scalajs.js._
import scalajs.js.annotation.JSImport

/** export interface Logger { trace?: (...content: any[]) => void; debug:
  * (...content: any[]) => void; info: (...content: any[]) => void; warn:
  * (...content: any[]) => void; error: (...content: any[]) => void; }
  */

//     /**
//  * A function that, when invoked, returns a promise that will be fulfilled with
//  * a value of type T.
//  *
//  * @example A function that reads credentials from shared SDK configuration
//  * files, assuming roles and collecting MFA tokens as necessary.
//  */
// export interface Provider<T> {
//   (): Promise<T>;
// }

// /**
//  * A function that, when invoked, returns a promise that will be fulfilled with
//  * a value of type T. It memoizes the result from the previous invocation
//  * instead of calling the underlying resources every time.
//  *
//  * You can force the provider to refresh the memoized value by invoke the
//  * function with optional parameter hash with `forceRefresh` boolean key and
//  * value `true`.
//  *
//  * @example A function that reads credentials from IMDS service that could
//  * return expired credentials. The SDK will keep using the expired credentials
//  * until an unretryable service error requiring a force refresh of the
//  * credentials.
//  */
// export interface MemoizedProvider<T> {
//   (options?: { forceRefresh?: boolean }): Promise<T>;
// }

@js.native
@JSImport("@aws-sdk/client-dynamodb", "DynamoDBClient")
class DynamoDBClient(configuration: DynamoDBClientConfig) extends js.Object {
  def destroy(): Unit = js.native

  def send[InputType, OutputType](
      command: Command[InputType, OutputType]
  ): js.Promise[OutputType] = js.native
}

@js.native
@JSImport("@aws-sdk/client-dynamodb", "Command")
class Command[ClientInput, ClientOutput] extends js.Object {
  val input: ClientInput = js.native
}

@js.native
trait DynamoDBClientConfig extends js.Object {
  def credentials: js.UndefOr[MemoizedProvider[Credentials] | Credentials] =
    js.native
  def customUserAgent: js.UndefOr[String] = js.native
  def endpoint: js.UndefOr[String] = js.native
  def region: js.UndefOr[MemoizedProvider[String] | String]
  def maxAttempts: Int = js.native
  def disableHostPrefix: js.UndefOr[Boolean] = js.native
  def endpointCacheSize: js.UndefOr[Int] = js.native
  def endpointDiscoveryEnabled: js.UndefOr[Int] = js.native
  // def logger: js.UndefOr[Logger] = js.undefined
  def retryMode: js.UndefOr[String | Int]
}

object DynamoDBClientConfig {
  def apply(
      region: MemoizedProvider[String] | String,
      credentials: js.UndefOr[MemoizedProvider[Credentials] | Credentials] =
        js.undefined,
      endpoint: js.UndefOr[String] = js.undefined,
      customUserAgent: js.UndefOr[String] = js.undefined,
      maxAttempts: js.UndefOr[Int] = js.undefined,
      disableHostPrefix: js.UndefOr[Boolean] = js.undefined,
      endpointCacheSize: js.UndefOr[Int] = js.undefined,
      endpointDiscoveryEnabled: js.UndefOr[Int] = js.undefined
      // logger: js.UndefOr[Logger] = js.undefined

  ): DynamoDBClientConfig = {
    js.Dynamic
      .literal(
        region = region.merge.asInstanceOf[js.Any],
        credentials = credentials.merge.asInstanceOf[js.Any],
        endpoint = endpoint,
        customUserAgent = customUserAgent,
        maxAttempts = maxAttempts,
        disableHostPrefix = disableHostPrefix,
        endpointCacheSize = endpointCacheSize,
        endpointDiscoveryEnabled = endpointDiscoveryEnabled
      )
      .asInstanceOf[DynamoDBClientConfig]
  }
}

@js.native
trait AttributeDefinition extends js.Object {
  val AttributeName: js.UndefOr[String] = js.native
  val AttributeType: js.UndefOr[String] =
    js.native // TODO it is actually ScalarAttributeType | String but ScalarAttributeType is an enumeration of "B", "N", "S" I have no idea how to implement it
}

object AttributeDefinition {
  def apply(
      AttributeName: js.UndefOr[String] = js.undefined,
      AttributeType: js.UndefOr[String] = js.undefined
  ): AttributeDefinition = js.Dynamic
    .literal(
      AttributeName = AttributeName,
      AttributeType = AttributeType
    )
    .asInstanceOf[AttributeDefinition]
}

@js.native
trait ProvisionedThroughput extends js.Object {
  val ReadCapacityUnits: Int = js.native
  val WriteCapacityUnits: Int = js.native
}

object ProvisionedThroughput {
  def apply(
      ReadCapacityUnits: Int,
      WriteCapacityUnits: Int
  ): ProvisionedThroughput = js.Dynamic
    .literal(
      ReadCapacityUnits = ReadCapacityUnits,
      WriteCapacityUnits = WriteCapacityUnits
    )
    .asInstanceOf[ProvisionedThroughput]
}

@js.native
trait KeySchemaElement extends js.Object {
  val AttributeName: js.UndefOr[String] = js.native

  /** HASH | RANGE */
  val KeyType: js.UndefOr[String] = js.native
}

object KeySchemaElement {
  def apply(
      AttributeName: js.UndefOr[String] = js.undefined,
      KeyType: js.UndefOr[String] = js.undefined
  ): KeySchemaElement = js.Dynamic
    .literal(
      AttributeName = AttributeName,
      KeyType = KeyType
    )
    .asInstanceOf[KeySchemaElement]
}

@js.native
trait GlobalSecondaryIndex extends js.Object {
  val IndexName: String = js.native
  val KeySchema: js.Array[KeySchemaElement] = js.native
  val Projection: String = js.native
  val ProvisionedThroughput: js.UndefOr[ProvisionedThroughput] = js.native
}

object GlobalSecondaryIndex {
  def apply(
      IndexName: String,
      KeySchema: js.Array[KeySchemaElement],
      Projection: String,
      ProvisionedThroughput: js.UndefOr[ProvisionedThroughput] = js.undefined
  ): GlobalSecondaryIndex = js.Dynamic
    .literal(
      IndexName = IndexName,
      KeySchema = KeySchema,
      Projection = Projection,
      ProvisionedThroughput = ProvisionedThroughput
    )
    .asInstanceOf[GlobalSecondaryIndex]
}

@js.native
trait LocalSecondaryIndex extends js.Object {
  val IndexName: String = js.native
  val KeySchema: js.Array[KeySchemaElement] = js.native
  val Projection: String = js.native
}

object LocalSecondaryIndex {
  def apply(
      IndexName: String,
      KeySchema: js.Array[KeySchemaElement],
      Projection: String
  ): LocalSecondaryIndex = js.Dynamic
    .literal(
      IndexName = IndexName,
      KeySchema = KeySchema,
      Projection = Projection
    )
    .asInstanceOf[LocalSecondaryIndex]
}

@js.native
trait StreamSpecification extends js.Object {
  val StreamEnabled: Boolean = js.native

  /** KEYS_ONLY - Only the key attributes of the modified item are written to
    * the stream.
    *
    * NEW_IMAGE - The entire item, as it appears after it was modified, is
    * written to the stream.
    *
    * OLD_IMAGE - The entire item, as it appeared before it was modified, is
    * written to the stream.
    *
    * NEW_AND_OLD_IMAGES - Both the new and the old item images of the item are
    * written to the stream.
    *
    * @return
    */
  val StreamViewType: js.UndefOr[String] = js.native
}

object StreamSpecification {
  def apply(
      StreamEnabled: Boolean,
      StreamViewType: js.UndefOr[String] = js.undefined
  ): StreamSpecification = js.Dynamic
    .literal(
      StreamEnabled = StreamEnabled,
      StreamViewType = StreamViewType
    )
    .asInstanceOf[StreamSpecification]
}

// TODO It is huge https://docs.aws.amazon.com/AWSJavaScriptSDK/v3/latest/clients/client-dynamodb/interfaces/tabledescription.html#tablename
@js.native
trait TableDescription extends js.Object {
  // val ArchivalSummary: js.UndefOr[ArchivalSummary] = js.native
  val AttributeDefinitions: js.UndefOr[AttributeDefinition] = js.native
  val TableName: js.UndefOr[String] = js.native
}

@js.native
trait ConsumedCapacity extends js.Object {
  val TableName: js.UndefOr[String] = js.native
  val Table: js.UndefOr[Capacity] = js.native
  val CapacityUnits: js.UndefOr[Int] = js.native
  val ReadCapacityUnits: js.UndefOr[Int] = js.native
  val WriteCapacityUnits: js.UndefOr[Int] = js.native
  val GlobalSecondaryIndexes: js.UndefOr[js.Dictionary[Capacity]] = js.native
  val LocalSecondaryIndexes: js.UndefOr[js.Dictionary[Capacity]] = js.native

}

@js.native
trait Capacity extends js.Object {
  val CapacityUnits: js.UndefOr[Int] = js.native
  val ReadCapacityUnits: js.UndefOr[Int] = js.native
  val WriteCapacityUnits: js.UndefOr[Int] = js.native
}

@js.native
trait ItemCollectionMetrics extends js.Object {
  val ItemCollectionKey: js.UndefOr[js.Dictionary[AttributeValue]] = js.native
  val SizeEstimateRangeGB: js.UndefOr[js.Array[Int]] = js.native
}

@js.native
trait ReturnValues extends js.Any
object ReturnValues {
  val None = "NONE".asInstanceOf[ReturnValues]
  val AllOld = "ALL_OLD".asInstanceOf[ReturnValues]
}

@js.native
trait ReturnConsumedCapacity extends js.Any
object ReturnConsumedCapacity {
  val Indexes = "INDEXES".asInstanceOf[ReturnConsumedCapacity]
  val Total = "TOTAL".asInstanceOf[ReturnConsumedCapacity]
  val None = "NONE".asInstanceOf[ReturnConsumedCapacity]
}

@js.native
trait ReturnItemCollectionMetrics extends js.Any
object ReturnItemCollectionMetrics {
  val Size = "SIZE".asInstanceOf[ReturnItemCollectionMetrics]
  val None = "NONE".asInstanceOf[ReturnItemCollectionMetrics]
}

import scala.scalajs.js
import scala.scalajs.js.typedarray.Uint8Array

@js.native
trait AttributeValue extends js.Object {
  def S: js.UndefOr[String] = js.native
  def N: js.UndefOr[String] = js.native
  def B: js.UndefOr[Uint8Array] = js.native
  def SS: js.UndefOr[js.Array[String]] = js.native
  def NS: js.UndefOr[js.Array[String]] = js.native
  def BS: js.UndefOr[js.Array[Uint8Array]] = js.native
  def M: js.UndefOr[js.Dictionary[AttributeValue]] = js.native
  def L: js.UndefOr[js.Array[AttributeValue]] = js.native
  def NULL: js.UndefOr[Boolean] = js.native
  def BOOL: js.UndefOr[Boolean] = js.native
  def $unknown: js.UndefOr[js.Tuple2[String, js.Any]] = js.native
}

object AttributeValue {
  val NULL: AttributeValue =
    js.Dynamic.literal(NULL = true).asInstanceOf[AttributeValue]
  def BOOL(value: Boolean): AttributeValue =
    js.Dynamic.literal(BOOL = value).asInstanceOf[AttributeValue]
  def S(value: String): AttributeValue =
    js.Dynamic.literal(S = value).asInstanceOf[AttributeValue]
  def N(value: String): AttributeValue =
    js.Dynamic.literal(N = value).asInstanceOf[AttributeValue]
  def B(value: Uint8Array): AttributeValue =
    js.Dynamic.literal(B = value).asInstanceOf[AttributeValue]
  def M(value: js.Dictionary[AttributeValue]): AttributeValue =
    js.Dynamic.literal(M = value).asInstanceOf[AttributeValue]
  def L(value: js.Array[AttributeValue]): AttributeValue =
    js.Dynamic.literal(L = value).asInstanceOf[AttributeValue]
  def SS(value: js.Array[String]): AttributeValue =
    js.Dynamic.literal(SS = value).asInstanceOf[AttributeValue]
  def NS(value: js.Array[String]): AttributeValue =
    js.Dynamic.literal(NS = value).asInstanceOf[AttributeValue]
  def BS(value: js.Array[Uint8Array]): AttributeValue =
    js.Dynamic.literal(BS = value).asInstanceOf[AttributeValue]
}
