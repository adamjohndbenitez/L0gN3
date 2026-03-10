package nubank.cosmo.gof.designpatterns.bstructuralpatterns.adapter.antipattern;

public class OldPrinter {

    // (2) But you only have an OldPrinter object, which doesn't implement Printable - it only has priintOld(String msg
    public void printOld(String msg) {
        System.out.println("Old printer: " + msg);
    }
}
