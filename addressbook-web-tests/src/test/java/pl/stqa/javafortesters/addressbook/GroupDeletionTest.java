package pl.stqa.javafortesters.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{

  @Test
  public void testGroupDeletion() throws Exception {

    gotoGroupPage();
    selectGroup();
    deleteSelectedGroup();
    returnToGroupPage();
  }

}
