package nubank.cosmo.solid.dip.di;

/**
 *
 * DI is one way to achieve DIP in your code, but DIP is the broader principle.
 *
 *  - Dependency Inversion Principle (DIP) is a design principle: it says high-level modules should depend on abstractions, not concrete implementations.
 *  - Dependency Injection (DI) is a technique or pattern: it's a way to provide those abstractions to your classes, usually by passing them in (via constructor, method, or property).
 *
 *  So, Dependency Inversion and Dependency Injection are related but not the same.
 *
 */
public class DependencyInjection {

    public static void main(String[] args) {
        // Usage:
        MessageService email = new EmailService(); // Here, Notification doesn't create the EmailService itself, Instead, the service is injected from outside, making it easy to swap implementations or mock for testing.
        Notification notification = new Notification(email);
        notification.notifyUser("Hello");
    }
}
