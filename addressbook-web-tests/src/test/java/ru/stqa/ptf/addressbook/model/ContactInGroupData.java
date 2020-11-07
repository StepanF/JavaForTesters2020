package ru.stqa.ptf.addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address_in_groups")
public class ContactInGroupData {

  @Id
  @Column(name = "id")
  private  int id = Integer.MAX_VALUE;
  @Column(name = "group_id")
  private  int group_id;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  public Groups getGroups() {
    return new Groups(groups);
  }

  public ContactInGroupData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactInGroupData withGroup_id(int group_id) {
    this.group_id = group_id;
    return this;
  }
}
