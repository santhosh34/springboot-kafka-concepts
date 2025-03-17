package com.sanovus.mega.concepts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MessageFactory<T> {

    @Autowired
    private final List<IMessageHandler> messageHandlerList;

    public MessageFactory(List<IMessageHandler> messageHandlerList) {
        this.messageHandlerList = messageHandlerList;
        System.out.println("All list please: \n" + messageHandlerList);
    }

    public IMessageHandler getMessageHandler(Object dtoObj) {
        Optional<IMessageHandler> messageHandler =
                messageHandlerList.stream().filter(handler ->
                        handler.canHandle(dtoObj.getClass())).findFirst();
        return messageHandler.orElse(null);
    }

}
