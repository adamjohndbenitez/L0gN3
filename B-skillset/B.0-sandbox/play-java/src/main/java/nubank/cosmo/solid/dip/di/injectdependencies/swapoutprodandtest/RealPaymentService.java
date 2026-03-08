package nubank.cosmo.solid.dip.di.injectdependencies.swapoutprodandtest;

public class RealPaymentService implements PaymentService {

    public void pay(double amount) {
        System.out.println("Paid $" + amount);
    }
}
