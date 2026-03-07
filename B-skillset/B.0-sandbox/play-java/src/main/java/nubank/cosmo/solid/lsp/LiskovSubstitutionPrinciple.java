package nubank.cosmo.solid.lsp;

import nubank.cosmo.solid.lsp.violates.ostrichbirdproblem.Bird;
import nubank.cosmo.solid.lsp.violates.ostrichbirdproblem.Ostrich;
import nubank.cosmo.solid.lsp.violates.ostrichbirdproblem.Sparrow;
import nubank.cosmo.solid.lsp.violates.rectanglesquareproblem.Rectangle;
import nubank.cosmo.solid.lsp.violates.rectanglesquareproblem.Square;


/**
 *
 * Liskov Substitution Principle (LSP) comes in. This principle states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program. The child class must honor the parent's contract.
 * A classic example of a violation is the Rectangle/Square problem. If a Square inherits from Rectangle , it must behave like a Rectangle in every situation. Just as LSP ensures Our class hierarchies are sound, our next principle helps us design better contracts for those classes.
 *
 */
public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {

        // <<== Rectangle/Square Problem ==>>
        // Violates: If you use a Square where a Rectangle is expected
        nubank.cosmo.solid.lsp.violates.rectanglesquareproblem.Rectangle rectangle = new nubank.cosmo.solid.lsp.violates.rectanglesquareproblem.Square();
        rectangle.setWidth(5);
        rectangle.setHeight(10);
        System.out.println("Rectangle area: " + rectangle.getArea());
        // Why bad? The Square class changes the behavior of setWidth and setHeight , so it doesn't act like a true Rectangle . This breaks the "substitution" rule of LSP.

        // Follows: Now, both Rectangle and Square are independent and follow their own logic, but both can be used wherever a Shape is expected. This respects LSP!
        nubank.cosmo.solid.lsp.follows.rectanglesquareproblem.Shape rectangle0 = new nubank.cosmo.solid.lsp.follows.rectanglesquareproblem.Rectangle(7, 10);
//        rectangle0.setWidth(5); // IntelliJ's static code analysis \ Compiler error: Cannot resolve method 'setWidth' in 'Shape', then red on setWidth and setHeight,
//        rectangle0.setHeight(10);
        // ^ Why red on setWidth and setHeight, even though we have a methods in Rectangle
        // ^ actually pure Java polymorphism behavior, The reference type is Shape. That means the compiler only allows you to call methods that exist in the Shape interface. Your Shape interface only defines: `public interface Shape { int getArea(); }` So from the compiler's perspective, a Shape only has: getArea() And It does not know about: `setWidth()` & `setHeight()`
        /*
        rectangle0.getArea();   ✅ allowed
        rectangle0.setWidth();  ❌ not visible
        rectangle0.setHeight(); ❌ not visible
        ✅ [Takeaway] Java method access is determined by: REFERENCE TYPE not OBJECT TYPE
        Shape s = new Rectangle(); // Accessible methods: only Shape methods
        Rectangle r = new Rectangle(); // Rectangle + Shape methods
        ℹ️ [Quick mental model]
        interface = contract
        reference = contract you can see
        object = real implementation
        🔧 [Fix] Create a rectangle constructor to pass the width & height, [opt2] is to correct type to Rectangle but in here we demo Liskov Substitution Principle that states - "A subtype must be substitutable for its base type without breaking behavior." [opt3] casting (not recommended usually) But this defeats the purpose of abstraction.
        */
        System.out.println("Rectangle area: " + rectangle0.getArea());

        nubank.cosmo.solid.lsp.follows.rectanglesquareproblem.Shape square = new nubank.cosmo.solid.lsp.follows.rectanglesquareproblem.Square(4);
//        square.setWidth(5);
//        square.setHeight(10);
        System.out.println("Square area: " + square.getArea());

        // <<== Ostrich/Bird Problem ==>>
        // Violates: if you substitute an Ostrich for a bird.
        Bird bird = new Ostrich();
        bird.fly(); // Here, 0strich is a subclass of Bird , but it can't actually fly. If you substitute an 0strich where a Bird is expected, the program breaks. This violates LSP because the subclass doesn't honor the contract of the parent class.

        // Follows: Now, you can substitute any subclass where a Bird is expected.
        nubank.cosmo.solid.lsp.follows.ostrichbirdproblem.Bird bird0 = new nubank.cosmo.solid.lsp.follows.ostrichbirdproblem.Sparrow();
        bird0.makeSound(); // Output: Tweet!
        bird0 = new nubank.cosmo.solid.lsp.follows.ostrichbirdproblem.Parrot();
        bird0.makeSound(); // Output: Squawk!

    }
}
