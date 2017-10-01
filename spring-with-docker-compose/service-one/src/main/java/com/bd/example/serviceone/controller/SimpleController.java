package com.bd.example.serviceone.controller;

import com.bd.example.serviceone.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class SimpleController {

    private static final String SERVICE_ONE_UP_AND_RUNNING = "Service one up and running!!";

    /**
     *  This method just checks whether app up and running.
     * @return String saying service is up and running
     */
    @RequestMapping("/")
    public String serviceOne() {
        return SERVICE_ONE_UP_AND_RUNNING;
    }

    /**
     * This endpoint is used to create a user in sample application.
     * @param user
     * @return created user details like name, email and contact number etc.
     */
    @RequestMapping(value = "/createUser"
            , method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user) {
        System.out.println("user is = " + user);
        return user;
    }

    /**
     * This end point is to generate random numbers
     *
     * @return List of random numbers
     */
    @RequestMapping(value = "/generateRandomNumbers"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> generateRandomNumbers() {
        return new Random()
                .ints(1000, 2000)
                .limit(20)
                .boxed()
                .collect(Collectors.toList());
    }

}
