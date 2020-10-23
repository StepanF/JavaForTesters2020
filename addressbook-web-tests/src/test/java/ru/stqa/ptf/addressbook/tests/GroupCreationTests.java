package ru.stqa.ptf.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().goToGroupPage();

    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test5", null, null);
    app.getGroupHelper().createGroup(group);

    List<GroupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size() + 1);

/*
    int max = 0;
    for (GroupData g : after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
  */

    // group.setId(after.stream().max((Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    //строка выше это вычисление максимума, оставил для примера
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
