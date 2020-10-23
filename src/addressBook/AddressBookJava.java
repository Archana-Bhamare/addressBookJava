package addressBook;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;

public class AddressBookJava {
	String addressbook;
	String fname = null, lname = null, mnum = null, city = null, state = null, zip = null;
	String name = "^[A-Z]{1}[a-z]{3,}$";
	String mob = "^[91]{2}[ ]?[0-9]{10}$";
	String mail = "^[a-zA-Z0-9]+([.+-_][a-z-A-Z0-9]+)*@[a-zA-Z0-9]+.[a-z]{2,3}([.][a-z]{2})*$";
	String zipcode = "^[0-9]{3}[ ]?[0-9]{3}$";

	public void userInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the First Name : ");
		fname = sc.next();
		Pattern pattern = Pattern.compile(name);
		Matcher matcher = pattern.matcher(fname);
		if (matcher.find()) {
			System.out.println("Valid Name");
		} else {
			System.out.println("Please enter the name in valid Format, First letter should be Capital");
			fname = sc.next();
		}
		System.out.println("Enter the Last Name : ");
		lname = sc.next();
		Pattern pattern1 = Pattern.compile(name);
		Matcher matcher1 = pattern1.matcher(lname);
		if (matcher1.find()) {
			System.out.println("Valid Name");
		} else {
			System.out.println("Please enter the name in valid Format, First letter should be Capital");
			lname = sc.next();
		}

		System.out.println("Enter the Mobile Number : ");
		mnum = sc.nextInt();
		Pattern pattern2 = Pattern.compile(name);
		Matcher matcher2 = pattern2.matcher(mnum);
		if (matcher2.find()) {
			System.out.println("Valid Mobile Number");
		} else {
			System.out.println("Please enter the valid mobile number");
			mnum = sc.nextInt();
		}

		System.out.println("Enter the City  : ");
		city = sc.next();
		Pattern pattern3 = Pattern.compile(name);
		Matcher matcher3 = pattern3.matcher(city);
		if (matcher3.find()) {
			System.out.println("Valid City Name");
		} else {
			System.out.println("Please enter the city name in proper format");
			city = sc.next();
		}
		System.out.println("Enter the State : ");
		state = sc.next();
		Pattern pattern4 = Pattern.compile(name);
		Matcher matcher4 = pattern4.matcher(state);
		if (matcher4.find()) {
			System.out.println("Valid State Name");
		} else {
			System.out.println("Please enter the state name in proper format");
			state = sc.next();
		}

		System.out.println("Enter the Zip : ");
		zip = sc.nextInt();
		Pattern pattern5 = Pattern.compile(name);
		Matcher matcher5 = pattern5.matcher(zip);
		if (matcher5.find()) {
			System.out.println("Valid Zip code");
		} else {
			System.out.println("Invalid zip code");
			zip = sc.nextInt();
		}

	}

	public void insertUser() throws IOException {
		userInput();
		File f1 = new File("G:/addressbook.txt");
		f1.createNewFile();
		FileWriter fw = new FileWriter("G:/addressbook.txt");
		fw.write("\nFirst Name : " + fname + "\nLast Name : " + lname + "\nCity : " + city + "\nState : " + state);
		fw.close();
	}

	public void displayAddressBook() throws IOException {
		FileReader fr = new FileReader("G:/addressbook.txt");
		int ch = fr.read();
		System.out.println("Record : " + (char) ch);
		fr.close();
	}

	public static void main(String[] args) throws IOException {
		AddressBookJava add = new AddressBookJava();
		while (true) {
			Scanner s = new Scanner(System.in);
			System.out.println(
					"3.Add User Information\n2.Display AddressBook\n3.Modify Details\n4.Delete user Record\n5.Search Record\n6.Exit");
			int choice = s.nextInt();

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
				System.exit(0);
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
}
