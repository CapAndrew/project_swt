package ru.swt.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.swt.mantis.appmanager.ApplicationManager;
import ru.swt.mantis.model.Issue;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestBase {

	protected static final ApplicationManager app
					= new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

	@BeforeSuite
	public void setUp() throws IOException {
		app.init();
		app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php","config_inc.php.back");
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws IOException {
		app.ftp().restore("config_inc.php.back","config_inc.php");
		app.stop();
	}

	boolean isIssueOpen(int issueId) throws RemoteException, ServiceException, MalformedURLException {
		Issue issue = app.soap().getIssueById(issueId);

		if (issue.getStatus().equals("closed")){
			return false;
		}
		else{
			return true;
		}
	}

	public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
		if (isIssueOpen(issueId)) {
			throw new SkipException("Ignored because of issue " + issueId);
		}
	}
}
