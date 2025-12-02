package com.l0gn3;

/**
 * a separate java class representing the bean.
 * just contains a method that performs basic operations, such as printing a message to the console.
 *
 */
public class HelloWorld {

    private String message;

    public void printMessage() {
        System.out.println("Message: " + message);
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void sayHello() {
        System.out.println("Hello, world!" );
    }
}
