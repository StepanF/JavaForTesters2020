package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    {
      List<Object[]> list = new ArrayList<Object[]>();
      BufferedReader reader = new BufferedReader(new FileReader((new File("src/test/resources/contacts.csv"))));
      String line = reader.readLine();
      while (line != null) {
        String[] split = line.split(";");
        list.add(new Object[]{new ContactData().withFirstname(split[0]).withMiddlename(split[1]).
              withLastname(split[2]).withNickname(split[3]).withAddress(split[4]).withMobileCellPhone(split[5]).
              withEmail(split[6]).withGroup(split[7])});
        line = reader.readLine();
      }
      return list.iterator();
    }
  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) throws Exception {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/picture.png");
    app.contact().createContact(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
          before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test(enabled = true)
  public void testContactCreationWithPhoto() throws Exception {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/picture.png");
    ContactData contact = new ContactData().withFirstname("Иван79").withMiddlename("Иванович")
          .withLastname("Иванов").withNickname("Ivan").withAddress("Москва Петровка 38").
                withMobileCellPhone("89776666666")
          .withEmail("IvanMolodec@mail.ru").withPhoto(photo).withGroup("test1");
    app.contact().createContact(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
          before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test(enabled = true)
  public void testBadContactCreation() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Иван79'").withMiddlename("Иванович'")
          .withLastname("Иванов").withNickname("Ivan").withAddress("Москва Петровка 38").
                withMobileCellPhone("89776666666")
          .withEmail("IvanMolodec@mail.ru").withGroup("test1");
    app.contact().createContact(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}



/* Тест для проверки наличия файла

 @Test
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/picture.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }

 */