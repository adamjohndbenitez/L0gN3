package nubank.cosmo.gof.designpatterns.bstructuralpatterns.adapter.antipattern;

import nubank.cosmo.gof.designpatterns.bstructuralpatterns.adapter.Printable;

public class AntiAdapterPattern {
    public static void main(String[] args) {
        // (4) This is the incompatible interfaces' problem:
        OldPrinter legacy = new OldPrinter();
        // [Uncomment to see]
//        printDocument(legacy, "Hello!"); // (5) This won't compile! ERROR: Required type: Printable Provided: OldPrinter [Uncomment to see]

        // ^ The Adapter pattern solves this by wrapping 0ldPrinter in a PrinterAdapter that implements Printable , so you can use it where a Printable is required.

        // (6) Same error even you create a separate object for PrintDocument
        PrintDocument printDocument = new PrintDocument();

        // [Uncomment to see]
//        printDocument.printDocument(legacy, "Hello!"); // (7) This won't compile! ERROR: Required type: Printable Provided: OldPrinter [Uncomment to see]
    }

    // (1) Let's say you have a method that expects a Printable object:
    public static void printDocument(Printable printer, String text) { // (3) I can not pass OldPrinter directly to printDocument because their interfaces don't match.
        printer.print(text);
    }
}
