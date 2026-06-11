package com.l0gn3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main class that initializes Spring application
 * Retrieves bean calls its method that displays output.
 *
 */
@SpringBootApplication
@RestController // The @RestController annotation tells Spring that this code describes an endpoint that should be made available over the web.
public class App {
    public static void main( String[] args ) {
        // check if setup is functioning well.
        System.out.println( "Hello World!" );

        // Load XML-based configuration
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloWorldXml = (HelloWorld) xmlContext.getBean("helloWorld");
        helloWorldXml.printMessage();  // Output: Message: Hello, World from XML! aj confirming... when running the App in the terminal

        SpringApplication.run(App.class, args);
    }
    @GetMapping("/hello") // The @GetMapping(“/hello”) tells Spring to use our hello() method to answer requests that get sent to the http://localhost:8080/hello address.
    public String hello(
            @RequestParam(value = "name", defaultValue = "World") String name // the @RequestParam is telling Spring to expect a name value in the request, but if it’s not there, it will use the word "World" by default.
    ) {
        return String.format("Hello %s!", name);
        // Open your browser and in the address bar at the top enter http://localhost:8080/hello. You should get a nice friendly response like this: Hello World!
        // Pop quiz - What should happen if you add ?name=Amy to the end of the URL? http://localhost:8080/hello?name=Amy
    }
}
