package com.filippodeluca.jsfacade.awssdk
package middleware

import com.filippodeluca.jsfacade.awssdk.types._
import scalajs.js

object retry {

  @js.native
  trait RetryInputConfig extends js.Any {
    val maxAttempts: js.UndefOr[Double] = js.native
    val retryStrategy: js.UndefOr[RetryStrategy | RetryStrategyV2] = js.native
  }
}
