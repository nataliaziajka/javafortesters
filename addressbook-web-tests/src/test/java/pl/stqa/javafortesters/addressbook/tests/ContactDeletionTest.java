package pl.stqa.javafortesters.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.javafortesters.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @Test(enabled = false)
  public void testContactDeletion() throws Exception {

    app.goTo().gotoHomePage();
    if(app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData().withFirstname("Natalia").withLastname("Ziajka"));
    }
    List<ContactData> before = app.getContactHelper().all();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeAlert();
    List<ContactData> after = app.getContactHelper().all();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }
  }

