package com.inflearn.lecture.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class HelloWorldController {
    //GET
    // /hello-world (endpoint)
    // RequestMapping(Method=RequestMethod.GET, path="/hello-world" <<예전방식
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "hello-world";
    }
}
