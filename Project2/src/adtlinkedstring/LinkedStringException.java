package adtlinkedstring;

/**
 * Defines an exception that is thrown when an operation can't be completed.
 * For example, if a linked string is empty, charAt operation can't be done.
 * @author ylzhao
 * @version 1.0
 */
public class LinkedStringException extends RuntimeException {
	
	/**
	 * Constructs an object with specific message
	 * @param message A string literal specifying the details of this exception
	 */
	public LinkedStringException(String message) {
		super(message);
	}
}
