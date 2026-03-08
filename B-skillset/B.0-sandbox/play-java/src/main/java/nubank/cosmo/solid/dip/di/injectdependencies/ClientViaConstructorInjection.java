package nubank.cosmo.solid.dip.di.injectdependencies;

public class ClientViaConstructorInjection {

    private Service service;

    public ClientViaConstructorInjection(Service service) { // Inject interface, not concrete class.
        this.service = service; // Injected via constructor.
    }
}
