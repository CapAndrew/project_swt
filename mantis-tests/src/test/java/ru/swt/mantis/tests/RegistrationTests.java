package ru.swt.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.swt.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RegistrationTests extends TestBase {

	@BeforeMethod
	public void startMailServer() {
		app.mail().start();
	}

	@Test
	public void testRegistration() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException, MessagingException {
		long now = System.currentTimeMillis();
		String user = String.format("user%s", now);
		String password = "password";
		String email = String.format("user%s@localhost.localdomain", now);
		//app.james().createUser(user, password);
		app.registration().start(user, email);
		List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
		//List<MailMessage> mailMessages = app.james().waitForMail(user, password, 60000);
		String confirmationLink = findConfirmationLink(mailMessages, email);
		app.registration().finish(confirmationLink, password);
		assertTrue(app.newSession().login(user, password));
	}

	private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
		MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
		VerbalExpression regex = VerbalExpression.regex().find("https://").nonSpace().oneOrMore().build();
		return regex.getText(mailMessage.text);
	}

	@AfterMethod(alwaysRun = true)
	public void stopMailServer() {
		app.mail().stop();
	}
}
