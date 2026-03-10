Structural patterns explain how to semble objects and classes into larger structures, while keeping these structures flexible and efficient. 

 * The __Adapter__ pattern helps two incompatible interfaces work together, 
 * while the __Decorator__ pattern adds new functionality to an object dynamically.
 * The __Facade__ pattern provides a simple, clean entry point to a complex system. 

What is the main alternative to using the Decorator pattern for adding functionality? Subclassing is the main alternative to the Decorator pattern. With subclassing, you create a new class that extends the original, adding or changing behavior. However, subclassing can lead to a rigid class hierarchy, while Decorator lets you add features flexibly at runtime.

### Subclassing -vs- Decorator Pattern

#### Subclassing:
```
class Coffee {
    public String getDescription() { return "Simple coffee"; }
}
class MilkCofee extends Coffee {
    @Override
    public String getDescription() { return super.getDescription() + ", milk"; }
}

// Usage:
Coffee coffee = new MilkCoffee();
System.out.println(coffee.
```
With __Subclassing__, you create a new class for each variation.

#### Decorator Pattern:
```
interface Coffee {
    String getDescription();
}
class SimpleCoffee implements Coffee {
    public String getDescription() { return "Simple coffee"; }
}
class MilkDecorator implements Coffee {
    private Coffee coffee;
    public MilkDecorator(Coffee coffee) { this.coffee = coffee; }
    public String getDescription() { return coffee.getDescription() + ", milk"; }
}

//Usage:
Coffee coffee = new SimpleCoffee();
coffee = new MilkDecorator(coffee);
System.out.println(coffee.getDescription()); // Output: Simple coffee, milk
```
With __Decorator__, you can add features dynamically at runtime by wrapping objects, making it more flexible!

"At runtime" means while your program is running, responding to user input. For example, if a usre selects "add milk" in a coffee ordering app, your code wraps the coffee object with a MilkDecorator.
"At runtime" does not mean changing the code or redeloying the server - you are just composing objects differently based on what's happening in real time.

#### Real-world analogy of "at runtime":
Imagine a coffee shop: when a customer orders, they can choose to add milk, sugar, or both. The barista doesn't know in advance what each customer will want-they add ingredients as the order comes in.
In code, the "base coffee" is your starting object. As the program runs, you "wrap" it with decorators (like MilkDecorator or SugarDecorator) depending on what the user selects. You're not changing the code or adding new classes while the server runs-you're just combining objects in different ways based on real-time choices.
```
// Step 1: Start with a plain coffee.
Coffee coffee = new SimpleCoffee();

// Step 2: User decides to add milk.
if (userWantsMilk) {
    coffee = new MilkDecorator(coffee);
}

// Step 3: User then adds sugar.
if (userWantsMilk) {
    coffee = new SugarDecorator(coffee);
}

// Step 4: User both decides to add milk and sugar.
System.out.println(coffee.getDescription()); // Simple coffee, milk, sugar 
```
Each time you wrap the coffee object with a new decorator, you add a feature. This happens while the program is running, based on user choices or other conditions-not by changing the code or restarting the server.
In other words, the MilkDecorator class (and any other decorators) are written and compiled before the app runs. You aren't creating new classes while the app is running. Instead, at runtime, the user's choice or decision which decorators to use or applied to the coffee object and how to combine them based on user actions or program logic.
So, all the decorator classes exist in your code ahead of time. When the app is running, you "wrap" objects with these decorators as needed-you're just creating new object combinations, not new classes.
That's the power of the Decorator pattern. By letting users (or program logic) decide which decorators to apply while the app is running, you give your program flexibility to add features on demand. This is much more adaptable than hardcoding every possible combination with subclasses. The decorators themselves are written ahead of time, but how they're used is decided at runtime, based on real needs or user input.
