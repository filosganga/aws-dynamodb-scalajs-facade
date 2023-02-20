package com.filippodeluca.jsfacade.awssdkv
package client
package dynamodb
package commands

import scalajs.js
import scalajs.js.annotation.JSImport

import com.filippodeluca.jsfacade.awssdkv.types.MetadataBearer
import com.filippodeluca.jsfacade.awssdkv.types.ResponseMetadata
import com.filippodeluca.jsfacade.awssdkv.client.dynamodb.models._

@js.native
@JSImport("@aws-sdk/client-dynamodb", "BatchGetItemCommand")
class BatchGetItemCommand(override val input: BatchGetItemCommandInput)
    extends Command[BatchGetItemCommandInput, BatchGetItemCommandOutput]

object BatchGetItemCommand {
  def apply(input: BatchGetItemCommandInput): BatchGetItemCommand =
    new BatchGetItemCommand(
      input
    )
}

@js.native
@JSImport("@aws-sdk/client-dynamodb", "BatchWriteItemCommand")
class BatchWriteItemCommand(override val input: BatchWriteItemCommandInput)
    extends Command[BatchWriteItemCommandInput, BatchWriteItemCommandOutput]

object BatchWriteItemCommand {
  def apply(input: BatchWriteItemCommandInput): BatchWriteItemCommand =
    new BatchWriteItemCommand(
      input
    )
}

@js.native
@JSImport("@aws-sdk/client-dynamodb", "CreateTableCommand")
class CreateTableCommand(override val input: CreateTableCommandInput)
    extends Command[CreateTableCommandInput, CreateTableCommandOutput]

object CreateTableCommand {
  def apply(input: CreateTableCommandInput): CreateTableCommand =
    new CreateTableCommand(
      input
    )
}

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
@JSImport("@aws-sdk/client-dynamodb", "GetItemCommand")
class GetItemCommand(override val input: GetItemCommandInput)
    extends Command[GetItemCommandInput, GetItemCommandOutput]

object GetItemCommand {
  def apply(input: GetItemCommandInput): GetItemCommand = new GetItemCommand(
    input
  )
}

@js.native
@JSImport("@aws-sdk/client-dynamodb", "PutItemCommand")
class PutItemCommand(override val input: PutItemCommandInput)
    extends Command[PutItemCommandInput, PutItemCommandOutput]

object PutItemCommand {
  def apply(input: PutItemCommandInput): PutItemCommand = new PutItemCommand(
    input
  )
}

@js.native
@JSImport("@aws-sdk/client-dynamodb", "QueryCommand")
class QueryCommand(override val input: QueryCommandInput)
    extends Command[QueryCommandInput, QueryCommandOutput]

object QueryCommand {
  def apply(input: QueryCommandInput): QueryCommand = new QueryCommand(
    input
  )
}

@js.native
@JSImport("@aws-sdk/client-dynamodb", "ScanCommand")
class ScanCommand(override val input: ScanCommandInput)
    extends Command[ScanCommandInput, ScanCommandOutput]

object ScanCommand {
  def apply(input: ScanCommandInput): ScanCommand = new ScanCommand(
    input
  )
}

@js.native
@JSImport("@aws-sdk/client-dynamodb", "DescribeTableCommand")
class DescribeTableCommand(override val input: DescribeTableCommandInput)
    extends Command[DescribeTableCommandInput, DescribeTableCommandOutput]

object DescribeTableCommand {
  def apply(input: DescribeTableCommandInput): DescribeTableCommand =
    new DescribeTableCommand(
      input
    )
}

@js.native
@JSImport("@aws-sdk/client-dynamodb", "UpdateItemCommand")
class UpdateItemCommand(override val input: UpdateItemCommandInput)
    extends Command[UpdateItemCommandInput, UpdateItemCommandOutput]

object UpdateItemCommand {
  def apply(input: UpdateItemCommandInput): UpdateItemCommand =
    new UpdateItemCommand(
      input
    )
}
