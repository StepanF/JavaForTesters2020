package ru.stqa.ptf.addressbook.model;

import java.util.Objects;

public class ContactData {
  private  int id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String address;
  private final String mobileCellPhone;
  private final String email;
  private String group;

  @Override
  public String toString() {
    return "ContactData{" +
          "id='" + id + '\'' +
          ", firstname='" + firstname + '\'' +
          ", lastname='" + lastname + '\'' +
          '}';
  }



  public ContactData(int id, String firstname, String middlename, String lastname, String nickname, String address, String mobileCellPhone, String email, String group) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.address = address;
    this.mobileCellPhone = mobileCellPhone;
    this.email = email;
    this.group = group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) &&
          Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }

  public ContactData(String firstname, String middlename, String lastname, String nickname, String address, String mobileCellPhone, String email, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.address = address;
    this.mobileCellPhone = mobileCellPhone;
    this.email = email;
    this.group = group;
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

  public String getGroup() {
    return group;
  }
  public void setId(int id) {
    this.id = id;
  }
}
