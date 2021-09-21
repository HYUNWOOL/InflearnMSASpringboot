package com.inflearn.lecture.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class HelloWorldController {
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
}
