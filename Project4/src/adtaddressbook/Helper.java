package adtaddressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Contains helper methods for the driver program.
 * @author ylzhao
 * @version 1.0
 */
public class Helper {
	
	/**
	 * Demonstrates and tests the binary tree based ADT Address Book
	 * @throws FileNotFoundException If a file is not found
	 */
	public static void start() throws FileNotFoundException {
		
		AddressBook addressBook = new AddressBook();
		
		create(addressBook);
		
		display(addressBook);
		
		testIsEmptyAndDisplay(addressBook);
		
		testCountAndDisplay(addressBook);
		
		Contact contact = testGetAndDisplay(addressBook, "MoonParlato");
		
		testInsertAndDisplay(addressBook, contact);
		
		testSearchAndDisplay(addressBook, contact);
		
		testRemoveAndDisplay(addressBook, contact);
		
		testSearchAndDisplay(addressBook, contact);
		
		testCountAndDisplay(addressBook);
		
		System.out.println("\n***** Operation: Changes this contact name and then use the non-existing contact to test operations *****");
		contact.setName("ylzhao");
		
		testSearchAndDisplay(addressBook, contact);
		
		testRemoveAndDisplay(addressBook, contact);
		
		testSearchAndDisplay(addressBook, contact);
		
		testCountAndDisplay(addressBook);
		
		testMakeEmptyAndDisplay(addressBook);
		
		testCountAndDisplay(addressBook);
		
		testIsEmptyAndDisplay(addressBook);
	}
	
	/**
	 * Creates an Address Book filled with contacts
	 * @param addBook A reference to an Address Book of contacts
	 * @throws FileNotFoundException If a file is not found
	 */
	private static void create(AddressBook addBook) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("contacts.txt"));
		
		// skip the first row of the table. The first row is the fields description rather than specific contact information.
		input.nextLine();
		
		while(input.hasNext()) {
			StringTokenizer tokens = new StringTokenizer(input.nextLine(), "\t", false);
			Contact contact = new Contact();
			Address address = new Address();
			String firstname = new String(tokens.nextToken());
			String lastname = new String(tokens.nextToken());
			String name = firstname + lastname;
			contact.setName(name);
			address.setStreet(new String(tokens.nextToken()));
			address.setCity(new String(tokens.nextToken()));
			address.setState(new String(tokens.nextToken()));
			address.setZipcode(new String(tokens.nextToken()));
			contact.setAddress(address);
			contact.setPhone(new String(tokens.nextToken()));
			addBook.insert(contact);
		}
		
	}
	
	/**
	 * Displays contacts in different orders.
	 * @param addBook A reference to an Address Book of contacts
	 */
	private static void display(AddressBook addBook) {
		
		TreeIterator<Contact> addBookIterator = addBook.iterator();
		
		System.out.println("\n***** Operation: Preorder *****");
		addBookIterator.setPreorder();
		traverse(addBookIterator);
		
		System.out.println("\n***** Operation: Inorder *****");
		addBookIterator.setInorder();
		traverse(addBookIterator);
		
		System.out.println("\n***** Operation: Postorder *****");
		addBookIterator.setPostorder();
		traverse(addBookIterator);
	}
	
	/**
	 * Test isEmpty() method and display the result
	 * @param addBook A reference to an Address Book of contacts
	 */
	private static void testIsEmptyAndDisplay(AddressBook addBook) {
		System.out.println("\n***** Operation: Checks to see if this Address Book is empty *****");
		System.out.println(addBook.isEmpty());
	}
	
	/**
	 * Test count() method and display the result
	 * @param addBook A reference to an Address Book of contacts
	 */
	private static void testCountAndDisplay(AddressBook addBook) {
		System.out.println("\n***** Operation: Checks how many contacts are there in this Address Book *****");
		System.out.println(addBook.count());
	}
	
	/**
	 * Test get(String name) method and display the result
	 * @param addBook A reference to an Address Book of contacts
	 * @param name A reference to the name of contact
	 * @return A reference to the contact
	 */
	private static Contact testGetAndDisplay(AddressBook addBook, String name) {
		System.out.println("\n***** Operation: Gets the contact of this Address Book *****");
		Contact contact = addBook.get(name);
		System.out.println(contact);
		return contact;
	}
	
	/**
	 * Test insert(Contact contact) method
	 * @param addBook A reference to an Address Book of contacts
	 * @param contact A reference to the contact
	 */
	private static void testInsertAndDisplay(AddressBook addBook, Contact contact) {
		System.out.println("\n***** Operation: Inserts the contact of this Address Book *****");
		addBook.insert(contact);
	}
	
	/**
	 * Test remove(Contact contact) method
	 * @param addBook A reference to an Address Book of contacts
	 * @param contact A reference to the contact
	 */
	private static void testRemoveAndDisplay(AddressBook addBook, Contact contact) {
		System.out.println("\n***** Operation: Removes the contact of this Address Book *****");
		addBook.remove(contact);
	}
	
	/**
	 * Test search(Contact contact) and display the result
	 * @param addBook A reference to an Address Book of contacts
	 * @param contact A reference to the contact
	 */
	private static void testSearchAndDisplay(AddressBook addBook, Contact contact) {
		System.out.println("\n***** Operation: Searches the contact of this Address Book *****");
		System.out.println(addBook.search(contact));
	}
	
	/**
	 * Test makeEmpty() method
	 * @param addBook A reference to an Address Book of contacts
	 */
	private static void testMakeEmptyAndDisplay(AddressBook addBook) {
		System.out.println("\n***** Operation: Completely Empties this Address Book *****");
		addBook.makeEmpty();
	}
	
	/**
	 * Helper method to display the contacts from iterator
	 * @param addBookIterator A reference to the iterator
	 */
	private static void traverse(TreeIterator<Contact> addBookIterator) {
		int i = 1;
		while(addBookIterator.hasNext()) {
			System.out.println("Contact" + i + ": \t" + addBookIterator.next());
			i++;
		}
	}

}
