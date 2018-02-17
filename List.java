/**Interface for linked list
 * 
 * @version 1
 */
package datastructures;
	public interface List<T> {
	 
		/**
		 * Add (insert) data at specific index in list,
		 * e.g., add( 0, data ) inserts data to front/head of list
		 **/
		public void add( int index, T data );
	 
		/**
		 * Get data stored at specific index in list.
		 **/
		public T get( int index );
	 
		/**
		 * Delete data at specific index in list,
		 * e.g., delete( 0 ) removes the first element from the list
		 **/
		public void delete( int index );
	 
		/**
		 * Get the number of elements in this list.
		 **/
		public int size();
	 
		/**
		 * Check if the list is empty.
	 	 **/
		public boolean isEmpty();
	}


