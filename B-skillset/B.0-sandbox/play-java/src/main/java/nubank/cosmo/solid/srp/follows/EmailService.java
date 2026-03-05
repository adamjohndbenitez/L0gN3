package nubank.cosmo.solid.srp.follows;

public class EmailService {
    public void sendWelcomeEmail(User user) {
        System.out.println("Sending Welcome to " + user.getName() + " at his email " + user.getEmail());
    }
}
