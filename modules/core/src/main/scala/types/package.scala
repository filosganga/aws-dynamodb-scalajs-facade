package com.filippodeluca.jsfacade.awssdk

import scalajs.js
import scalajs.js.|

package object types {

  type EndpointParameters = js.Dictionary[js.UndefOr[String | Boolean]]

  type HeaderBag = js.Dictionary[String]

  type QueryParameterBag = js.Dictionary[String | js.Array[String] | Null]

  /** A {Date} object, a unix (epoch) timestamp in seconds, or a string that can
    * be understood by the JavaScript {Date} constructor.
    */
  type DateInput = Double | String | js.Date;

  /** User agent data that to be put into the request's user agent.
    */
  type UserAgent = js.Array[UserAgentPair]
}
