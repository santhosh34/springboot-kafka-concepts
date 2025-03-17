package com.sanovus.mega.concepts.services;

import com.sanovus.mega.concepts.dto.OrderPriceDTO;
import com.sanovus.mega.concepts.dto.TradePriceDTO;
import org.springframework.stereotype.Service;



@Service
public class TradePriceMessageHandlerImpl implements IMessageHandler {


    @Override
    public boolean canHandle(String dtoObjClassName) {
        System.out.println("dtoObjClass Param2.1==>"+dtoObjClassName);
        System.out.println("dtoObjClass Param2.2==>"+TradePriceDTO.class.getName());
        boolean sth=  dtoObjClassName.equals(TradePriceDTO.class.getName());
        System.out.println(sth);
        return sth;
    }

    @Override
    public void handle(Object dtoObject) {
        TradePriceDTO tradePriceDTO = (TradePriceDTO) dtoObject;
        System.out.println("===>"+tradePriceDTO.getTrader());
        System.out.println("handling TradePriceMessageHandlerImpl:" + tradePriceDTO);

    }
}



