package pl.stqa.javafortesters.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.javafortesters.addressbook.model.ContactData;
import pl.stqa.javafortesters.addressbook.model.Contacts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactCreationTest extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.contact().gotoContactGroupPage();
    Contacts before = app.contact().all();
    //ContactData contact = new ContactData("Natalia", "Joanna", "Ziajka", "natalia-ziajka", "Quality Assurance Engineer", "ABC", "Warszawska 25, Kraków", "Klimeckiego 1, Kraków", "+48123456789", "Limanowskiego 1, Kraków", "+48123456789", "nataliaziajka@gmail.com", "natalia-ziajka@wp.pl", "not applicable", "https://github.com/nataliaziajka", "test1");
    ContactData contact = new ContactData().withFirstname("Natalia").withLastname("Ziajka");
    app.contact().createContact(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before
            .withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }

  }
