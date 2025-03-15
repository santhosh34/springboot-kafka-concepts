package com.sanovus.mega.concepts.kafka;

import com.sanovus.mega.concepts.dto.TradePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class kafkaPublisherService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void publishMsg(TradePrice tradePrice){

        CompletableFuture sendStatusFuture = kafkaTemplate.send("topicName", tradePrice);

        sendStatusFuture.whenComplete((Object object, Object result) ->{
            System.out.println(object);
            System.out.println(result);
        });
    }
}
