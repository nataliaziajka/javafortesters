package pl.stqa.javafortesters.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pl.stqa.javafortesters.addressbook.appmanager.ApplicationManager;
import pl.stqa.javafortesters.addressbook.model.GroupData;
import pl.stqa.javafortesters.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static afu.org.checkerframework.checker.units.UnitsTools.g;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestBase {
  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }
  @BeforeMethod
  public void logTestStart(Method m){
    logger.info("Start test" + m.getName());
  }
  @BeforeMethod(alwaysRun = true)
  public void logTestStop(Method m, Object[] p){
    logger.info("Stop test"+ m.getName() + "with parameters" + Arrays.asList(p));
  }

  public void verifyGroupListInUI() {
    if(Boolean.getBoolean("verifyUI")){
    Groups dbGroups = app.db().groups();
    Groups uiGroups = app.group().all();
    assertThat(uiGroups, equalTo(dbGroups.stream()
            .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
            .collect(Collectors.toSet())));
                }}
  }

//BrowserType.FIREFOX