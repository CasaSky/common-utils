package com.casasky.example;

import com.casasky.util.JsonUtil;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class CryptoEventSqsListener {

    @SqsListener(value = "sample-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    void receiveMessage(CryptoEvent cryptoEvent) {
      log.info("sqs message received {}", JsonUtil.toJson(cryptoEvent));
    }
}