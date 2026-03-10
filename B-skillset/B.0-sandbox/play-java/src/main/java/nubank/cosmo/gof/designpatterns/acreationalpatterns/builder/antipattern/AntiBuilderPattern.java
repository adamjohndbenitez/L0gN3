package nubank.cosmo.gof.designpatterns.acreationalpatterns.builder.antipattern;

/**
 *
 * The Builder pattern helps avoid constructors with too many parameters, which can be confusing and error-prone. Here's an example of an "anti-pattern"-a constructor with lots of parameters, making it hard to read and maintain:
 *
 */
public class AntiBuilderPattern {
    public static void main(String[] args) {
        // Usage:
        Pizza pizza = new Pizza("Thin crust", "tomato", "cheese"); // If you add more options, the constructor gets longer and harder to use. It's easy to mix up parameters or forget what each one means. The Builder pattern solves this by letting you set only what you need, with clear method names, and avoids unnecessary dependencies between parameters.
    }
}
