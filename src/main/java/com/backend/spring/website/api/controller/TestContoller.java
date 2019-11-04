package com.backend.spring.website.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestContoller {
	
    @RequestMapping("/")
    String hellow() 
    {
        return "Hello, it's working!";
    }
}
