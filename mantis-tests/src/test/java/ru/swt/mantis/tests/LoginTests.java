package ru.swt.mantis.tests;

import org.testng.annotations.Test;
import ru.swt.mantis.appmanager.HttpSession;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertTrue;

public class LoginTests extends TestBase{

	@Test
	public void testLogin() throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
		HttpSession session = app.newSession();
		assertTrue(session.login("administrator", "root"));
		assertTrue(session.isLoggedInAs("administrator"));
	}
}
