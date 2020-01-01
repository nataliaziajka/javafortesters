package pl.stqa.javafortesters.addressbook;

import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{

  @Test
  public void testAddNewContact() throws Exception {
    gotoContactGroupPage();
    fillContactForm(new ContactData("Natalia", "Joanna", "Ziajka", "natalia-ziajka", "Quality Assurance Engineer", "ABC", "Warszawska 25, Kraków", "Klimeckiego 1, Kraków", "+48123456789", "Limanowskiego 1, Kraków", "+48123456789", "nataliaziajka@gmail.com", "natalia-ziajka@wp.pl", "not applicable", "https://github.com/nataliaziajka"));
  }

}
