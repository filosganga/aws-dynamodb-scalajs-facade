package com.filippodeluca.jsfacade.awssdkv
package types

import scalajs.js
import scalajs.js.typedarray.Uint8Array


/**
 * A function that, given a TypedArray of bytes, can produce a string
 * representation thereof.
 *
 * @example An encoder function that converts bytes to hexadecimal
 * representation would return `'deadbeef'` when given `new
 * Uint8Array([0xde, 0xad, 0xbe, 0xef])`.
 */
@js.native
trait Encoder extends js.Any {
  def apply(input: Uint8Array): String = js.native
}

/**
 * A function that, given a string, can derive the bytes represented by that
 * string.
 *
 * @example A decoder function that converts bytes to hexadecimal
 * representation would return `new Uint8Array([0xde, 0xad, 0xbe, 0xef])` when
 * given the string `'deadbeef'`.
 */
@js.native
trait Decoder extends js.Any {
  def apply(input: String): Uint8Array = js.native
}

/**
 * A function that, when invoked, returns a promise that will be fulfilled with
 * a value of type T.
 *
 * @example A function that reads credentials from shared SDK configuration
 * files, assuming roles and collecting MFA tokens as necessary.
 */
@js.native
trait Provider[T] extends js.Any {
  def apply(): js.Promise[T] = js.native
}


/**
 * A function that, when invoked, returns a promise that will be fulfilled with
 * a value of type T. It memoizes the result from the previous invocation
 * instead of calling the underlying resources every time.
 *
 * You can force the provider to refresh the memoized value by invoke the
 * function with optional parameter hash with `forceRefresh` boolean key and
 * value `true`.
 *
 * @example A function that reads credentials from IMDS service that could
 * return expired credentials. The SDK will keep using the expired credentials
 * until an unretryable service error requiring a force refresh of the
 * credentials.
 */
@js.native
trait MemoizedProvider[T] extends Provider[T] {
  def apply(options: js.UndefOr[MemoizedProviderOptions]): js.Promise[T] =
    js.native
}


@js.native
trait MemoizedProviderOptions extends js.Object {
  val forceRefresh: js.UndefOr[Boolean] = js.native
}

object MemoizedProviderOptions {
  def apply(forceRefresh: js.UndefOr[Boolean]): MemoizedProviderOptions =
    js.Dynamic
      .literal(
        forceRefresh = forceRefresh.asInstanceOf[js.Any]
      )
      .asInstanceOf[MemoizedProviderOptions]

}

/**
 * A function that, given a request body, determines the
 * length of the body. This is used to determine the Content-Length
 * that should be sent with a request.
 *
 * @example A function that reads a file stream and calculates
 * the size of the file.
 */
@js.native
trait BodyLengthCalculator extends js.Any {
  def apply(body: js.Any): js.UndefOr[Double] = js.native
}

/**
 * Interface that specifies the retry behavior
 */
@js.native
trait RetryStrategy extends js.Any {
  /**
   * The retry mode describing how the retry strategy control the traffic flow.
   */
  val mode: js.UndefOr[String] = js.native
  
  /**
   * the retry behavior the will invoke the next handler and handle the retry accordingly.
   * This function should also update the $metadata from the response accordingly.
   * @see {@link ResponseMetadata}
   */
  def retry[Input <: js.Object, Output <: MetadataBearer]: js.Function2[FinalizeHandler[Input, Output], FinalizeHandlerArguments[Input], js.Promise[FinalizeHandlerOutput[Output]]] = js.native
}

/**
 * Parses a URL in string form into an Endpoint object.
 */
@js.native
trait UrlParser extends js.Any {
  def apply(url: String): Endpoint = js.native
}

/**
 * Object containing regionalization information of
 * AWS services.
 */
@js.native
trait RegionInfo extends js.Any {
  val hostname: String = js.native
  val partition: String = js.native
  val path: js.UndefOr[String] = js.native
  val signingService: js.UndefOr[String] = js.native
  val signingRegion: js.UndefOr[String] = js.native
}

/**
 * Options to pass when calling {@link RegionInfoProvider}
 */
@js.native
trait RegionInfoProviderOptions extends js.Any {
  /**
   * Enables IPv6/IPv4 dualstack endpoint.
   * @default false
   */
  val useDualstackEndpoint: Boolean = js.native
  /**
   * Enables FIPS compatible endpoints.
   * @default false
   */
  val useFipsEndpoint: Boolean = js.native
}

/**
 * Function returns designated service's regionalization
 * information from given region. Each service client
 * comes with its regionalization provider. it serves
 * to provide the default values of related configurations
 */
@js.native
trait RegionInfoProvider extends js.Any {
  def apply(region: String, options: js.UndefOr[RegionInfoProviderOptions]): js.Promise[js.UndefOr[RegionInfo]] = js.native
}

/**
 * A tuple that represents an API name and optional version
 * of a library built using the AWS SDK.
 */
@js.native
trait UserAgentPair extends js.Any {
  val name: String = js.native
  val version: js.UndefOr[String] = js.native
}

/**
 * User agent data that to be put into the request's user
 * agent.
 */
type UserAgent = js.Array[UserAgentPair]