package nubank.cosmo.solid.isp.violates;

public class HumanWorker implements Worker {

    public void work() {
        System.out.println("Working...");
    }

    public void eat() {
        System.out.println("Eating lunch");
    }
}
