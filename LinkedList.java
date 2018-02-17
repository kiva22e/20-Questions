/**liked list class
 * @elyssaKiva
 * @version 1
 */
package datastructures;
public class LinkedList<T> implements List<T> {
	private LinkedListNode<T> head;

	/**
	 * Add (insert) data at specific index in list, e.g., add( 0, data ) inserts
	 * data to front/head of list
	 **/
	public void add(int index, T data) {
		if (head == null) {
			head = new LinkedListNode<T>();
			head.setData(data);
		} else {
			LinkedListNode<T> start = head;
			if (index == 0) {
				LinkedListNode<T> newValue = new LinkedListNode<T>();
				newValue.setData(data);
				newValue.setNext(start);
				head = newValue;
			} else {
				for (int i = 0; i < index - 1; i++) {
					start = start.getNext();
				}
				LinkedListNode<T> newValue = new LinkedListNode<T>();
				newValue.setData(data);
				newValue.setNext(start.getNext());
				start.setNext(newValue);

			}
		}

	}

	/**
	 * Get data stored at specific index in list.
	 **/
	public T get(int index) {
		if (head == null) {
			return null;
		} else {
			LinkedListNode<T> start = head;
			for (int i = 0; i < index; i++) {
				start = start.getNext();
			}
			if (start == null) {
				return null;
			} else {
				return start.getData();
			}
		}

	}

	/**
	 * Delete data at specific index in list, e.g., delete( 0 ) removes the
	 * first element from the list
	 **/
	public void delete(int index) {
		if (head != null) {
			if (index == 0) {
				head=head.getNext();
			} else {
				LinkedListNode<T> start = head;
				for (int i = 0; i < index-1; i++) {
					start = start.getNext();
				}
				LinkedListNode<T> end = start;
				for (int i = 0; i < 2; i++) {
					end = end.getNext();
				}
				LinkedListNode<T>mid=start.getNext();
				mid=null;
				start.setNext(end);
			}
		}

	}

	/**
	 * Get the number of elements in this list.
	 **/
	public int size() {
		LinkedListNode<T> start = head;
		int counter = 1;
		if (head == null) {
			return 0;
		} else {
			while (start.getNext() != null) {
				start = start.getNext();
				counter += 1;
			}
		}

		return counter;
	}

	/**
	 * Check if the list is empty.
	 **/
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}

		return false;
	}
	public String toString() {
        String result = "";
        LinkedListNode current = head;
        result+=current.getData() + " ";
        while(current.getNext() != null){
            current = current.getNext();
            result += current.getData() + " ";
        }
        return "List: " + result;
}

	public LinkedListNode<T> getFirstNode() {
		// TODO Auto-generated method stub
		return head;
	}

	

}
