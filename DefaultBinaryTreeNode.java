/**
 * 
 * @author elyssakiva
 *
 */
package datastructures;
public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T> {
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T node;

	/**
	 * Get the data stored at this node.
	 * 
	 * @return Object data.
	 */
	public T getData() {

		return node;
	}

	/**
	 * Set the data stored at this node.
	 */
	public void setData(T data) {
		node=data;
	}

	/**
	 * Get the left child.
	 * 
	 * @return BinaryTreeNode that is left child, or null if no child.
	 */
	public BinaryTreeNode<T> getLeftChild() {
		return left;
	}

	/**
	 * Get the right child.
	 * 
	 * @return BinaryTreeNode that is right child, or null if no child.
	 */
	public BinaryTreeNode<T> getRightChild() {
		return right;
	}

	/**
	 * Set the left child.
	 */
	public void setLeftChild(BinaryTreeNode<T> left) {
		this.left=left;

	}

	/**
	 * Set the right child.
	 */
	public void setRightChild(BinaryTreeNode<T> right) {
		this.right=right;

	}

	/**
	 * Tests if this node is a leaf (has no children).
	 * 
	 * @return true if leaf node.
	 */
	public boolean isLeaf() {
		if(getRightChild()==null && getLeftChild()==null){
			return true;
		}
		return false;
	}

}
