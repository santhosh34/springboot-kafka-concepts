package com.sanovus.mega.concepts.services;

import com.sanovus.mega.concepts.dto.IBaseDTO;

public interface IMessageHandler {

    public boolean canHandle(Class<?> dtoObjClass);

    public void handle(Object dtoObject);


}

