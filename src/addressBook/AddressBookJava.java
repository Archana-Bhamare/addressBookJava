package addressBook;

public class AddressBookJava {
	public static void main(String[] args) {
		String fname = null, lname = null, mnum = null, email = null, city = null, state = null, zip = null;
		String name = "^[A-Z]{1}[a-z]{3,}$";
		String mob = "^[91]{2}[ ]?[0-9]{10}$";
		String mail = "^[a-zA-Z0-9]+([.+-_][a-z-A-Z0-9]+)*@[a-zA-Z0-9]+.[a-z]{2,3}([.][a-z]{2})*$";
		String zipcode = "^[0-9]{3}[ ]?[0-9]{3}$";
		while (true) {
			Scanner s = new Scanner(System.in);
			System.out.println("1.Create AddressBook\n2.Display AddressBook\n3.Add User Information\n4.Modify Deatils\n5.Delete user Record\n6.Search By Name\n7.Search By Zip\n8.Exit");
			int choice = s.nextInt();
			AddressBookJava add = new AddressBookJava();
			switch (choice) {
			case 1:
				add.createAddressBook();
				break;
			case 2:
				add.displayAddressBook();
				break;
			case 3:
				add.insertUser();
				break;
			case 4:
				add.modify();
				break;
			case 5:
				add.deleteRecord();
				break;
			case 6:
				add.searchByName();
				break;
			case 7:
				add.searchByZip();
				break;
			case 8:
				add.System.exit(0);
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
}