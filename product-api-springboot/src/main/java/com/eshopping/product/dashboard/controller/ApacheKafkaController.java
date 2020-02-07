package com.eshopping.product.dashboard.controller;

import com.eshopping.product.dashboard.mesasging.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class ApacheKafkaController {

    @Autowired
    KafkaSender kafkaSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("messagge") String message) {
        kafkaSender.send(message);
        return "Message sent to the Kafka Topic";
    }

}
