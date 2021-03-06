package ru.stqa.ptf.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;
import ru.stqa.ptf.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader((new File("src/test/resources/contacts.xml"))))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> groups = (List<ContactData>) xstream.fromXML(xml);
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader((new File("src/test/resources/contacts.json"))))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> groups = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData contact) throws Exception {
    Contacts before = app.db().contacts();
    app.contact().createContact(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(
          before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    verifyContactListInUI();//для включения проверки данных UI c базой, в настройки добавить -DverifyUI=true
  }

  @Test(enabled = true)
  public void testContactCreationWithPhoto() throws Exception {
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    File photo = new File("src/test/resources/picture.png");
    ContactData contact = new ContactData().withFirstname("Иван Здесь фото").withMiddlename("Иванович")
          .withLastname("Иванов").withNickname("Ivan").withAddress("Москва Петровка 38").
                withMobileCellPhone("89776666666")
          .withEmail("IvanMolodec@mail.ru").withPhoto(photo).inGroup(groups.iterator().next());
    app.contact().createContact(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(
          before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    verifyContactListInUI();//для включения проверки данных UI c базой, в настройки добавить -DverifyUI=true
  }

/*  @Test(enabled = false) //тест для проверки кривого создания контакта
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

*/

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