package com.filippodeluca.jsfacade.awssdkv
package middleware

import scalajs.js

import com.filippodeluca.jsfacade.awssdkv.types._

object userAgent {

  @js.native
  trait UserAgentInputConfig extends js.Any {

    /** The custom user agent header that would be appended to default one
      */
    val customUserAgent: js.UndefOr[String] = js.native
  }
}
