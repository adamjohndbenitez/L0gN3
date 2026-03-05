package nubank.cosmo.solid.srp;


import nubank.cosmo.solid.srp.follows.EmailService;
import nubank.cosmo.solid.srp.violates.User;

/**
 * the Single Responsibility Principle (SRP). This one's simple but powerful: a class should have only one reason to change. If a class is juggling too many jobs, it can become fragile and hard to work with. For example, a User class should stick to user data. Logic for sending emails or generating reports belongs in its own dedicated class. Once your classes have clear, single responsibilities, the next step is to make them flexible for future changes.
 *
 */
public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        // violates:
        User user0 = new User();
        user0.setName("Zed");
        user0.setEmail("zed@mail.com");
        user0.sendWelcomeEmail();

        // follows:
        nubank.cosmo.solid.srp.follows.User user1 = new nubank.cosmo.solid.srp.follows.User();
        EmailService emailService = new EmailService();
        user1.setName("Leah");
        user1.setEmail("leah@mail.com");
        emailService.sendWelcomeEmail(user1);
    }
}
