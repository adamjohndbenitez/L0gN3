package nubank.cosmo.gof.designpatterns.acreationalpatterns.builder.antipattern;

/**
 *
 * The static Builder class is designed to help you build a Pizza object step-by-step, without needing an existing Pizza instance. This keeps things clean and avoids unnecessary dependencies.
 *
 */
public class Pizza {

    private String dough;
    private String sauce;
    private String topping;

    public Pizza(String dough, String sauce, String topping) {
        this.dough = dough;
        this.sauce = sauce;
        this.topping = topping;
    }

}
