package pl.stqa.javafortesters.addressbook.model;

public class ContactData {

  public void setId(int id) {
    this.id = id;
  }

  private int id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String comapany;
  private final String address;
  private final String homeaddress;
  private final String mobilephone;
  private final String workaddress;
  private final String fax;
  private final String email;
  private final String secondemail;
  private final String thirdemail;
  private final String homepage;
  private String contact;

  public ContactData(int id, String firstname, String middlename, String lastname, String nickname, String title, String comapany, String address, String homeaddress, String mobilephone, String workaddress, String fax, String email, String secondemail, String thirdemail, String homepage, String contact) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.comapany = comapany;
    this.address = address;
    this.homeaddress = homeaddress;
    this.mobilephone = mobilephone;
    this.workaddress = workaddress;
    this.fax = fax;
    this.email = email;
    this.secondemail = secondemail;
    this.thirdemail = thirdemail;
    this.homepage = homepage;
    this.contact = contact;
  }

  public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String comapany, String address, String homeaddress, String mobilephone, String workaddress, String fax, String email, String secondemail, String thirdemail, String homepage, String contact) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.comapany = comapany;
    this.address = address;
    this.homeaddress = homeaddress;
    this.mobilephone = mobilephone;
    this.workaddress = workaddress;
    this.fax = fax;
    this.email = email;
    this.secondemail = secondemail;
    this.thirdemail = thirdemail;
    this.homepage = homepage;
    this.contact = contact;
  }
  public String getContact() {
    return contact;
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

  public String getTitle() {
    return title;
  }

  public String getComapany() {
    return comapany;
  }

  public String getAddress() {
    return address;
  }

  public String getHomeaddress() {
    return homeaddress;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public String getWorkaddress() {
    return workaddress;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getSecondemail() {
    return secondemail;
  }

  public String getThirdemail() {
    return thirdemail;
  }

  public String getHomepage() {
    return homepage;
  }

  public int getId() {
    return id;
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
