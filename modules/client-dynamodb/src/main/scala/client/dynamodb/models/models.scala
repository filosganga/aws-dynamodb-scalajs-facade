package com.filippodeluca.jsfacade.awssdk
package client
package dynamodb
package models

import com.filippodeluca.jsfacade.awssdk.types.MetadataBearer
import scalajs.js
import scalajs.js.typedarray.Uint8Array

sealed trait ScalarAttributeType extends js.Any
object ScalarAttributeType {
  val B = "B".asInstanceOf[ScalarAttributeType]
  val N = "N".asInstanceOf[ScalarAttributeType]
  val S = "S".asInstanceOf[ScalarAttributeType]
}

sealed trait KeyType extends js.Any
object KeyType {
  val Hash = "HASH".asInstanceOf[KeyType]
  val Range = "RANGE".asInstanceOf[KeyType]
}

@js.native
trait AttributeDefinition extends js.Object {
  val AttributeName: js.UndefOr[String] = js.native
  val AttributeType: js.UndefOr[ScalarAttributeType] = js.native
}

object AttributeDefinition {
  def apply(
      AttributeName: js.UndefOr[String] = js.undefined,
      AttributeType: js.UndefOr[ScalarAttributeType] = js.undefined
  ): AttributeDefinition = js.Dynamic
    .literal(
      AttributeName = AttributeName.asInstanceOf[js.Any],
      AttributeType = AttributeType.asInstanceOf[js.Any]
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
  val KeyType: js.UndefOr[KeyType] = js.native
}

object KeySchemaElement {
  def apply(
      AttributeName: js.UndefOr[String] = js.undefined,
      KeyType: js.UndefOr[KeyType] = js.undefined
  ): KeySchemaElement = js.Dynamic
    .literal(
      AttributeName = AttributeName.asInstanceOf[js.Any],
      KeyType = KeyType.asInstanceOf[js.Any]
    )
    .asInstanceOf[KeySchemaElement]
}

@js.native
trait Projection extends js.Object {

  /** <p>The set of attributes that are projected into the index:</p> <ul> <li>
    * <p> <code>KEYS_ONLY</code> - Only the index and primary keys are projected
    * into the index.</p> </li> <li> <p> <code>INCLUDE</code> - In addition to
    * the attributes described in <code>KEYS_ONLY</code>, the secondary index
    * will include other non-key attributes that you specify.</p> </li> <li> <p>
    * <code>ALL</code> - All of the table attributes are projected into the
    * index.</p> </li> </ul>
    */
  val ProjectionType: js.UndefOr[ProjectionType] = js.native

  /** <p>Represents the non-key attribute names which will be projected into the
    * index.</p> <p>For local secondary indexes, the total count of
    * <code>NonKeyAttributes</code> summed across all of the local secondary
    * indexes, must not exceed 100. If you project the same attribute into two
    * different indexes, this counts as two distinct attributes when determining
    * the total.</p>
    */
  val NonKeyAttributes: js.UndefOr[js.Array[String]] = js.native
}

object Projection {
  def apply(
      ProjectionType: js.UndefOr[ProjectionType] = js.undefined,
      NonKeyAttributes: js.UndefOr[js.Array[String]] = js.undefined
  ): Projection = js.Dynamic
    .literal(
      ProjectionType = ProjectionType.asInstanceOf[js.Any],
      NonKeyAttributes = NonKeyAttributes.asInstanceOf[js.Any]
    )
    .asInstanceOf[Projection]
}

@js.native
trait GlobalSecondaryIndex extends js.Object {
  val IndexName: String = js.native
  val KeySchema: js.Array[KeySchemaElement] = js.native
  val Projection: Projection = js.native
  val ProvisionedThroughput: js.UndefOr[ProvisionedThroughput] = js.native
}

object GlobalSecondaryIndex {
  def apply(
      IndexName: String,
      KeySchema: js.Array[KeySchemaElement],
      Projection: Projection,
      ProvisionedThroughput: js.UndefOr[ProvisionedThroughput] = js.undefined
  ): GlobalSecondaryIndex = js.Dynamic
    .literal(
      IndexName = IndexName,
      KeySchema = KeySchema,
      Projection = Projection,
      ProvisionedThroughput = ProvisionedThroughput.asInstanceOf[js.Any]
    )
    .asInstanceOf[GlobalSecondaryIndex]
}

@js.native
trait LocalSecondaryIndex extends js.Object {
  val IndexName: String = js.native
  val KeySchema: js.Array[KeySchemaElement] = js.native
  val Projection: js.UndefOr[Projection] = js.native
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

sealed trait StreamViewType extends js.Any
object StreamViewType {
  val KeysOnly = "KEYS_ONLY".asInstanceOf[StreamViewType]
  val NewImage = "NEW_IMAGE".asInstanceOf[StreamViewType]
  val OldImage = "OLD_IMAGE".asInstanceOf[StreamViewType]
  val NewAndOldImages = "NEW_AND_OLD_IMAGES".asInstanceOf[StreamViewType]
}

@js.native
trait StreamSpecification extends js.Object {
  val StreamEnabled: Boolean = js.native
  val StreamViewType: js.UndefOr[StreamViewType] = js.native
}

object StreamSpecification {
  def apply(
      StreamEnabled: Boolean,
      StreamViewType: js.UndefOr[StreamViewType] = js.undefined
  ): StreamSpecification = js.Dynamic
    .literal(
      StreamEnabled = StreamEnabled,
      StreamViewType = StreamViewType.asInstanceOf[js.Any]
    )
    .asInstanceOf[StreamSpecification]
}

/** <p>Contains details of a table archival operation.</p>
  */
@js.native
trait ArchivalSummary extends js.Object {

