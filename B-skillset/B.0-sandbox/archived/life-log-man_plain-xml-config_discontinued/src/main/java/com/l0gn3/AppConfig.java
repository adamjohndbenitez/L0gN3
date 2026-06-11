package com.l0gn3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean   //defines a bean which allows spring to manage bean and create instances of bean.
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }
}
