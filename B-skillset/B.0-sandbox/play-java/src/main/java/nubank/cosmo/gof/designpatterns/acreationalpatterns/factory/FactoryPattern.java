package nubank.cosmo.gof.designpatterns.acreationalpatterns.factory;

/**
 *
 * The Factory pattern lets you create objects without specifying the exact class.
 * The Factory pattern helps you decide with object to create at runtime, based on a condition.
 *
 */
public class FactoryPattern {
    public static void main(String[] args) {
        // Usage:
        Animal myPet = AnimalFactory.createAnimal("dog");
        myPet.speak();
    }
}
