/**LikedList nodes
 * @elyssaKiva
 * @version 1
 */
package datastructures;
public class LinkedListNode<T> {
	private T data;
	private LinkedListNode<T> next;

	/**
	 * Set the data stored at this node.
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Get the data stored at this node.
	 */
	public T getData() {
		return data;

	}

	/**
	 * Set the next pointer to passed node.
	 */
	public void setNext(LinkedListNode<T> node) {
		next = node;

	}

	/**
	 * Get (pointer to) next node.
	 */
	public LinkedListNode<T> getNext() {
		return next;
	}

	/**
	 * Returns a String representation of this node.
	 */
	public String toString() {
		return data.toString();

	}

}
