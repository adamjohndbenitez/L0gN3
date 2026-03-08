package nubank.cosmo.solid.isp.violates;

public class RobotWorker implements Worker {
    public void work() {
        System.out.println("Working...");
    }

    public void eat() {
        // Not applicable
        throw new UnsupportedOperationException("Robots don't eat!");
        // Here, RobotWorker is forced to implement eat(), even though it doesn't make sense. THis is a classic ISP violation.¡
    }
}
