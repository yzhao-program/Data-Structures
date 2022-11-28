package adtlinkedstring;

/**
 * Defines an exception that is thrown when an index is out of bound.
 * @author ylzhao
 * @version 1.0
 */
public class LinkedStringIndexOutOfBoundsException extends IndexOutOfBoundsException {
	
	/**
	 * Constructs an object with specific message
	 * @param message A string literal specifying the details of this exception
	 */
	public LinkedStringIndexOutOfBoundsException(String message) {
		super(message);
	}

}
