package nubank.cosmo.solid.dip.di.injectdependencies.swapoutprodandtest;

public class Checkout {

    private PaymentService paymentService;

    public Checkout(PaymentService paymentService) { // inject any class that implements PaymentService
        this.paymentService = paymentService;
    }

    public void process(double amount) {
        paymentService.pay(amount);
    }
}