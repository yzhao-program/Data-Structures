package adtlinkedstring;

import java.io.FileNotFoundException;

/**
 * Demonstrates the use of the reference based Linked String.
 * @author ylzhao
 * @version 1.0
 */
public class Driver {
	/**
	 * Tests the reference based Linked String.
	 * @param args A reference to a string array that can store command line arguments
	 * @throws FileNotFoundException If a file is not found
	 * @throws LinkedStringIndexOutOfBoundsException If index < 0 or index >= length()
	 * @throws LinkedStringException If length() is 0 (If Linked String is empty)
	 */
	public static void main(String[] args) throws FileNotFoundException, LinkedStringIndexOutOfBoundsException, LinkedStringException {
		Helper.start();
	}

}