  /** <p>The date and time when table archival was initiated by DynamoDB, in
    * UNIX epoch time format.</p>
    */
  val ArchivalDateTime: js.UndefOr[js.Date] = js.native

  /** <p>The reason DynamoDB archived the table. Currently, the only possible
    * value is:</p>
    *
    * <ul> <li> <p> <code>INACCESSIBLE_ENCRYPTION_CREDENTIALS</code> - The table
    * was archived due to the table's KMS key being inaccessible for more than
    * seven days. An On-Demand backup was created at the archival time.</p>
    * </li> </ul>
    */
  val ArchivalReason: js.UndefOr[String] = js.native

  /** <p>The Amazon Resource Name (ARN) of the backup the table was archived to,
    * when applicable in the archival reason. If you wish to restore this backup
    * to the same table name, you will need to delete the original table.</p>
    */
  val ArchivalBackupArn: js.UndefOr[String] = js.native
}

/** <p>Contains the details for the read/write capacity mode. This page talks
  * about <code>PROVISIONED</code> and <code>PAY_PER_REQUEST</code> billing
  * modes. For more information about these modes, see <a
  * href="https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.ReadWriteCapacityMode.html">Read/write
  * capacity mode</a>.</p> <note> <p>You may need to switch to on-demand mode at
  * least once in order to return a <code>BillingModeSummary</code>
  * response.</p> </note>
  */
@js.native
trait BillingModeSummary extends js.Object {

  /** <p>Controls how you are charged for read and write throughput and how you
    * manage capacity. This setting can be changed later.</p> <ul> <li> <p>
    * <code>PROVISIONED</code> - Sets the read/write capacity mode to
    * <code>PROVISIONED</code>. We recommend using <code>PROVISIONED</code> for
    * predictable workloads.</p> </li> <li> <p> <code>PAY_PER_REQUEST</code> -
    * Sets the read/write capacity mode to <code>PAY_PER_REQUEST</code>. We
    * recommend using <code>PAY_PER_REQUEST</code> for unpredictable workloads.
    * </p> </li> </ul>
    */
  val BillingMode: js.UndefOr[BillingMode] = js.native

  /** <p>Represents the time when <code>PAY_PER_REQUEST</code> was last set as
    * the read/write capacity mode.</p>
    */
  val LastUpdateToPayPerRequestDateTime: js.UndefOr[js.Date] = js.native
}

@js.native
sealed trait TableStatus extends js.Any
object TableStatus {
  val Active = "ACTIVE".asInstanceOf[TableStatus]
  val Archived = "ARCHIVED".asInstanceOf[TableStatus]
  val Archiving = "ARCHIVING".asInstanceOf[TableStatus]
  val Creating = "CREATING".asInstanceOf[TableStatus]
  val Deleting = "DELETING".asInstanceOf[TableStatus]
  val InaccessibleEncryptionCredentials =
    "INACCESSIBLE_ENCRYPTION_CREDENTIALS".asInstanceOf[TableStatus]
  val Updating = "UPDATING".asInstanceOf[TableStatus]
}

@js.native
sealed trait IndexStatus extends js.Any
object IndexStatus {
  val Active = "ACTIVE".asInstanceOf[IndexStatus]
  val Creating = "CREATING".asInstanceOf[IndexStatus]
  val Deleting = "DELETING".asInstanceOf[IndexStatus]
  val Updating = "UPDATING".asInstanceOf[IndexStatus]
}

@js.native
sealed trait ProjectionType extends js.Any
object ProjectionType {
  val All = "ALL".asInstanceOf[ProjectionType]
  val Include = "INCLUDE".asInstanceOf[ProjectionType]
  val KeysOnly = "KEYS_ONLY".asInstanceOf[ProjectionType]
}

@js.native
trait ProvisionedThroughputDescription extends js.Object {

  /** <p>The date and time of the last provisioned throughput increase for this
    * table.</p>
    */
  val LastIncreaseDateTime: js.UndefOr[js.Date] = js.native

  /** <p>The date and time of the last provisioned throughput decrease for this
    * table.</p>
    */
  val LastDecreaseDateTime: js.UndefOr[js.Date] = js.native

  /** <p>The Double of provisioned throughput decreases for this table during
    * this UTC calendar day. For current maximums on provisioned throughput
    * decreases, see <a
    * href="https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Limits.html">Service,
    * Account, and Table Quotas</a> in the <i>Amazon DynamoDB Developer
    * Guide</i>.</p>
    */
  val NumberOfDecreasesToday: js.UndefOr[Double] = js.native

  /** <p>The maximum Double of strongly consistent reads consumed per second
    * before DynamoDB returns a <code>ThrottlingException</code>. Eventually
    * consistent reads require less effort than strongly consistent reads, so a
    * setting of 50 <code>ReadCapacityUnits</code> per second provides 100
    * eventually consistent <code>ReadCapacityUnits</code> per second.</p>
    */
  val ReadCapacityUnits: js.UndefOr[Double] = js.native

