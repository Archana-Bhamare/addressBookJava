package com.bridgelabz.addressbook.runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.bridgelabz.addressbook.utils.Constants;
import java.io.*;

class Contact {
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

public class AddressBookJava {
	// Instance Variable
	private List<String> persons;
	private Contact user = new Contact();

	private static final Scanner SC = new Scanner(System.in);

	public AddressBookJava() {
		persons = new ArrayList<String>();
	}

	public void userInput() {
		System.out.println("Enter the First Name : ");
		user.setFirstName(SC.next());
		if (validateRegex(user.getFirstName(), Constants.NAME_REGEX)) {
			System.out.println("Valid Name");
		} else {
			System.out.println("Please enter the name in valid Format, First letter should be Capital");
			user.setFirstName(SC.next());
		}
		System.out.println("Enter the Last Name : ");
		user.setLastName(SC.next());
		if (validateRegex(user.getLastName(), Constants.NAME_REGEX)) {
			System.out.println("Valid Name");
		} else {
			System.out.println("Please enter the name in valid Format, First letter should be Capital");
			user.setLastName(SC.next());
		}
		SC.nextLine();
		System.out.println("Enter the Mobile Number : ");
		user.setMobileNumber(SC.nextLine());
		if (validateRegex(user.getMobileNumber(), Constants.MOBILE_NUMBER_REGEX)) {
			System.out.println("Valid Mobile Number");
		} else {
			System.out.println("Please enter the valid mobile number");
			user.setMobileNumber(SC.nextLine());
		}
		System.out.println("Enter the City  : ");
		user.setCity(SC.next());
		if (validateRegex(user.getCity(), Constants.NAME_REGEX)) {
			System.out.println("Valid City Name");
		} else {
			System.out.println("Please enter the city name in proper format");
			user.setCity(SC.next());
		}
		System.out.println("Enter the State : ");
		user.setState(SC.next());
		if (validateRegex(user.getState(), Constants.NAME_REGEX)) {
			System.out.println("Valid State Name");
		} else {
			System.out.println("Please enter the state name in proper format");
			user.setCity(SC.next());
		}
		SC.nextLine();
		System.out.println("Enter the Zip : ");
		user.setZip(SC.nextLine());
		if (validateRegex(user.getZip(), Constants.ZIP_CODE_REGEX)) {
			System.out.println("Valid Zip code");
		} else {
			System.out.println("Invalid zip code");
			user.setZip(SC.nextLine());
		}
	}

	// Add user details
	public void insertUser() throws IOException {
		userInput();

		persons.add(user.getFirstName());
		persons.add(user.getLastName());
		persons.add(user.getCity());
		persons.add(user.getState());
		persons.add(user.getMobileNumber());
		persons.add(user.getZip());

		System.out.println(persons);

//		try (FileWriter fileWriter = new FileWriter(Constants.PATH)) {
//			System.out.println("1");
//			fileWriter.write(persons.toString());
//			fileWriter.close();
//		} finally {
//			persons = null;
//		}
//
//		try (FileReader fileReader = new FileReader(Constants.PATH)) {
//			System.out.println("1");
//			int ch = fileReader.read();
//			while (ch != -1) {
//				System.out.print((char) ch);
//				fileReader.close();
//			}
//		}

		File file = new File(Constants.PATH);
		file.createNewFile();
		FileWriter fw = new FileWriter(Constants.PATH);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(persons.toString());
		bw.close();
	}

	// Display the address book
	public void displayAddressBook() throws IOException {
		String line = null;
		FileReader fr = new FileReader(Constants.PATH);
		BufferedReader br = new BufferedReader(fr);
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}

	// Edit user details
	public void modify() {
		System.out.println("Enter the first name to wants modify : ");
		user.setFirstName(SC.next());
		for (int i = 0; i < persons.size(); i++) {
			String p = (String) persons.get(i);
			if (user.getFirstName().equals(p)) {
				System.out.println("1.First Name\n2.Last Name\n3.City\n4.State\n5.Exit");
				int choice = SC.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the First Name : ");
					user.setFirstName(SC.next());
					if (validateRegex(user.getFirstName(), Constants.NAME_REGEX)) {
						System.out.println("Valid Name");
						persons.set(0, user.getFirstName());
					} else {
						System.out.println("Please enter the name in valid Format, First letter should be Capital");
						user.setFirstName(SC.next());
					}
					break;
				case 2:
					System.out.println("Enter the Last Name : ");
					user.setLastName(SC.next());
					if (validateRegex(user.getLastName(), Constants.NAME_REGEX)) {
						System.out.println("Valid Name");
						persons.set(1, user.getLastName());
					} else {
						user.setLastName(SC.next());
						System.out.println("Please enter the name in valid Format, First letter should be Capital");
					}
					break;
				case 3:
					System.out.println("Enter the City  : ");
					user.setCity(SC.next());
					if (validateRegex(user.getCity(), Constants.NAME_REGEX)) {
						System.out.println("Valid City Name");
						persons.set(2, user.getCity());
					} else {
						System.out.println("Please enter the city name in proper format");
						user.setCity(SC.next());
					}
					break;
				case 4:
					System.out.println("Enter the State : ");
					user.setState(SC.next());
					if (validateRegex(user.getState(), Constants.NAME_REGEX)) {
						System.out.println("Valid State Name");
						persons.set(3, user.getState());
					} else {
						System.out.println("Please enter the state name in proper format");
						user.setState(SC.next());
					}
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice");
					break;
				}
				System.out.println(persons);
			} else {
				System.out.println("Name Not Exist");
			}
		}
	}

	// Delete user record
	public void deleteRecord() {
		System.out.println("Enter the firstname to wants to delete : ");
		String fname = SC.next();
		for (int i = 0; i < persons.size(); i++) {
			String p = (String) persons.get(i);
			if (fname.equals(p)) {
				persons.remove(i);
				System.out.println("Record Deleted");
			} else {
				System.out.println("Name Not Exist");
			}
		}
	}

	// Search user Record
	public void searchRecord() {
		System.out.println("Enter the name that u want to search : ");
		String fname = SC.next();
		for (int i = 0; i < persons.size(); i++) {
			String p = (String) persons.get(i);
			if (fname.equals(p)) {
				System.out.println("Record Found : " + p);
			} else {
				System.out.println("Name not exist!!!");
			}
		}
	}

	

	public static void main(String arges[]) {
		AddressBookJava add = new AddressBookJava();
		int choice;
		do {
			System.out.println("********************MENU********************");
			System.out.print(
					"1.Add User Information\n2.Display Address Book\n3.Modify User Details\n4.Delete user Record\n5.Search Record\n6.Exit");
			choice = SC.nextInt();
			try {
				switch (choice) {
				case 1:
					add.insertUser();
					break;
				case 2:
					add.displayAddressBook();
					break;
				case 3:
					add.modify();
					break;
				case 4:
					add.deleteRecord();
					break;
				case 5:
					add.searchRecord();
					break;
				case 6:
					break;
				default:
					System.out.println("Invalid Choice");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (choice != 6);
	}

	private boolean validateRegex(String request, String pattern) {
		return Pattern.compile(pattern).matcher(request).matches() ? true : false;
	}
}
