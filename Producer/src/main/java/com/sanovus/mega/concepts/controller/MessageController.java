package com.sanovus.mega.concepts.controller;


import com.sanovus.mega.concepts.kafka.MsgProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trigger")
public class MessageController {

    @Autowired
    private MsgProducerService msgProducerService;

    @GetMapping("/sth")
    public String getSth(){
        return "Something .... ";
    }

    @GetMapping("/json-msg")
    public String produceJsonMsg(){
        msgProducerService.sendJsonMessage();
        return "Produced a msg and handed over to kafka .... ";
    }

    @GetMapping("/byte-array-msg")
    public String produceByteArrayMsg(){
        msgProducerService.sendByteArrayMessage();
        return "Produced a msg and handed over to kafka .... ";
    }

}
