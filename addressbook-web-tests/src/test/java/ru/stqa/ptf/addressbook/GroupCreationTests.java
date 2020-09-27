package ru.stqa.ptf.addressbook;


import org.testng.annotations.*;


public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {

    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test", "test", "test"));
    submitGroupCreation();
    returnToGroupPage();

  }

}
