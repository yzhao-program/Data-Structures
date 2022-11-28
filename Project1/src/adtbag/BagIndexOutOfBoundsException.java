package adtbag;

/**
 * Defines an exception that is thrown when an index is out of bound.
 * @author ylzhao
 * @version 1.0
 */
public class BagIndexOutOfBoundsException extends IndexOutOfBoundsException {
	
	/**
	 * Constructs an object with specific message
	 * @param message A string literal specifying the details of this exception
	 */
	public BagIndexOutOfBoundsException(String message) {
		super(message);
	}
}
