package adtlinkedstring;

/**
 * Implementations of operations of the Linked String.
 * @author ylzhao
 * @version 1.0
 */
public class LinkedString implements LinkedStringInterface {
	
	/**
	 * A reference to the first node of the linked string
	 */
	private Node head;
	
	/**
	 * The number of node in this linked string
	 */
	private int count;
	
	/**
	 * Creates an empty linked string.
	 */
	public LinkedString() {
		this("");
	}
	
	/**
	 * Creates a linked string with a reference to a String instance.
	 * @param charStr A reference to a String instance to be used to create a linked list
	 */
	public LinkedString(String charStr) {
		this(charStr.toCharArray());
	}
	
	/**
	 * Creates a linked string with a reference to a char array.
	 * @param charArr A reference to a char array to be used to create a linked list
	 */
	public LinkedString(char[] charArr) {
		// Add Node from tail to head so don't need loop to look through the linked string
		for (int i = charArr.length - 1; i >= 0; i--) {
			if (this.count == 0) {//Empty Linked String
				this.head = new Node(charArr[i], null, null);
			} else {
				this.head = new Node(charArr[i], this.head, null);
				this.head.getNext().setPrevious(this.head);
			}
			this.count++;
		}
	}
	
	/**
	 * Gets the char value at the specified index.
	 * @param index An integer specifying the position of the char value
	 * @return An character specifying the retrieved char value
	 * @throws LinkedStringIndexOutOfBoundsException If index < 0 or index >= length()
	 * @throws LinkedStringException If length() is 0 (If Linked String is empty)
	 */
	public char charAt(int index) throws LinkedStringIndexOutOfBoundsException, LinkedStringException {
		if (this.length() == 0) {
			throw new LinkedStringException("The linked string is empty");
		} else if (index < 0 || index >= this.length()) {
			throw new LinkedStringIndexOutOfBoundsException("The index value must be between 0 and " + (this.count - 1));
		} else {
			int position = 0;
			Node current = this.head;
			while(position != index) {
				position++;
				current = current.getNext();
			}
			return (char)current.getElement();
		}
	}
	
	/**
	 * Concatenates a specified linked string to the end of this linked string.
	 * @param linkedStr A reference to the specified linked string
	 * @return A reference to the concatenated linked string
	 */
	public LinkedString concat(LinkedString linkedStr) {
		
		char[] charArray1 = findAll(this);
		char[] charArray2 = findAll(linkedStr);
		char[] concatCharArray = new char[charArray1.length + charArray2.length];
		for (int i = 0; i < charArray1.length; i++) {
			concatCharArray[i] = charArray1[i];
		}
		for (int i = 0; i < charArray2.length; i++) {
			concatCharArray[i + charArray1.length] = charArray2[i];
		}
		
		/*
		String charString1 = findAll(this);
		String charString2 = findAll(charStr);
		String concatCharString = charString1 + charString2;
		*/
		
		LinkedString concatLinkedString = new LinkedString(concatCharArray);
		return concatLinkedString;
	}
	
	/**
	 * Checks to see if the length of this linked string is 0 (Checks to see if this linked string is empty).
	 * @return A boolean value specifying if the length of this linked string is 0 (if the linked string is empty)
	 */
	public boolean isEmpty() {
		return this.length() == 0;
	}
	
	/**
	 * Checks the length of this linked string.
	 * @return An integer specifying the length of this linked string
	 */
	public int length() {
		return this.count;
	}
	
	/**
	 * Gets a new linked string that is a substring of this linked string.
	 * @param beginIndex An integer specifying the begin position of the new substring linked string of this linked string
	 * @param endIndex An integer specifying the end position (exclusive) of the new substring linked string of this linked string
	 * @return A reference to the new linked string that is a substring of this linked string
	 * @throws LinkedStringIndexOutOfBoundsException If index < 0 or index > length() or beginIndex >= endIndex
	 * @throws LinkedStringException If length() is 0 (If Linked String is empty)
	 */
	public LinkedString substring(int beginIndex, int endIndex) throws LinkedStringIndexOutOfBoundsException, LinkedStringException {
		if (this.length() == 0) {
			throw new LinkedStringException("The linked string is empty");
		} else if (beginIndex < 0 || beginIndex > this.length() || endIndex < 0 || endIndex > this.length() || beginIndex >= endIndex) {
			throw new LinkedStringIndexOutOfBoundsException("The index value must be between 0 and " + this.count + ", and the beginIndex should be smaller than the endIndex.");
		} else {
			char[] charArray = findAll(this);
			char[] subCharArray = new char[endIndex - beginIndex];
			for (int i = beginIndex; i < endIndex; i++) {
				subCharArray[i - beginIndex] = charArray[i];
			}
			
			/*
			String charString = findAll(this);
			String subCharString = charString.substring(beginIndex, endIndex);
			*/
			LinkedString subLinkedString = new LinkedString(subCharArray);
			return subLinkedString;
		}
	}
	
	/**
	 * Helper method to get all the elements of the nodes in a linked string and convert them to char array in order.
	 * @param linkedStr A reference to the linked string
	 * @return A reference to the char array
	 */
	private char[] findAll(LinkedString linkedStr) {
		StringBuilder charString = new StringBuilder();
		Node current = linkedStr.head;
		while(current != null) {
			charString.append(current.getElement().toString());
			current = current.getNext();
		}
		return charString.toString().toCharArray();
	}
	
	/**
	 * Converts this Linked String to String for printing it.
	 * @return A reference to the string
	 */
	public String toString() {
		StringBuilder outputResult = new StringBuilder();
//		outputResult.append("Linked String head side: Null<--");
		Node current = this.head;
		while(current != null) {
			outputResult.append(current.getElement().toString());
			current = current.getNext();
//			if(current != null) {
//				outputResult.append("<-->");
//			}
		}
//		outputResult.append("-->Null");
		return outputResult.toString();
	}
}
