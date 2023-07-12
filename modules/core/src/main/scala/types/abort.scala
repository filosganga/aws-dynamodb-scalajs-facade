package com.filippodeluca.jsfacade.awssdk.types

import scalajs.js
import scalajs.js.|

@js.native
trait AbortHandler extends js.Any {
  def apply(`this`: AbortSignal, ev: js.Any): js.Any
}

/** Holders of an AbortSignal object may query if the associated operation has
  * been aborted and register an onabort handler.
  *
  * @see
  *   https://developer.mozilla.org/en-US/docs/Web/API/AbortSignal
  */
@js.native
trait AbortSignal extends js.Any {

  /** Whether the action represented by this signal has been cancelled.
    */
  val aborted: Boolean = js.native

  /** A function to be invoked when the action represented by this signal has
    * been cancelled.
    */
  val onabort: AbortHandler | Null = js.native
}
