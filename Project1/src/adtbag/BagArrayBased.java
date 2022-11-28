package adtbag;

import java.util.Random;

/**
 * Implementations of operations of an ADT bag.
 * @author ylzhao
 * @version 1.0
 */
public class BagArrayBased implements BagInterface{
	
	/**
	 * A reference to an array of items
	 */
	private Object[] arrayBag;
	
	/**
	 * The number of items in this ADT bag
	 */
	private int count;
	
	/**
	 * The number of capacity in this ADT bag
	 */
	private int capacity = 100;
	
	/**
	 * Creates an empty ADT bag with a certain capacity.
	 */
	public BagArrayBased() {
		this.arrayBag = new Object[capacity];
		this.count = 0;
	}
	
	/**
	 * Adds an item to the end of the list of this bag
	 * @param item A reference to the item added
	 * @throws BagException If size() is the number of capacity (If bag is full)
	 */
	public void insert(Object item) throws BagException {
		if (this.size() == this.arrayBag.length) {
			throw new BagException("The bag is full, and no items can be added.");
		} else {
			this.arrayBag[count] = item;
			this.count++;
		}
	}
	
	/**
	 * Removes the item at the end of this bag
	 * @throws BagException If size() is 0 (If bag is empty)
	 */
	public void removeLast() throws BagException {
		if (this.size() == 0) {
			throw new BagException("The bag is empty, and no items can be removed.");
		} else {
			this.count--;
		}
	}
	
	/**
	 * Removes an item at a random index from this bag
	 * @throws BagIndexOutOfBoundsException If index < 0 or index >= size()
	 * @throws BagException If size() is 0 (If bag is empty)
	 */
	public void removeRandom() throws BagIndexOutOfBoundsException, BagException {
		
		if (this.size() == 0) {
			throw new BagException("The bag is empty, and no items can be removed.");
		}
		
		Random r = new Random();
		int index = r.nextInt(this.size());
		
		if (index < 0 || index >= this.size()) {
			throw new BagIndexOutOfBoundsException("The index value must be between 0 and " + (this.count-1));
		} else {
			for(int i = index; i < (this.count - 1); i++) {
				this.arrayBag[i] = this.arrayBag[i+1];
			}
			this.count--;
		}
	}
	
	/**
	 * Gets the index of the first occurrence of an item from this bag
	 * @param item A reference to this item
	 * @return An integer specifying the index of the first occurrence of this item from this bag
	 */
	public int get(Object item) {
		for(int i = 0; i < this.count; i++) {
			if(this.arrayBag[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Gets a reference to an item at position index of this bag
	 * @param index An integer specifying the position of the data
	 * @return An object specifying the retrieved data
	 * @throws BagIndexOutOfBoundsException If index < 0 or index >= size()
	 * @throws BagException If size() is 0 (If bag is empty)
	 */
	public Object get(int index) throws BagIndexOutOfBoundsException, BagException {
		if (this.size() == 0) {
			throw new BagException("The bag is empty, and no items can be gotten.");
		} else if (index < 0 || index >= this.size()) {
			throw new BagIndexOutOfBoundsException("The index value must be between 0 and " + (this.count-1));
		} else {
			return this.arrayBag[index];
		}
	}
	
	/**
	 * Checks how many items are there in this bag
	 * @return An integer specifying how many items are there in this bag
	 */
	public int size() {
		return this.count;
	}
	
	/**
	 * Checks to see if this bag is empty
	 * @return A boolean value specifying if this bag is empty or not
	 */
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	/**
	 * Empty this bag
	 * @throws BagException If size() is 0 (If bag is empty)
	 */
	public void makeEmpty() throws BagException {
		if (this.size() == 0) {
			throw new BagException("The bag is empty already.");
		} else {
			this.arrayBag = new Object[capacity];
			this.count = 0;
		}
	}

}
