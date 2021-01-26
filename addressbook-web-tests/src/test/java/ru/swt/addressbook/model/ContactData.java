package ru.swt.addressbook.model;

public class ContactData {
	private int id = 0;
	private String firstName;
	private String middleName;
	private String lastName;
	private String nickName;
	private String title;
	private String company;
	private String address;
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String faxPhone;
	private String email;
	private String email2;
	private String email3;
	private String homePage;
	private String address2;
	private String phone2;
	private String notes;
	private String dayOfBDay;
	private String monthOfBDay;
	private String yearOfBDay;
	private String dayOfAnniversary;
	private String monthOfAnniversary;
	private String yearOfAnniversary;
	private String allPhones;
	private String allEmails;
	private String group;

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

	public ContactData withDayOfBDay(String dayOfBDay) {
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

	public ContactData withDayOfAnniversary(String dayOfAnniversary) {
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

	public String getDayOfBDay() {
		return dayOfBDay;
	}

	public String getMonthOfBDay() {
		return monthOfBDay;
	}

	public String getYearOfBDay() {
		return yearOfBDay;
	}

	public String getDayOfAnniversary() {
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ContactData that = (ContactData) o;

		if (id != that.id) return false;
		if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
		return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ContactData{" +
						"id=" + id +
						", firstName='" + firstName + '\'' +
						", lastName='" + lastName + '\'' +
						'}';
	}
}
