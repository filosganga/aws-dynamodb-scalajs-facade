package com.filippodeluca.jsfacade.awssdk
package config

import com.filippodeluca.jsfacade.awssdk.types._
import scalajs.js
import scalajs.js.|

object resolver {

  @js.native
  trait RegionInputConfig extends UseFipsEndpoint {

    /** The AWS region to which this client will send requests
      */
    val region: js.UndefOr[String | Provider[String]] = js.native
  }

  @js.native
  trait UseFipsEndpoint extends js.Any {

    /** Enables FIPS compatible endpoints.
      */
    val useFipsEndpoint: js.UndefOr[Boolean | Provider[Boolean]] = js.native
  }

}
