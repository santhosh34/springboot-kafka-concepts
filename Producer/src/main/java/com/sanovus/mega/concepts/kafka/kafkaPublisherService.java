package com.sanovus.mega.concepts.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.RoutingKafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import java.util.concurrent.CompletableFuture;


@Slf4j
@Service
public class kafkaPublisherService {

    @Autowired
    private RoutingKafkaTemplate routingKafkaTemplate;

    public void publishByteArrayMsg(Object object){

            CompletableFuture<SendResult<Object, Object>> sendResultCompletableFuture =
                    routingKafkaTemplate.send("my-byte-array-topic", SerializationUtils.serialize(object));

            sendResultCompletableFuture.whenComplete((result, exceptionIfAny) -> {
                if (exceptionIfAny == null) {
                    System.out.println("ByteArrayResult:"+result);
                    System.out.println("ByteArrayHeaders:"+result.getProducerRecord().headers());
                }else{
                    log.error(exceptionIfAny.getMessage());
                }
            });

    }
    public void publishJsonMsg(Object object){

        CompletableFuture<SendResult<Object, Object>> sendResultCompletableFuture =
                routingKafkaTemplate.send("my-json-topic", object);

        sendResultCompletableFuture.whenComplete((result, exceptionIfAny) -> {
            if (exceptionIfAny == null) {
                System.out.println("JsonResult:"+result);
                System.out.println("JsonHeaders:"+result.getProducerRecord().headers());
            }else{
                log.error(exceptionIfAny.getMessage());
            }
        });

    }
}
