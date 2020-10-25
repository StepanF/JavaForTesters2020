package ru.stqa.ptf.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobileCellPhone());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  public void goToAddNew() {
      click(By.linkText("add new"));
  }

  public void editContact(int index) {
    wd.findElements(By.cssSelector("img[title = 'Edit']")).get(index).click();

  }

  public void submitModificationContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
      }

  public void clickDeleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeAlertOfDeletion() {
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData contact) {
    goToAddNew();
    fillContactForm(contact,true);
    submitContactForm();
    goToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input")) ;
   }

  public int getContactCount() {
    return wd.findElements(By.cssSelector("input[name='selected[]'][type='checkbox']")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements  = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      List<WebElement> tag = element.findElements(By.tagName("td"));
      String firstname = tag.get(2).getText();
      String lastname = tag.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
     ContactData contact = new ContactData( id, firstname, null, lastname, null, null, null, null, null);
     contacts.add(contact);
    }
    return contacts;
  }
  public void delete(int index) {
     selectContact(index);
     clickDeleteContact();
     closeAlertOfDeletion();
  }
  public void modify(int index, ContactData contact) {
     editContact(index);
     fillContactForm(contact,false);
     submitModificationContact();
     goToHomePage();
  }
}
