package com.sanovus.mega.concepts.services;

import com.sanovus.mega.concepts.dto.OrderPriceDTO;
import org.springframework.stereotype.Service;

@Service
public class OrderPriceMessageHandlerImpl implements IMessageHandler {


    @Override
    public boolean canHandle(Class<?> dtoObjClass) {
        return OrderPriceDTO.class.equals(dtoObjClass);
    }

    @Override
    public void handle(Object dtoObject) {

        OrderPriceDTO orderPriceDTO = (OrderPriceDTO) dtoObject;

        System.out.println("handling OrderPriceMessageHandlerImpl:" + orderPriceDTO);

    }
}


