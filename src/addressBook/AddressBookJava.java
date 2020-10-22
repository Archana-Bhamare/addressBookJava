package addressBook;

public class AddressBookJava {
	public static void main(String[] args) {
		String fname = null, lname = null, mnum = null, email = null, city = null, state = null, zip = null;
		String name = "^[A-Z]{1}[a-z]{3,}$";
		String mob = "^[91]{2}[ ]?[0-9]{10}$";
		String mail = "^[a-zA-Z0-9]+([.+-_][a-z-A-Z0-9]+)*@[a-zA-Z0-9]+.[a-z]{2,3}([.][a-z]{2})*$";
		String zipcode = "^[0-9]{3}[ ]?[0-9]{3}$";
	}
}