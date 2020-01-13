package pl.stqa.javafortesters.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.javafortesters.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {

    app.getNavigationHelper().gotoHomePage();
    if(app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Natalia", "Joanna", "Ziajka", "natalia-ziajka", "Quality Assurance Engineer", "ABC", "Warszawska 25, Kraków", "Klimeckiego 1, Kraków", "+48123456789", "Limanowskiego 1, Kraków", "+48123456789", "nataliaziajka@gmail.com", "natalia-ziajka@wp.pl", "not applicable", "https://github.com/nataliaziajka", "test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeAlert();
  }
}

