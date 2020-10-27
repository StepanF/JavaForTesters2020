package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() throws Exception {
   Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Иван79").withMiddlename("Иванович")
          .withLastname("Иванов").withNickname("Ivan").withAddress("Москва Петровка 38").
                withMobileCellPhone( "89776666666")
    .withEmail("IvanMolodec@mail.ru").withGroup("test1");
    app.contact().createContact(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() +1);
    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
