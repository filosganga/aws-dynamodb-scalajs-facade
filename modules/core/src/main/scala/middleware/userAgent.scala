package com.filippodeluca.jsfacade.awssdk
package middleware

import com.filippodeluca.jsfacade.awssdk.types._
import scalajs.js

object userAgent {

  @js.native
  trait UserAgentInputConfig extends js.Any {

    /** The custom user agent header that would be appended to default one
      */
    val customUserAgent: js.UndefOr[String] = js.native
  }
}
