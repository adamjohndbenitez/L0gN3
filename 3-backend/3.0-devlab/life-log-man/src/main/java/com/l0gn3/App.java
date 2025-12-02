package com.l0gn3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class that initializes Spring application
 * Retrieves bean calls its method that displays output.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // check if setup is functioning well.
        System.out.println( "Hello World!" );

        // Load XML-based configuration
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloWorldXml = (HelloWorld) xmlContext.getBean("helloWorld");
        helloWorldXml.printMessage();  // Output: Message: Hello, World from XML!
    }
}
