package ru.stqa.ptf.addressbook.generator;

import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    save(contacts,file);
  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts){
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s\n" , contact.getFirstname(),contact.getMiddlename(),contact.getLastname(),
            contact.getNickname(),contact.getAddress(),contact.getMobileCellPhone(),contact.getEmail(),contact.getGroup()));
    }
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i<count; i++){
      contacts.add(new ContactData().withFirstname(String.format("Иван %s", i)).withMiddlename(String.format("Иванович %s", i))
            .withLastname(String.format("Иванов %s", i)).withNickname(String.format("Ivan %s", i)).
                  withAddress(String.format("Москва Петровка %s", i)).withMobileCellPhone(String.format("8977666666%s", i))
            .withEmail(String.format("IvanMolodec%s@mail.ru", i)).withGroup("test1"));
    }
    return contacts;
  }
}
