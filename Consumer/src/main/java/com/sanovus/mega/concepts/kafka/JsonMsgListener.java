package com.sanovus.mega.concepts.kafka;


import com.sanovus.mega.concepts.dto.OrderPrice;
import com.sanovus.mega.concepts.dto.TradePrice;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@KafkaListener(id = "1", topics = {"my-json-topic"})
public class JsonMsgListener {

    @KafkaHandler()
    public void tradePrice(TradePrice tradePrice ) {
        System.out.println(tradePrice);
        System.out.println("tradePrice");
    }

    @KafkaHandler()
    public void orderPrice(OrderPrice orderPrice ) {
        System.out.println(orderPrice);
        System.out.println("orderPrice");
    }


}
