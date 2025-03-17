package com.sanovus.mega.concepts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageFactory {

    @Autowired
    private List<IMessageHandler> messageHandlerList;

    public IMessageHandler getMessageHandler(String dtoObjClassName) {
        Optional<IMessageHandler> messageHandler =
                messageHandlerList.stream().filter(handler ->
                        handler.canHandle(dtoObjClassName)).findFirst();
        return messageHandler.orElse(null);
    }

}
