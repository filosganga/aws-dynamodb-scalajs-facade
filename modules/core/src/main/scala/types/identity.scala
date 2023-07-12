package com.filippodeluca.jsfacade.awssdk.types
package identity

import scalajs.js

@js.native
trait Identity extends js.Object {
  val expiration: js.UndefOr[js.Date] = js.native
}

@js.native
trait IdentityProvider[A <: Identity] extends Provider[A] {
  def apply(
      identityProperties: js.UndefOr[js.Dictionary[js.Any]]
  ): js.Promise[A] = js.native
}

@js.native
trait AnonymousIdentity extends Identity

@js.native
trait LoginIdentity extends Identity {
  val username: String = js.native
  val password: String = js.native
}

object LoginIdentity {
  def apply(
      username: String,
      password: String,
      expiration: js.UndefOr[js.Date] = js.undefined
  ) = js.Dynamic
    .literal(
      username = username.asInstanceOf[js.Any],
      password = password.asInstanceOf[js.Any],
      expiration = expiration.asInstanceOf[js.Any]
    )
    .asInstanceOf[LoginIdentity]
}

@js.native
trait LoginIdentityProvider extends IdentityProvider[LoginIdentity]

@js.native
trait TokenIdentity extends Identity {
  val token: String = js.native
}

object TokenIdentity {
  def apply(
      token: String,
      expiration: js.UndefOr[js.Date] = js.undefined
  ) = js.Dynamic
    .literal(
      token = token.asInstanceOf[js.Any],
      expiration = expiration.asInstanceOf[js.Any]
    )
    .asInstanceOf[TokenIdentity]
}

@js.native
trait TokenIdentityProvider extends IdentityProvider[TokenIdentity]

@js.native
trait AwsCredentialIdentity extends Identity {
  val accessKeyId: String = js.native
  val secretAccessKey: String = js.native
  val sessionToken: js.UndefOr[String] = js.native
}

object AwsCredentialIdentity {
  def apply(
      accessKeyId: String,
      secretAccessKey: String,
      sessionToken: js.UndefOr[String] = js.undefined,
      expiration: js.UndefOr[js.Date] = js.undefined
  ): AwsCredentialIdentity = js.Dynamic
    .literal(
      accessKeyId = accessKeyId.asInstanceOf[js.Any],
      secretAccessKey = secretAccessKey.asInstanceOf[js.Any],
      sessionToken = sessionToken.asInstanceOf[js.Any],
      expiration = expiration.asInstanceOf[js.Any]
    )
    .asInstanceOf[AwsCredentialIdentity]
}

@js.native
trait AwsCredentialIdentityProvider
    extends IdentityProvider[AwsCredentialIdentity]
