package nubank.cosmo.gof.designpatterns.acreationalpatterns.singleton;

public class SingletonPattern {
    public static void main(String[] args) {
        DatabaseConnection db = DatabaseConnection.getInstance(); // No "new" since getInstance() is static
//        DatabaseConnection db1 = new DatabaseConnection(); // ERROR! compile - 'DatabaseConnection()' has private access in 'nubank.cosmo.gof.designpatterns.acreationalpatterns.singleton.DatabaseConnection'

        db.connect(); // Output: Connected to database!
    }
}
