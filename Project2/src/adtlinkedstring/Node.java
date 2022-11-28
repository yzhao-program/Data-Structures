package adtlinkedstring;

/**
 * Represents a node in a linked string.
 * @author ylzhao
 * @version 1.0
 */
public class Node {
	
	/**
	 * The element of this node
	 */
	private Object element;
	/**
	 * The link to next node
	 */
	private Node next;
	/**
	 * The link to previous node
	 */
	private Node previous;

	/**
	 * Constructs a default node.
	 */
	public Node() {
		this(null, null, null);
	}  
	/**
	 * Constructs a node with an element and link to a null node.
	 * @param element A reference to the element of this node
	 */
	public Node(Object element) {
		this(element, null, null);
	}  
	/**
	 * Constructs a node with an element and a link to next node.
	 * @param element A reference to the element of this node
	 */
	/**
	 * Constructs a node with an element and a link to next node.
	 * @param element A reference to the element of this node
	 * @param next A reference to the next node of this node
	 */
	public Node(Object element, Node next) {
		this(element, next, null);
    }
	/**
	 * Constructs a node with an element and two links to next node and previous node.
	 * @param element A reference to the element of this node
	 * @param next A reference to the next node of this node
	 * @param previous A reference to the previous node of this node
	 */
	public Node(Object element, Node next, Node previous) {
		this.element = element;
		this.next = next;
		this.previous = previous;
	}
	
	
	/**
	 * Returns the element of this node.
	 * @return The element of this node
	 */
	public Object getElement() {
		return this.element;
	}
	
	/**
	 * Changes the element of this node.
	 * @param A reference to an element
	 */
	public void setElement(Object element) {
		this.element = element;
	}
	
	/**
	 * Returns the next reference of this node.
	 * @return A reference to the next node of this node
	 */
	public Node getNext() {
		return this.next;
	}
	
	/**
	 * Changes the next reference of this node
	 * @param next A reference to the next node of this node
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	
	/**
	 * Returns the previous reference of this node.
	 * @return A reference to the previous node of this node
	 */
	public Node getPrevious() {
		return this.previous;
	}
	
	/**
	 * Changes the previous reference of this node
	 * @param previous A reference to the previous node of this node
	 */
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	/**
	 * Returns a string representation of this node.
	 * @return A string representation of this node
	 */
	public String toString(){
		return getClass().getSimpleName() + ": " + this.element;
	}

}
