package ru.stqa.ptf.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String address;
  private final String mobileCellPhone;
  private final String email;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String address, String mobileCellPhone, String email) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.address = address;
    this.mobileCellPhone = mobileCellPhone;
    this.email = email;
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
}
