package pl.stqa.javafortesters.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.javafortesters.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test(enabled = false)
  public void testContactModification() throws Exception {
    app.goTo().gotoHomePage();
    if(app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData().withFirstname("Natalia").withLastname("Ziajka"));
    }
    List<ContactData> before = app.getContactHelper().all();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Jan").withLastName("Kowalski");
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()-1);
    before.add(contact);
    Assert.assertEquals(before,after);
  }
  }

