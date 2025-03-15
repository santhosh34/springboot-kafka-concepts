package com.sanovus.mega.concepts.kafka;

import com.sanovus.mega.concepts.dto.TradePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgProducerService {

    @Autowired
    private kafkaPublisherService kafkaPublisherService;

    public void sendMessage(){
        TradePrice tradePrice = TradePrice.builder().id(1).trader("santhosh").build();
        kafkaPublisherService.publishMsg(tradePrice);
    }
}
