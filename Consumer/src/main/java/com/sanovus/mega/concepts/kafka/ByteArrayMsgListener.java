package com.sanovus.mega.concepts.kafka;

import com.sanovus.mega.concepts.services.IMessageHandler;
import com.sanovus.mega.concepts.services.MessageFactory;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "2", topics = {"my-byte-array-topic"})
public class ByteArrayMsgListener {

    @Autowired
    private MessageFactory messageFactory;

    @KafkaHandler(isDefault = true)
    public void getBytes(@Payload byte[] data ) {

        Object object = SerializationUtils.deserialize(data);

        System.out.println("BEGIN");
        System.out.println("byte[] class:"+object.getClass().getName());
        IMessageHandler messageHandler=  messageFactory.getMessageHandler(object.getClass().getName());
        System.out.println("final msgHandler:"+messageHandler);
        //messageHandler.handle(object);
        System.out.println("END");

    }
}
