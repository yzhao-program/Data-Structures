package adtbag;

import java.io.FileNotFoundException;

/**
 * Demonstrates the use of array based ADT bag.
 * @author ylzhao
 * @version 1.0
 */
public class Driver {
	/**
	 * Tests the array based ADT bag.
	 * @param args A reference to a string array that can store command line arguments
	 * @throws FileNotFoundException If a file is not found
	 * @throws BagIndexOutOfBoundsException If index < 0 or index >= size()
	 * @throws BagException If size() is the number of capacity or is 0 (If bag is full or is empty)
	 */
	public static void main(String[] args) throws FileNotFoundException, BagIndexOutOfBoundsException, BagException {
		Helper.start();
	}

}
