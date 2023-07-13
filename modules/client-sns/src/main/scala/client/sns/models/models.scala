package com.filippodeluca.jsfacade.awssdk
package client
package sns
package models

import com.filippodeluca.jsfacade.awssdk.types._
import scalajs.js
import scalajs.js.typedarray.Uint8Array

@js.native
trait MessageAttributeValue extends js.Object {

  /** Amazon SNS supports the following logical data types: String,
    * String.Array, Number, and Binary. For more information, see Message
    * Attribute Data Types
    * (https://docs.aws.amazon.com/sns/latest/dg/sns-message-attributes.html#SNSMessageAttributes.DataTypes).
    */
  val DataType: String = js.native

  /** Binary type attributes can store any binary data, for example, compressed
    * data, encrypted data, or images.
    */
  val BinaryValue: js.UndefOr[Uint8Array] = js.native

  /** String type attributes can store any string data.
    */
  val StringValue: js.UndefOr[String] = js.native
}

object MessageAttributeValue {
  def apply(
      DataType: String,
      BinaryValue: js.UndefOr[Uint8Array] = js.undefined,
      StringValue: js.UndefOr[String] = js.undefined
  ): MessageAttributeValue = {
    js.Dynamic
      .literal(
        DataType = DataType.asInstanceOf[js.Any],
        BinaryValue = BinaryValue.asInstanceOf[js.Any],
        StringValue = StringValue.asInstanceOf[js.Any]
      )
      .asInstanceOf[MessageAttributeValue]
  }
}

@js.native
trait PublishCommandInput extends js.Object {

  /** <p>The topic you want to publish to.</p> <p>If you don't specify a value
    * for the <code>TopicArn</code> parameter, you must specify a value for the
    * <code>PhoneNumber</code> or <code>TargetArn</code> parameters.</p>
    */
  val TopicArn: js.UndefOr[String] = js.native

  /** <p>If you don't specify a value for the <code>TargetArn</code> parameter,
    * you must specify a value for the <code>PhoneNumber</code> or
    * <code>TopicArn</code> parameters.</p>
    */
  val TargetArn: js.UndefOr[String] = js.native

  /** <p>The phone number to which you want to deliver an SMS message. Use E.164
    * format.</p> <p>If you don't specify a value for the
    * <code>PhoneNumber</code> parameter, you must specify a value for the
    * <code>TargetArn</code> or <code>TopicArn</code> parameters.</p>
    */
  val PhoneNumber: js.UndefOr[String] = js.native

  /** <p>The message you want to send.</p> <p>If you are publishing to a topic
    * and you want to send the same message to all transport protocols, include
    * the text of the message as a String value. If you want to send different
    * messages for each transport protocol, set the value of the
    * <code>MessageStructure</code> parameter to <code>json</code> and use a
    * JSON object for the <code>Message</code> parameter. </p> <p></p>
    * <p>Constraints:</p> <ul> <li> <p>With the exception of SMS, messages must
    * be UTF-8 encoded strings and at most 256 KB in size (262,144 bytes, not
    * 262,144 characters).</p> </li> <li> <p>For SMS, each message can contain
    * up to 140 characters. This character limit depends on the encoding schema.
    * For example, an SMS message can contain 160 GSM characters, 140 ASCII
    * characters, or 70 UCS-2 characters.</p> <p>If you publish a message that
    * exceeds this size limit, Amazon SNS sends the message as multiple
    * messages, each fitting within the size limit. Messages aren't truncated
    * mid-word but are cut off at whole-word boundaries.</p> <p>The total size
    * limit for a single SMS <code>Publish</code> action is 1,600
    * characters.</p> </li> </ul> <p>JSON-specific constraints:</p> <ul> <li>
    * <p>Keys in the JSON object that correspond to supported transport
    * protocols must have simple JSON string values.</p> </li> <li> <p>The
    * values will be parsed (unescaped) before they are used in outgoing
    * messages.</p> </li> <li> <p>Outbound notifications are JSON encoded
    * (meaning that the characters will be reescaped for sending).</p> </li>
    * <li> <p>Values have a minimum length of 0 (the empty string, "", is
    * allowed).</p> </li> <li> <p>Values have a maximum length bounded by the
    * overall message size (so, including multiple protocols may limit message
    * sizes).</p> </li> <li> <p>Non-string values will cause the key to be
    * ignored.</p> </li> <li> <p>Keys that do not correspond to supported
    * transport protocols are ignored.</p> </li> <li> <p>Duplicate keys are not
    * allowed.</p> </li> <li> <p>Failure to parse or validate any key or value
    * in the message will cause the <code>Publish</code> call to return an error
    * (no partial delivery).</p> </li> </ul>
    */
  val Message: String = js.native

