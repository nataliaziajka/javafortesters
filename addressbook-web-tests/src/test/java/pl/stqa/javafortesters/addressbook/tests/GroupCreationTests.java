package pl.stqa.javafortesters.addressbook.tests;


import org.testng.annotations.Test;
import pl.stqa.javafortesters.addressbook.model.GroupData;
import pl.stqa.javafortesters.addressbook.model.Groups;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    Groups after = app.group().all();

    assertThat(after,equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    assertThat(after.size(), equalTo(before.size() + 1));
  }


}
