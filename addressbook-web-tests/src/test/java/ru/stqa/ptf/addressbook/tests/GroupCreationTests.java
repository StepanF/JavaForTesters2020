package ru.stqa.ptf.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test", "test", "test"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    app.getGroupHelper().returnToGroupPage();

  }

}