  /** <p>Optional parameter to be used as the "Subject" line when the message is
    * delivered to email endpoints. This field will also be included, if
    * present, in the standard JSON messages delivered to other endpoints.</p>
    * <p>Constraints: Subjects must be ASCII text that begins with a letter,
    * number, or punctuation mark; must not include line breaks or control
    * characters; and must be less than 100 characters long.</p>
    */
  val Subject: js.UndefOr[String] = js.native

  /** <p>Set <code>MessageStructure</code> to <code>json</code> if you want to
    * send a different message for each protocol. For example, using one publish
    * action, you can send a short message to your SMS subscribers and a longer
    * message to your email subscribers. If you set
    * <code>MessageStructure</code> to <code>json</code>, the value of the
    * <code>Message</code> parameter must: </p> <ul> <li> <p>be a syntactically
    * valid JSON object; and</p> </li> <li> <p>contain at least a top-level JSON
    * key of "default" with a value that is a string.</p> </li> </ul> <p>You can
    * define other top-level keys that define the message you want to send to a
    * specific transport protocol (e.g., "http").</p> <p>Valid value:
    * <code>json</code> </p>
    */
  val MessageStructure: js.UndefOr[String] = js.native

  /** <p>Message attributes for Publish action.</p>
    */
  val MessageAttributes: js.UndefOr[js.Dictionary[MessageAttributeValue]] =
    js.native

  /** <p>This parameter applies only to FIFO (first-in-first-out) topics. The
    * <code>MessageDeduplicationId</code> can contain up to 128 alphanumeric
    * characters <code>(a-z, A-Z, 0-9)</code> and punctuation
    * <code>(!"#$%&'()*+,-./:;<=>?@[\]^_`\{|\}~)</code>.</p> <p>Every message
    * must have a unique <code>MessageDeduplicationId</code>, which is a token
    * used for deduplication of sent messages. If a message with a particular
    * <code>MessageDeduplicationId</code> is sent successfully, any message sent
    * with the same <code>MessageDeduplicationId</code> during the 5-minute
    * deduplication interval is treated as a duplicate. </p> <p>If the topic has
    * <code>ContentBasedDeduplication</code> set, the system generates a
    * <code>MessageDeduplicationId</code> based on the contents of the message.
    * Your <code>MessageDeduplicationId</code> overrides the generated one.</p>
    */
  val MessageDeduplicationId: js.UndefOr[String] = js.native

  /** <p>This parameter applies only to FIFO (first-in-first-out) topics. The
    * <code>MessageGroupId</code> can contain up to 128 alphanumeric characters
    * <code>(a-z, A-Z, 0-9)</code> and punctuation
    * <code>(!"#$%&'()*+,-./:;<=>?@[\]^_`\{|\}~)</code>.</p> <p>The
    * <code>MessageGroupId</code> is a tag that specifies that a message belongs
    * to a specific message group. Messages that belong to the same message
    * group are processed in a FIFO manner (however, messages in different
    * message groups might be processed out of order). Every message must
    * include a <code>MessageGroupId</code>.</p>
    */
  val MessageGroupId: js.UndefOr[String] = js.native
}

object PublishCommandInput {
  def apply(
      Message: String,
      MessageAttributes: js.UndefOr[js.Dictionary[MessageAttributeValue]] =
        js.undefined,
      TopicArn: js.UndefOr[String] = js.undefined,
      TargetArn: js.UndefOr[String] = js.undefined,
      PhoneNumber: js.UndefOr[String] = js.undefined,
      MessageStructure: js.UndefOr[String] = js.undefined,
      Subject: js.UndefOr[String] = js.undefined,
      MessageDeduplicationId: js.UndefOr[String] = js.undefined,
      MessageGroupId: js.UndefOr[String] = js.undefined
  ): PublishCommandInput = {
    js.Dynamic
      .literal(
        Message = Message.asInstanceOf[js.Any],
        MessageAttributes = MessageAttributes.asInstanceOf[js.Any],
        TopicArn = TopicArn.asInstanceOf[js.Any],
        TargetArn = TargetArn.asInstanceOf[js.Any],
        PhoneNumber = PhoneNumber.asInstanceOf[js.Any],
        MessageStructure = MessageStructure.asInstanceOf[js.Any],
        Subject = Subject.asInstanceOf[js.Any],
        MessageDeduplicationId = MessageDeduplicationId.asInstanceOf[js.Any],
        MessageGroupId = MessageGroupId.asInstanceOf[js.Any]
      )
      .asInstanceOf[PublishCommandInput]
  }
}

