package com.andrey.projetomvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloWorld")
public class HelloWorldCotroller {

    @GetMapping
    public String helloWorld(){ return "Hello World!!"; }

}
