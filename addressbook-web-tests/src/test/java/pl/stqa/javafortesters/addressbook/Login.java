package pl.stqa.javafortesters.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

  public WebDriver wd;
  public void login(String username, String password) {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }
}
