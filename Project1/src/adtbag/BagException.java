package adtbag;

/**
 * Defines an exception that is thrown when the bag is full or empty
 * @author ylzhao
 * @version 1.0
 */
public class BagException extends Exception {
	
	/**
	 * Constructs an object with specific message
	 * @param message A string literal specifying the details of this exception
	 */
	public BagException(String message) {
		super(message);
	}
}
