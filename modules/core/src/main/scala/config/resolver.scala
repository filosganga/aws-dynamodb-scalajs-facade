package com.filippodeluca.jsfacade.awssdkv
package config

import scalajs.js

import com.filippodeluca.jsfacade.awssdkv.types._

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
