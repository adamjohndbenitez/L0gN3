package nubank.cosmo.solid.dip.follows;

public class LightBulb implements Switchable {

    public void turnOn() {
        System.out.println("LightBulb turning on");
    }

    public void turnOff() {
        System.out.println("LightBulb turning off");
    }
}