  /** <p>The maximum Double of writes consumed per second before DynamoDB
    * returns a <code>ThrottlingException</code>.</p>
    */
  val WriteCapacityUnits: js.UndefOr[Double] = js.native
}

/** <p>Represents the properties of a global secondary index.</p>
  */
@js.native
trait GlobalSecondaryIndexDescription extends js.Object {

  /** <p>The name of the global secondary index.</p>
    */
  val IndexName: js.UndefOr[String] = js.native

  /** <p>The complete key schema for a global secondary index, which consists of
    * one or more pairs of attribute names and key types:</p> <ul> <li> <p>
    * <code>HASH</code> - partition key</p> </li> <li> <p> <code>RANGE</code> -
    * sort key</p> </li> </ul> <note> <p>The partition key of an item is also
    * known as its <i>hash attribute</i>. The term "hash attribute" derives from
    * DynamoDB's usage of an internal hash function to evenly distribute data
    * items across partitions, based on their partition key values.</p> <p>The
    * sort key of an item is also known as its <i>range attribute</i>. The term
    * "range attribute" derives from the way DynamoDB stores items with the same
    * partition key physically close together, in sorted order by the sort key
    * value.</p> </note>
    */
  val KeySchema: js.UndefOr[js.Array[KeySchemaElement]] = js.native

  /** <p>Represents attributes that are copied (projected) from the table into
    * the global secondary index. These are in addition to the primary key
    * attributes and index key attributes, which are automatically projected.
    * </p>
    */
  val Projection: js.UndefOr[Projection] = js.native

  /** <p>The current state of the global secondary index:</p> <ul> <li> <p>
    * <code>CREATING</code> - The index is being created.</p> </li> <li> <p>
    * <code>UPDATING</code> - The index is being updated.</p> </li> <li> <p>
    * <code>DELETING</code> - The index is being deleted.</p> </li> <li> <p>
    * <code>ACTIVE</code> - The index is ready for use.</p> </li> </ul>
    */
  val IndexStatus: js.UndefOr[IndexStatus] = js.native

  /** <p>Indicates whether the index is currently backfilling.
    * <i>Backfilling</i> is the process of reading items from the table and
    * determining whether they can be added to the index. (Not all items will
    * qualify: For example, a partition key cannot have any duplicate values.)
    * If an item can be added to the index, DynamoDB will do so. After all items
    * have been processed, the backfilling operation is complete and
    * <code>Backfilling</code> is false.</p> <p>You can delete an index that is
    * being created during the <code>Backfilling</code> phase when
    * <code>IndexStatus</code> is set to CREATING and <code>Backfilling</code>
    * is true. You can't delete the index that is being created when
    * <code>IndexStatus</code> is set to CREATING and <code>Backfilling</code>
    * is false. </p> <note> <p>For indexes that were created during a
    * <code>CreateTable</code> operation, the <code>Backfilling</code> attribute
    * does not appear in the <code>DescribeTable</code> output.</p> </note>
    */
  val Backfilling: js.UndefOr[Boolean] = js.native

  /** <p>Represents the provisioned throughput settings for the specified global
    * secondary index.</p> <p>For current minimum and maximum provisioned
    * throughput values, see <a
    * href="https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Limits.html">Service,
    * Account, and Table Quotas</a> in the <i>Amazon DynamoDB Developer
    * Guide</i>.</p>
    */
  val ProvisionedThroughput: js.UndefOr[ProvisionedThroughputDescription] =
    js.native

  /** <p>The total size of the specified index, in bytes. DynamoDB updates this
    * value approximately every six hours. Recent changes might not be reflected
    * in this value.</p>
    */
  val IndexSizeBytes: js.UndefOr[Double] = js.native

  /** <p>The Double of items in the specified index. DynamoDB updates this value
    * approximately every six hours. Recent changes might not be reflected in
    * this value.</p>
    */
  val ItemCount: js.UndefOr[Double] = js.native

  /** <p>The Amazon Resource Name (ARN) that uniquely identifies the index.</p>
    */
  val IndexArn: js.UndefOr[String] = js.native
}

/** <p>Represents the properties of a local secondary index.</p>
  */
@js.native
trait LocalSecondaryIndexDescription extends js.Object {

  /** <p>Represents the name of the local secondary index.</p>
    */
  val IndexName: js.UndefOr[String] = js.native

  /** <p>The complete key schema for the local secondary index, consisting of
    * one or more pairs of attribute names and key types:</p> <ul> <li> <p>
    * <code>HASH</code> - partition key</p> </li> <li> <p> <code>RANGE</code> -
    * sort key</p> </li> </ul> <note> <p>The partition key of an item is also
    * known as its <i>hash attribute</i>. The term "hash attribute" derives from
    * DynamoDB's usage of an internal hash function to evenly distribute data
    * items across partitions, based on their partition key values.</p> <p>The
    * sort key of an item is also known as its <i>range attribute</i>. The term
    * "range attribute" derives from the way DynamoDB stores items with the same
    * partition key physically close together, in sorted order by the sort key
    * value.</p> </note>
    */
  val KeySchema: js.UndefOr[js.Array[KeySchemaElement]] = js.native

