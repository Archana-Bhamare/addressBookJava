package com.bridgelabz.addressbook;

public class Contact {
	private String firstName, lastName, city, state, mobileNumber, zip;

	public Contact() {
	}

	public Contact(String firstName, String lastName, String city, String state, String mobileNumber, String zip) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.mobileNumber = mobileNumber;
		this.zip = zip;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "[\nFirst Name : " + firstName + "\nLast Name : " + lastName + "\nCity : " + city + "\nState : " + state
				+ "\nMobule Number : " + mobileNumber + "\nZip Code : " + zip + "]";
	}
}
