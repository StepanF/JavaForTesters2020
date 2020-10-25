package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withFirstname("Иван79").withMiddlename("Иванович")
          .withLastname("Иванов").withNickname("Ivan").withAddress("Москва Петровка 38").
                withMobileCellPhone( "89776666666")
    .withEmail("IvanMolodec@mail.ru").withGroup("test1");
    app.contact().createContact(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() +1);
    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
