package com.filippodeluca.jsfacade.awssdk.types

import scalajs.js

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
