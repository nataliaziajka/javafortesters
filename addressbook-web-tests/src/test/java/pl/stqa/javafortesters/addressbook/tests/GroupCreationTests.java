package pl.stqa.javafortesters.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.javafortesters.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", "null", "null"));

  }

}
