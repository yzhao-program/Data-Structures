package adtaddressbook;

/**
 * Represents an address in a contact. Each address contains four string elements: street, city, state, zipcode.
 * @author ylzhao
 * @version 1.0
 */
public class Address {
	
	/**
	 * The street of this address
	 */
	private String street;
	
	/**
	 * The city of this address
	 */
	private String city;
	
	/**
	 * The state of this address
	 */
	private String state;
	
	/**
	 * The zipcode of this address
	 */
	private String zipcode;
	
	/**
	 * Constructs a default address
	 */
	public Address() {
		
	}
	
	/**
	 * Constructs an address with four string elements
	 * @param street A reference to the street of this address
	 * @param city A reference to the city of this address
	 * @param state A reference to the state of this address
	 * @param zipcode A reference to the zipcode of this address
	 */
	public Address(String street, String city, String state, String zipcode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	/**
	 * Gets the street of this address
	 * @return A reference to the street of this address
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Sets the street of this address
	 * @param street A reference to the street of this address
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Gets the city of this address
	 * @return A reference to the city of this address
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city of this address
	 * @param city A reference to the city of this address
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the state of this address
	 * @return A reference to the state of this address
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets the state of this address
	 * @param state A reference to the state of this address
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Gets the zipcode of this address
	 * @return A reference to the zipcode of this address
	 */
	public String getZipcode() {
		return zipcode;
	}
	
	/**
	 * Sets the zipcode of this address
	 * @param zipcode A reference to the zipcode of this address
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	/*
	public boolean equals(Address o) {
		return this.street.equals(o.street) && this.city.equals(o.city) && this.state.equals(o.state) && this.zipcode.equals(o.zipcode);
	}
	*/
	
	/**
	 * Override toString() method and converts the Address to String for printing it.
	 * @return A reference to the string
	 */
	public String toString() {
		String addressResult = "Address: [" + this.street + ", " + this.city + ", " + this.state + ", " + this.zipcode + "]";
		return addressResult;
	}
}
