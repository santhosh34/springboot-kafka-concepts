package com.sanovus.mega.concepts.services;

import com.sanovus.mega.concepts.dto.IBaseDTO;

public interface IMessageHandler {

    public boolean canHandle(String dtoObjClassName);

    public void handle(Object dtoObject);


}

