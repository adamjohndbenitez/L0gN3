package nubank.cosmo.solid.dip.di.injectdependencies.swapoutprodandtest;

/**
 *
 * Injecting interfaces (abstractions) allows you to swap out different implementations without changing your main code. This is powerful for flexibility and testing.
 *
 * Why?
 * - You can use a real implementation in production.
 * - For testing, you can inject a mock or fake implementation to simulate behavior without relying on real systems.
 *
 */
public class InjectingInterfacesAbstractions {

    public static void main(String[] args) {
        // In production:
        Checkout checkout = new Checkout(new RealPaymentService()); // inject any class that implements PaymentService
        checkout.process(100);

        // In testing:
        Checkout testCheckout = new Checkout(new MockPaymentService());
        testCheckout.process(100);
    }
}
