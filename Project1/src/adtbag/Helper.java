package adtbag;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Contains helper methods for the driver program.
 * @author ylzhao
 * @version 1.0
 */
public class Helper {
	/**
	 * Demonstrates and tests the array based ADT bag.
	 * @throws FileNotFoundException If a file is not found
	 * @throws BagIndexOutOfBoundsException If index < 0 or index >= size()
	 * @throws BagException If size() is the number of capacity or is 0 (If bag is full or is empty)
	 */
	public static void start() throws FileNotFoundException, BagIndexOutOfBoundsException, BagException{
		BagArrayBased bag = new BagArrayBased();
		
		// Create a list
		create(bag);
		
		// Display a list
		display(bag);
		
		// Test insert(Object item) method and display the bag of items updated
		testInsertAndDisplay(bag, "Apple");
		
		// Test size() method and display the size result
		testSizeAndDisplay(bag);
		
		// Test isEmpty() method and display the boolean result to check whether the bag is empty
		testIsEmptyAndDisplay(bag);
		
		// Test get(int index) method and display the item at position index of this bag
		testGetAndDisplay(bag, 6);
		
		// Test get(Object item) method and display the index of the first occurrence of an item
		testGetAndDisplay(bag, "Apple");
		
		// Test get(Object item) method and display the index of the first occurrence of an item. Cheese doesn't exist, so return -1
		testGetAndDisplay(bag, "Cheese");
		
		// Test removeLast() method and display the bag of items updated
		testRemoveLastAndDisplay(bag);
		
		// Test removeRandom() method and display the bag of items updated
		testRemoveRandomAndDisplay(bag);
		
		// Test makeEmpty() method and display the bag of items updated
		testMakeEmptyAndDisplay(bag);
		
		// Test isEmpty() method and display the boolean result to check whether the bag is empty
		testIsEmptyAndDisplay(bag);
		
	}
	
	/**
	 * Creates a list of items.
	 * @param list A reference to a list of items
	 * @throws FileNotFoundException If a file is not found
	 * @throws BagException If size() is the number of capacity (If bag is full)
	 */
	private static void create(BagArrayBased list) throws FileNotFoundException, BagException{
		Scanner input = new Scanner(new File("testdata.txt"));
		//Bread, Cake, Apple, Pear, Orange, Egg, Beef, Apple, Apple, Orange
		while(input.hasNext()){
			list.insert(input.next());
	    }
		input.close();
	}
	
	/**
	 * Displays items in order.
	 * @param list A reference to a list of items
	 * @throws BagIndexOutOfBoundsException If index < 0 or index >= size()
	 * @throws BagException If size() is the number of capacity or is 0 (If bag is full or is empty)
	 */
	private static void display(BagArrayBased list) throws BagIndexOutOfBoundsException, BagException {
		StringBuilder outputResult = new StringBuilder();
		outputResult.append("Bag: { size = " + list.size() + ", ");
		outputResult.append("[");
		for (int i = 0; i < list.size(); i++) {
			outputResult.append(list.get(i).toString());
			if (i != list.size() - 1) {
				outputResult.append(", ");
			}
		}
		outputResult.append("] }");
		System.out.println(outputResult);
	}
	
	/**
	 * Test insert(Object item) method and display the list of items updated
	 * @param list A reference to a list of items
	 * @param item A reference to the item added
	 * @throws BagException If size() is the number of capacity (If bag is full)
	 */
	private static void testInsertAndDisplay(BagArrayBased list, Object item) throws BagException {
		System.out.println("\n***** Operation: Adds " + item + " to the end of the list of this bag *****");
		list.insert(item);
		display(list);
	}
	
	/**
	 * Test size() method and display the size result
	 * @param list A reference to a list of items
	 */
	private static void testSizeAndDisplay(BagArrayBased list) {
		System.out.println("\n***** Operation: Checks how many items are there in this bag *****");
		System.out.println(list.size());
	}
	
	/**
	 * Test isEmpty() method and display the boolean result to check whether the list is empty
	 * @param list A reference to a list of items
	 */
	private static void testIsEmptyAndDisplay(BagArrayBased list) {
		System.out.println("\n***** Operation: Checks to see if this bag is empty *****");
		System.out.println(list.isEmpty());
	}
	
	/**
	 * Test get(int index) method and display the item at position index of this list
	 * @param list A reference to a list of items
	 * @param index An integer specifying the position of the item
	 * @throws BagIndexOutOfBoundsException If index < 0 or index >= size()
	 * @throws BagException If size() is 0 (If bag is empty)
	 */
	private static void testGetAndDisplay(BagArrayBased list, int index) throws BagIndexOutOfBoundsException, BagException {
		System.out.println("\n***** Operation: Gets a reference to an item at position index " + index + " of this bag *****");
		System.out.println(list.get(index));
	}
	
	/**
	 * Test get(Object item) method and display the index of the first occurrence of an item from this list
	 * @param list A reference to a list of items
	 * @param item A reference to this item
	 */
	private static void testGetAndDisplay(BagArrayBased list, Object item) {
		System.out.println("\n***** Operation: Gets the index of the first occurrence of " + item + " from this bag *****");
		System.out.println(list.get(item));
	}
	
	/**
	 * Test removeLast() method and display the list of items updated
	 * @param list A reference to a list of items
	 * @throws BagException If size() is 0 (If bag is empty)
	 */
	private static void testRemoveLastAndDisplay(BagArrayBased list) throws BagException {
		System.out.println("\n***** Operation: Removes the item at the end of this bag *****");
		list.removeLast();
		display(list);
	}
	
	/**
	 * Test removeRandom() method and display the list of items updated
	 * @param list A reference to a list of items
	 * @throws BagIndexOutOfBoundsException If index < 0 or index >= size()
	 * @throws BagException If size() is 0 (If bag is empty)
	 */
	private static void testRemoveRandomAndDisplay(BagArrayBased list) throws BagIndexOutOfBoundsException, BagException {
		System.out.println("\n***** Operation: Removes an item at a random index from this bag *****");
		list.removeRandom();
		display(list);
	}
	
	/**
	 * Test makeEmpty() method and display the list of items updated
	 * @param list A reference to a list of items
	 * @throws BagException If size() is 0 (If bag is empty)
	 */
	private static void testMakeEmptyAndDisplay(BagArrayBased list) throws BagException {
		System.out.println("\n***** Operation: Empty this bag *****");
		list.makeEmpty();
		display(list);
	}
}
