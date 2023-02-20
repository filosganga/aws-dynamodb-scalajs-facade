package com.filippodeluca.jsfacade.awssdkv.types

import scalajs.js

/** An object that provides a checksum of data provided in chunks to `update`.
  * The checksum may be performed incrementally as chunks are received or all at
  * once when the checksum is finalized, depending on the underlying
  * implementation.
  *
  * It's recommended to compute checksum incrementally to avoid reading the
  * entire payload in memory.
  *
  * A class that implements this interface may accept an optional secret key in
  * its constructor while computing checksum value, when using HMAC. If
  * provided, this secret key would be used when computing checksum.
  */

@js.native
trait Checksum extends js.Any {

  /** Constant length of the digest created by the algorithm in bytes.
    */
  val digestLength: js.UndefOr[Double] = js.native

  /** Creates a new checksum object that contains a deep copy of the internal
    * state of the current `Checksum` object.
    */
  val copy: js.UndefOr[js.Function0[Checksum]] = js.native

  /** Returns the digest of all of the data passed.
    */
  def digest(): js.Promise[js.typedarray.Uint8Array] = js.native

  /** Allows marking a checksum for checksums that support the ability to mark
    * and reset.
    *
    * @param {Double}
    *   readLimit - The maximum limit of bytes that can be read before the mark
    *   position becomes invalid.
    */
  val mark: js.UndefOr[js.Function1[Double, Unit]] = js.native

  /** Resets the checksum to its initial value.
    */
  def reset(): Unit = js.native

  /** Adds a chunk of data for which checksum needs to be computed. This can be
    * called many times with new data as it is streamed.
    *
    * Implementations may override this method which passes second param which
    * makes Checksum object stateless.
    *
    * @param {Uint8Array}
    *   chunk - The buffer to update checksum with.
    */
  def update(chunk: js.typedarray.Uint8Array): Unit = js.native
}

/** A constructor for a Checksum that may be used to calculate an HMAC.
  * Implementing classes should not directly hold the provided key in memory
  * beyond the lexical scope of the constructor.
  */
@js.native
trait ChecksumConstructor extends js.Any {
  // def `new`(secret: js.UndefOr[SourceData]): Checksum = js.native
}
