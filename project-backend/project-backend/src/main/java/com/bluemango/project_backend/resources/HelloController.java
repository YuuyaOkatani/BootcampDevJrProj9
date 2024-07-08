package com.bluemango.project_backend.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HelloController {

    @GetMapping("hello")
    public String GetHello(){
        return "Hello, World! This is a REST API developed using Spring Boot.";
    }
    
}
