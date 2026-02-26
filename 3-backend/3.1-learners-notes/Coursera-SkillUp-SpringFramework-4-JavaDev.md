# Course Overview

Spring Frameworks for Java Development

in-depth understanding of Spring’s core components, including dependency injection, aspect-oriented programming, and configuration management. 

creating modular and maintainable applications by leveraging Spring’s powerful features.

gain experience setting up Spring applications, managing dependencies with Maven, and building RESTful APIs. The course also covers advanced concepts such as Spring Boot, Spring MVC, and Spring Security, enabling you to build dynamic web applications easily. Emphasizing best practices in software design, including modular architecture, code reusability, and secure development, this course prepares you for real-world enterprise application challenges.

explore the core components and ecosystem of Spring, understand essential terminologies, and set up your development environment using tools like IntelliJ and Maven.

focusing on its role in simplifying the development of stand-alone, production-grade Spring-based applications.

create and configure Spring Boot projects using Spring Initializr and build REST APIs to enable dynamic web interactions. By mastering essential concepts such as controllers, annotations, and API testing with Postman, you will gain the skills to develop robust and efficient web applications.

develop interactive web applications using Spring MVC and implement security measures using Spring Security.

set up Spring MVC projects, integrate Thymeleaf for dynamic content rendering, and handle user input through interactive web forms.

---

# Spring Ecosystem:

## Primary components
- Spring Core
  - Provides dependency injection
  - Supports aspect-oriented programming
  - 
- Spring MVC
  - Servces as a web framework
  - Separates:
    - Business Logic
    - User Interface
    - Input processing
   
- Spring AOP
  - Manages cross-cutting concerns
  - Keeps concers separate from business logic

## 2ndary Spring tools:
- Spring Security
  - provides a customizable framework
  - enableds authentication and access control
  - adds security feature

- Spring JDBC
  - simplifies DB interactions
  - manages error handling
  - abstracts JDBC operations
 
- Spring Integration
  - Helps create message-driven app
  - Offers extensible framework
  - 
- Spring Data
  - Simplifies CRUD operations
  - Offers a uniform approache to data access
 
- Spring REST Docs
  - Documents RESTful services
  - Generates snippets for AsciiDoc or Markdown files
  - Ensures API documentation is in sync with code
 
- Spring Session
  - Manages user sessions
  - Supports session clustering
  - Makes session handling efficient
 
- Spring Boot
  - Rapid speed app development 
  - Simplifies configuration and deployment
  - Uses embedded servers
 
- Spring CLI
  - enables rapid prototyping
 
- Spring Cloud
  - provides tools for distributed systems
  - offers services discovery
  - offers circuit breakers
  - manages comms
  - ensures reliability in microservices architecture
 
- Spring Webflux (adv feature)
  - handles asynchronous, non-blocking apps
  - manages hi-volume requests efficiently

- Spring Kafka (adv feature)
  - builds event-driven systems w/ kafka
  - streams messages in real time

- Spring cloud gateway (adv feature)
  - serves as an API gateway
  - routes requests and managem security

- Spring Authorization Server (adv feature)
  - implements OAuth2.0 and OpenID Connect
  - Secures application with authorization protocols

- Spring AI
  - uses POJOs (plain-old java objects) for AI application
  - promotes AI engineering with Spring framework

# Spring Applications
- E-commerce
  - manages complex transactions
  - handles user accounts
  - processes secure payments
  - 
- Banking
  - ensures robust security
  - manages complex transactions
  - 
- Healthcare
  - manages patient records securely
  - enhances operational efficiency
  - 
- Soc Med
  - handles millions of users simultaneously
  - ensures seamless user experience
 
# Spring Benefits
- Develops robust enterprise applications
- Enables rapid web development with Spring Boot
- Sets up quickly
- integrates with Spring MVC
- Secure Restful APIs with Spring Security
- creates reliable microservices with Spring Bot

