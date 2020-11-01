package ru.stqa.ptf.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
  private  int id = Integer.MAX_VALUE;
  @Expose
  private  String firstname;
  @Expose
  private  String middlename;
  @Expose
  private  String lastname;
  @Expose
  private  String nickname;
  @Expose
  private  String address;
  @Expose
  private  String mobileCellPhone;
  @Expose
  private  String email;
  @Expose
  private  String email2;
  @Expose
  private String email3;
  @Expose
  private String group;
  @Expose
  private String homePhone;
  @Expose
  private String workPhone;
  @Expose
  private  String allPhones;
  @Expose
  private String allEmails;
  private File photo;

  public File getPhoto() {
    return photo;
  }


  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }





  @Override
  public String toString() {
    return "ContactData{" +
          "id='" + id + '\'' +
          ", firstname='" + firstname + '\'' +
          ", lastname='" + lastname + '\'' +
          '}';
  }

  public int getId() {
    return id;
  }
  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getAddress() {
    return address;
  }

  public String getMobileCellPhone() {
    return mobileCellPhone;
  }

  public String getEmail() {
    return email;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getHomePhone() {
    return homePhone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
          Objects.equals(firstname, that.firstname) &&
          Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }

  public String getGroup() {
    return group;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withMobileCellPhone(String mobileCellPhone) {
    this.mobileCellPhone = mobileCellPhone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }
  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }



  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public String getEmail2() {
    return email2;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return  this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return  this;
  }

  public String getEmail3() {
    return email3;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }
}