@js.native
trait PublishCommandOutput extends MetadataBearer {

  /** Unique identifier assigned to the published message.
    */
  val MessageId: String = js.native

  val SequenceNumber: js.UndefOr[String] = js.native

}

object PublishCommandOutput {
  def apply(
      MessageId: String,
      SequenceNumber: js.UndefOr[String] = js.undefined
  ): PublishCommandOutput = {
    js.Dynamic
      .literal(
        MessageId = MessageId.asInstanceOf[js.Any],
        SequenceNumber = SequenceNumber.asInstanceOf[js.Any]
      )
      .asInstanceOf[PublishCommandOutput]
  }
}

@js.native
trait CreateTopicCommandInput extends js.Object {

  /** <p>The name of the topic you want to create.</p> <p>Constraints: Topic
    * names must be made up of only uppercase and lowercase ASCII letters,
    * numbers, underscores, and hyphens, and must be between 1 and 256
    * characters long.</p> <p>For a FIFO (first-in-first-out) topic, the name
    * must end with the <code>.fifo</code> suffix. </p>
    */
  val Name: String = js.native

  /** <p>A map of attributes with their corresponding values.</p> <p>The
    * following lists the names, descriptions, and values of the special request
    * parameters that the <code>CreateTopic</code> action uses:</p> <ul> <li>
    * <p> <code>DeliveryPolicy</code> – The policy that defines how Amazon SNS
    * retries failed deliveries to HTTP/S endpoints.</p> </li> <li> <p>
    * <code>DisplayName</code> – The display name to use for a topic with SMS
    * subscriptions.</p> </li> <li> <p> <code>FifoTopic</code> – Set to true to
    * create a FIFO topic.</p> </li> <li> <p> <code>Policy</code> – The policy
    * that defines who can access your topic. By default, only the topic owner
    * can publish or subscribe to the topic.</p> </li> <li> <p>
    * <code>SignatureVersion</code> – The signature version corresponds to the
    * hashing algorithm used while creating the signature of the notifications,
    * subscription confirmations, or unsubscribe confirmation messages sent by
    * Amazon SNS. By default, <code>SignatureVersion</code> is set to
    * <code>1</code>.</p> </li> <li> <p> <code>TracingConfig</code> – Tracing
    * mode of an Amazon SNS topic. By default <code>TracingConfig</code> is set
    * to <code>PassThrough</code>, and the topic passes through the tracing
    * header it receives from an Amazon SNS publisher to its subscriptions. If
    * set to <code>Active</code>, Amazon SNS will vend X-Ray segment data to
    * topic owner account if the sampled flag in the tracing header is true.
    * This is only supported on standard topics.</p> </li> </ul> <p>The
    * following attribute applies only to <a
    * href="https://docs.aws.amazon.com/sns/latest/dg/sns-server-side-encryption.html">server-side
    * encryption</a>:</p> <ul> <li> <p> <code>KmsMasterKeyId</code> – The ID of
    * an Amazon Web Services managed customer master key (CMK) for Amazon SNS or
    * a custom CMK. For more information, see <a
    * href="https://docs.aws.amazon.com/sns/latest/dg/sns-server-side-encryption.html#sse-key-terms">Key
    * Terms</a>. For more examples, see <a
    * href="https://docs.aws.amazon.com/kms/latest/APIReference/API_DescribeKey.html#API_DescribeKey_RequestParameters">KeyId</a>
    * in the <i>Key Management Service API Reference</i>. </p> </li> </ul>
    * <p>The following attributes apply only to <a
    * href="https://docs.aws.amazon.com/sns/latest/dg/sns-fifo-topics.html">FIFO
    * topics</a>:</p> <ul> <li> <p> <code>FifoTopic</code> – When this is set to
    * <code>true</code>, a FIFO topic is created.</p> </li> <li> <p>
    * <code>ContentBasedDeduplication</code> – Enables content-based
    * deduplication for FIFO topics.</p> <ul> <li> <p>By default,
    * <code>ContentBasedDeduplication</code> is set to <code>false</code>. If
    * you create a FIFO topic and this attribute is <code>false</code>, you must
    * specify a value for the <code>MessageDeduplicationId</code> parameter for
    * the <a
    * href="https://docs.aws.amazon.com/sns/latest/api/API_Publish.html">Publish</a>
    * action. </p> </li> <li> <p>When you set
    * <code>ContentBasedDeduplication</code> to <code>true</code>, Amazon SNS
    * uses a SHA-256 hash to generate the <code>MessageDeduplicationId</code>
    * using the body of the message (but not the attributes of the message).</p>
    * <p>(Optional) To override the generated value, you can specify a value for
    * the <code>MessageDeduplicationId</code> parameter for the
    * <code>Publish</code> action.</p> </li> </ul> </li> </ul>
    */
  val Attributes: js.UndefOr[js.Dictionary[String]] = js.native

