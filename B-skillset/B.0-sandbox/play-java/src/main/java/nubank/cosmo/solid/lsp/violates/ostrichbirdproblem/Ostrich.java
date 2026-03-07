package nubank.cosmo.solid.lsp.violates.ostrichbirdproblem;

public class Ostrich extends Bird {

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Actually, Ostriches cannot fly.");
    }
}
