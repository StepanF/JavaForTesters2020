package ru.stqa.ptf.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

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

  public int count() {
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
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
//      String[] phones = cells.get(5).getText().split("\n"); так можно разбивать на строки и преобразовывать в массив
      String allPhones = cells.get(5).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).
            withAllPhones(allPhones).withAddress(address).withAllEmails(allEmails));
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

  public ContactData infoFromEditForm(ContactData contact){
    initContactModificationById(contact.getId());
    String  firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String  lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).
          withHomePhone(home).withMobileCellPhone(mobile).withWorkPhone(work).withAddress(address).withEmail(email).withEmail2(email2).withEmail3(email3);
  }

  private void initContactModificationById(int id){
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
    WebElement row = checkbox.findElement((By.xpath(("./../.."))));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }

}

