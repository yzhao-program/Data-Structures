package adtaddressbook;

/**
 * Represents a contact which is used as type in address book. Each contact contains three elements: name, address, phone.
 * @author ylzhao
 * @version 1.0
 */
public class Contact implements Comparable<Contact> {
	
	/**
	 * The name of this contact
	 */
	private String name;
	
	/**
	 * The address of this contact
	 */
	private Address address;
	
	/**
	 * The phone of this contact
	 */
	private String phone;
	
	/**
	 * Constructs a default contact
	 */
	public Contact() {
		
	}
	
	/**
	 * Constructs an contact with three string elements
	 * @param name A reference to the name of this contact
	 * @param address A reference to the address of this contact
	 * @param phone A reference to the phone of this contact
	 */
	public Contact(String name, Address address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	/**
	 * Gets the name of this contact
	 * @return A reference to the name of this contact
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of this contact
	 * @param name A reference to the name of this contact
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the address of this contact
	 * @return A reference to the address of this contact
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Sets the address of this contact
	 * @param address A reference to the address of this contact
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * Gets the phone of this contact
	 * @return A reference to the phone of this contact
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Sets the phone of this contact
	 * @param phone A reference to the phone of this contact
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Compares this object with the specified object for order. Returns a negative integer, zero, or a positive integer as this object 
	 * is less than, equal to, or greater than the specified object. The natural ordering of this object is the order of names.
	 * @param o The object to be compared
	 * @return A negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object
	 */
	public int compareTo(Contact o) {
		return this.name.compareTo(o.name);
	}
	
	/*
	public boolean equals(Contact o) {
		return this.name.equals(o.name) && this.address.equals(o.address) && this.phone.equals(o.phone);
	}
	*/
	
	/**
	 * Override toString() method and converts the Address to String for printing it.
	 * @return A reference to the string
	 */
	public String toString() {
		String contactResult = "{ Name: " + this.name + "; " + this.address.toString() + "; Phone: " + this.phone + " }";
		return contactResult;
	}

}
