package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ding on 2017/5/22.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(){

        return "Hello World";
    }
}
