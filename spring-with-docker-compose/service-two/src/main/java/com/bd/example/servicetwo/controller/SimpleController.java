package com.bd.example.servicetwo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private static final String SERVICE_ONE_UP_AND_RUNNING = "Service two up and running!!";

    @RequestMapping("/")
    public String serviceTwo() {
        return SERVICE_ONE_UP_AND_RUNNING;
    }
}
