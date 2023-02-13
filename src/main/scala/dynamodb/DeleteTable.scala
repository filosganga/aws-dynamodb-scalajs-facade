package com.filippodeluca.jsfacade.aws
package dynamodb

import scalajs.js
import scalajs.js.annotation.JSImport

@js.native
@JSImport("@aws-sdk/client-dynamodb", "DeleteTableCommand")
class DeleteTableCommand(override val input: DeleteTableCommandInput)
    extends Command[DeleteTableCommandInput, DeleteTableCommandOutput]

object DeleteTableCommand {
  def apply(input: DeleteTableCommandInput): DeleteTableCommand =
    new DeleteTableCommand(
      input
    )
}

@js.native
trait DeleteTableCommandInput extends js.Object {
  val TableName: String = js.native
}

object DeleteTableCommandInput {
  def apply(
      TableName: String
  ): DeleteTableCommandInput = js.Dynamic
    .literal(
      TableName = TableName
    )
    .asInstanceOf[DeleteTableCommandInput]
}

@js.native
trait DeleteTableCommandOutput extends js.Object {
  def $metadata: ResponseMetadata = js.native
  def TableDescription: js.UndefOr[TableDescription] = js.native
}
