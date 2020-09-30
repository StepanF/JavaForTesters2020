package ru.stqa.ptf.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void goToHomePage() {

    click(By.linkText("home page"));
  }

  public void submitContactForm() {

    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobileCellPhone());
    type(By.name("email"), contactData.getEmail());

  }

  public void editContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

  }

  public void submitModificationContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void chooseFirstContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
  }

  public void clickDeleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }
  public void closeAlertOfDeletion() {
    wd.switchTo().alert().accept();
  }
}
