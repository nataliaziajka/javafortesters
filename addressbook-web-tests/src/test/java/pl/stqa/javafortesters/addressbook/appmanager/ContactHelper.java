package pl.stqa.javafortesters.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pl.stqa.javafortesters.addressbook.model.ContactData;
import pl.stqa.javafortesters.addressbook.model.Contacts;
import pl.stqa.javafortesters.addressbook.model.GroupData;
import pl.stqa.javafortesters.addressbook.model.Groups;
import java.util.List;
import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase {

  private boolean acceptNextAlert;

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    attach(By.name("photo"),contactData.getPhoto());

  }

  public void selectContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
    acceptNextAlert = true;
  }
  public void selectContactById(int id) {
    click(By.cssSelector("input[value='"+id+ "']"));
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

  public void initContactModificationById(int id) {
    //click(By.xpath("//img[@alt='Edit']"));
    //--------------------------
//    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[values='%s']",id)));
//    WebElement row =checkbox.findElement(By.xpath("./../.."));
//    List<WebElement>cells = row.findElements(By.tagName("tag"));
//    cells.get(7).findElement(By.tagName("a")).click();
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
  }

  public void submitContactModification() {
    //click(By.xpath("//div[@id='content']/form/input[22]"));
    click(By.xpath("//img[@alt='Edit']"));
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

  public Contacts all() {
    Contacts contacts = new Contacts();

    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));

      String firstName = cells.get(1).getText();
      String lastName = cells.get(2).getText();
      String allPhones = cells.get(5).getText();

      ContactData contactData = new ContactData().withId(id).withFirstname(firstName)
              .withLastname(lastName).withAllPhones(allPhones);

        contacts.add(contactData);
    }
    return contacts;

  }
  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    closeAlert();
  }
  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModificationById(contact.getId());
    submitContactModification();
    returnToHomePage();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);

  }
  }






