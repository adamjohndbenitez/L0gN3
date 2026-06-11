package xyz.season.springtime.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // The @RestController annotation tells Spring that this code describes an endpoint that should be made available over the web. The class is flagged as a @RestController, meaning it is ready for use by Spring MVC to handle web requests.
public class HelloController {

    @GetMapping("/0") // @GetMapping maps / to the index() method. When invoked from a browser or by using curl on the command line, the method returns pure text. That is because @RestController combines @Controller and @ResponseBody, two annotations that results in web requests returning data rather than a view.
    public String index() {
        return "Greetings from Spring Boot!";
    }
// TODO: aj - commented-out to give way to spring security class MvcConfig addViewControllers(ViewControllerRegistry registry) registry.addViewController("/").setViewName("home");

    @GetMapping("/hello0") // The @GetMapping(“/hello”) tells Spring to use our hello() method to answer requests that get sent to the http://localhost:8080/hello address.
    public String hello(
            @RequestParam(value = "name", defaultValue = "World") String name // the @RequestParam is telling Spring to expect a name value in the request, but if it’s not there, it will use the word "World" by default.
    ) {
        return String.format("Hello %s!", name);
    }

}
