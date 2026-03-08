package nubank.cosmo.solid.isp;

import nubank.cosmo.solid.isp.violates.HumanWorker;
import nubank.cosmo.solid.isp.violates.RobotWorker;

/**
 *
 * The 'I' in SOLID stands for the Interface Segregation Principle (ISP). It advises that clients should not be forced to depend on interfaces they do not use.
 * It's better to have many small, specific interfaces than one big, general-purpose one.
 * For example, instead of a giant Worker interface, you could have smaller Workable and Eatable interfaces. Clients can then implement only what they need. Creating lean interfaces is a great start, but the final principle changes how our modules connect to them.
 *
 */
public class InterfaceSegregationPrinciple {

    public static void main(String[] args) {
        // Follows:
        nubank.cosmo.solid.isp.follows.HumanWorker humanWorker0 = new nubank.cosmo.solid.isp.follows.HumanWorker();
        humanWorker0.work();
        humanWorker0.eat();
        nubank.cosmo.solid.isp.follows.RobotWorker robotWorker0 = new nubank.cosmo.solid.isp.follows.RobotWorker();
        robotWorker0.work();

        // Violates:
        nubank.cosmo.solid.isp.violates.HumanWorker humanWorker = new nubank.cosmo.solid.isp.violates.HumanWorker();
        humanWorker.work();
        humanWorker.eat();
        nubank.cosmo.solid.isp.violates.RobotWorker robotWorker = new nubank.cosmo.solid.isp.violates.RobotWorker();
        robotWorker.work();
        robotWorker.eat();
    }
}
