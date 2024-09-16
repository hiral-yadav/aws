import * as cdk from 'aws-cdk-lib';
import { Construct } from 'constructs';
import * as lambda from 'aws-cdk-lib/aws-lambda';
import path = require('path');

export class NodeStack extends cdk.Stack {
  constructor(scope: Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    new lambda.Function(this, 'test-lambda', {
      code: lambda.Code.fromAsset(path.join(__dirname, '../src/lambda')),
      handler: 'index.handler',
      runtime: lambda.Runtime.NODEJS_20_X,
    });
  }
}
