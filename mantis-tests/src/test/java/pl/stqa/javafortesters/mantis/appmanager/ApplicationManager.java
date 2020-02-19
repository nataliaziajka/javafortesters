package pl.stqa.javafortesters.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private final Properties properties;
  WebDriver wd;

  private String browser;

  public ApplicationManager(String browser)  {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {

    String target = System.getProperty("target","local");
    properties.load(new FileReader(new File(String.format("src/test/resources/local.properties",target))));


    String browser = BrowserType.FIREFOX;
    if(Objects.equals(browser, BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    }
    else if(Objects.equals(browser, BrowserType.CHROME)){
      wd = new ChromeDriver();
    }
    else if(Objects.equals(browser, BrowserType.IE)){
      wd = new InternetExplorerDriver();
    }
    wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));
  }

  public void stop() {
    wd.quit();
  }

}

