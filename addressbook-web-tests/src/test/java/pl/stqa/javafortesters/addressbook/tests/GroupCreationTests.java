package pl.stqa.javafortesters.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.events.Event;
import pl.stqa.javafortesters.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test1", null, null);
    app.getGroupHelper().createGroup(new GroupData("test1", "null", "null"));
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size()+1);

    //wyliczenie maksymalnego identyfikatora
    int max = 0;
    for(GroupData g: after){
      if(g.getId()>max){
        max = g.getId();
      }
    }
    // porownywacz dla dwoch obiektow typu group data
    Comparator<? super GroupData>byId = new Comparator<GroupData>() {
      @Override
      public int compare(GroupData o1, GroupData o2) {
        return Integer.compare(o1.getId(), o2.getId());
      }
    };
    //obliczanie maksymalnego obiektu
    int max1 = after.stream().max(byId).get().getId();
    group.setId(max);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
