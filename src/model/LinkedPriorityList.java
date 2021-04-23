package model;

/**
 * This class implements a generic collection to store elements where indexes
 * represent priorities and the priorities can change in several ways.
 *
 * @author Omar R. Gebril
 *
 * @param <E>
 *            The type of all elements stored in this collection
 */
// There will be an error here until you implement all methods of PriorityList.
// Here is a shortcut to get started:
// 1. Hover over ArrayPriorityList
// 2. Select Add unimplemented methods
// 3. Copy and paste the comments, or preferable retype them
public class LinkedPriorityList<E> implements PriorityList<E> {

	// This private inner class saves lots of typing and is hidden from outsiders
	private class Node {

		// These instance variables can be accessed from the enclosing class
		private E data;
		private Node next;

		private Node(E element, Node link) {
			data = element;
			next = link;
		}
	}

	// These instance variables belong to the enclosing class LinkedPriorityList
	private Node first;
	private int size;

	// Create an empty list with zero elements
	public LinkedPriorityList() {
		first = new Node(null, null);
		size = 0;
	}

	/**
	 * Return the number of elements currently in this PriorityList
	 * 
	 * @return The number of elements in this PriorityList
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Return true if there are zero elements in this PriorityList
	 * 
	 * @return true if size() == 0 or false if size() > 0
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * If possible, insert the element at the given index. If index is out of the
	 * valid range of 0..size(), throw new IllegalArgumentException(); When size is
	 * 3, the only possible values for index are 0, 1, 2, AND 3 because you can add
	 * an element as the new last.
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @param el
	 *            The element to insert
	 * @throws IllegalArgumentException
	 */
	@Override
	public void insertElementAt(int index, E el) throws IllegalArgumentException {
		if (index < 0 || index > size()) {
			throw new IllegalArgumentException();
		}

		if (isEmpty()) {
			first.next = new Node(el, null);
			size++;
		} else {
			int i = 0;
			Node prev = first;
			Node curr = first.next;
			while (i < index) {
				prev = curr;
				curr = curr.next;
				i++;
			}
			prev.next = new Node(el, curr);
			size++;
		}
	}

	/**
	 * If possible, return a reference to the element at the given index. If index
	 * is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @return A reference to the element at index index.
	 * @throws IllegalArgumentException
	 */
	@Override
	public E getElementAt(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size()) {
			throw new IllegalArgumentException();
		}
		Node curr = first.next;
		int i = 0;
		while (i < index) {
			curr = curr.next;
			i++;
		}
		return (E) curr.data;
	}

	/**
	 * If possible, remove the element at the given index. If index is out of the
	 * valid range of 0..size()-1, throw new IllegalArgumentException(); When size
	 * is 3, the only possible values for index are 0, 1, and 2.
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	@Override
	public void removeElementAt(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size()) {
			throw new IllegalArgumentException();
		}
		Node curr = first.next;
		Node prev = first;
		int i = 0;
		while (i < index) {
			prev = curr;
			curr = curr.next;
			i++;
		}
		prev.next = curr.next;
		curr = prev;
		size--;

	}

	/**
	 * If possible, swap the element located at index with the element at index + 1.
	 * An attempt to lower the priority of the element at index size()-1 has no
	 * effect. If index is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 * 
	 * @param index
	 *            The index of the element to move
	 * @throws IllegalArgumentException
	 */
	@Override
	public void lowerPriorityOf(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size()) {
			throw new IllegalArgumentException();
		}
		Node curr = first.next;
		for (int z = 0; z < index; z++) {
			curr = curr.next;
		}

		Node curr2 = first.next;
		for (int q = 0; q < index + 1; q++) {
			curr2 = curr2.next;
		}

		E element = curr.data;
		E element2 = curr2.data;
		curr.data = element2;
		curr2.data = element;
	}

	/**
	 * If possible, swap the element located at index with the element at index-1.
	 * An attempt to raise the priority at index 0 has no effect. If index is out of
	 * the valid range of 0..size()-1, throw new IllegalArgumentException(); When
	 * size is 3, the only possible values for index are 0, 1, and 2.
	 * 
	 * @param index
	 *            The index of the element to move
	 * @throws IllegalArgumentException
	 */
	@Override
	public void raisePriorityOf(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size()) {
			throw new IllegalArgumentException();
		}
		Node curr = first.next;
		for (int z = 0; z < index; z++) {
			curr = curr.next;
		}

		Node curr2 = first.next;
		for (int q = 0; q < index - 1; q++) {
			curr2 = curr2.next;
		}

		E element = curr.data;
		E element2 = curr2.data;
		curr.data = element2;
		curr2.data = element;
	}

	/**
	 * Return a copy of all elements as an array of Objects that is the size of this
	 * PriorityList and in the same order. If there are no elements in this list,
	 * return new Object[0]; A change to the return value must not affect this
	 * PriorityList object.
	 * 
	 * @return An array of Objects where capacity == size()
	 */
	@Override
	public Object[] toArray() {
		Object[] temp = new Object[size()];
		Node curr = first.next;
		int i = 0;
		while (curr != null) {
			temp[i] = curr.data;
			i++;
			curr = curr.next;
		}
		return temp;
	}

	/**
	 * If possible, move the element at the given index to the end of this list. An
	 * attempt to move the last element to the last has no effect. If the index is
	 * out of the valid range 0..size()-1 throw new IllegalArgumentException(); When
	 * size is 3, the only possible values for index are 0, 1, and 2.
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	@Override
	public void moveToLast(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size()) {
			throw new IllegalArgumentException();
		}
		if (index < size() - 1) {
			Node curr = first.next;
			Node prev = first;
			for (int i = 0; i < index; i++) {
				prev = curr;
				curr = curr.next;
			}
			prev.next = curr.next;
			Node element = curr;
			int j = index;
			while (j < size) {
				prev = curr;
				curr = curr.next;
				j++;
			}
			prev.next = element;
		}

	}

	/**
	 * If possible, move the element at the given index to the front of this list An
	 * attempt to move the top element to the top has no effect. If the index is out
	 * of the valid range of 0..size()-1, throw new IllegalArgumentException(); When
	 * size is 3, the only possible values for index are 0, 1, and 2.
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	@Override
	public void moveToTop(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size()) {
			throw new IllegalArgumentException();
		}
		if (index > 0) {
			Node curr = first.next;
			Node prev = first;
			Node element = first.next;
			for (int i = 0; i < index; i++) {
				prev = curr;
				curr = curr.next;
			}
			prev.next = curr.next;
			// Node element = first.next;
			first.next = curr;
			curr.next = element;
		}
	}
}
