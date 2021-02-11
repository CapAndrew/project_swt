package ru.swt.bugify.tests;

import org.testng.annotations.Test;
import ru.swt.bugify.model.Issue;

import java.io.IOException;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class BugifyTests extends TestBase {

	@Test
	public void testCreateIssue() throws IOException {
		skipIfNotFixed(1);
		Set<Issue> oldIssues = app.rest().getIssues();
		Issue newIssue = new Issue().withSubject("Issue 11022021").withDescription("Test description 11022021");
		int issueId = app.rest().createIssue(newIssue);
		Issue issue = app.rest().getIssueById(issueId);
		Set<Issue> newIssues = app.rest().getIssues();
		oldIssues.add(newIssue.withId(issueId).withStatus(issue.getState_name()));
		assertEquals(newIssues, oldIssues);
	}

	@Test
	public void testIssueStatus() throws IOException {
		Issue issue = app.rest().getIssueById(701);

		System.out.println(isIssueOpen(701));
		System.out.println(issue);
	}
}