  /** <p>The list of tags to add to a new topic.</p> <note> <p>To be able to tag
    * a topic on creation, you must have the <code>sns:CreateTopic</code> and
    * <code>sns:TagResource</code> permissions.</p> </note>
    */
  val Tags: js.UndefOr[js.Array[Tag]] = js.native;

  /** <p>The body of the policy document you want to use for this topic.</p>
    * <p>You can only add one policy per topic.</p> <p>The policy must be in
    * JSON string format.</p> <p>Length Constraints: Maximum length of
    * 30,720.</p>
    */
  val DataProtectionPolicy: js.UndefOr[String] = js.native
}

object CreateTopicCommandInput {
  def apply(
      Name: String,
      Attributes: js.UndefOr[js.Dictionary[String]] = js.undefined,
      Tags: js.UndefOr[js.Array[Tag]] = js.undefined,
      DataProtectionPolicy: js.UndefOr[String] = js.undefined
  ): CreateTopicCommandInput = js.Dynamic
    .literal(
      Name = Name.asInstanceOf[js.Any],
      Attributes = Attributes.asInstanceOf[js.Any],
      DataProtectionPolicy = DataProtectionPolicy.asInstanceOf[js.Any]
    )
    .asInstanceOf[CreateTopicCommandInput]
}

@js.native
trait CreateTopicCommandOutput extends MetadataBearer {
  val TopicArn: String = js.native
}

object CreateTopicCommandOutput {
  def apply(
      TopicArn: String
  ): CreateTopicCommandOutput = {
    js.Dynamic
      .literal(
        TopicArn = TopicArn.asInstanceOf[js.Any]
      )
      .asInstanceOf[CreateTopicCommandOutput]
  }
}

@js.native
trait DeleteTopicCommandInput extends js.Object {
  val TopicArn: String = js.native
}

object DeleteTopicCommandInput {
  def apply(
      TopicArn: String
  ): DeleteTopicCommandInput = js.Dynamic
    .literal(
      TopicArn = TopicArn.asInstanceOf[js.Any]
    )
    .asInstanceOf[DeleteTopicCommandInput]
}

@js.native
trait DeleteTopicCommandOutput extends MetadataBearer

@js.native
trait PublishBatchRequestEntry extends js.Object {

  /** <p>An identifier for the message in this batch.</p> <note> <p>The
    * <code>Ids</code> of a batch request must be unique within a request. </p>
    * <p>This identifier can have up to 80 characters. The following characters
    * are accepted: alphanumeric characters, hyphens(-), and underscores (_).
    * </p> </note>
    */
  val Id: String = js.native

  /** <p>The body of the message.</p>
    */
  val Message: String = js.native

  /** <p>The subject of the batch message.</p>
    */
  val Subject: js.UndefOr[String] = js.native

  /** <p>Set <code>MessageStructure</code> to <code>json</code> if you want to
    * send a different message for each protocol. For example, using one publish
    * action, you can send a short message to your SMS subscribers and a longer
    * message to your email subscribers. If you set
    * <code>MessageStructure</code> to <code>json</code>, the value of the
    * <code>Message</code> parameter must: </p> <ul> <li> <p>be a syntactically
    * valid JSON object; and</p> </li> <li> <p>contain at least a top-level JSON
    * key of "default" with a value that is a string.</p> </li> </ul> <p>You can
    * define other top-level keys that define the message you want to send to a
    * specific transport protocol (e.g. http). </p>
    */
  val MessageStructure: js.UndefOr[String] = js.native

