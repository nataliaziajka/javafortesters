package pl.stqa.javafortesters.mantis.appmanager;

import org.openqa.selenium.By;
import pl.stqa.javafortesters.mantis.model.UserData;

public class UserHelper extends HelperBase {
  public UserHelper(ApplicationManager app) {
    super( app );
  }

  public void changePasswordFor(UserData user) {
    selectUserById(user.getId());
    resetPasswordForSelectedUser();
  }

  private void resetPasswordForSelectedUser() {
    wd.findElement( By.cssSelector("input[value='Nowe hasło']")).click();
  }

  private void selectUserById(int id) {
    wd.findElement(By.cssSelector("a[href*='user_id="+ id + "']")).click();
  }

}
