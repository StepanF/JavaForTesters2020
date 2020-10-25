package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
  @Test(enabled = false)
  public void contactModificationTest() {

    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Иван", "Иванович", "Иванов", "Ivan", "Москва Петровка 38", "89776666666", "IvanMolodec@mail.ru", "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContact(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size()-1).getId(), "Иван", "Иванович", "Иванов", "Ivan", "Москва Петровка 38", "89776666666", "IvanMolodec@mail.ru",null);
    app.getContactHelper().fillContactForm(contact,false);
    app.getContactHelper().submitModificationContact();
    app.getContactHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
