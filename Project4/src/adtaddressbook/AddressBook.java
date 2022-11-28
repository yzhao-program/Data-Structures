package adtaddressbook;

/**
 * Implementations on the design of an ADT Address Book with operations such as
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
public class AddressBook implements ADTAddressBook {
	
	/**
	 * A reference to a binary search tree of contacts
	 */
	private BinarySearchTree<Contact> tree;
	
	/**
	 * The number of contacts in this Address Book
	 */
	private int count;
	
	/**
	 * Constructs an empty Address Book
	 */
	public AddressBook() {
		this.tree = new BinarySearchTree<Contact>();
		this.count = 0;
	}
	
	/**
	 * Insert a contact into this Address Book
	 * @param contact A reference to this contact
	 */
	public void insert(Contact contact) {
		boolean target = this.tree.insert(contact);
		if (target) {
			count++;
		} else {
			System.out.println("Insertion fails. The name already exists in the Address Book. "
					+ "You should remove it and then insert a new one, "
					+ "but we suggest you to check the current information of the contact name first before removing it.");
		}
	}
	
	/**
	 * Delete a contact from this Address Book
	 * @param contact A reference to this contact
	 */
	public void remove(Contact contact) {
		boolean target = this.tree.remove(contact);
		if (target) {
			count--;
		} else {
			System.out.println("Deletion fails. The name doesn't exist in the Address Book.");
		}
	}
	
	/**
	 * Search a contact in this Address Book
	 * @param contact A reference to this contact
	 * @return A boolean value specifying if this Address Book has this contact.
	 */
	public boolean search(Contact contact) {
		return this.tree.search(contact);
	}
	
	/**
	 * Get a reference to a contact from this Address Book.
	 * @param name A reference to this contact name
	 * @return A reference to the retrieved contact from this Address Book.
	 */
	public Contact get(String name) {
		return getContact(this.tree.root, name);
	}
	
	/**
	 * Helper method for getting a reference to a contact from this Address Book recursively
	 * @param node The root node of the current subtree
	 * @param name A reference to this contact name
	 * @return A reference to the retrieved contact from this Address Book.
	 */
	private Contact getContact(TreeNode<Contact> node, String name) {
		if (node == null) {
			return null;
		}
		
		if (name.compareTo(node.getElement().getName()) == 0) {
			return node.getElement();
		} else if (name.compareTo(node.getElement().getName()) < 0) {
			return getContact(node.getLeft(), name);
		} else {
			return getContact(node.getRight(), name);
		}
	}
	
	/**
	 * Returns true if the Address Book is empty, else returns false.
	 * @return A boolean value specifying if the Address Book is empty.
	 */
	public boolean isEmpty() {
		return this.tree.isEmpty();
	}
	
	/**
	 * Removes all contacts from this Address Book.
	 */
	public void makeEmpty() {
		this.tree.makeEmpty();
		this.count = 0;
	}
	
	/**
	 * Check how many contacts are there in this Address Book
	 * @return An integer specifying how many number of contacts are there in this Address Book
	 */
	public int count() {
//		this.count = this.tree.getSize();
		return this.count;
	}
	
	/**
	 * Get the iterator of the binary search tree included in the Address Book.
	 * @return A reference to the iterator.
	 */
	public TreeIterator<Contact> iterator(){
		return tree.iterator();
	}

}
