package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().GroupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData( "test", null, null));
    }
  }

  @Test
  public void testDeletionGroup() throws Exception {

    List<GroupData> before = app.group().list();
    int index  = before.size() - 1;
    app.group().delete(index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(index);
    Assert.assertEquals(before, after);
    }



}
