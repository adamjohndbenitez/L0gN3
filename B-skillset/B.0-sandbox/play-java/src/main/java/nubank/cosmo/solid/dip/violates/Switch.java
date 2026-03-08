package nubank.cosmo.solid.dip.violates;

public class Switch {

    private LightBulb lightBulb; //Here, the Switch class directly depends on the concrete LightBulb class. If you want to use a different kind of bulb, you have to change the Switch code. This violates DIP because high-level modules (like Switch ) should depend on abstractions, not concrete details.

    public Switch(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
    }

    public void operate() {
        lightBulb.turnOn();
    }
}
