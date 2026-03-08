package nubank.cosmo.solid.dip.di;

public class Notification {

    private MessageService messageService;

    // Dependency Injection via Constructor.
    public Notification(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyUser(String message) {
        messageService.sendMessage(message);
    }
}
