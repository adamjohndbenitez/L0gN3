package xyz.season.springtime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication // @SpringBootApplication is a convenience annotation that adds all of the following: (1) @Configuration: Tags the class as a source of bean definitions for the application context. (2) @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet. (3) @ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.
public class SpringTimeApplication {

	public static void main(String[] args) { // The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.
		SpringApplication.run(SpringTimeApplication.class, args);
	}

    @Bean // There is also a CommandLineRunner method marked as a @Bean, and this runs on startup. It retrieves all the beans that were created by your application or that were automatically added by Spring Boot. It sorts them and prints them out.
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
            // You can see org.springframework.boot.<tech>.autoconfigure beans. There is also a tomcatServletWebServerFactory one.

        };
    }
}
