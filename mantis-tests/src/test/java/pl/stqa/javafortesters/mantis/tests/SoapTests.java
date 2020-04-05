package pl.stqa.javafortesters.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.javafortesters.mantis.model.Issue;
import pl.stqa.javafortesters.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

public class SoapTests extends TestBase {

  @BeforeMethod

  public void ensurePreconditions() throws RemoteException, ServiceException, MalformedURLException {

//    Set<Issue> issues = app.soap().getIssues( "administrator", "root" );
    Set<Issue> issues = app.soap().getIssuesReportedBy("natalia123", "natalia123");
    for (Issue issue : issues) {
      skipIfNotFixed(issue.getId());
    }
  }

  @Test
  public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {

    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for (Project project : projects) {
      System.out.println(project.getName());
    }
  }

  @Test

  public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
    Set<Project> projects = app.soap().getProjects();
    Issue issue = new Issue().withSummary("Test issue")
            .withDescription("Test issue description").withProject(projects.iterator().next());
    Issue created = app.soap().addIssue(issue);
    Assert.assertEquals(issue.getSummary(), created.getSummary());
  }
}

