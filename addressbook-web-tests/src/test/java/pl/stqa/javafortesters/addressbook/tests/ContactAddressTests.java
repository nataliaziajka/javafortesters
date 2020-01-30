package pl.stqa.javafortesters.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.javafortesters.addressbook.model.ContactData;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static pl.stqa.javafortesters.addressbook.tests.ContactPhoneTests.cleaned;

public class ContactAddressTests extends TestBase {


  @Test
  public void testContactAddress() {
    app.goTo().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(cleaned(contact.getAddress()), equalTo(contactInfoFromEditForm.getAddress()));

  }
}

