package ru.swt.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
	@XStreamOmitField
	@Id
	@Column(name = "id")
	private int id = 0;

	@Expose
	@Column(name = "firstname")
	private String firstName = "";

	@Column(name = "middlename")
	private String middleName = "";

	@Expose
	@Column(name = "lastname")
	private String lastName = "";

	@Column(name = "nickname")
	private String nickName = "";

	@Column(name = "title")
	private String title = "";

	@Column(name = "company")
	private String company = "";

	@Expose
	@Column(name = "address")
	@Type(type = "text")
	private String address = "";

	@Expose
	@Column(name = "home")
	@Type(type = "text")
	private String homePhone = "";

	@Column(name = "mobile")
	@Type(type = "text")
	private String mobilePhone = "";

	@Column(name = "work")
	@Type(type = "text")
	private String workPhone = "";

	@Column(name = "fax")
	@Type(type = "text")
	private String faxPhone = "";

	@Expose
	@Column(name = "email")
	@Type(type = "text")
	private String email = "";

	@Column(name = "email2")
	@Type(type = "text")
	private String email2 = "";

	@Column(name = "email3")
	@Type(type = "text")
	private String email3 = "";

	@Column(name = "homepage")
	@Type(type = "text")
	private String homePage = "";

	@Column(name = "address2")
	@Type(type = "text")
	private String address2 = "";

	@Column(name = "phone2")
	@Type(type = "text")
	private String phone2 = "";

	@Column(name = "notes")
	@Type(type = "text")
	private String notes = "";

	@Column(name = "bday", columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.IntegerType")
	private int dayOfBDay = 0;

	@Column(name = "bmonth")
	private String monthOfBDay = "-";

	@Column(name = "byear")
	private String yearOfBDay = "";

	@Column(name = "aday", columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.IntegerType")
	private int dayOfAnniversary = 0;

	@Column(name = "amonth")
	private String monthOfAnniversary = "-";

	@Column(name = "ayear")
	private String yearOfAnniversary = "";

	@Transient
	private String group;

	@Transient
	private String allPhones;

	@Transient
	private String allEmails;

	@Column(name = "photo")
	@Type(type = "text")
	private String photo;

	public ContactData withPhoto(File photo) {
		this.photo = photo.getPath();
		return this;
	}

	public ContactData withId(int id) {
		this.id = id;
		return this;
	}

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withNickName(String nickName) {
		this.nickName = nickName;
		return this;
	}

	public ContactData withTitle(String title) {
		this.title = title;
		return this;
	}

	public ContactData withCompany(String company) {
		this.company = company;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public ContactData withWorkPhone(String workPhone) {
		this.workPhone = workPhone;
		return this;
	}

	public ContactData withFaxPhone(String faxPhone) {
		this.faxPhone = faxPhone;
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

	public ContactData withHomePage(String homePage) {
		this.homePage = homePage;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

	public ContactData withNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public ContactData withDayOfBDay(int dayOfBDay) {
		this.dayOfBDay = dayOfBDay;
		return this;
	}

	public ContactData withMonthOfBDay(String monthOfBDay) {
		this.monthOfBDay = monthOfBDay;
		return this;
	}

	public ContactData withYearOfBDay(String yearOfBDay) {
		this.yearOfBDay = yearOfBDay;
		return this;
	}

	public ContactData withDayOfAnniversary(int dayOfAnniversary) {
		this.dayOfAnniversary = dayOfAnniversary;
		return this;
	}

	public ContactData withMonthOfAnniversary(String monthOfAnniversary) {
		this.monthOfAnniversary = monthOfAnniversary;
		return this;
	}

	public ContactData withYearOfAnniversary(String yearOfAnniversary) {
		this.yearOfAnniversary = yearOfAnniversary;
		return this;
	}

	public ContactData withGroup(String group) {
		this.group = group;
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

	public File getPhoto() {
		if (photo != null) {
			return new File(photo);
		} else {
			return null;
		}
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public String getTitle() {
		return title;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress() {
		return address;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public String getFaxPhone() {
		return faxPhone;
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

	public String getHomePage() {
		return homePage;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}

	public String getNotes() {
		return notes;
	}

	public int getDayOfBDay() {
		return dayOfBDay;
	}

	public String getMonthOfBDay() {
		return monthOfBDay;
	}

	public String getYearOfBDay() {
		return yearOfBDay;
	}

	public int getDayOfAnniversary() {
		return dayOfAnniversary;
	}

	public String getMonthOfAnniversary() {
		return monthOfAnniversary;
	}

	public String getYearOfAnniversary() {
		return yearOfAnniversary;
	}

	public String getGroup() {
		return group;
	}

	public String getAllPhones() {
		return allPhones;
	}

	public String getAllEmails() {
		return allEmails;
	}

	@Override
	public String toString() {
		return "ContactData{" +
						"id=" + id +
						", firstName='" + firstName + '\'' +
						", middleName='" + middleName + '\'' +
						", lastName='" + lastName + '\'' +
						", nickName='" + nickName + '\'' +
						", title='" + title + '\'' +
						", company='" + company + '\'' +
						", address='" + address + '\'' +
						", homePhone='" + homePhone + '\'' +
						", mobilePhone='" + mobilePhone + '\'' +
						", workPhone='" + workPhone + '\'' +
						", faxPhone='" + faxPhone + '\'' +
						", email='" + email + '\'' +
						", email2='" + email2 + '\'' +
						", email3='" + email3 + '\'' +
						", homePage='" + homePage + '\'' +
						", address2='" + address2 + '\'' +
						", phone2='" + phone2 + '\'' +
						", notes='" + notes + '\'' +
						", dayOfBDay=" + dayOfBDay +
						", monthOfBDay='" + monthOfBDay + '\'' +
						", yearOfBDay='" + yearOfBDay + '\'' +
						", dayOfAnniversary=" + dayOfAnniversary +
						", monthOfAnniversary='" + monthOfAnniversary + '\'' +
						", yearOfAnniversary='" + yearOfAnniversary + '\'' +
						'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ContactData that = (ContactData) o;

		if (id != that.id) return false;
		if (dayOfBDay != that.dayOfBDay) return false;
		if (dayOfAnniversary != that.dayOfAnniversary) return false;
		if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
		if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
		if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
		if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
		if (title != null ? !title.equals(that.title) : that.title != null) return false;
		if (company != null ? !company.equals(that.company) : that.company != null) return false;
		if (address != null ? !address.equals(that.address) : that.address != null) return false;
		if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
		if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
		if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
		if (faxPhone != null ? !faxPhone.equals(that.faxPhone) : that.faxPhone != null) return false;
		if (email != null ? !email.equals(that.email) : that.email != null) return false;
		if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
		if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
		if (homePage != null ? !homePage.equals(that.homePage) : that.homePage != null) return false;
		if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
		if (phone2 != null ? !phone2.equals(that.phone2) : that.phone2 != null) return false;
		if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
		if (monthOfBDay != null ? !monthOfBDay.equals(that.monthOfBDay) : that.monthOfBDay != null) return false;
		if (yearOfBDay != null ? !yearOfBDay.equals(that.yearOfBDay) : that.yearOfBDay != null) return false;
		if (monthOfAnniversary != null ? !monthOfAnniversary.equals(that.monthOfAnniversary) : that.monthOfAnniversary != null)
			return false;
		return yearOfAnniversary != null ? yearOfAnniversary.equals(that.yearOfAnniversary) : that.yearOfAnniversary == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (company != null ? company.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
		result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
		result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
		result = 31 * result + (faxPhone != null ? faxPhone.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (email2 != null ? email2.hashCode() : 0);
		result = 31 * result + (email3 != null ? email3.hashCode() : 0);
		result = 31 * result + (homePage != null ? homePage.hashCode() : 0);
		result = 31 * result + (address2 != null ? address2.hashCode() : 0);
		result = 31 * result + (phone2 != null ? phone2.hashCode() : 0);
		result = 31 * result + (notes != null ? notes.hashCode() : 0);
		result = 31 * result + dayOfBDay;
		result = 31 * result + (monthOfBDay != null ? monthOfBDay.hashCode() : 0);
		result = 31 * result + (yearOfBDay != null ? yearOfBDay.hashCode() : 0);
		result = 31 * result + dayOfAnniversary;
		result = 31 * result + (monthOfAnniversary != null ? monthOfAnniversary.hashCode() : 0);
		result = 31 * result + (yearOfAnniversary != null ? yearOfAnniversary.hashCode() : 0);
		return result;
	}
}
