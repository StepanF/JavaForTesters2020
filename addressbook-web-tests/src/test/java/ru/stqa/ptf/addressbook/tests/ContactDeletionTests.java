package ru.stqa.ptf.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goToHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().createContact(new ContactData().withFirstname("Иван79").withMiddlename("Иванович")
            .withLastname("Иванов").withNickname("Ivan").withAddress("Москва Петровка 38").
                  withMobileCellPhone("89776666666"));
    }
  }


  @Test(enabled = true)
  public void contactDeletionTest() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().goToHomePage();
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, CoreMatchers.equalTo(before.without(deletedContact)));

  }


}