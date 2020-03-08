package pl.stqa.javafortesters.mantis.tests;

import org.testng.annotations.Test;
import pl.stqa.javafortesters.mantis.appmanager.HttpSession;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTest
        extends TestBase{

@Test
public void testLogin() throws IOException{
  HttpSession session = app.newSession();
  assertTrue(session.login("administrator", "root"));
  assertTrue(session.isLoggedInAs("administrator"));
}}
