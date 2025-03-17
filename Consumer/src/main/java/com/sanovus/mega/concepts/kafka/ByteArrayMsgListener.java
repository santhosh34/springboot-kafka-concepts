package com.sanovus.mega.concepts.kafka;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanovus.mega.concepts.dto.OrderPrice;
import com.sanovus.mega.concepts.dto.TradePrice;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.ByteArrayJsonMessageConverter;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Parser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


@Component
@KafkaListener(id = "2", topics = {"my-byte-array-topic"})
public class ByteArrayMsgListener {

//    private static final ObjectMapper objectMapper = new ObjectMapper();
//
//    @KafkaHandler()
//    public void tradePrice(@Payload TradePrice tradePrice ) {
//        System.out.println(tradePrice);
//        System.out.println("objectString987");
//    }
//
//    @KafkaHandler()
//    public void orderPrice(@Payload OrderPrice orderPrice ) {
//        System.out.println(orderPrice);
//        System.out.println("orderPrice");
//    }

    @KafkaHandler(isDefault = true)
    public void getBytes(@Payload byte[] data ) {

        Object object = SerializationUtils.deserialize(data);
        System.out.println(object.getClass().getName());

    }
}
