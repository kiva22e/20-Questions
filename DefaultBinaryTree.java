/**
 * 
 * @author elyssakiva
 *
 */
package datastructures;
public class DefaultBinaryTree<T> implements BinaryTree<T> {
	private BinaryTreeNode<T> root;

	/**
	 * Get the root node for this tree.
	 * 
	 * @return root or null if tree is empty.
	 */
	public BinaryTreeNode<T> getRoot() {

		return root;
	}

	/**
	 * Set the root node for this tree.
	 */
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;

	}

	/**
	 * Test if the tree is empty.
	 * 
	 * @return true if tree has no data.
	 */
	public boolean isEmpty() {
		if (getRoot() == null) {
			return true;
		}
		return false;
	}

	/**
	 * Get the data of this tree using inorder traversal.
	 * 
	 * @return inorder List.
	 */
	public LinkedList<T> inorderTraversal() {
		LinkedList<T> traversal = new LinkedList<T>();
		inorderTraversal(root, traversal);
		System.out.println(traversal.toString());
		return traversal;
	}
	/**
	 * recursive helper method for inorder traversal
	 * @param node
	 * @param traversal
	 */
	private void inorderTraversal(BinaryTreeNode<T> node,
			LinkedList<T> traversal) {
		if(node !=null){
			inorderTraversal(node.getLeftChild(), traversal);
			traversal.add(traversal.size(),node.getData());
			inorderTraversal(node.getRightChild(), traversal);
		}

	}

	/**
	 * Get the data of this tree using preorder traversal.
	 * 
	 * @return preorder List.
	 */
	public LinkedList<T> preorderTraversal() {
		LinkedList<T> traversal = new LinkedList<T>();
		preorderTraversal(root, traversal);
		System.out.println(traversal.toString());
		return traversal;
	}
	/**
	 * recursive helper method for preorder traversal
	 * @param node
	 * @param traversal
	 */
	public void preorderTraversal(BinaryTreeNode<T> node,
			LinkedList<T> traversal){
		if(node !=null){
			traversal.add(traversal.size(),node.getData());
			preorderTraversal(node.getLeftChild(), traversal);
			preorderTraversal(node.getRightChild(), traversal);
			
		}
		
	}
	

	/**
	 * Get the data of this tree using postorder traversal.
	 * 
	 * @return postorder List.
	 */
	public LinkedList<T> postorderTraversal() {
		LinkedList<T> traversal = new LinkedList<T>();
		postorderTraversal(root, traversal);
		System.out.println(traversal.toString());
		return traversal;
	}
	/**
	 * recursive helper method for postorder traversal
	 * @param node
	 * @param traversal
	 */
	private void postorderTraversal(BinaryTreeNode<T> node,
			LinkedList<T> traversal){
		if(node !=null){
			postorderTraversal(node.getLeftChild(), traversal);
			postorderTraversal(node.getRightChild(), traversal);
			traversal.add(traversal.size(),node.getData());
		}
		
	}
	

}
