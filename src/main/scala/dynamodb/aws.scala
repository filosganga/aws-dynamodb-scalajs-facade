package com.filippodeluca.jsfacade.aws

import scalajs.js

@js.native
trait Credentials extends js.Any {
  val AccessKeyId: js.UndefOr[String] = js.native
  val Expiration: js.UndefOr[js.Date] = js.native
  val SecretAccessKey: js.UndefOr[String] = js.native
  val SessionToken: js.UndefOr[String] = js.native
  val accessKeyId: String = js.native
  val secretAccessKey: String = js.native
  val sessionToken: js.UndefOr[String] = js.native
}

object Credentials {
  def apply(
      AccessKeyId: js.UndefOr[String] = js.undefined,
      Expiration: js.UndefOr[js.Date] = js.undefined,
      SecretAccessKey: js.UndefOr[String] = js.undefined,
      SessionToken: js.UndefOr[String] = js.undefined
  ): Credentials = js.Dynamic
    .literal(
      AccessKeyId = AccessKeyId,
      Expiration = Expiration,
      SecretAccessKey = SecretAccessKey,
      SessionToken = SessionToken
    )
    .asInstanceOf[Credentials]
}

@js.native
trait MemoizedProviderOptions extends js.Object {
  val forceRefresh: js.UndefOr[Boolean] = js.native
}

object MemoizedProviderOptions {
  def apply(forceRefresh: js.UndefOr[Boolean]): MemoizedProviderOptions =
    js.Dynamic
      .literal(
        forceRefresh = forceRefresh
      )
      .asInstanceOf[MemoizedProviderOptions]

}

@js.native
trait MemoizedProvider[T] extends js.Any {
  def apply(options: js.UndefOr[MemoizedProviderOptions]): js.Promise[T]
}

@js.native
trait ResponseMetadata extends js.Object {
  val attempts: js.UndefOr[Int] = js.native
  val cfId: js.UndefOr[String] = js.native
  val extendedRequestId: js.UndefOr[String] = js.native
  val httpStatusCode: js.UndefOr[Int] = js.native
  val requestId: js.UndefOr[String] = js.native
  val totalRetryDelay: js.UndefOr[Int] = js.native
}
