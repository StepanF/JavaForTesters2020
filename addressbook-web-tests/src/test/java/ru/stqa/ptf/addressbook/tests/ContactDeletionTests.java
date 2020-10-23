package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;


public class ContactDeletionTests extends TestBase {
  @Test
  public void contactDeletionTest() {

    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){

      app.getContactHelper().createContact(new ContactData("Иван", "Иванович", "Иванов", "Ivan", "Москва Петровка 38", "89776666666", "IvanMolodec@mail.ru", "test1"));

    }
    app.getContactHelper().chooseFirstContact();
    app.getContactHelper().clickDeleteContact();
    app.getContactHelper().closeAlertOfDeletion();

  }
}