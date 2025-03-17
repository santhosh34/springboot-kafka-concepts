package com.sanovus.mega.concepts.services;

import com.sanovus.mega.concepts.dto.TradePriceDTO;
import org.springframework.stereotype.Service;



@Service
public class TradePriceMessageHandlerImpl implements IMessageHandler {


    @Override
    public boolean canHandle(Class<?> dtoObjClass) {
        return TradePriceDTO.class.equals(dtoObjClass);
    }

    @Override
    public void handle(Object dtoObject) {
        TradePriceDTO tradePriceDTO = (TradePriceDTO) dtoObject;
        System.out.println("handling TradePriceMessageHandlerImpl:" + tradePriceDTO);

    }
}



