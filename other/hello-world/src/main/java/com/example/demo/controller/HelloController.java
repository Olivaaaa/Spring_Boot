package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //需要路径映射
    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }

}
