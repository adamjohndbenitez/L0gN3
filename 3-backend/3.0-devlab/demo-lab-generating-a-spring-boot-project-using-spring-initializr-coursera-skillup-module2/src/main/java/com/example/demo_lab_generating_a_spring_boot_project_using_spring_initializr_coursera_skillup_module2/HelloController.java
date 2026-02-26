package com.example.demo_lab_generating_a_spring_boot_project_using_spring_initializr_coursera_skillup_module2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }
}