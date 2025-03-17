package com.sanovus.mega.concepts.kafka;

import com.sanovus.mega.concepts.dto.OrderPriceDTO;
import com.sanovus.mega.concepts.dto.TradePriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class MsgProducerService {

    @Autowired
    private kafkaPublisherService kafkaPublisherService;

    public void sendJsonMessage(){
        TradePriceDTO tradePriceDTO = TradePriceDTO.builder().id(new Random().nextInt()).trader("traderJsonName").build();
        kafkaPublisherService.publishJsonMsg(tradePriceDTO);
        OrderPriceDTO orderPriceDTO = OrderPriceDTO.builder().id(new Random().nextInt()).buyer("buyerJsonName").build();
        kafkaPublisherService.publishJsonMsg(orderPriceDTO);
    }

    public void sendByteArrayMessage(){
        TradePriceDTO tradePriceDTO = TradePriceDTO.builder().id(new Random().nextInt()).trader("traderByteArrayName").build();
        kafkaPublisherService.publishByteArrayMsg(tradePriceDTO);
        OrderPriceDTO orderPriceDTO = OrderPriceDTO.builder().id(new Random().nextInt()).buyer("buyerByteArrayName").build();
        kafkaPublisherService.publishByteArrayMsg(orderPriceDTO);
    }
}
