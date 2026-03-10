package nubank.cosmo.gof.designpatterns.bstructuralpatterns.adapter;

/**
 *
 * The Adapter pattern lets you connect classes with incompatible interfaces by creating a wrapper that translates one interface to another. Here's a simple Java example: Suppose you have a legacy
 * 0ldPrinter class, but your code expects a Printable interface:
 *
 */
public class AdapterPattern {
    public static void main(String[] args) {
        OldPrinter legacy = new OldPrinter();
        Printable printer = new PrinterAdapter(legacy); // The Adapter ( PrinterAdapter ) lets you use 0ldPrinter wherever a Printable is needed, bridging the gap between interfaces.
        printer.print("This is legacy printer");
    }
}
