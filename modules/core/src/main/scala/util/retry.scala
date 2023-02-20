package com.filippodeluca.jsfacade.awssdkv
package util

import scalajs.js
import scalajs.js.annotation.JSImport

import com.filippodeluca.jsfacade.awssdkv.types._

object retry {

  @js.native
  @JSImport("@aws-sdk/util-retry", "getDefaultRetryBackoffStrategy")
  val getDefaultRetryBackoffStrategy
      : js.Function0[StandardRetryBackoffStrategy] = js.native

  @js.native
  trait RateLimiter extends js.Any {

    /** If there is sufficient capacity (tokens) available, it immediately
      * returns. If there is not sufficient capacity, it will either sleep a
      * certain amount of time until the rate limiter can retrieve a token from
      * its token bucket or raise an exception indicating there is insufficient
      * capacity.
      */
    val getSendToken: js.Function0[js.Promise[Unit]] = js.native

    /** Updates the client sending rate based on response. If the response was
      * successful, the capacity and fill rate are increased. If the response
      * was a throttling response, the capacity and fill rate are decreased.
      * Transient errors do not affect the rate limiter.
      */
    val updateClientSendingRate: js.Function1[js.Any, Unit] = js.native
  }

  @js.native
  trait DefaultRateLimiterOptions extends js.Any {
    val beta: js.UndefOr[Double] = js.native
    val minCapacity: js.UndefOr[Double] = js.native
    val minFillRate: js.UndefOr[Double] = js.native
    val scaleConstant: js.UndefOr[Double] = js.native
    val smooth: js.UndefOr[Double] = js.native
  }

  @js.native
  @JSImport("@aws-sdk/util-retry", "DefaultRateLimiter")
  class DefaultRateLimiter(options: js.UndefOr[DefaultRateLimiterOptions])
      extends RateLimiter

  @js.native
  @JSImport("@aws-sdk/util-retry", "StandardRetryStrategy")
  class StandardRetryStrategy(maxAttemptsProvider: Provider[Double])
      extends RetryStrategyV2

  @js.native
  trait AdaptiveRetryStrategyOptions extends js.Any {
    val rateLimiter: js.UndefOr[RateLimiter] = js.native
  }

  @js.native
  @JSImport("@aws-sdk/util-retry", "AdaptiveRetryStrategy")
  class AdaptiveRetryStrategy(
      maxAttemptsProvider: Provider[Double],
      options: js.UndefOr[AdaptiveRetryStrategyOptions]
  ) extends RetryStrategyV2

}
