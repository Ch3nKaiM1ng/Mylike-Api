package com.mylike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BaseContoller {
    @GetMapping("{path}")
    public String get(@PathVariable("path") String path){
        return path;
    }
}
