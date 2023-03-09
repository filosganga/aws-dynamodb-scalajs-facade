package com.filippodeluca.jsfacade.awssdk.types

import scalajs.js

/** Authentication schemes represent a way that the service will authenticate
  * the customer’s identity.
  */
@js.native
trait AuthScheme extends js.Any {

  /** @example
    *   "sigv4a" or "sigv4"
    */
  val name: "sigv4" | "sigv4a" | String = js.native

  /** @example
    *   "s3"
    */
  val signingName: String = js.native

  /** @example
    *   "us-east-1"
    */
  val signingRegion: String;

  /** @example
    *   ["*"]
    * @exammple
    *   ["us-west-2", "us-east-1"]
    */
  val signingRegionSet: js.UndefOr[js.Array[String]];

  val properties: js.Dictionary[js.Any] = js.native
}

// As described in the Smithy documentation:
// https://github.com/awslabs/smithy/blob/main/smithy-model/src/main/resources/software/amazon/smithy/model/loader/prelude.smithy
@js.native
trait HttpAuthDefinition extends js.Any {

  /** Defines the location of where the Auth is serialized.
    */
  val in: HttpAuthLocation = js.native

  /** Defines the name of the HTTP header or query String parameter that
    * contains the Auth.
    */
  val name: String = js.native

  /** Defines the security scheme to use on the `Authorization` header value.
    * This can only be set if the "in" property is set to {@link
    * HttpAuthLocation.HEADER}.
    */
  val scheme: js.UndefOr[String] = js.native
}

@js.native
sealed trait HttpAuthLocation extends js.Any
object HttpAuthLocation {
  val Header = "HEADER".asInstanceOf[HttpAuthLocation]
  val Query = "QUERY".asInstanceOf[HttpAuthLocation]
}