  /** <p>Represents attributes that are copied (projected) from the table into
    * the global secondary index. These are in addition to the primary key
    * attributes and index key attributes, which are automatically projected.
    * </p>
    */
  val Projection: js.UndefOr[Projection] = js.native

  /** <p>The total size of the specified index, in bytes. DynamoDB updates this
    * value approximately every six hours. Recent changes might not be reflected
    * in this value.</p>
    */
  val IndexSizeBytes: js.UndefOr[Double] = js.native

  /** <p>The Double of items in the specified index. DynamoDB updates this value
    * approximately every six hours. Recent changes might not be reflected in
    * this value.</p>
    */
  val ItemCount: js.UndefOr[Double] = js.native

  /** <p>The Amazon Resource Name (ARN) that uniquely identifies the index.</p>
    */
  val IndexArn: js.UndefOr[String] = js.native
}

/** <p>Contains details for the restore.</p>
  */
@js.native
trait RestoreSummary extends js.Object {

  /** <p>The Amazon Resource Name (ARN) of the backup from which the table was
    * restored.</p>
    */
  val SourceBackupArn: js.UndefOr[String] = js.native

  /** <p>The ARN of the source table of the backup that is being restored.</p>
    */
  val SourceTableArn: js.UndefOr[String] = js.native

  /** <p>Point in time or source backup time.</p>
    */
  val RestoreDateTime: js.UndefOr[js.Date] = js.native

  /** <p>Indicates if a restore is in progress or not.</p>
    */
  val RestoreInProgress: js.UndefOr[Boolean] = js.native
}

/** <p>Contains details of the table class.</p>
  */
@js.native
trait TableClassSummary extends js.Object {

  /** <p>The table class of the specified table. Valid values are
    * <code>STANDARD</code> and <code>STANDARD_INFREQUENT_ACCESS</code>.</p>
    */
  val TableClass: js.UndefOr[TableClass] = js.native

  /** <p>The date and time at which the table class was last updated.</p>
    */
  val LastUpdateDateTime: js.UndefOr[js.Date] = js.native
}

/** <p>Represents the properties of a table.</p>
  */
@js.native
trait TableDescription extends js.Object {

  /** <p>An array of <code>AttributeDefinition</code> objects. Each of these
    * objects describes one attribute in the table and index key schema.</p>
    * <p>Each <code>AttributeDefinition</code> object in this array is composed
    * of:</p> <ul> <li> <p> <code>AttributeName</code> - The name of the
    * attribute.</p> </li> <li> <p> <code>AttributeType</code> - The data type
    * for the attribute.</p> </li> </ul>
    */
  val AttributeDefinitions: js.UndefOr[js.Array[AttributeDefinition]] =
    js.native

  /** <p>The name of the table.</p>
    */
  val TableName: js.UndefOr[String] = js.native

  /** <p>The primary key structure for the table. Each
    * <code>KeySchemaElement</code> consists of:</p> <ul> <li> <p>
    * <code>AttributeName</code> - The name of the attribute.</p> </li> <li> <p>
    * <code>KeyType</code> - The role of the attribute:</p> <ul> <li> <p>
    * <code>HASH</code> - partition key</p> </li> <li> <p> <code>RANGE</code> -
    * sort key</p> </li> </ul> <note> <p>The partition key of an item is also
    * known as its <i>hash attribute</i>. The term "hash attribute" derives from
    * DynamoDB's usage of an internal hash function to evenly distribute data
    * items across partitions, based on their partition key values.</p> <p>The
    * sort key of an item is also known as its <i>range attribute</i>. The term
    * "range attribute" derives from the way DynamoDB stores items with the same
    * partition key physically close together, in sorted order by the sort key
    * value.</p> </note>
    *
    * </li> </ul> <p>For more information about primary keys, see <a
    * href="https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey">Primary
    * Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.</p>
    */
  val KeySchema: js.UndefOr[js.Array[KeySchemaElement]] = js.native

  /** <p>The current state of the table:</p> <ul> <li> <p> <code>CREATING</code>
    * \- The table is being created.</p> </li> <li> <p> <code>UPDATING</code> -
    * The table/index configuration is being updated. The table/index remains
    * available for data operations when <code>UPDATING</code>.</p> </li> <li>
    * <p> <code>DELETING</code> - The table is being deleted.</p> </li> <li> <p>
    * <code>ACTIVE</code> - The table is ready for use.</p> </li> <li> <p>
    * <code>INACCESSIBLE_ENCRYPTION_CREDENTIALS</code> - The KMS key used to
    * encrypt the table in inaccessible. Table operations may fail due to
    * failure to use the KMS key. DynamoDB will initiate the table archival
    * process when a table's KMS key remains inaccessible for more than seven
    * days. </p> </li> <li> <p> <code>ARCHIVING</code> - The table is being
    * archived. Operations are not allowed until archival is complete. </p>
    * </li> <li> <p> <code>ARCHIVED</code> - The table has been archived. See
    * the ArchivalReason for more information. </p> </li> </ul>
    */
  val TableStatus: js.UndefOr[TableStatus] = js.native

  /** <p>The date and time when the table was created, in <a
    * href="http://www.epochconverter.com/">UNIX epoch time</a> format.</p>
    */
  val CreationDateTime: js.UndefOr[js.Date] = js.native

