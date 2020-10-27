package ru.stqa.ptf.addressbook.model;

import java.util.Objects;

public class ContactData {
  private  int id = Integer.MAX_VALUE;
  private  String firstname;
  private  String middlename;
  private  String lastname;
  private  String nickname;
  private  String address;
  private  String mobileCellPhone;
  private  String email;
  private String group;

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

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

}
