package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
  @Test
  public void contactDeletionTest() {

    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().chooseFirstContact();
    app.getContactHelper().clickDeleteContact();
    app.getContactHelper().closeAlertOfDeletion();

  }
}