package pl.stqa.javafortesters.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.javafortesters.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.getContactHelper().gotoContactGroupPage();
    List<ContactData> before = app.getContactHelper().all();
    //ContactData contact = new ContactData("Natalia", "Joanna", "Ziajka", "natalia-ziajka", "Quality Assurance Engineer", "ABC", "Warszawska 25, Kraków", "Klimeckiego 1, Kraków", "+48123456789", "Limanowskiego 1, Kraków", "+48123456789", "nataliaziajka@gmail.com", "natalia-ziajka@wp.pl", "not applicable", "https://github.com/nataliaziajka", "test1");
    ContactData contact = new ContactData().withFirstname("Natalia").withLastname("Ziajka");
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Assert.assertEquals(before,after);
  }
  }
