package ru.stqa.ptf.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;
import ru.stqa.ptf.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
  private void editContactById(int id) {
    wd.findElement(By.xpath("//input[@value='" + id + "']/../../td[8]/a")).click();
  }

  public void submitModificationContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }


  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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
    contactCache = null;
    goToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input")) ;
   }

  public int getContactCount() {
    return wd.findElements(By.cssSelector("input[name='selected[]'][type='checkbox']")).size();
  }
  public Contacts contactCache = null;

  public Contacts all() {
    if (contactCache !=null){
        return new Contacts(contactCache);
      }
    contactCache = new Contacts();
    List<WebElement> elements  = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      List<WebElement> tag = element.findElements(By.tagName("td"));
      String firstname = tag.get(2).getText();
      String lastname = tag.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return new Contacts(contactCache);
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    clickDeleteContact();
    contactCache = null;
    closeAlertOfDeletion();
  }

  public void modify(  ContactData contact) {
     editContactById(contact.getId());
     fillContactForm(contact,false);
     submitModificationContact();
    contactCache = null;
     goToHomePage();
  }


}

