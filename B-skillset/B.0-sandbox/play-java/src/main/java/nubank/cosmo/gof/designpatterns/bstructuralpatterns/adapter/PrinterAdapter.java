package nubank.cosmo.gof.designpatterns.bstructuralpatterns.adapter;

public class PrinterAdapter implements Printable {

    private OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    public void print(String text) {
        oldPrinter.printOld(text);
    }
}