# Spring Concepts
 Applications are programs built using the Spring Framework. They comprise various components such as 
 Beans, Services, and Configurations. 


 Beans are objects managed by the Spring Inversion of Control, or IoC, container. They are fundamental to a Spring application and form the core components that provide functionality in a Spring application. Simply put, a Bean is like a piece of furniture in a house. Each item, such as a sofa or table, contributes to the house's functionality, just like a Bean serves a specific purpose to the program.

 The application context is the central component of the Spring Framework. It manages the Beans and their dependencies throughout the application's lifecycle. It is like a manual or ready reckoner that provides the instructions for creating and managing the various Beans that make up the application. It ensures that all necessary components are available when required.

 Configuration involves the setup and management of Spring components. It can be executed through XML files, Java annotations, or Java-based classes. The configuration is like a building's blueprint, which outlines how each room or bean should be constructed and maintained within the structure. Annotations simplify configuration by serving as metadata. They provide key information about how Beans should be managed. 

 Annotations simplify configuration by serving as metadata. They provide key information about how Beans should be managed. 
For example, the @component annotation marks a class as a Spring Bean. Annotations act like labels on a product, providing important details about its contents, without needing separate documentation.

Dependencies refer to objects that other objects require to function properly. They enable objects to work together effectively within an application. For instance, cars require engines to run, which implies that the engine is a dependency for the car. 

Inversion of Control, or IoC, is a key principle that transfers the responsibility of creating and managing dependencies from the application code to the Spring framework. Rather than manually creating objects, such as an engine for a car, Spring provides the necessary components when initializing beans. 
This process is akin to ordering food at a restaurant. The chef prepares the meal for you, thereby creating and managing the dependency on your behalf.

Dependency Injection, or DI, is a technique that allows dependencies to be injected into objects at runtime. Spring automatically provides dependencies instead of allowing an object to create them. For example, if a car needs an engine to operate, Spring injects this engine into the car when the car Bean is initialized.

Autowiring is a Spring feature that automatically injects the necessary dependencies into Beans without explicitly defining them in the configuration. Spring uses reflection to match the correct beans based on their type or name. Autowiring can be compared to an automatic coffee machine, which brews coffee with little manual intervention. It eliminates manual defining and wiring dependencies.

Components are classes directly managed by the IoC container. They are annotated using @component and can be automatically registered as beans within the Spring container. Components can be services, repositories, or any other application part. They are similar to departments within an organization, each responsible for specific functions, working together to ensure the smooth operation of the application.

Aspect-Oriented Programming, or AOP, is a programming paradigm that works alongside Object-Oriented Programming. 
It improves application maintainability by isolating concerns relevant across multiple parts of the application, such as logging, security, and transaction management. AOP can be compared to adding layers to a cake, where each layer represents a different aspect, such as flavor or decoration, contributing to the overall structure without altering its core.

# Annotations
explore common Spring Annotations:

@Component declares a class as a Spring-managed Bean, allowing it to be automatically registered in the Inversion of Control, or IOC, container. In this example, BookService is marked with @Component, making it available for dependency injection in the application. 
```java
import org.springframework.stereotype.Component;

@Component //<-- Marks BookService class and Makes it available for dependency injection
public class BookService {
    public void listBooks() {
        System.out.println("Listing all books");
    }
}
```


@Controller marks a class as a WebController in a Model-ViewController, or MVC, application, allowing it to handle Hypertext Transfer Protocol, or HTTP, requests. In this example, BookController is annotated with @Controller, making it responsible for processing requests and returning the appropriate view. 
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //<-- Marks BookControoller class and Making it responsible for processing requests and returning appropriate view
public class BookController {

    @GetMapping("/books")
    public void showBooks() {
        return "books"; // returns the view name "books"
    }
}

```


@Autowired enables automatic dependency injection, allowing the Spring container to resolve and inject dependencies without explicit configuration. In this example, BookService is injected into BookController, enabling it to call methods from BookService. 
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class BookController {

    @Autowired //<-- Marks BookService class variable field and Enabling BookService to call methods.
    private BookService bookService;

    public void displayBooks() {
        bookService.listBooks();
    }
}

```

