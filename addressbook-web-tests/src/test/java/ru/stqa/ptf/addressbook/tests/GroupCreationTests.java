package ru.stqa.ptf.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.ptf.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test", "test", "test"));
    app.submitGroupCreation();
    app.returnToGroupPage();

  }

}
