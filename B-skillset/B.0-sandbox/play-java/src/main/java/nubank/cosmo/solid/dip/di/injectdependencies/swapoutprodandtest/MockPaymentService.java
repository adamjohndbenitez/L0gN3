package nubank.cosmo.solid.dip.di.injectdependencies.swapoutprodandtest;

public class MockPaymentService implements PaymentService {

    public void pay(double amount) {
        System.out.println("Mock pay $" + amount);
    }
}