  /** <p>The provisioned throughput settings for the table, consisting of read
    * and write capacity units, along with data about increases and
    * decreases.</p>
    */
  val ProvisionedThroughput: js.UndefOr[ProvisionedThroughputDescription] =
    js.native

  /** <p>The total size of the specified table, in bytes. DynamoDB updates this
    * value approximately every six hours. Recent changes might not be reflected
    * in this value.</p>
    */
  val TableSizeBytes: js.UndefOr[Double] = js.native

  /** <p>The Double of items in the specified table. DynamoDB updates this value
    * approximately every six hours. Recent changes might not be reflected in
    * this value.</p>
    */
  val ItemCount: js.UndefOr[Double] = js.native

  /** <p>The Amazon Resource Name (ARN) that uniquely identifies the table.</p>
    */
  val TableArn: js.UndefOr[String] = js.native

  /** <p>Unique identifier for the table for which the backup was created. </p>
    */
  val TableId: js.UndefOr[String] = js.native

  /** <p>Contains the details for the read/write capacity mode.</p>
    */
  val BillingModeSummary: js.UndefOr[BillingModeSummary] = js.native

  /** <p>Represents one or more local secondary indexes on the table. Each index
    * is scoped to a given partition key value. Tables with one or more local
    * secondary indexes are subject to an item collection size limit, where the
    * amount of data within a given item collection cannot exceed 10 GB. Each
    * element is composed of:</p> <ul> <li> <p> <code>IndexName</code> - The
    * name of the local secondary index.</p> </li> <li> <p>
    * <code>KeySchema</code> - Specifies the complete index key schema. The
    * attribute names in the key schema must be between 1 and 255 characters
    * (inclusive). The key schema must begin with the same partition key as the
    * table.</p> </li> <li> <p> <code>Projection</code> - Specifies attributes
    * that are copied (projected) from the table into the index. These are in
    * addition to the primary key attributes and index key attributes, which are
    * automatically projected. Each attribute specification is composed of:</p>
    * <ul> <li> <p> <code>ProjectionType</code> - One of the following:</p> <ul>
    * <li> <p> <code>KEYS_ONLY</code> - Only the index and primary keys are
    * projected into the index.</p> </li> <li> <p> <code>INCLUDE</code> - Only
    * the specified table attributes are projected into the index. The list of
    * projected attributes is in <code>NonKeyAttributes</code>.</p> </li> <li>
    * <p> <code>ALL</code> - All of the table attributes are projected into the
    * index.</p> </li> </ul> </li> <li> <p> <code>NonKeyAttributes</code> - A
    * list of one or more non-key attribute names that are projected into the
    * secondary index. The total count of attributes provided in
    * <code>NonKeyAttributes</code>, summed across all of the secondary indexes,
    * must not exceed 100. If you project the same attribute into two different
    * indexes, this counts as two distinct attributes when determining the
    * total.</p> </li> </ul> </li> <li> <p> <code>IndexSizeBytes</code> -
    * Represents the total size of the index, in bytes. DynamoDB updates this
    * value approximately every six hours. Recent changes might not be reflected
    * in this value.</p> </li> <li> <p> <code>ItemCount</code> - Represents the
    * Double of items in the index. DynamoDB updates this value approximately
    * every six hours. Recent changes might not be reflected in this value.</p>
    * </li> </ul> <p>If the table is in the <code>DELETING</code> state, no
    * information about indexes will be returned.</p>
    */
  val LocalSecondaryIndexes
      : js.UndefOr[js.Array[LocalSecondaryIndexDescription]] = js.native

