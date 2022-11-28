package adtlinkedstring;

/**
 * Specifications on the design of operations of the Linked String.
 * @author ylzhao
 * @version 1.0
 */
public interface LinkedStringInterface {
	
	/**
	 * Gets the char value at the specified index.
	 * @param index An integer specifying the position of the char value
	 * @return An character specifying the retrieved char value
	 * @throws LinkedStringIndexOutOfBoundsException If index < 0 or index >= length()
	 * @throws LinkedStringException If length() is 0 (If Linked String is empty)
	 */
	public char charAt(int index) throws LinkedStringIndexOutOfBoundsException, LinkedStringException;
	
	/**
	 * Concatenates a specified linked string to the end of this linked string.
	 * @param linkedStr A reference to the specified linked string
	 * @return A reference to the concatenated linked string
	 */
	public LinkedString concat(LinkedString linkedStr);
	
	/**
	 * Checks to see if the length of this linked string is 0 (Checks to see if this linked string is empty).
	 * @return A boolean value specifying if the length of this linked string is 0 (if the linked string is empty)
	 */
	public boolean isEmpty();
	
	/**
	 * Checks the length of this linked string.
	 * @return An integer specifying the length of this linked string
	 */
	public int length();
	
	/**
	 * Gets a new linked string that is a substring of this linked string.
	 * @param beginIndex An integer specifying the begin position of the new substring linked string of this linked string
	 * @param endIndex An integer specifying the end position (exclusive) of the new substring linked string of this linked string
	 * @return A reference to the new linked string that is a substring of this linked string
	 * @throws LinkedStringIndexOutOfBoundsException If index < 0 or index > length() or beginIndex >= endIndex
	 * @throws LinkedStringException If length() is 0 (If Linked String is empty)
	 */
	public LinkedString substring(int beginIndex, int endIndex) throws LinkedStringIndexOutOfBoundsException, LinkedStringException;
}
