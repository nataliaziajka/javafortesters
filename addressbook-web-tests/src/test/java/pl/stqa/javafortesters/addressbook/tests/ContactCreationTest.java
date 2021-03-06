package pl.stqa.javafortesters.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.javafortesters.addressbook.model.ContactData;
import pl.stqa.javafortesters.addressbook.model.Contacts;

import java.io.File;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactCreationTest extends TestBase {

  public ContactCreationTest(Properties properties) {
    this.properties = properties;
  }

  private final Properties properties;

  @Test
  public void testAddNewContact() throws Exception {
    app.contact().initContactCreation();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.png");
    //ContactData contact = new ContactData("Natalia", "Joanna", "Ziajka", "natalia-ziajka", "Quality Assurance Engineer", "ABC", "Warszawska 25, Kraków", "Klimeckiego 1, Kraków", "+48123456789", "Limanowskiego 1, Kraków", "+48123456789", "nataliaziajka@gmail.com", "natalia-ziajka@wp.pl", "not applicable", "https://github.com/nataliaziajka", "test1");
    ContactData contact = new ContactData().withFirstname(properties.getProperty("name")).withLastname(properties.getProperty("web.surname")).withPhoto(photo);
    app.contact().createContact(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
  }
//  @Test
//  public void testCurrentDir(){
//    File currentDir = new File(".");
//    System.out.println(currentDir.getAbsolutePath());
//    File photo = new File("src/test/resources/stru.png");
//    System.out.println(photo.getAbsolutePath());
//    System.out.println(photo.exists());
//  }

  }
