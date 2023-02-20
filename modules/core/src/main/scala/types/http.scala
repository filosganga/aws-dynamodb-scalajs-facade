package com.filippodeluca.jsfacade.awssdkv.types

import scalajs.js

type HeaderBag = js.Dictionary[String]

type QueryParameterBag = js.Dictionary[String | js.Array[String] | Null]

@js.native
trait Headers extends js.Map[String, String] {
  def withHeader(headerName: String, headerValue: String): Headers = js.native
  def withoutHeader(headerName: String): Headers = js.native
}

@js.native
trait HttpMessage extends js.Any {
  val headers: HeaderBag = js.native
  val body: js.UndefOr[js.Any] = js.native
}

@js.native
trait Endpoint extends js.Any {
  val protocol: String = js.native
  val hostname: String = js.native
  val port: js.UndefOr[Int] = js.native
  val path: String = js.native
  val query: js.UndefOr[QueryParameterBag] = js.native
}

@js.native
trait HttpRequest extends HttpMessage, Endpoint {
  val method: String = js.native
}

@js.native
trait HttpResponse extends HttpMessage {
  val statusCode: Int = js.native
}

@js.native
trait HttpHandlerOptions extends js.Any {
  val abortSignal: js.UndefOr[AbortSignal] = js.native;
}

