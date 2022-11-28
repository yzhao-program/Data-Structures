package adtbag;

/**
 * Specifications on the design of operations of an ADT bag.
 * @author ylzhao
 * @version 1.0
 */
public interface BagInterface {
	
	/**
	 * Adds an item to the end of the list of this bag
	 * @param item A reference to the item added
	 * @throws BagException If size() is the number of capacity (If bag is full)
	 */
	public void insert(Object item) throws BagException;
	
	/**
	 * Removes the item at the end of this bag
	 * @throws BagException If size() is 0 (If bag is empty)
	 */
	public void removeLast() throws BagException;
	
	/**
	 * Removes an item at a random index from this bag
	 * @throws BagIndexOutOfBoundsException If index < 0 or index >= size()
	 * @throws BagException If size() is 0 (If bag is empty)
	 */
	public void removeRandom() throws BagIndexOutOfBoundsException, BagException;
	
	/**
	 * Gets the index of the first occurrence of an item from this bag
	 * @param item A reference to this item
	 * @return An integer specifying the index of the first occurrence of this item from this bag
	 */
	public int get(Object item);
	
	/**
	 * Gets a reference to an item at position index of this bag
	 * @param index An integer specifying the position of the data
	 * @return An object specifying the retrieved data
	 * @throws BagIndexOutOfBoundsException If index < 0 or index >= size()
	 * @throws BagException If size() is 0 (If bag is empty)
	 */
	public Object get(int index) throws BagIndexOutOfBoundsException, BagException;
	
	/**
	 * Checks how many items are there in this bag
	 * @return An integer specifying how many items are there in this bag
	 */
	public int size();
	
	/**
	 * Checks to see if this bag is empty
	 * @return A boolean value specifying if this bag is empty or not
	 */
	public boolean isEmpty();
	
	/**
	 * Empty this bag
	 * @throws BagException If size() is 0 (If bag is empty)
	 */
	public void makeEmpty() throws BagException;

}
