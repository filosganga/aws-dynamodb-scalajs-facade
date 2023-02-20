package com.filippodeluca.jsfacade.awssdkv.types

import scalajs.js

/** A list of logger's log level. These levels are sorted in order of increasing
  * severity. Each log level includes itself and all the levels behind itself.
  *
  * @example
  *   new Logger({logLevel: 'warn'}) will print all the warn and error message.
  */
@js.native
sealed trait LogLevel extends js.Any
object LogLevel {
  val All = "all".asInstanceOf[LogLevel]
  val Trace = "trace".asInstanceOf[LogLevel]
  val Debug = "debug".asInstanceOf[LogLevel]
  val Log = "log".asInstanceOf[LogLevel]
  val Info = "info".asInstanceOf[LogLevel]
  val Warn = "warn".asInstanceOf[LogLevel]
  val Error = "error".asInstanceOf[LogLevel]
  val Off = "off".asInstanceOf[LogLevel]

}

/** An object consumed by Logger constructor to initiate a logger object.
  */
@js.native
trait LoggerOptions extends js.Any {
  val logger: js.UndefOr[Logger] = js.native
  val logLevel: js.UndefOr[LogLevel] = js.native
}

/** Represents a logger object that is available in HandlerExecutionContext
  * throughout the middleware stack.
  */
@js.native
trait Logger extends js.Any {
  val trace: js.UndefOr[js.Function1[js.Array[js.Any], Unit]] = js.native
  val debug: js.Function1[js.Array[js.Any], Unit] = js.native
  val info: js.Function1[js.Array[js.Any], Unit] = js.native
  val warn: js.Function1[js.Array[js.Any], Unit] = js.native
  val error: js.Function1[js.Array[js.Any], Unit] = js.native
}
