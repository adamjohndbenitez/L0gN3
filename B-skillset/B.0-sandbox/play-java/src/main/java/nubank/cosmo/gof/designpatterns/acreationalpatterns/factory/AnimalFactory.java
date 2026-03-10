package nubank.cosmo.gof.designpatterns.acreationalpatterns.factory;

public class AnimalFactory {

    public static Animal createAnimal(String type) {
        if (type.equals("dog")) {
            return new Dog();
        } else if (type.equals("cat")) {
            return new Cat();
        }
        return null;
    }
}
