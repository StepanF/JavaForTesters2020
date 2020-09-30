package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
  @Test
  public void contactModificationTest() {

    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Иван", "Иванович", "Иванов", "Ivan", "Москва Петровка 38", "89776666666", "IvanMolodec@mail.ru"));
    app.getContactHelper().submitModificationContact();
    app.getContactHelper().goToHomePage();

  }

}
