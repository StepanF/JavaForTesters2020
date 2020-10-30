package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @Test

public void testContactPhones() {

    app.goTo().goToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact ) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
          .stream().filter((s) -> ! s.equals("")).map(ContactPhoneTests::cleaned)
          .collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact ) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobileCellPhone(), contact.getWorkPhone())
          .stream().filter((s) -> ! s.equals("")).map(ContactPhoneTests::cleaned)
          .collect(Collectors.joining("\n"));

  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]","");
}

}