  /** <p>Each message attribute consists of a <code>Name</code>,
    * <code>Type</code>, and <code>Value</code>. For more information, see <a
    * href="https://docs.aws.amazon.com/sns/latest/dg/sns-message-attributes.html">Amazon
    * SNS message attributes</a> in the Amazon SNS Developer Guide.</p>
    */
  val MessageAttributes: js.UndefOr[js.Dictionary[MessageAttributeValue]] =
    js.native

  /** <p>This parameter applies only to FIFO (first-in-first-out) topics.</p>
    * <p>The token used for deduplication of messages within a 5-minute minimum
    * deduplication interval. If a message with a particular
    * <code>MessageDeduplicationId</code> is sent successfully, subsequent
    * messages with the same <code>MessageDeduplicationId</code> are accepted
    * successfully but aren't delivered.</p> <ul> <li> <p>Every message must
    * have a unique <code>MessageDeduplicationId</code>.</p> <ul> <li> <p>You
    * may provide a <code>MessageDeduplicationId</code> explicitly.</p> </li>
    * <li> <p>If you aren't able to provide a
    * <code>MessageDeduplicationId</code> and you enable
    * <code>ContentBasedDeduplication</code> for your topic, Amazon SNS uses a
    * SHA-256 hash to generate the <code>MessageDeduplicationId</code> using the
    * body of the message (but not the attributes of the message).</p> </li>
    * <li> <p>If you don't provide a <code>MessageDeduplicationId</code> and the
    * topic doesn't have <code>ContentBasedDeduplication</code> set, the action
    * fails with an error.</p> </li> <li> <p>If the topic has a
    * <code>ContentBasedDeduplication</code> set, your
    * <code>MessageDeduplicationId</code> overrides the generated one. </p>
    * </li> </ul> </li> <li> <p>When <code>ContentBasedDeduplication</code> is
    * in effect, messages with identical content sent within the deduplication
    * interval are treated as duplicates and only one copy of the message is
    * delivered.</p> </li> <li> <p>If you send one message with
    * <code>ContentBasedDeduplication</code> enabled, and then another message
    * with a <code>MessageDeduplicationId</code> that is the same as the one
    * generated for the first <code>MessageDeduplicationId</code>, the two
    * messages are treated as duplicates and only one copy of the message is
    * delivered. </p> </li> </ul> <note> <p>The
    * <code>MessageDeduplicationId</code> is available to the consumer of the
    * message (this can be useful for troubleshooting delivery issues).</p>
    * <p>If a message is sent successfully but the acknowledgement is lost and
    * the message is resent with the same <code>MessageDeduplicationId</code>
    * after the deduplication interval, Amazon SNS can't detect duplicate
    * messages. </p> <p>Amazon SNS continues to keep track of the message
    * deduplication ID even after the message is received and deleted. </p>
    * </note> <p>The length of <code>MessageDeduplicationId</code> is 128
    * characters.</p> <p> <code>MessageDeduplicationId</code> can contain
    * alphanumeric characters <code>(a-z, A-Z, 0-9)</code> and punctuation
    * <code>(!"#$%&'()*+,-./:;<=>?@[\]^_`\{|\}~)</code>.</p>
    */
  val MessageDeduplicationId: js.UndefOr[String] = js.native

  /** <p>This parameter applies only to FIFO (first-in-first-out) topics.</p>
    * <p>The tag that specifies that a message belongs to a specific message
    * group. Messages that belong to the same message group are processed in a
    * FIFO manner (however, messages in different message groups might be
    * processed out of order). To interleave multiple ordered streams within a
    * single topic, use <code>MessageGroupId</code> values (for example, session
    * data for multiple users). In this scenario, multiple consumers can process
    * the topic, but the session data of each user is processed in a FIFO
    * fashion. </p> <p>You must associate a non-empty
    * <code>MessageGroupId</code> with a message. If you don't provide a
    * <code>MessageGroupId</code>, the action fails. </p> <p>The length of
    * <code>MessageGroupId</code> is 128 characters.</p> <p>
    * <code>MessageGroupId</code> can contain alphanumeric characters
    * <code>(a-z, A-Z, 0-9)</code> and punctuation
    * <code>(!"#$%&'()*+,-./:;<=>?@[\]^_`\{|\}~)</code>.</p> <important> <p>
    * <code>MessageGroupId</code> is required for FIFO topics. You can't use it
    * for standard topics. </p> </important>
    */
  val MessageGroupId: js.UndefOr[String] = js.native
}

