package com.ipiecoles.java.mdd050.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class HelloController {

    @RequestMapping(
            value = "/sayHello", //URL
            method = RequestMethod.GET
    )
    public String hello(){
        return "Hello";
    }

}

