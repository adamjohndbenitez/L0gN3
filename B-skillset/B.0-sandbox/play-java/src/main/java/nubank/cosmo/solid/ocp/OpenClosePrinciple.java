package nubank.cosmo.solid.ocp;


import nubank.cosmo.solid.ocp.follows.Rectangle;
import nubank.cosmo.solid.ocp.violates.AreaCalculator;
import nubank.cosmo.solid.ocp.violates.Circle;

/**
 * the Open/Closed Principle (0CP). The principle states that software entities should be open for extension but closed for modification. The goal is to add new features without touching existing, working code. Think of a plugin system: new functionality can be added without ever changing the core application. That's OCP in action! This principle often relies on inheritance, which must be handled carefully.
 */
public class OpenClosePrinciple {
    public static void main(String[] args) {
        // violates OCP: must modify class to add new shapes
        nubank.cosmo.solid.ocp.violates.AreaCalculator areaCalculator0 = new nubank.cosmo.solid.ocp.violates.AreaCalculator();
        nubank.cosmo.solid.ocp.violates.Circle circle0 = new nubank.cosmo.solid.ocp.violates.Circle();
        circle0.setRadius(5.0);
        nubank.cosmo.solid.ocp.violates.Rectangle rectangle0 = new nubank.cosmo.solid.ocp.violates.Rectangle();
        rectangle0.setWidth(10.0);
        rectangle0.setHeight(10.0);
        double areaOfACircle = areaCalculator0.calculateArea(circle0);
        System.out.println("Area of circle: " + areaOfACircle);
        double areaOfARectangle = areaCalculator0.calculateArea(rectangle0);
        System.out.println("Area of a rectangle: " + areaOfARectangle);

        // follows OCP:  open for extension, closed for modification
        nubank.cosmo.solid.ocp.follows.AreaCalculator areaCalculator1 = new nubank.cosmo.solid.ocp.follows.AreaCalculator();
        nubank.cosmo.solid.ocp.follows.Circle circle1 = new nubank.cosmo.solid.ocp.follows.Circle(7);
        nubank.cosmo.solid.ocp.follows.Rectangle rectangle1 = new Rectangle(80, 80);
        System.out.println("Area of circle: " + areaCalculator1.calculateArea(circle1));
        System.out.println("Area of a rectangle: " + areaCalculator1.calculateArea(rectangle1));



    }
}
