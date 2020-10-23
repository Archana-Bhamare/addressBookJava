package addressBook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class AddressBookJava {
	ArrayList<String> persons = new ArrayList<>();
	String addressbook;
	String fname = null, lname = null, mnum = null, city = null, state = null, zip = null;
	String name = "^[A-Z]{1}[a-z]{3,}$";
	String mob = "^[91]{2}[ ]?[0-9]{10}$";
	String mail = "^[a-zA-Z0-9]+([.+-_][a-z-A-Z0-9]+)*@[a-zA-Z0-9]+.[a-z]{2,3}([.][a-z]{2})*$";
	String zipcode = "^[0-9]{3}[ ]?[0-9]{3}$";

	public  void userInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the First Name : ");
		fname = s.next();
		Pattern pattern = Pattern.compile(name);
		Matcher matcher = pattern.matcher(fname);
		if (matcher.find()) {
			System.out.println("Valid Name");
		} else {
			System.out.println("Please enter the name in valid Format, First letter should be Capital");
			fname = s.next();
		}
		System.out.println("Enter the Last Name : ");
		lname = s.next();
		Pattern pattern1 = Pattern.compile(name);
		Matcher matcher1 = pattern1.matcher(lname);
		if (matcher1.find()) {
			System.out.println("Valid Name");
		} else {
			System.out.println("Please enter the name in valid Format, First letter should be Capital");
			lname = s.next();
		}
	/*	System.out.println("Enter the Mobile Number : ");
		mnum = s.nextInt();
		Pattern pattern2 = Pattern.compile(name);
		Matcher matcher2 = pattern2.matcher(mnum);
		if (matcher2.find()) {
			System.out.println("Valid Mobile Number");
		} else {
			System.out.println("Please enter the valid mobile number");
			mnum = s.nextInt();
		}*/
		System.out.println("Enter the City  : ");
		city = s.next();
		Pattern pattern3 = Pattern.compile(name);
		Matcher matcher3 = pattern3.matcher(city);
		if (matcher3.find()) {
			System.out.println("Valid City Name");
		} else {
			System.out.println("Please enter the city name in proper format");
			city = s.next();
		}
		System.out.println("Enter the State : ");
		state = s.next();
		Pattern pattern4 = Pattern.compile(name);
		Matcher matcher4 = pattern4.matcher(state);
		if (matcher4.find()) {
			System.out.println("Valid State Name");
		} else {
			System.out.println("Please enter the state name in proper format");
			state = s.next();
		}
		/*System.out.println("Enter the Zip : ");
		zip = s.nextInt();
		Pattern pattern5 = Pattern.compile(name);
		Matcher matcher5 = pattern5.matcher(zip);
		if (matcher5.find()) {
			System.out.println("Valid Zip code");
		} else {
			System.out.println("Invalid zip code");
			zip = s.nextInt();
		}*/
	}

	public void insertUser() {
		userInput();
		String p=new String(fname);
		String p1=new String(lname);
		String p2=new String(city);
		String p3=new String(state);
		persons.add(p);
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		System.out.println(persons);
		try {
		ArrayList<String> persons = new ArrayList<>(Files.readAllLines(Paths.get(addressbook)));
		/*try (BufferedReader reader=new BufferedReader(new FileReader(addressbook))){
			while (reader.ready()){
				persons.add(reader.readLine());
			}*/
		}catch (IOException e) {
			// TODO: handle exception
		} 
		catch (java.lang.NullPointerException e) {
			// TODO: handle exception
		}
}
	
	public static void main(String[] args) {
		AddressBookJava add = new AddressBookJava();
		add.insertUser();
		/*
		 * while (true) { Scanner s = new Scanner(System.in);
		 * System.out.println(
		 * "1.Create AddressBook\n2.Display AddressBook\n3.Add User Information\n4.Modify Details\n5.Delete user Record\n6.Search By Name\n7.Search By Zip\n8.Exit"
		 * ); int choice = s.nextInt();
		 * 
		 * switch (choice) { case 1: add.createAddressBook(); break; case 2:
		 * add.displayAddressBook(); break; case 3: add.insertUser(); break;
		 * case 4: add.modify(); break; case 5: add.deleteRecord(); break; case
		 * 6: add.searchByName(); break; case 7: add.searchByZip(); break; case
		 * 8: System.exit(0); default: System.out.println("Invalid Choice");
		 * break; }
		 */
	}
}
