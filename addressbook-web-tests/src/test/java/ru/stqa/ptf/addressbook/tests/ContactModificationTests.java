package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
  @Test
  public void contactModificationTest() {

    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Иван", "Иванович", "Иванов", "Ivan", "Москва Петровка 38", "89776666666", "IvanMolodec@mail.ru", "test1"));
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Иван", "Иванович", "Иванов", "Ivan", "Москва Петровка 38", "89776666666", "IvanMolodec@mail.ru",null),false);
    app.getContactHelper().submitModificationContact();
    app.getContactHelper().goToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before );

  }

}
