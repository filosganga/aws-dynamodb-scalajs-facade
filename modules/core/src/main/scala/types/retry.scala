package com.filippodeluca.jsfacade.awssdk.types

import scalajs.js

sealed trait RetryErrorType
object RetryErrorType {

  /** This is a connection level error such as a socket timeout, socket connect
    * error, tls negotiation timeout etc... Typically these should never be
    * applied for non-idempotent request types since in this scenario, it's
    * impossible to know whether the operation had a side effect on the server.
    */
  val Transient = "TRANSIENT".asInstanceOf[RetryErrorType]

  /** This is an error where the server explicitly told the client to back off,
    * such as a 429 or 503 Http error.
    */
  val Throttling = "THROTTLING".asInstanceOf[RetryErrorType]

  /** This is a server error that isn't explicitly throttling but is considered
    * by the client to be something that should be retried.
    */
  val ServerError = "SERVER_ERROR".asInstanceOf[RetryErrorType]

  /** Doesn't count against any budgets. This could be something like a 401
    * challenge in Http.
    */
  val ClientError = "CLIENT_ERROR".asInstanceOf[RetryErrorType]
}

@js.native
trait RetryErrorInfo extends js.Any {
  val errorType: RetryErrorType = js.native

  /** Protocol hint. This could come from Http's 'retry-after' header or
    * something from MQTT or any other protocol that has the ability to convey
    * retry info from a peer.
    *
    * @returns
    *   the Date after which a retry should be attempted.
    */
  val retryAfterHint: js.UndefOr[js.Date] = js.native
}

@js.native
trait RetryBackoffStrategy extends js.Any {

  /** @returns
    *   the number of milliseconds to wait before retrying an action.
    */
  def computeNextBackoffDelay(retryAttempt: Double): Double = js.native
}

@js.native
trait StandardRetryBackoffStrategy extends RetryBackoffStrategy {

  /** Sets the delayBase used to compute backoff delays.
    * @param delayBase
    */
  def setDelayBase(delayBase: Double): Unit = js.native
}

@js.native
trait RetryStrategyOptions extends js.Any {
  val backoffStrategy: RetryBackoffStrategy = js.native
  val maxRetriesBase: Double = js.native
}

@js.native
trait RetryToken extends js.Any {

  /** @returns
    *   the current count of retry.
    */
  def getRetryCount(): Double = js.native

  /** @returns
    *   the number of milliseconds to wait before retrying an action.
    */
  def getRetryDelay(): Double = js.native
}

@js.native
trait StandardRetryToken extends RetryToken {

  /** @returns
    *   wheather token has remaining tokens.
    */
  def hasRetryTokens(errorType: RetryErrorType): Boolean = js.native

  /** @returns
    *   the number of available tokens.
    */
  def getRetryTokenCount(errorInfo: RetryErrorInfo): Double = js.native

  /** @returns
    *   the cost of the last retry attemp.
    */
  def getLastRetryCost(): js.UndefOr[Double] = js.native

  /** Releases a number of tokens.
    *
    * @param amount
    *   of tokens to release.
    */
  def releaseRetryTokens(amount: js.UndefOr[Double]): Unit = js.native
}

@js.native
trait RetryStrategyV2 extends js.Any {

  /** Called before any retries (for the first call to the operation). It either
    * returns a retry token or an error upon the failure to acquire a token
    * prior.
    *
    * tokenScope is arbitrary and out of scope for this component. However,
    * adding it here offers us a lot of future flexibility for outage detection.
    * For example, it could be "us-east-1" on a shared retry strategy, or
    * "us-west-2-c:dynamodb".
    */
  def acquireInitialRetryToken(
      retryTokenScope: String
  ): js.Promise[RetryToken] = js.native

  /** After a failed operation call, this function is invoked to refresh the
    * retryToken returned by acquireInitialRetryToken(). This function can
    * either choose to allow another retry and send a new or updated token, or
    * reject the retry attempt and report the error either in an exception or
    * returning an error.
    */
  def refreshRetryTokenForRetry(
      tokenToRenew: RetryToken,
      errorInfo: RetryErrorInfo
  ): js.Promise[RetryToken] = js.native

  /** Upon successful completion of the operation, a user calls this function to
    * record that the operation was successful.
    */
  def recordSuccess(token: RetryToken): Unit = js.native
}

sealed trait ExponentialBackoffJitterType
object ExponentialBackoffJitterType {
  val Default = "DEFAULT".asInstanceOf[ExponentialBackoffJitterType]
  val None = "NONE".asInstanceOf[ExponentialBackoffJitterType]
  val Full = "FULL".asInstanceOf[ExponentialBackoffJitterType]
  val Decorrelated = "DECORRELATED".asInstanceOf[ExponentialBackoffJitterType]
}

@js.native
trait ExponentialBackoffStrategyOptions extends js.Any {
  val jitterType: ExponentialBackoffJitterType = js.native

  /* Scaling factor to add for the backoff in milliseconds. Default is 25ms */
  val backoffScaleValue: js.UndefOr[Double] = js.native
}
