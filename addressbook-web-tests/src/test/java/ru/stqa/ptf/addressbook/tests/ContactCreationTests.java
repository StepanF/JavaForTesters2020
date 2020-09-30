package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goToAddNew();
    app.fillContactForm(new ContactData("Иван", "Иванович", "Иванов", "Ivan", "Москва Петровка 38", "89776666666", "IvanMolodec@mail.ru"));
    app.submitContactForm();
    app.goToHomePage();
  }

}