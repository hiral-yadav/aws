package com.aws.api.producer;

import com.amazonaws.services.kinesis.producer.KinesisProducer;
import com.amazonaws.services.kinesis.producer.UserRecordResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.concurrent.Future;

@Service
public class MessageProducer {

    @Autowired
    private KinesisProducer kinesisProducer;

    public void produceRecords() {
        // Produce a record
        String partitionKey = "";
        ByteBuffer data = ByteBuffer.wrap("example-data".getBytes());

        Future<UserRecordResult> future = kinesisProducer.addUserRecord(STREAM_NAME, partitionKey, data);

        // Wait for the result
        try {
            UserRecordResult result = future.get();
            System.out.println("Record added with sequence number: " + result.getSequenceNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Clean up
        kinesisProducer.flushSync();
        kinesisProducer.destroy();
    }

}
