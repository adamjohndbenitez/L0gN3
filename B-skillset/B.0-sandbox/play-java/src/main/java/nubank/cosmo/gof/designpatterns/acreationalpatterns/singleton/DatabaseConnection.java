package nubank.cosmo.gof.designpatterns.acreationalpatterns.singleton;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    private DatabaseConnection() {} // Notice how the . constructor is private, so you can't create a new instances directly. You always use `getInstance()` to get the single shared objeect.

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to database!");
    }
}
