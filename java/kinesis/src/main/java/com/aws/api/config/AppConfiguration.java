package com.aws.api.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.kinesis.producer.KinesisProducer;
import com.amazonaws.services.kinesis.producer.KinesisProducerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public KinesisProducerConfiguration getConfig() {
        KinesisProducerConfiguration config = new KinesisProducerConfiguration()
                .setRegion("us-east-1")
                .setCredentialsProvider(new DefaultAWSCredentialsProviderChain())
                .setAggregationEnabled(true)
                .setAggregationMaxCount(500);
        return config;
    }

    @Bean
    public KinesisProducer getProducer() {
        return new KinesisProducer(getConfig());
    }
}
