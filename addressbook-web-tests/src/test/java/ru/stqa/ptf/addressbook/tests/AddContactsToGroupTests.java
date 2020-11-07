package ru.stqa.ptf.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;
import ru.stqa.ptf.addressbook.model.GroupData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddContactsToGroupTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditionsForAddContactsToGroupTests() {
    app.goTo().goToHomePage();
    if (app.db().contacts().size() == 0) {
      app.contact().createContact(new ContactData().withFirstname("Иван79").withMiddlename("Иванович")
            .withLastname("Иванов").withNickname("Ivan").withAddress("Москва Петровка 38").
                  withMobileCellPhone("89776666666"));
    }

    app.goTo().GroupPage();
    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData().withName("test"));
    }
  }


  @Test
  public void testContactAddToGroup() {

    Contacts before = app.db().contacts();
    ContactData findContact = before.iterator().next();
    app.goTo().goToHomePage();
    app.contact().addToGroup(findContact);
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before));



  }


}