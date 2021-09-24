package com.inflearn.lecture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping(value = "/v1")
public class HelloWorldController {

  @Autowired
  private MessageSource messageSource;
  // GET
  // /hello-world (endpoint)
  // RequestMapping(Method=RequestMethod.GET, path="/hello-world" <<예전방식
  @GetMapping(path = "/hello-world")
  public String helloWorld() {
    return "hello-world";
  }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("hello-world");
    }

  @GetMapping(path = "/hello-world-bean/path/{id}")
  public HelloWorldBean helloWorldBeanPath(@PathVariable String id) {
    return new HelloWorldBean(String.format("hello-world, %s",id));
  }

  @GetMapping(path = "/hello-world-international")
  public String helloWorldInternational(@RequestHeader(name ="Accept-Language",required = false ) Locale locale){

    return messageSource.getMessage("greeting.message",null, locale);
  }
}
