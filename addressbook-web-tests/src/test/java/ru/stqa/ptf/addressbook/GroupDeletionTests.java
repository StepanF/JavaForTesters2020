package ru.stqa.ptf.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {



  @Test
  public void testDeletionGroup() throws Exception {

    goToGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();

  }

}