@Configuration marks a class as a source of Bean definitions for the application context, allowing Spring to manage and instantiate Beans. For instance, AppConfig defines a BookService Bean created and managed by Spring. 
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //<-- Marks AppConfig class and Defines a bean
public class AppConfig {

    @Bean
    public BookService bookService() {
        return new BookService();
    }
}

```

@Bean is an annotation used inside a @Configuration class to define a method that returns an object managed by the Spring container. For instance, the BookService method creates and registers a BookService Bean in the application context. 
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean //<-- Marks BookService method and creates and registers a BookService Bean
    public BookService bookService() {
        return new BookService();
    }
}

```

@RequestMapping maps HTTP requests to specific methods or classes in an MVC application. For instance, @RequestMapping maps requests to the endpoint. 
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @RequestMapping("/books") //<-- Marks getBooks method and it maps request to the endpoint
    public String getBooks() {
        return "books";
    }
}

```

@PathVariable extracts values from a Uniform Resource Identifier, or URI path, and binds them to method parameters. For instance, @PathVariable is used to retrieve the book ID. 
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/books{id}")
    public String getBookById(@PathVariable("id") String bookId) { //<-- Marks boookId method parameter string and use it to retrieve the book id into the uri path above
        System.out.println("Book ID:" + bookId)
        return "bookDetails";
    }
}

```

@RestController combines @Controller and @ResponseBody, making it suitable for building RESTful web services. In this example, BookRestController returns JSON responses for API requests. 
```java
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController //<-- Marks the BookRestController class and Returns JSON responses
public class BookRestController {

    @GetMapping("/api/books")
    public List<String> getAllBooks() { 
        return Arrays.asList("Spring Boot", Spring Cloud");
    }
}

```

@RequestParam extracts query parameters from an HTTP request and binds them to method parameters. In this example, @RequestParam retrieves the book title from the URL query parameter. 
```java
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BookRestController {

    @GetMapping("/api/books") 
    public String getBookByTitle(@RequestParam("title") String title) { //<-- Marks the getBookByTitle method and retrieves titles from the URL query parameter
        return Arrays.asList("Spring Boot", Spring Cloud");
    }
}

```


@ResponseBody tells Spring to write the method's return value directly to the HTTP response body instead of resolving it as a view. In this example, @ResponseBody ensures that the getMessage method returns a raw string response. 
```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {

    @GetMapping("/api/books") 
    public String getBookByTitle(@RequestParam("title") String title) { //<-- No Marking of @ResponseBody at getBookByTitle method and ensures that the method returns a raw string response.
        return Arrays.asList("Spring Boot", Spring Cloud");
    }
}

```


@Value injects values from property files, system environment variables, or default values into Spring-managed Beans. In this example, @Value assigns a property value to the LibraryName field. 
```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Library {

    @Value("${library.name}") //<-- Marks libraryName class variable field and it assigns a property value.
    private String libraryName;
 
    public void printLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
}

```


@Scope defines the lifecycle and visibility of a Bean, such as Singleton or Prototype Scope. In this example, @Scope ensures that a new instance of Book is created each time requested. 
```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") //<-- Marks Book class and it ensures new isntance on request.
public class Book {

  // Bean definition for a prototype scope.

}
```

Annotations in the Spring framework are categorized based on their 
1.) purpose and 2.) placement within the code. 

_Class-level annotations_, like @Component, @Service, @Repository, and @Controller are placed above the class declaration to define it as a Spring-managed Bean. 
```java
@Service
public class BookService {
    // Class code
    
}
```
They help Spring identify and register the class for dependency injection and other framework functionalities. 

_Method-level annotations_, such as @Bean, @RequestMapping, and @getMapping are placed above method declarations to configure their behavior. These annotations tell Spring how the method should be executed, such as 
* defining routes in a web application or
* managing transactions.
```java
@GetMapping("/books")
public List<String> getBooks() {
    // Method code
}
```

