package com.spring.app.springbootjsonbinary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/halo")
public class ControllerHallo {

    @GetMapping
    public String getHallo(){
        return "hallo spring postgresql";
    }
}
