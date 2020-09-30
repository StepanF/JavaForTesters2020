package ru.stqa.ptf.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
     click(By.linkText("groups"));
  }
  public void goToAddNew() {
    click(By.linkText("add new"));
  }

  public void goToHomePage() {click(By.linkText("home"));
  }
}
