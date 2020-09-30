package ru.stqa.ptf.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    goToAddNew();
    fillContactForm(new ContactData("Иван", "Иванович", "Иванов", "Ivan", "Москва Петровка 38", "89776666666", "IvanMolodec@mail.ru"));
    submitContactForm();
    goToHomePage();
  }

}
