package com.filippodeluca.jsfacade.awssdk.types

import scalajs.js

@js.native
trait EndpointV2 extends js.Any {
  val url: String = js.native

  val headers: js.Dictionary[js.Array[String]] = js.native

  /** export type EndpointObjectProperty = \| string \| boolean \| { [key:
    * string]: EndpointObjectProperty } \| EndpointObjectProperty[];
    *
    * Typescript type: properties?: { authSchemes?: AuthScheme[]; } &
    * Record<string, EndpointObjectProperty>;
    */
  val properties: js.UndefOr[js.Object] = js.native

}
