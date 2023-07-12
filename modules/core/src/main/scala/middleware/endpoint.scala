package com.filippodeluca.jsfacade.awssdk
package middleware

import com.filippodeluca.jsfacade.awssdk.config.resolver.UseFipsEndpoint
import com.filippodeluca.jsfacade.awssdk.types._
import scalajs.js
import scalajs.js.|

object endpoint {

  trait EndpointProviderContext {
    val logger: js.UndefOr[Logger]
  }

  /** Endpoint config interfaces and resolver for Endpoint v2. They live in
    * separate package to allow per-service onboarding. When all services
    * onboard Endpoint v2, the resolver in config-resolver package can be
    * removed. This interface includes all the endpoint parameters with built-in
    * bindings of "AWS::*" and "SDK::*"
    */
  @js.native
  trait EndpointInputConfig extends UseFipsEndpoint {

    /** The fully qualified endpoint of the webservice. This is only for using a
      * custom endpoint (for example, when using a local version of S3).
      *
      * Endpoint transformations such as S3 applying a bucket to the hostname
      * are still applicable to this custom endpoint.
      */
    val endpoint: js.UndefOr[
      String | Endpoint |
        Provider[
          Endpoint
        ] | EndpointV2 | Provider[EndpointV2]
    ] = js.native

    /** Providing a custom endpointProvider will override built-in
      * transformations of the endpoint such as S3 adding the bucket name to the
      * hostname, since they are part of the default endpointProvider.
      */
    val endpointProvider: js.UndefOr[
      js.Function2[EndpointParameters, EndpointProviderContext, EndpointV2]
    ] = js.native

    /** Whether TLS is enabled for requests.
      * @deprecated
      */
    val tls: js.UndefOr[Boolean] = js.native

    /** Enables IPv6/IPv4 dualstack endpoint.
      */
    val useDualstackEndpoint: js.UndefOr[Boolean | Provider[Boolean]] =
      js.native;

  }

  @js.native
  trait EndpointDiscoveryInputConfig extends js.Any {

    /** The size of the client cache storing endpoints from endpoint discovery
      * operations. Defaults to 1000.
      */
    val endpointCacheSize: js.UndefOr[Double] = js.native

    /** Whether to call operations with endpoints given by service dynamically.
      * Setting this config to `true` will enable endpoint discovery for all
      * applicable operations. Setting it to `false` will explicitly disable
      * endpoint discovery even though operations that require endpoint
      * discovery will presumably fail. Leaving it to undefined means SDK only
      * do endpoint discovery when it's required. Defaults to `undefined`.
      */
    val endpointDiscoveryEnabled: js.UndefOr[Boolean] = js.native

  }
}
