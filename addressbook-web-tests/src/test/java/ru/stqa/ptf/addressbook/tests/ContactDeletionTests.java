package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Set;


public class ContactDeletionTests extends TestBase {

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
  public void contactDeletionTest() {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact  = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().goToHomePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(deletedContact);

      Assert.assertEquals(before, after);

  }


}