package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
  int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("Иван", "Иванович", "Иванов", "Ivan", "Москва Петровка 38", "89776666666", "IvanMolodec@mail.ru", "test1"));
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before +1);
  }

}
