package com.bd.example.serviceone.controller;

import com.bd.example.serviceone.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
// @Controller
public class SimpleController {

    private static final String SERVICE_ONE_UP_AND_RUNNING = "Service one up and running!!";

    /**
     *  This method just checks whether app up and running.
     * @return String saying service is up and running
     */
    @ResponseBody
    @RequestMapping("/")
    public Map<String, Object> serviceOne() {
        return Collections.singletonMap("message", SERVICE_ONE_UP_AND_RUNNING);
    }

    /**
     * This endpoint is used to create a user in sample application.
     * @param user
     * @return created user details like name, email and contact number etc.
     */
    @ResponseBody
    @RequestMapping(value = "/createUser"
            , method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user) {
        System.out.println("user is = " + user);
        user.setPassword(UUID.randomUUID().toString());
        return user;
    }

    /**
     * This end point is to generate random numbers
     *
     * @return List of random numbers
     */
    @ResponseBody
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
