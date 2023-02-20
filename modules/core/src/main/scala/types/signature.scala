package com.filippodeluca.jsfacade.awssdkv.types

import scalajs.js
import scalajs.js.typedarray.Uint8Array

/**
 * A {Date} object, a unix (epoch) timestamp in seconds, or a string that can be
 * understood by the JavaScript {Date} constructor.
 */
type DateInput = Double | String | js.Date;

@js.native
trait SigningArguments extends js.Any {
  /**
   * The date and time to be used as signature metadata. This value should be
   * a Date object, a unix (epoch) timestamp, or a string that can be
   * understood by the JavaScript `Date` constructor.If not supplied, the
   * value returned by `new Date()` will be used.
   */
  val signingDate: js.UndefOr[DateInput] = js.native

  /**
   * The service signing name. It will override the service name of the signer
   * in current invocation
   */
  val signingService: js.UndefOr[String] = js.native

  /**
   * The region name to sign the request. It will override the signing region of the
   * signer in current invocation
   */
  val signingRegion: js.UndefOr[String] = js.native
}

@js.native
trait RequestSigningArguments extends SigningArguments {
  /**
   * A set of strings whose members represents headers that cannot be signed.
   * All headers in the provided request will have their names converted to
   * lower case and then checked for existence in the unsignableHeaders set.
   */
  val unsignableHeaders: js.UndefOr[js.Set[String]] = js.native

  /**
   * A set of strings whose members represents headers that should be signed.
   * Any values passed here will override those provided via unsignableHeaders,
   * allowing them to be signed.
   *
   * All headers in the provided request will have their names converted to
   * lower case before signing.
   */
  val signableHeaders: js.UndefOr[js.Set[String]] = js.native
}

@js.native
trait RequestPresigningArguments extends RequestSigningArguments {
  /**
   * The number of seconds before the presigned URL expires
   */
  val expiresIn: js.UndefOr[Double] = js.native

  /**
   * A set of strings whose representing headers that should not be hoisted
   * to presigned request's query string. If not supplied, the presigner
   * moves all the AWS-specific headers (starting with `x-amz-`) to the request
   * query string. If supplied, these headers remain in the presigned request's
   * header.
   * All headers in the provided request will have their names converted to
   * lower case and then checked for existence in the unhoistableHeaders set.
   */
  val unhoistableHeaders: js.UndefOr[js.Set[String]] = js.native
}

@js.native
trait EventSigningArguments extends SigningArguments {
  val priorSignature: String = js.native
}

@js.native
trait RequestPresigner extends js.Any {
  /**
   * Signs a request for future use.
   *
   * The request will be valid until either the provided `expiration` time has
   * passed or the underlying credentials have expired.
   *
   * @param requestToSign The request that should be signed.
   * @param options       Additional signing options.
   */
  def presign(requestToSign: HttpRequest, options: js.UndefOr[RequestPresigningArguments]): js.Promise[HttpRequest] = js.native
}

/**
 * An object that signs request objects with AWS credentials using one of the
 * AWS authentication protocols.
 */
@js.native
trait RequestSigner extends js.Any {
  /**
   * Sign the provided request for immediate dispatch.
   */
  def sign(requestToSign: HttpRequest, options: js.UndefOr[RequestSigningArguments]): js.Promise[HttpRequest] = js.native
}

@js.native
trait StringSigner extends js.Any {
  /**
   * Sign the provided `stringToSign` for use outside of the context of
   * request signing. Typical uses include signed policy generation.
   */
  def sign(stringToSign: String, options: js.UndefOr[SigningArguments]): js.Promise[String] = js.native
}

@js.native
trait  FormattedEvent extends js.Any {
  val headers: js.typedarray.Uint8Array = js.native
  val payload: js.typedarray.Uint8Array = js.native
}

@js.native
trait EventSigner extends js.Any {
  /**
   * Sign the individual event of the event stream.
   */
  def sign(event: FormattedEvent, options: EventSigningArguments): js.Promise[String] = js.native
}