package com.sanovus.mega.concepts.kafka;


import com.sanovus.mega.concepts.dto.OrderPriceDTO;
import com.sanovus.mega.concepts.dto.TradePriceDTO;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@KafkaListener(id = "1", topics = {"my-json-topic"})
public class JsonMsgListener {

    @KafkaHandler()
    public void tradePrice(TradePriceDTO tradePriceDTO ) {
        System.out.println(tradePriceDTO);
        System.out.println("tradePriceDTO");
    }

    @KafkaHandler()
    public void orderPrice(OrderPriceDTO orderPriceDTO ) {
        System.out.println(orderPriceDTO);
        System.out.println("orderPriceDTO");
    }


}
