package nubank.cosmo.solid.dip.di.injectdependencies;

public class ClientViaMethodInjection {

    private Service service;

    public void setService(Service service) {
        this.service = service; // Injected via method.
    }
}
