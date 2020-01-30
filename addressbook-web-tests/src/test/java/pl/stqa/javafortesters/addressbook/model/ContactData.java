package pl.stqa.javafortesters.addressbook.model;

public class ContactData {

  private int id =Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String mobilephone;
  private String workphone;
  private String homephone;
  private String allPhones;
  private String address;


  public String getAllPhones() {

    return allPhones;
  }
  public String getAddress() {

    return address;
  }

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

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {

    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
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
