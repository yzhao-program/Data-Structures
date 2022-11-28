package adtaddressbook;

/**
 * Represents a binary search tree with basic operations such as
 * 1. Replaces the data item in the root of a binary tree with new item, if the tree is not empty.
 * 2. Removes all nodes from this binary search tree.
 * 3. Check how many nodes are there in this binary search tree.
 * 4. Search an element in this binary search tree.
 * 5. Insert an element into this binary search tree.
 * 6. Remove an element from this binary search tree.
 * 7. Get the iterator of this binary search tree.
 * @author ylzhao
 * @version 1.0
 */
public class BinarySearchTree<E extends Comparable<E>> extends BaseBinaryTree<E> {
	
	/**
	 * The number of nodes in this binary search tree
	 */
//	private int size;
	
	/**
	 * A boolean value specifying whether the operation is successful or not
	 */
	private boolean flag = false;
	
	/**
	 * Constructs an empty binary tree.
	 */
	public BinarySearchTree() {
		super();
	}
	
	/**
	 * Constructs a one-node binary search tree whose root contains a root item.
	 * @param rootItem
	 */
	public BinarySearchTree(E rootItem) {
		super(rootItem);
	}
	
	/**
	 * Replaces the data item in the root of a binary tree with new item, if the tree is not empty.
	 * If the tree is empty, creates a root node whose data item is newItem and inserts the new node into the tree.
	 * @param newItem A reference to a new root item
	 */
	public void setRoot(E newItem) {
		if (this.root != null) {
			this.root.setElement(newItem);
		} else {
			this.root = new TreeNode<E>(newItem, null, null);
		}
	}
	
	/**
	 * Removes all nodes from this binary search tree.
	 */
	/*
	public void makeEmpty() {
		this.root = null;
		this.size = 0;
	}
	*/
	
	/**
	 * Check how many nodes are there in this binary search tree
	 * @return An integer specifying how many number of nodes are there in this binary search tree
	 */
	/*
	public int getSize() {
		return this.size;
	}
	*/
	
	/**
	 * Search an element in this binary search tree
	 * @param e A reference to this element
	 * @return A boolean value specifying if this binary search tree has this element.
	 */
	public boolean search(E e) {
		return searchItem(this.root, e);
	}
	
	/**
	 * Helper method for searching an element in this binary search tree recursively
	 * @param node The root node of the current subtree
	 * @param e A reference to this element
	 * @return A boolean value specifying if this binary search tree has this element.
	 */
	private boolean searchItem(TreeNode<E> node, E e) {
		if (node == null) {
			return false;
		}
		
		if(e.compareTo(node.getElement()) == 0) {
			return true;
		} else if(e.compareTo(node.getElement()) < 0) {
			return searchItem(node.getLeft(), e);
		} else {
			return searchItem(node.getRight(), e);
		}
	}
	
	/**
	 * Insert an element into this binary search tree
	 * @param e A reference to this element
	 * @return A boolean value specifying whether the operation is successful or not
	 */
	public boolean insert(E e) {
		this.flag = false;
		this.root = insertItem(this.root, e);
		return this.flag;
	}
	
	/**
	 * Helper method for inserting an element in this binary search tree recursively
	 * @param node The root node of the current subtree
	 * @param e A reference to this element
	 * @return A reference to the new root node of the current subtree after insertion.
	 */
	private TreeNode<E> insertItem(TreeNode<E> node, E e){
		if (node == null) {
//			size++;
			this.flag = true;
			return new TreeNode<E>(e);
		}
		
		if (e.compareTo(node.getElement()) < 0) {
			node.setLeft(insertItem(node.getLeft(), e));
		} else if(e.compareTo(node.getElement()) > 0) {
			node.setRight(insertItem(node.getRight(), e));
		}
		
		return node;
	}
	
	/**
	 * Remove an element from this binary search tree
	 * @param e A reference to this element
	 * @return A boolean value specifying whether the operation is successful or not
	 */
	public boolean remove(E e) {
		this.flag = false;
		this.root = removeItem(this.root, e);
		return this.flag;
	}
	
	/**
	 * Helper method for removing an element in this binary search tree recursively
	 * @param node The root node of the current subtree
	 * @param e A reference to this element
	 * @return A reference to the new root node of the current subtree after remove.
	 */
	private TreeNode<E> removeItem(TreeNode<E> node, E e){
		if (node == null) {
			return null;
		}
		
		if (e.compareTo(node.getElement()) < 0) {
			node.setLeft(removeItem(node.getLeft(), e));
			return node;
		} else if (e.compareTo(node.getElement()) > 0) {
			node.setRight(removeItem(node.getRight(), e));
			return node;
		} else {
			
			if ((node.getLeft() == null) && (node.getRight() == null)) {
//				size--;
				this.flag = true;
				return null;
			} else if (node.getLeft() == null) {
				TreeNode<E> rightNode = node.getRight();
				node.setRight(null);
//				size--;
				this.flag = true;
				return rightNode;
			} else if (node.getRight() == null) {
				TreeNode<E> leftNode = node.getLeft();
				node.setLeft(null);
//				size--;
				this.flag = true;
				return leftNode;
			} else {
				TreeNode<E> predecessor = maximum(node.getLeft());
				predecessor.setLeft(removeMaximum(node.getLeft()));
				predecessor.setRight(node.getRight());
				node.setLeft(null);
				node.setRight(null);
//				size--; This operation is done in removeMaximum(TreeNode<E> node) helper method
				return predecessor;
			}
		}
	}
	
	/**
	 * Helper method for getting the node has the maximum element recursively
	 * @param node The root node of the current subtree
	 * @return A reference to the node has the maximum element
	 */
	private TreeNode<E> maximum(TreeNode<E> node){
		if (node.getRight() == null) {
			return node;
		}
		
		return maximum(node.getRight());
	}
	
	/**
	 * Helper method for removing the node has the maximum element recursively
	 * @param node The root node of the current subtree
	 * @return A reference to the new root node of the current subtree after removing the node has the maximum element
	 */
	private TreeNode<E> removeMaximum(TreeNode<E> node){
		if (node.getRight() == null) {
			TreeNode<E> leftNode = node.getLeft();
			node.setLeft(null);
//			size--;
			this.flag = true;
			return leftNode;
		}
		
		node.setRight(removeMaximum(node.getRight()));
		return node;
	}
	
	/**
	 * Get the iterator of this binary search tree
	 * @return A reference to the iterator
	 */
	public TreeIterator<E> iterator(){
		return new TreeIterator<E>(this);
	}

}
