package ru.swt.addressbook.model;

public class ContactData {
	private int id;
	private final String firstName;
	private final String middleName;
	private final String lastName;
	private final String nickName;
	private final String title;
	private final String company;
	private final String address;
	private final String homePhone;
	private final String mobilePhone;
	private final String workPhone;
	private final String faxPhone;
	private final String email;
	private final String email2;
	private final String email3;
	private final String homePage;
	private final String address2;
	private final String phone2;
	private final String notes;
	private final String dayOfBDay;
	private final String monthOfBDay;
	private final String yearOfBDay;
	private final String dayOfAnniversary;
	private final String monthOfAnniversary;
	private final String yearOfAnniversary;
	private final String group;

	public ContactData(int id, String firstName, String middleName, String lastName, String nickName, String title, String company, String address, String homePhone, String mobilePhone, String workPhone, String faxPhone, String email, String email2, String email3, String homePage, String address2, String phone2, String notes, String dayOfBDay, String monthOfBDay, String yearOfBDay, String dayOfAnniversary, String monthOfAnniversary, String yearOfAnniversary, String group) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.title = title;
		this.company = company;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.faxPhone = faxPhone;
		this.email = email;
		this.email2 = email2;
		this.email3 = email3;
		this.homePage = homePage;
		this.address2 = address2;
		this.phone2 = phone2;
		this.notes = notes;
		this.dayOfBDay = dayOfBDay;
		this.monthOfBDay = monthOfBDay;
		this.yearOfBDay = yearOfBDay;
		this.dayOfAnniversary = dayOfAnniversary;
		this.monthOfAnniversary = monthOfAnniversary;
		this.yearOfAnniversary = yearOfAnniversary;
		this.group = group;
	}

	public ContactData(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = null;
		this.lastName = lastName;
		this.nickName = null;
		this.title = null;
		this.company = null;
		this.address = null;
		this.homePhone = null;
		this.mobilePhone = null;
		this.workPhone = null;
		this.faxPhone = null;
		this.email = null;
		this.email2 = null;
		this.email3 = null;
		this.homePage = null;
		this.address2 = null;
		this.phone2 = null;
		this.notes = null;
		this.dayOfBDay = null;
		this.monthOfBDay = null;
		this.yearOfBDay = null;
		this.dayOfAnniversary = null;
		this.monthOfAnniversary = null;
		this.yearOfAnniversary = null;
		this.group = null;
	}

	public ContactData(String firstName, String middleName, String lastName, String nickName, String title, String company, String address, String homePhone, String mobilePhone, String workPhone, String faxPhone, String email, String email2, String email3, String homePage, String address2, String phone2, String notes, String dayOfBDay, String monthOfBDay, String yearOfBDay, String dayOfAnniversary, String monthOfAnniversary, String yearOfAnniversary, String group) {
		this.id = 0;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.title = title;
		this.company = company;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.faxPhone = faxPhone;
		this.email = email;
		this.email2 = email2;
		this.email3 = email3;
		this.homePage = homePage;
		this.address2 = address2;
		this.phone2 = phone2;
		this.notes = notes;
		this.dayOfBDay = dayOfBDay;
		this.monthOfBDay = monthOfBDay;
		this.yearOfBDay = yearOfBDay;
		this.dayOfAnniversary = dayOfAnniversary;
		this.monthOfAnniversary = monthOfAnniversary;
		this.yearOfAnniversary = yearOfAnniversary;
		this.group = group;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
