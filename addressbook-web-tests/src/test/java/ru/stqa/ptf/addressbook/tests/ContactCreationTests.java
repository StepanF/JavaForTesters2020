package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() throws Exception {
   Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Иван79").withMiddlename("Иванович")
          .withLastname("Иванов").withNickname("Ivan").withAddress("Москва Петровка 38").
                withMobileCellPhone( "89776666666")
    .withEmail("IvanMolodec@mail.ru").withGroup("test1");
    app.contact().createContact(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() +1));
    assertThat(after, equalTo(
          before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }

}
