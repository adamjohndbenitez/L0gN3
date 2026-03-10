package nubank.cosmo.gof.designpatterns.acreationalpatterns.builder;

public class Pizza {

    private String dough;
    private String sauce;
    private String topping;

    private Pizza(Builder builder) {}

    // With the Builder pattern, you can easily create different variations of a complex object without a constructor with tons of parameters.
    // In Java, a class defined inside another class is called an "inner class." When you see static before the inner class, it's calleda "static nested class." The Builder is static so it doesn't need a reference to the outer Pizza instance-it's just a helper to build Pizza objects. If it weren't static, youd need a Pizza object to create a Builder, which defeats the purpose!
    // This static Builder class is designed to help you build a Pizza object step-by-step, without needing an existing Pizza instance. This keeps things clean and avoids unnecessary dependencies.
    public static class Builder {
        private String dough;
        private String sauce;
        private String topping;

        public Builder setDough(String dough) {
            this.dough = dough;
            return this;
        }

        public Builder setSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder setTopping(String topping) {
            this.topping = topping;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
