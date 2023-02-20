package com.filippodeluca.jsfacade.awssdkv.types

import scalajs.js

@js.native
trait ResponseMetadata extends js.Object {
  val attempts: js.UndefOr[Int] = js.native
  val cfId: js.UndefOr[String] = js.native
  val extendedRequestId: js.UndefOr[String] = js.native
  val httpStatusCode: js.UndefOr[Int] = js.native
  val requestId: js.UndefOr[String] = js.native
  val totalRetryDelay: js.UndefOr[Int] = js.native
}

@js.native
trait MetadataBearer extends js.Object {

  /** Metadata pertaining to this request.
    */
  val $metadata: ResponseMetadata = js.native
}
