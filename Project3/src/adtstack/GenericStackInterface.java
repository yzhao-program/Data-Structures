package adtstack;

/**
 * Specifications of common operations of a stack. 
 * @author ylzhao
 * @version 1.0
 */
public interface GenericStackInterface<E>{
	
	/**
	 * Checks the number of objects of this stack.
	 * Precondition: None.
	 * Postcondition: Returns the integer which indicate the number of objects of this stack.
	 * @return An integer specifying the number of objects of this stack
	 */
	public int getSize();
	
	/**
	 * Retrieve a reference to the top element of this stack
	 * Precondition: None.
	 * Postcondition: If the stack is not empty, the item that was added most recently is returned. The stack is unchanged.
	 * @return A reference to the item that was added most recently
	 * @throws StackException If the stack is empty
	 */
	public E peek() throws StackException;
	
	/**
	 * Add an object to the top of this stack.
	 * Precondition: New item is the item to be added.
	 * Postcondition: If insertion is successful, item is on the top of the stack.
	 * @param o An item to be added to the stack.
	 */
	public void push(E o);
	
	/**
	 * Remove from the top of this stack.
	 * Precondition: None.
	 * Postcondition: If the stack is not empty, the item that was added most recently is removed from the stack and returned.
	 * @return The item that was most recently added to this stack.
	 * @throws StackException If the stack is empty.
	 */
	public E pop() throws StackException;
	
	/**
	 * Indicate whether this stack is empty.
	 * Precondition: None.
	 * Postcondition: Returns true if the stack is empty; otherwise returns false.
	 * @return A boolean value specifying if this stack is empty.
	 */
	public boolean isEmpty();
	
}
