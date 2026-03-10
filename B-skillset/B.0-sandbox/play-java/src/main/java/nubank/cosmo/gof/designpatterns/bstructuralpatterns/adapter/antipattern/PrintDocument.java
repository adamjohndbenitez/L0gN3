package nubank.cosmo.gof.designpatterns.bstructuralpatterns.adapter.antipattern;

import nubank.cosmo.gof.designpatterns.bstructuralpatterns.adapter.Printable;

public class PrintDocument {

    // (1) Let's say you have a method that expects a Printable object:
    public void printDocument(Printable printer, String text) { // (3) I can not pass OldPrinter directly to printDocument because their interfaces don't match.
        printer.print(text);

    }
}
