package com.example.springbootprometheus.controller;

import com.example.springbootprometheus.pojo.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/message")
    public Message message() {
        return new Message("stuff");
    }
}