_Field-level_ annotations like @Autowired, @Value, and @Qualifier are placed directly above fields to inject dependencies or values. This allows Spring to automatically provide the required objects or external property values without manual instantiation. 
```java
@Autowired
private BookRepository bookRepository;

@Value("${library.name}")
private String libraryName;
```

Annotations like @Autowired and @Qualifier can be placed on constructors and parameters to ensure the correct dependencies are injected. This is particularly useful for enforcing dependency injections in classes with multiple dependencies. 
```java
public class Library {
    private final BookService bookService;

    @Autowired
    public Library(@Qualifier("specificBookService") BookService bookService) {
        this.bookService = bookService
    }
}
```

annotations are classification labels that provide metadata to the Spring framework. They help automate tasks such as Bean creation, request handling, and dependency injection. 

Recap:
@Component declares a class as a Spring-managed bean. 
@Controller defines a web controller in an MVC app. 
@Rest-Controller combines @Controller and @ResponseBody, allowing controllers to return data directly. 
@Bean registers a method's return as a Spring bean. 
@Configuration defines a class for Spring configurations. 
@RequestMapping maps HTTP requests to methods or classes. 
@GetMapping maps HTTP GET requests to a specific method. 
@Autowired enables automatic dependency injection. 
@Qualifier specifies which bean to inject when multiple exist. 
@Value injects values from properties or environment variables. 
@Scope sets a bean's lifecycle and scope. 
@PathVariable extracts values from a URI path. 
@RequestParam retrieves query parameters from a request. 
@ResponseBody ensures that a method's return is sent as the response body. 


Annotations in Spring are classified into 
1. class level,
2. method level,
3. field level, and
4. constructor and parameter level categories.

# Maven
Maven is a powerful project management and comprehension tool used mainly for Java projects. It provides a framework to automate the software build process, helping developers manage dependencies, compile code, run tests, and package applications. 

The key aspects of Maven are its 
1. Project Object Model (POM) file,  - The pom.xml file is the most critical component of a Maven project. It contains information on the configuration details used by Maven to build the project, project building process, its dependencies, and various build processes. 
2. dependencies,  - Projects depend on external libraries to work properly. In Maven, the external libraries are declared in the POM file and it automatically downloads from the central repository. For example, in the POM file file, a dependency has been added for Spring Boot. 
3. repositories,  - Repositories are the locations where Maven stores library files. While Maven Central is the default repository, you can configure additional repositories if needed. 
4. build life cycle,   - The Maven build lifecycle consists of several phases such as validate, compile, test, package, verify, install, and deploy. For example, running mvn install will go through all phases up till install. 
5. and Plug-ins.  - You can use Maven plugins to compile code or generate documentation. Plugin information can be specified in the POM file.


Next, let's explore the components of a pom.xml file. The key fields in the pom.xml file include: 
1. project element, - It is the root element of the pom file. It defines the XML namespace and schema location.
2. model version,  - specifies the version of the pom model you are using and is usually set to 4.0.0.
3. group ID,  - represents the group or organization that the project belongs to and is usually structured like a domain name. 
4. artifact ID,  - is the unique name of the project or module. It often resembles the project's name.
5. version,  - defines the current edition of the project. For example, 1.0-SNAPSHOT. The SNAPSHOT suffix indicates that the version is still under development. 
6. packaging,  - determines the package type to be created by Maven, such as JAR, WAR, etc. If the package type is not specified, the value defaults to JAR.
7. dependencies,  - section lists all external libraries that your project uses. Each dependency is defined with a dependency tag containing the group ID, artifact ID, version, and scope.
8. build,  - build field contains information about the build process, including information on plugins and execution goals.
9. repositories,  - repository field lists the additional repositories where Maven should look for dependencies if they are not found in the default Maven Central Repository.
10. properties,  - Properties field allows you to define custom variables that can be used in the POM file, such as setting a project-wide Java version. 
11. and profiles.  - Profiles field allows you to define different configurations for different environments, such as development or production


# Defining Spring Project:


