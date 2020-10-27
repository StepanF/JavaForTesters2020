package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goToHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().createContact(new ContactData().withFirstname("Иван79").withMiddlename("Иванович")
            .withLastname("Иванов").withNickname("Ivan").withAddress("Москва Петровка 38").
                  withMobileCellPhone( "89776666666"));
    }
  }


  @Test(enabled = true)
  public void contactModificationTest() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Иван79").withMiddlename("Иванович")
          .withLastname("Иванов").withNickname("Ivan").withAddress("Москва Петровка 38").
                withMobileCellPhone( "89776666666");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);

  }
}
