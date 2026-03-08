package nubank.cosmo.solid.dip.follows;

public class Switch {

    private Switchable switchable; // Now, Switch depends on the Switchable interface, not a concrete class. You can swap in any device that implements Switchable - perfect for testing and flexibility!

    public Switch(Switchable switchable) {
        this.switchable = switchable;
    }

    public void operate() {
        switchable.turnOn();
    }
}