  /** <p>The global secondary indexes, if any, on the table. Each index is
    * scoped to a given partition key value. Each element is composed of:</p>
    * <ul> <li> <p> <code>Backfilling</code> - If true, then the index is
    * currently in the backfilling phase. Backfilling occurs only when a new
    * global secondary index is added to the table. It is the process by which
    * DynamoDB populates the new index with data from the table. (This attribute
    * does not appear for indexes that were created during a
    * <code>CreateTable</code> operation.) </p> <p> You can delete an index that
    * is being created during the <code>Backfilling</code> phase when
    * <code>IndexStatus</code> is set to CREATING and <code>Backfilling</code>
    * is true. You can't delete the index that is being created when
    * <code>IndexStatus</code> is set to CREATING and <code>Backfilling</code>
    * is false. (This attribute does not appear for indexes that were created
    * during a <code>CreateTable</code> operation.)</p> </li> <li> <p>
    * <code>IndexName</code> - The name of the global secondary index.</p> </li>
    * <li> <p> <code>IndexSizeBytes</code> - The total size of the global
    * secondary index, in bytes. DynamoDB updates this value approximately every
    * six hours. Recent changes might not be reflected in this value. </p> </li>
    * <li> <p> <code>IndexStatus</code> - The current status of the global
    * secondary index:</p> <ul> <li> <p> <code>CREATING</code> - The index is
    * being created.</p> </li> <li> <p> <code>UPDATING</code> - The index is
    * being updated.</p> </li> <li> <p> <code>DELETING</code> - The index is
    * being deleted.</p> </li> <li> <p> <code>ACTIVE</code> - The index is ready
    * for use.</p> </li> </ul> </li> <li> <p> <code>ItemCount</code> - The
    * Double of items in the global secondary index. DynamoDB updates this value
    * approximately every six hours. Recent changes might not be reflected in
    * this value. </p> </li> <li> <p> <code>KeySchema</code> - Specifies the
    * complete index key schema. The attribute names in the key schema must be
    * between 1 and 255 characters (inclusive). The key schema must begin with
    * the same partition key as the table.</p> </li> <li> <p>
    * <code>Projection</code> - Specifies attributes that are copied (projected)
    * from the table into the index. These are in addition to the primary key
    * attributes and index key attributes, which are automatically projected.
    * Each attribute specification is composed of:</p> <ul> <li> <p>
    * <code>ProjectionType</code> - One of the following:</p> <ul> <li> <p>
    * <code>KEYS_ONLY</code> - Only the index and primary keys are projected
    * into the index.</p> </li> <li> <p> <code>INCLUDE</code> - In addition to
    * the attributes described in <code>KEYS_ONLY</code>, the secondary index
    * will include other non-key attributes that you specify.</p> </li> <li> <p>
    * <code>ALL</code> - All of the table attributes are projected into the
    * index.</p> </li> </ul> </li> <li> <p> <code>NonKeyAttributes</code> - A
    * list of one or more non-key attribute names that are projected into the
    * secondary index. The total count of attributes provided in
    * <code>NonKeyAttributes</code>, summed across all of the secondary indexes,
    * must not exceed 100. If you project the same attribute into two different
    * indexes, this counts as two distinct attributes when determining the
    * total.</p> </li> </ul> </li> <li> <p> <code>ProvisionedThroughput</code> -
    * The provisioned throughput settings for the global secondary index,
    * consisting of read and write capacity units, along with data about
    * increases and decreases. </p> </li> </ul> <p>If the table is in the
    * <code>DELETING</code> state, no information about indexes will be
    * returned.</p>
    */
  val GlobalSecondaryIndexes
      : js.UndefOr[js.Array[GlobalSecondaryIndexDescription]] = js.native

  /** <p>The current DynamoDB Streams configuration for the table.</p>
    */
  val StreamSpecification: js.UndefOr[StreamSpecification] = js.native

  /** <p>A timestamp, in ISO 8601 format, for this stream.</p>
    *
    * <p>Note that <code>LatestStreamLabel</code> is not a unique identifier for
    * the stream, because it is possible that a stream from another table might
    * have the same timestamp. However, the combination of the following three
    * elements is guaranteed to be unique:</p> <ul> <li> <p>Amazon Web Services
    * customer ID</p> </li> <li> <p>Table name</p> </li> <li> <p>
    * <code>StreamLabel</code> </p> </li> </ul>
    */
  val LatestStreamLabel: js.UndefOr[String] = js.native

  /** <p>The Amazon Resource Name (ARN) that uniquely identifies the latest
    * stream for this table.</p>
    */
  val LatestStreamArn: js.UndefOr[String] = js.native

  /** <p>Represents the version of <a
    * href="https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/GlobalTables.html">global
    * tables</a> in use, if the table is replicated across Amazon Web Services
    * Regions.</p>
    */
  val GlobalTableVersion: js.UndefOr[String] = js.native

  /** <p>Represents replicas of the table.</p>
    */
  // TODO val Replicas: js.UndefOr[js.Array[ReplicaDescription]] = js.native

  /** <p>Contains details for the restore.</p>
    */
  val RestoreSummary: js.UndefOr[RestoreSummary] = js.native

  /** <p>The description of the server-side encryption status on the specified
    * table.</p>
    */
  val SSEDescription: js.UndefOr[SSEDescription] = js.native

  /** <p>Contains information about the table archive.</p>
    */
  val ArchivalSummary: js.UndefOr[ArchivalSummary] = js.native

