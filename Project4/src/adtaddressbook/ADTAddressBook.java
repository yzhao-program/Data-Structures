package adtaddressbook;

/**
 * Specifications on the design of an ADT Address Book with operations such as
 * 1. Insert a contact into this Address Book.
 * 2. Delete a contact from this Address Book.
 * 3. Search a contact in this Address Book.
 * 4. Get a reference to a contact from this Address Book.
 * 5. Returns true if the Address Book is empty, else returns false.
 * 6. Removes all contacts from this Address Book.
 * 7. Check how many contacts are there in this Address Book.
 * 8. Get the iterator of the binary search tree included in the Address Book.
 * @author ylzhao
 * @version 1.0
 */
public interface ADTAddressBook {
	
	/**
	 * Insert a contact into this Address Book
	 * @param contact A reference to this contact
	 */
	public void insert(Contact contact);
	
	/**
	 * Delete a contact from this Address Book
	 * @param contact A reference to this contact
	 */
	public void remove(Contact contact);
	
	/**
	 * Search a contact in this Address Book
	 * @param contact A reference to this contact
	 * @return A boolean value specifying if this Address Book has this contact.
	 */
	public boolean search(Contact contact);
	
	/**
	 * Get a reference to a contact from this Address Book.
	 * @param name A reference to this contact name
	 * @return A reference to the retrieved contact from this Address Book.
	 */
	public Contact get(String name);
	
	/**
	 * Returns true if the Address Book is empty, else returns false.
	 * @return A boolean value specifying if the Address Book is empty.
	 */
	public boolean isEmpty();
	
	/**
	 * Removes all contacts from this Address Book.
	 */
	public void makeEmpty();
	
	/**
	 * Check how many contacts are there in this Address Book
	 * @return An integer specifying how many number of contacts are there in this Address Book
	 */
	public int count();
	
	/**
	 * Get the iterator of the binary search tree included in the Address Book.
	 * @return A reference to the iterator.
	 */
	public TreeIterator<Contact> iterator();

}
