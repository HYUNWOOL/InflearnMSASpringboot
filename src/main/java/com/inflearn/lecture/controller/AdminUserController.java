package com.inflearn.lecture.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.inflearn.lecture.exception.UserNotFoundException;
import com.inflearn.lecture.user.User;
import com.inflearn.lecture.user.UserDaoService;
import com.inflearn.lecture.user.UserV2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminUserController {
    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public MappingJacksonValue findAllUsers(){
        List<User> users = service.findAll();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
            .filterOutAllExcept("id","name","password","createAt");
        FilterProvider filterProvider = new SimpleFilterProvider()
            .addFilter("UserInfo",filter);
        MappingJacksonValue value = new MappingJacksonValue(users);
        value.setFilters(filterProvider);

        return value;
    }

//    @GetMapping("/v1/users/{id}")
//    @GetMapping(value = "/users/{id}/",params = "version=1")
//    @GetMapping(value = "/users/{id}",headers = "X-API-VERSION=1")
    @GetMapping(value = "/users/{id}" ,produces = "application/vnd.company.appv1+json")
    public MappingJacksonValue findByIdV1(@PathVariable int id){
        User user = service.findById(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] Not Found",id));
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
            .filterOutAllExcept("id","name","password","ssn");
        FilterProvider filterProvider = new SimpleFilterProvider()
            .addFilter("UserInfo",filter);
        MappingJacksonValue value = new MappingJacksonValue(user);
        value.setFilters(filterProvider);

        return value;
    }


//    @GetMapping("/v2/users/{id}")
    @GetMapping(value = "/users/{id}" ,produces = "application/vnd.company.appv2+json")
    public MappingJacksonValue findByIdV2(@PathVariable int id){
        User user = service.findById(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] Not Found",id));
        }
        //User - > User2
        UserV2 userV2 = new UserV2();
        BeanUtils.copyProperties(user,userV2);// id, name, createAt password, ssn
        userV2.setGrade("VIP");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
            .filterOutAllExcept("id","name","createAt","grade");
        FilterProvider filterProvider = new SimpleFilterProvider()
            .addFilter("UserInfoV2",filter);
        MappingJacksonValue value = new MappingJacksonValue(userV2);
        value.setFilters(filterProvider);

        return value;
    }
}
