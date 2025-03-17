package com.sanovus.mega.concepts.services;

import com.sanovus.mega.concepts.dto.OrderPriceDTO;
import org.springframework.stereotype.Service;

@Service
public class OrderPriceMessageHandlerImpl implements IMessageHandler {


    @Override
    public boolean canHandle(String dtoObjClassName) {
        System.out.println("dtoObjClass Param1.1==>"+dtoObjClassName);
        System.out.println("dtoObjClass Param1.2==>"+OrderPriceDTO.class.getName());
//        System.out.println("dtoObjClass Original1==>"+ OrderPriceDTO.class.getAnnotations());
        boolean sth=  dtoObjClassName.equals(OrderPriceDTO.class.getName());
        System.out.println(sth);
        return sth;
    }

    @Override
    public void handle(Object dtoObject) {

        OrderPriceDTO orderPriceDTO = (OrderPriceDTO) dtoObject;

        System.out.println("handling OrderPriceMessageHandlerImpl:" + orderPriceDTO);

    }
}


