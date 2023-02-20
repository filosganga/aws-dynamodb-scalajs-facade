package com.filippodeluca.jsfacade.awssdkv
package middleware

import scalajs.js

import com.filippodeluca.jsfacade.awssdkv.types._

object retry {

  @js.native
  trait RetryInputConfig extends js.Any {
    val maxAttempts: js.UndefOr[Double] = js.native
    val retryStrategy: js.UndefOr[RetryStrategy | RetryStrategyV2] = js.native
  }
}