object PublishBatchRequestEntry {
  def apply(
      Id: String,
      Message: String,
      MessageAttributes: js.UndefOr[js.Dictionary[MessageAttributeValue]] =
        js.undefined,
      MessageStructure: js.UndefOr[String] = js.undefined,
      Subject: js.UndefOr[String] = js.undefined,
      MessageDeduplicationId: js.UndefOr[String] = js.undefined,
      MessageGroupId: js.UndefOr[String] = js.undefined
  ): PublishBatchRequestEntry = js.Dynamic
    .literal(
      Id = Id.asInstanceOf[js.Any],
      Message = Message.asInstanceOf[js.Any],
      MessageAttributes = MessageAttributes.asInstanceOf[js.Any],
      MessageStructure = MessageStructure.asInstanceOf[js.Any],
      Subject = Subject.asInstanceOf[js.Any],
      MessageDeduplicationId = MessageDeduplicationId.asInstanceOf[js.Any],
      MessageGroupId = MessageGroupId.asInstanceOf[js.Any]
    )
    .asInstanceOf[PublishBatchRequestEntry]
}

@js.native
trait PublishBatchCommandInput extends js.Object {

  /** <p>The Amazon resource name (ARN) of the topic you want to batch publish
    * to.</p>
    */
  val TopicArn: String = js.native;

  /** <p>A list of <code>PublishBatch</code> request entries to be sent to the
    * SNS topic.</p>
    */
  val PublishBatchRequestEntries: js.Array[PublishBatchRequestEntry] =
    js.native;
}

object PublishBatchCommandInput {
  def apply(
      TopicArn: String,
      PublishBatchRequestEntries: js.Array[PublishBatchRequestEntry]
  ): PublishBatchCommandInput = js.Dynamic
    .literal(
      TopicArn = TopicArn.asInstanceOf[js.Any],
      PublishBatchRequestEntries =
        PublishBatchRequestEntries.asInstanceOf[js.Any]
    )
    .asInstanceOf[PublishBatchCommandInput]
}

@js.native
trait BatchResultErrorEntry extends js.Object {

  /** <p>The <code>Id</code> of an entry in a batch request</p>
    */
  val Id: String = js.native

  /** <p>An error code representing why the action failed on this entry.</p>
    */
  val Code: String = js.native

  /** <p>A message explaining why the action failed on this entry.</p>
    */
  val Message: js.UndefOr[String] = js.native

  /** <p>Specifies whether the error happened due to the caller of the batch API
    * action.</p>
    */
  val SenderFault: Boolean = js.native
}

/** @public
  *   <p>Encloses data related to a successful message in a batch request for
  *   topic.</p>
  */
@js.native
trait PublishBatchResultEntry extends js.Object {

  /** <p>The <code>Id</code> of an entry in a batch request.</p>
    */
  val Id: js.UndefOr[String] = js.native

  /** <p>An identifier for the message.</p>
    */
  val MessageId: js.UndefOr[String] = js.native

  /** <p>This parameter applies only to FIFO (first-in-first-out) topics.</p>
    * <p>The large, non-consecutive number that Amazon SNS assigns to each
    * message.</p> <p>The length of <code>SequenceNumber</code> is 128 bits.
    * <code>SequenceNumber</code> continues to increase for a particular
    * <code>MessageGroupId</code>.</p>
    */
  val SequenceNumber: js.UndefOr[String] = js.native
}

/** @public
  */
@js.native
trait PublishBatchCommandOutput extends js.Object {

  /** <p>A list of successful <code>PublishBatch</code> responses.</p>
    */
  val Successful: js.UndefOr[js.Array[PublishBatchResultEntry]] = js.native

  /** <p>A list of failed <code>PublishBatch</code> responses. </p>
    */
  val Failed: js.UndefOr[js.Array[BatchResultErrorEntry]] = js.native
}
