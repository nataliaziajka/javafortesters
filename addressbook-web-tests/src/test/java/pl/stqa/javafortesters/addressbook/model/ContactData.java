package pl.stqa.javafortesters.addressbook.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="addressbook")
public class ContactData {

  @Id
  @Column(name="id")
  private int id;
  //private int id =Integer.MAX_VALUE;
  @Column(name="firstname")
  private String firstname;

  @Column(name="lastname")
  private String lastname;

  @Column(name="mobile")
  @Type(type="text")
  private String mobilephone;

  @Column(name="work")
  @Type(type="text")
  private String workphone;

  @Column(name="home")
  @Type(type="text")
  private String homephone;

  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @Column(name="address")
  @Type(type="text")
  private String address;

  @Column(name="email")
  @Type(type="text")
  private String email;

  @Column(name="email2")
  @Type(type="text")
  private String email2;

  @Column(name="email3")
  @Type(type="text")
  private String email3;

  @Column(name="photo")
  @Type(type="text")
  private String photo;

  public Groups getGroups() {
    return new Groups(groups);
  }

  @ManyToMany(fetch =FetchType.EAGER)
  @JoinTable(name ="address_in_groups",
  joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name= "goup_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  public File getPhoto() { return new File(photo); }

  public String getAllPhones() { return allPhones; }

  public String getAllEmails() { return allEmails; }

  public String getAddress() { return address; }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getWorkphone() {
    return workphone;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {

    this.id = id;
    return this;
  }
  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
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
  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }
  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }
  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }
  public ContactData withMobilePhone(String mobilephone) {
    this.mobilephone = mobilephone;
    return this;
  }
  public ContactData withWorkPhone(String workphone) {
    this.workphone = workphone;
    return this;
  }
  public ContactData withHomePhone(String homephone) {
    this.homephone = homephone;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
