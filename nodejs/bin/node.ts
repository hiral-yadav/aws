#!/usr/bin/env node
import 'source-map-support/register';
import * as cdk from 'aws-cdk-lib';
import { NodeStack } from '../lib/lambda-stack';
import { S3Stack } from '../lib/s3-stack';

const app = new cdk.App();
new NodeStack(app, 'NodeStack');
new S3Stack(app, 'S3Stack');