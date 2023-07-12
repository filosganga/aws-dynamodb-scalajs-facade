package com.filippodeluca.jsfacade.awssdk
package client
package sns
package commands

import com.filippodeluca.jsfacade.awssdk.client.sns.models._
import scalajs.js
import scalajs.js.annotation.JSImport

@js.native
@JSImport("@aws-sdk/client-sns", "PublishCommand")
class PublishCommand(override val input: PublishCommandInput)
    extends Command[PublishCommandInput, PublishCommandOutput]

object PublishCommand {
  def apply(input: PublishCommandInput): PublishCommand =
    new PublishCommand(
      input
    )
}

@js.native
@JSImport("@aws-sdk/client-sns", "CreateTopicCommand")
class CreateTopicCommand(override val input: CreateTopicCommandInput)
    extends Command[CreateTopicCommandInput, CreateTopicCommandOutput]

object CreateTopicCommand {
  def apply(input: CreateTopicCommandInput): CreateTopicCommand =
    new CreateTopicCommand(
      input
    )
}

@js.native
@JSImport("@aws-sdk/client-sns", "DeleteTopicCommand")
class DeleteTopicCommand(override val input: DeleteTopicCommandInput)
    extends Command[DeleteTopicCommandInput, DeleteTopicCommandOutput]

object DeleteTopicCommand {
  def apply(input: DeleteTopicCommandInput): DeleteTopicCommand =
    new DeleteTopicCommand(
      input
    )
}

@js.native
@JSImport("@aws-sdk/client-sns", "PublishBatchCommand")
class PublishBatchCommand(override val input: PublishBatchCommandInput)
    extends Command[PublishBatchCommandInput, PublishBatchCommandOutput]

object PublishBatchCommand {
  def apply(input: PublishBatchCommandInput): PublishBatchCommand =
    new PublishBatchCommand(
      input
    )
}
