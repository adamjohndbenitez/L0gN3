package nubank.cosmo.solid.dip.di;

public class EmailService implements MessageService {

    public void sendMessage(String message) {
        System.out.println("Email: " + message);
    }
}
