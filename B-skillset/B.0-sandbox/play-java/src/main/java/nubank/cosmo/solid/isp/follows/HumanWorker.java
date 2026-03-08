package nubank.cosmo.solid.isp.follows;

public class HumanWorker implements Workable, Eatable { // Now, HumanWorker implements both Workable and Eatable, while RobotWorker only implements Workable. Each class only depends on the interfaces it actually needs - this is ISP in action!

    public void work() {
        System.out.println("Working...");
    }

    public void eat() {
        System.out.println("Eating lunch");
    }
}
