package adtaddressbook;

/**
 * Represents an exception thrown from a tree when operations fail.
 * @author ylzhao
 * @version 1.0
 */
public class TreeException extends RuntimeException {
	/**
	 * Construct an exception object with a message.
	 * @param s A reference to an exception message
	 */
	public TreeException(String s) {
		super(s);
	}
}
