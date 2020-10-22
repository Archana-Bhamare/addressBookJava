package addressBook;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBookJava {
	String fname = null, lname = null, mnum = null, city = null, state = null, zip = null;
	String name = "^[A-Z]{1}[a-z]{3,}$";
	String mob = "^[91]{2}[ ]?[0-9]{10}$";
	String mail = "^[a-zA-Z0-9]+([.+-_][a-z-A-Z0-9]+)*@[a-zA-Z0-9]+.[a-z]{2,3}([.][a-z]{2})*$";
	String zipcode = "^[0-9]{3}[ ]?[0-9]{3}$";

	public void userInput() {
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
		System.out.println("Enter the Mobile Number : ");
		mnum = s.nextInt();
		Pattern pattern2 = Pattern.compile(name);
		Matcher matcher2 = pattern2.matcher(mnum);
		if (matcher2.find()) {
			System.out.println("Valid Mobile Number");
		} else {
			System.out.println("Please enter the valid mobile number");
			mnum = s.nextInt();
		}
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
		System.out.println("Enter the Zip : ");
		zip = s.nextInt();
		Pattern pattern5 = Pattern.compile(name);
		Matcher matcher5 = pattern5.matcher(zip);
		if (matcher5.find()) {
			System.out.println("Valid Zip code");
		} else {
			System.out.println("Invalid zip code");
			zip = s.nextInt();
		}
	}

	public static void main(String[] args) {
		AddressBookJava add = new AddressBookJava();
		add.userInput();
	}
}