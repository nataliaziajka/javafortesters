package pl.stqa.javafortesters.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.stqa.javafortesters.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }
  public void gotoContactGroupPage() {
    click(By.linkText("add new"));
  }
  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("middlename"),contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"),contactData.getNickname());
    type(By.name("title"),contactData.getTitle());
    type(By.name("company"),contactData.getComapany());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getHomeaddress());
    type(By.name("mobile"),contactData.getMobilephone());
    type(By.name("work"),contactData.getWorkaddress());
    type(By.name("fax"),contactData.getFax());
    type(By.name("email"),contactData.getEmail());
    type(By.name("email2"),contactData.getSecondemail());
    type(By.name("email3"),contactData.getThirdemail());
    type(By.name("homepage"),contactData.getHomepage());
  }

}
