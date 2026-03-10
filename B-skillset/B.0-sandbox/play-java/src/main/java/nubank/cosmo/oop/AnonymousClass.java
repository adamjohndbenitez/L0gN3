package nubank.cosmo.oop;

/**
 *
 * An "anonymous class" is a different concept-it's a class without a name, usually created for quick, one-off use (like passing a short implementation to a method).
 *
 */
public class AnonymousClass {

    static Runnable task = new Runnable() {
        @Override
        public void run() {
            System.out.println("Running in anonymous class!");
        }
    }; // Notice there's no class name-just new Runnable () { ... }.This is handy for simple, one-time behaviors.

    public static void main(String[] args) {
        task.run(); // Output: Running in anonymous class!
    }
}
