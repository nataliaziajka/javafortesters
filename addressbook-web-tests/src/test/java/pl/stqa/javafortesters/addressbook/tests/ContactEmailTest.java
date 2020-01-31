package pl.stqa.javafortesters.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.javafortesters.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static pl.stqa.javafortesters.addressbook.tests.TestBase.app;

public class ContactEmailTest {

  @Test
  public void testContactEmail() {

    app.goTo().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(mergeEmails(contact.getAllEmails(),equalTo(contactInfoFromEditForm)));

  }

  public String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())

            .stream().filter((s -> !s.equals("")))
            .map(ContactEmailTest::cleaned)
            .collect(Collectors.joining("\n"));

  }
  public static String cleaned(String email) {
    return email.replaceAll("\\s", "");

  }
}
