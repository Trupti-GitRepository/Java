/**
 * The external Tree Node for Linked Trees
 * @author Trupti Thakur
 *
 * @param <T>
 */


public class TreeNode<T> {
	private T data;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param node the data to be stored in the TreeNode

	 */
	public TreeNode(T dataNode) {
		data=dataNode;
	}

	/**
	 * used for making deep copies
	 * @param node - node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		data=node.getData();
		leftChild=node.getLeftChild();
		rightChild=node.getRightChild();
	}

	/**
	 * Return the data within this TreeNode.
	 * @return the data within the TreeNode
	 */
	public T getData() {
		return data;
	}

	/**
	 * Return the data within this TreeNode
	 * @return the data within the leftChild of TreeNode
	 */
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * Return the data within this TreeNode
	 * @return the data within the rightChild of TreeNode
	 */
	public TreeNode<T> getRightChild() {
		return rightChild;
	}
	
	
	/**
	 * set the leftChild
	 * @param leftChild
	 */
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild=leftChild;
	}
	
	
	/**
	 * set the rightChild
	 * @param rightChild
	 */
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild=rightChild;
	}

}
