package pl.stqa.javafortesters.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.javafortesters.addressbook.model.GroupData;
import pl.stqa.javafortesters.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().groupPage();
    if(app.group().all().size()==0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() throws Exception {

    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
        .withId(modifiedGroup.getId()).withName("test1").withHeader("null").withFooter("null");
    app.group().modifyGroup(group);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size());
    assertThat(after, CoreMatchers.equalTo(before.without(modifiedGroup).withAdded(group)));
  }


}