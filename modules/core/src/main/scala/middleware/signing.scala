package com.filippodeluca.jsfacade.awssdk
package middleware

import com.filippodeluca.jsfacade.awssdk.types._
import scalajs.js

object signing {
  import com.filippodeluca.jsfacade.awssdk.types._
  import com.filippodeluca.jsfacade.awssdk.types.identity._

  @js.native
  trait AwsAuthInputConfig extends SigV4AuthInputConfig {
    val signingRegion: js.UndefOr[String] = js.native
  }

  @js.native
  trait SigV4AuthInputConfig extends js.Any {
    val credentials
        : js.UndefOr[AwsCredentialIdentity | Provider[AwsCredentialIdentity]] =
      js.native
    val signer: js.UndefOr[
      RequestSigner | (AuthScheme) => js.Promise[RequestSigner]
    ] =
      js.native
    val signingEscapePath: js.UndefOr[Boolean] = js.native
    val systemClockOffset: js.UndefOr[Int] = js.native
  }

// export interface AwsAuthInputConfig {
//   /**
//    * The credentials used to sign requests.
//    */
//   credentials?: AwsCredentialIdentity | Provider<AwsCredentialIdentity>;

//   /**
//    * The signer to use when signing requests.
//    */
//   signer?: RequestSigner | ((authScheme?: AuthScheme) => Promise<RequestSigner>);

//   /**
//    * Whether to escape request path when signing the request.
//    */
//   signingEscapePath?: boolean;

//   /**
//    * An offset value in milliseconds to apply to all signing times.
//    */
//   systemClockOffset?: number;

//   /**
//    * The region where you want to sign your request against. This
//    * can be different to the region in the endpoint.
//    */
//   signingRegion?: string;

//   /**
//    * The injectable SigV4-compatible signer class constructor. If not supplied,
//    * regular SignatureV4 constructor will be used.
//    * @private
//    */
//   signerConstructor?: new (options: SignatureV4Init & SignatureV4CryptoInit) => RequestSigner;
// }

// export interface SigV4AuthInputConfig {
//   /**
//    * The credentials used to sign requests.
//    */
//   credentials?: AwsCredentialIdentity | Provider<AwsCredentialIdentity>;

//   /**
//    * The signer to use when signing requests.
//    */
//   signer?: RequestSigner | ((authScheme?: AuthScheme) => Promise<RequestSigner>);

//   /**
//    * Whether to escape request path when signing the request.
//    */
//   signingEscapePath?: boolean;

//   /**
//    * An offset value in milliseconds to apply to all signing times.
//    */
//   systemClockOffset?: number;
// }

}
