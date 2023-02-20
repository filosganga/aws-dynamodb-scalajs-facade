package com.filippodeluca.jsfacade.awssdkv
package client
package dynamodb
package models

import scalajs.js
import scalajs.js.annotation.JSImport
import com.filippodeluca.jsfacade.awssdkv.types.MetadataBearer

@js.native
sealed trait SSEType extends js.Any
object SSEType {
  val Aes256 = "AES256".asInstanceOf[SSEType]
  val Kms = "KMS".asInstanceOf[SSEType]
}

@js.native
sealed trait SSEStatus extends js.Any
object SSEStatus {
  val Disabled = "DISABLED".asInstanceOf[SSEStatus]
  val Disabling = "DISABLING".asInstanceOf[SSEStatus]
  val Enabled = "ENABLED".asInstanceOf[SSEStatus]
  val Enabling = "ENABLING".asInstanceOf[SSEStatus]
  val Updating = "UPDATING".asInstanceOf[SSEStatus]
}

/** <p>The description of the server-side encryption status on the specified
  * table.</p>
  */
@js.native
trait SSEDescription extends js.Object {

  /** <p>Represents the current state of server-side encryption. The only
    * supported values are:</p> <ul> <li> <p> <code>ENABLED</code> - Server-side
    * encryption is enabled.</p> </li> <li> <p> <code>UPDATING</code> -
    * Server-side encryption is being updated.</p> </li> </ul>
    */
  val Status: js.UndefOr[SSEStatus] = js.native

  /** <p>Server-side encryption type. The only supported value is:</p> <ul> <li>
    * <p> <code>KMS</code> - Server-side encryption that uses Key Management
    * Service. The key is stored in your account and is managed by KMS (KMS
    * charges apply).</p> </li> </ul>
    */
  val SSEType: js.UndefOr[SSEType] = js.native

  /** <p>The KMS key ARN used for the KMS encryption.</p>
    */
  val KMSMasterKeyArn: js.UndefOr[String] = js.native

  /** <p>Indicates the time, in UNIX epoch date format, when DynamoDB detected
    * that the table's KMS key was inaccessible. This attribute will
    * automatically be cleared when DynamoDB detects that the table's KMS key is
    * accessible again. DynamoDB will initiate the table archival process when
    * table's KMS key remains inaccessible for more than seven days from this
    * date.</p>
    */
  val InaccessibleEncryptionDateTime: js.UndefOr[js.Date] = js.native
}

/** <p>Represents the settings used to enable server-side encryption.</p>
  */
@js.native
trait SSESpecification extends js.Object {

  /** <p>Indicates whether server-side encryption is done using an Amazon Web
    * Services managed key or an Amazon Web Services owned key. If enabled
    * (true), server-side encryption type is set to <code>KMS</code> and an
    * Amazon Web Services managed key is used (KMS charges apply). If disabled
    * (false) or not specified, server-side encryption is set to Amazon Web
    * Services owned key.</p>
    */
  val Enabled: js.UndefOr[Boolean] = js.native

  /** <p>Server-side encryption type. The only supported value is:</p> <ul> <li>
    * <p> <code>KMS</code> - Server-side encryption that uses Key Management
    * Service. The key is stored in your account and is managed by KMS (KMS
    * charges apply).</p> </li> </ul>
    */
  val SSEType: js.UndefOr[SSEType] = js.native

  /** <p>The KMS key that should be used for the KMS encryption. To specify a
    * key, use its key ID, Amazon Resource Name (ARN), alias name, or alias ARN.
    * Note that you should only provide this parameter if the key is different
    * from the default DynamoDB key <code>alias/aws/dynamodb</code>.</p>
    */
  val KMSMasterKeyId: js.UndefOr[String] = js.native
}

object SSESpecification {
  def apply(
      Enabled: js.UndefOr[Boolean] = js.undefined,
      SSEType: js.UndefOr[SSEType] = js.undefined,
      KMSMasterKeyId: js.UndefOr[String] = js.undefined
  ): SSESpecification = js.Dynamic
    .literal(
      Enabled = Enabled.asInstanceOf[js.Any],
      SSEType = SSEType.asInstanceOf[js.Any],
      KMSMasterKeyId = KMSMasterKeyId.asInstanceOf[js.Any]
    )
    .asInstanceOf[SSESpecification]
}