  /** <p>Contains details of the table class.</p>
    */
  val TableClassSummary: js.UndefOr[TableClassSummary] = js.native
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
sealed trait ReturnValues extends js.Any
object ReturnValues {
  val None = "NONE".asInstanceOf[ReturnValues]
  val AllOld = "ALL_OLD".asInstanceOf[ReturnValues]
}

@js.native
sealed trait ReturnValue extends js.Any
object ReturnValue {
  val AllNew = "ALL_NEW".asInstanceOf[ReturnValue]
  val AllOld = "ALL_OLD".asInstanceOf[ReturnValue]
  val None = "NONE".asInstanceOf[ReturnValue]
  val UpdatedNew = "UPDATED_NEW".asInstanceOf[ReturnValue]
  val UpdatedOld = "UPDATED_OLD".asInstanceOf[ReturnValue]
}

@js.native
sealed trait ReturnConsumedCapacity extends js.Any
object ReturnConsumedCapacity {
  val Indexes = "INDEXES".asInstanceOf[ReturnConsumedCapacity]
  val Total = "TOTAL".asInstanceOf[ReturnConsumedCapacity]
  val None = "NONE".asInstanceOf[ReturnConsumedCapacity]
}

@js.native
sealed trait ReturnItemCollectionMetrics extends js.Any
object ReturnItemCollectionMetrics {
  val Size = "SIZE".asInstanceOf[ReturnItemCollectionMetrics]
  val None = "NONE".asInstanceOf[ReturnItemCollectionMetrics]
}

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

sealed trait BillingMode extends js.Any
object BillingMode {
  val Provisioned = "PROVISIONED".asInstanceOf[BillingMode]
  val PayPerRequest = "PAY_PER_REQUEST".asInstanceOf[BillingMode]
}

sealed trait TableClass extends js.Any
object TableClass {
  val Standard = "STANDARD".asInstanceOf[TableClass]
  val StandardInfrequentAccess =
    "STANDARD_INFREQUENT_ACCESS".asInstanceOf[TableClass]
}

trait Select extends js.Any
object Select {
  val AllAttributes = "ALL_ATTRIBUTES".asInstanceOf[Select]
  val AllProjectedAttributes = "ALL_PROJECTED_ATTRIBUTES".asInstanceOf[Select]
  val SpecificAttributes = "SPECIFIC_ATTRIBUTES".asInstanceOf[Select]
  val Count = "COUNT".asInstanceOf[Select]
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
trait BatchGetItemCommandOutput extends MetadataBearer {
  val ConsumedCapacity: js.UndefOr[ConsumedCapacity] = js.native
  val Responses
      : js.UndefOr[js.Dictionary[js.Array[js.Dictionary[AttributeValue]]]] =
    js.native
  val UnprocessedKeys: js.UndefOr[js.Dictionary[KeysAndAttributes]] =
    js.native
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
trait BatchWriteItemCommandOutput extends MetadataBearer {
  val ConsumedCapacity: js.UndefOr[ConsumedCapacity] = js.native
  val ItemCollectionMetrics: js.UndefOr[js.Dictionary[ItemCollectionMetrics]] =
    js.native
  val UnprocessedKeys: js.UndefOr[js.Dictionary[WriteRequest]] = js.native
}

@js.native
trait CreateTableCommandInput extends js.Object {
  val AttributeDefinitions: js.Array[AttributeDefinition] =
    js.native

  val BillingMode: js.UndefOr[BillingMode] =
    js.native
  val GlobalSecondaryIndexes: js.UndefOr[js.Array[GlobalSecondaryIndex]] =
    js.native
  val KeySchema: js.Array[KeySchemaElement] = js.native
  val LocalSecondaryIndexes: js.UndefOr[js.Array[LocalSecondaryIndex]] =
    js.native
  val ProvisionedThroughput: js.UndefOr[ProvisionedThroughput] = js.native
  val StreamSpecification: js.UndefOr[StreamSpecification] = js.native
  val SSESpecification: js.UndefOr[SSESpecification] = js.native

  val TableClass: js.UndefOr[TableClass] = js.native
  val TableName: String = js.native

  val Tags: js.UndefOr[js.Array[Tag]] = js.native
}

object CreateTableCommandInput {
  def apply(
      TableName: String,
      AttributeDefinitions: js.Array[AttributeDefinition],
      KeySchema: js.Array[KeySchemaElement],
      BillingMode: js.UndefOr[BillingMode] = js.undefined,
      GlobalSecondaryIndexes: js.UndefOr[js.Array[GlobalSecondaryIndex]] =
        js.undefined,
      LocalSecondaryIndexes: js.UndefOr[js.Array[LocalSecondaryIndex]] =
        js.undefined,
      ProvisionedThroughput: js.UndefOr[ProvisionedThroughput] = js.undefined,
      StreamSpecification: js.UndefOr[StreamSpecification] = js.undefined,
      SSESpecification: js.UndefOr[SSESpecification] = js.undefined,
      TableClass: js.UndefOr[TableClass] = js.undefined,
      Tags: js.UndefOr[js.Array[Tag]] = js.undefined
  ): CreateTableCommandInput = js.Dynamic
    .literal(
      TableName = TableName,
      AttributeDefinitions = AttributeDefinitions,
      KeySchema = KeySchema,
      BillingMode = BillingMode.asInstanceOf[js.Any],
      GlobalSecondaryIndexes = GlobalSecondaryIndexes.asInstanceOf[js.Any],
      LocalSecondaryIndexes = LocalSecondaryIndexes.asInstanceOf[js.Any],
      ProvisionedThroughput = ProvisionedThroughput.asInstanceOf[js.Any],
      StreamSpecification = StreamSpecification.asInstanceOf[js.Any],
      TableClass = TableClass.asInstanceOf[js.Any],
      SSESpecification = SSESpecification.asInstanceOf[js.Any],
      Tags = Tags.asInstanceOf[js.Any]
    )
    .asInstanceOf[CreateTableCommandInput]
}

@js.native
trait CreateTableCommandOutput extends MetadataBearer {
  val TableDescription: js.UndefOr[TableDescription] = js.native
}

@js.native
trait DeleteTableCommandInput extends js.Object {
  val TableName: String = js.native
}

object DeleteTableCommandInput {
  def apply(
      TableName: String
  ): DeleteTableCommandInput = js.Dynamic
    .literal(
      TableName = TableName
    )
    .asInstanceOf[DeleteTableCommandInput]
}

@js.native
trait DeleteTableCommandOutput extends MetadataBearer {
  val TableDescription: js.UndefOr[TableDescription] = js.native
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
        ConsistentRead = ConsistentRead.asInstanceOf[js.Any],
        ExpressionAttributeNames =
          ExpressionAttributeNames.asInstanceOf[js.Any],
        Key = Key,
        ProjectionExpression = ProjectionExpression.asInstanceOf[js.Any],
        ReturnConsumedCapacity = ReturnConsumedCapacity.asInstanceOf[js.Any]
      )
      .asInstanceOf[GetItemCommandInput]
  }
}

@js.native
trait GetItemCommandOutput extends MetadataBearer {
  val Item: js.UndefOr[js.Dictionary[AttributeValue]] = js.native
  val ConsumedCapacity: js.UndefOr[ConsumedCapacity] = js.native
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
        ConditionExpression = ConditionExpression.asInstanceOf[js.Any],
        ExpressionAttributeNames =
          ExpressionAttributeNames.asInstanceOf[js.Any],
        ExpressionAttributeValues =
          ExpressionAttributeValues.asInstanceOf[js.Any],
        ReturnConsumedCapacity = ReturnConsumedCapacity.asInstanceOf[js.Any],
        ReturnItemCollectionMetrics =
          ReturnItemCollectionMetrics.asInstanceOf[js.Any],
        ReturnValues = ReturnValues.asInstanceOf[js.Any]
      )
      .asInstanceOf[PutItemCommandInput]
  }
}

@js.native
trait PutItemCommandOutput extends MetadataBearer {

