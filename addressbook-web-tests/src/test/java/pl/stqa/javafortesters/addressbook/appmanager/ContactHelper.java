package pl.stqa.javafortesters.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.javafortesters.addressbook.model.ContactData;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase{

  private boolean acceptNextAlert;

  public ContactHelper(WebDriver wd) {

    super(wd);
  }
  public void gotoContactGroupPage() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
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

    if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getContact());
    }else{
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  public void selectContact() {

    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
    acceptNextAlert = true;
  }
  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));

  }

  public void closeAlert() {
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
  }
  private String closeAlertAndGetItsText() {
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  public void submitContactCreation() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
    }
  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public void returnToHomePage() {
      click(By.linkText("home"));
    }

  public void createContact(ContactData contact) {
    fillContactForm(contact, true);
    submitContactCreation();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[1]/td/input"));
  }
}