  /** The attribute values as they appeared before the PutItem operation, but
    * only if ReturnValues is specified as ALL_OLD in the request. Each element
    * consists of an attribute name and an attribute valu
    */
  val Attributes: js.UndefOr[js.Dictionary[AttributeValue]] = js.native

  val ConsumedCapacity: js.UndefOr[ConsumedCapacity] = js.native

  val ItemCollectionMetrics: js.UndefOr[ItemCollectionMetrics] = js.native
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
        IndexName = IndexName.asInstanceOf[js.Any],
        ConsistentRead = ConsistentRead.asInstanceOf[js.Any],
        Select = Select.asInstanceOf[js.Any],
        KeyConditionExpression = KeyConditionExpression.asInstanceOf[js.Any],
        ProjectionExpression = ProjectionExpression.asInstanceOf[js.Any],
        FilterExpression = FilterExpression.asInstanceOf[js.Any],
        ExpressionAttributeNames =
          ExpressionAttributeNames.asInstanceOf[js.Any],
        ExpressionAttributeValues =
          ExpressionAttributeValues.asInstanceOf[js.Any],
        ExclusiveStartKey = ExclusiveStartKey.asInstanceOf[js.Any],
        Limit = Limit.asInstanceOf[js.Any],
        ScanIndexForward = ScanIndexForward.asInstanceOf[js.Any],
        ReturnConsumedCapacity = ReturnConsumedCapacity.asInstanceOf[js.Any]
      )
      .asInstanceOf[QueryCommandInput]
  }
}

@js.native
trait QueryCommandOutput extends MetadataBearer {
  val ConsumedCapacity: js.UndefOr[ConsumedCapacity] = js.native

  val Items: js.UndefOr[js.Array[js.Dictionary[AttributeValue]]] = js.native
  val Count: js.UndefOr[Int] = js.native
  val ScannedCount: js.UndefOr[Int] = js.native
  val LastEvaluatedKey: js.UndefOr[js.Dictionary[AttributeValue]] = js.native
}

/** <p>Describes a tag. A tag is a key-value pair. You can add up to 50 tags to
  * a single DynamoDB table. </p> <p>Amazon Web Services-assigned tag names and
  * values are automatically assigned the <code>aws:</code> prefix, which the
  * user cannot assign. Amazon Web Services-assigned tag names do not count
  * towards the tag limit of 50. User-assigned tag names have the prefix
  * <code>user:</code> in the Cost Allocation Report. You cannot backdate the
  * application of a tag.</p> <p>For an overview on tagging DynamoDB resources,
  * see <a
  * href="https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Tagging.html">Tagging
  * for DynamoDB</a> in the <i>Amazon DynamoDB Developer Guide</i>.</p>
  */
@js.native
trait Tag extends js.Object {

  /** <p>The key of the tag. Tag keys are case sensitive. Each DynamoDB table
    * can only have up to one tag with the same key. If you try to add an
    * existing tag (same key), the existing tag value will be updated to the new
    * value.</p>
    */
  val Key: String = js.native

  /** <p>The value of the tag. Tag values are case-sensitive and can be
    * null.</p>
    */
  val Value: String = js.native
}

object Tag {
  def apply(Key: String, Value: String): Tag = js.Dynamic
    .literal(
      Key = Key,
      Value = Value
    )
    .asInstanceOf[Tag]
}

@js.native
trait DescribeTableCommandInput extends js.Object {

  /** <p>The name of the table to describe.</p>
    */
  val TableName: String = js.native
}

object DescribeTableCommandInput {
  def apply(TableName: String): DescribeTableCommandInput = js.Dynamic
    .literal(TableName = TableName)
    .asInstanceOf[DescribeTableCommandInput]
}

/** <p>Represents the output of a <code>DescribeTable</code> operation.</p>
  */
@js.native
trait DescribeTableCommandOutput extends MetadataBearer {

  /** <p>The properties of the table.</p>
    */
  val Table: js.UndefOr[TableDescription] = js.native
}
