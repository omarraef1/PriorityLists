package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import model.ArrayPriorityList;
import model.LinkedPriorityList;
import model.PriorityList;

/**
 * This unit test is for a generic collection that stores elements where indexes
 * represent priorities and the priorities can change in several ways.
 * LinkedPriortityList<E> uses a singly linked data structure to store the
 * elements.
 *
 * @author Omar R. Gebril
 *
 * @param <E>
 *            The type of all elements stored in this collection
 */

// You will have add JUnit 4 to the build path. The shortcut: hover over @Test
public class LinkedPriorityListTest {

	@Test(expected = IllegalArgumentException.class)
	public void testInsertToLeftandSizeandisEmptyandgetElementAtandraisePriorityOfandlowerPriorityOf() {
		PriorityList<String> list = new LinkedPriorityList<String>();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		list.insertElementAt(0, "First");
		// Must shift array elements in this case
		list.insertElementAt(1, "New First");
		list.insertElementAt(2, "Newer First");
		list.insertElementAt(3, "Even Newer First");
		list.insertElementAt(4, "Newest First");
		assertEquals(5, list.size());
		assertFalse(list.isEmpty());
		assertEquals("First", list.getElementAt(0));
		assertEquals("New First", list.getElementAt(1));
		list.removeElementAt(1);
		assertEquals("First", list.getElementAt(0));
		assertEquals("Newer First", list.getElementAt(1));
		assertEquals("Even Newer First", list.getElementAt(2));
		assertEquals("Newest First", list.getElementAt(3));
		assertEquals(4, list.size());
		list.lowerPriorityOf(2);
		assertEquals("Newest First", list.getElementAt(2));
		assertEquals("Even Newer First", list.getElementAt(3));
		assertEquals(4, list.size());
		list.raisePriorityOf(3);
		assertEquals("Even Newer First", list.getElementAt(2));
		assertEquals("Newest First", list.getElementAt(3));
		assertEquals(4, list.size());
		list.insertElementAt(-1, "Illegal index, throw error");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveElementAt() {
		PriorityList<Integer> list = new LinkedPriorityList<Integer>();
		list.insertElementAt(0, 1);
		list.insertElementAt(0, 2);
		list.insertElementAt(0, 3);
		list.insertElementAt(0, 4);
		assertEquals(4, list.size());
		list.removeElementAt(2);
		list.getElementAt(0);
		assertEquals(4, (int) list.getElementAt(0));
		assertEquals(3, (int) list.getElementAt(1));
		assertEquals(1, (int) list.getElementAt(2));
		assertEquals(3, list.size());
		list.removeElementAt(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMoveToLast() {
		PriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "Second");
		list.insertElementAt(0, "Third");
		list.insertElementAt(0, "Fourth");
		list.moveToLast(0);
		assertEquals("Third", list.getElementAt(0));
		assertEquals("Fourth", list.getElementAt(3));
		list.moveToLast(1);
		assertEquals("First", list.getElementAt(1));
		assertEquals("Second", list.getElementAt(3));
		list.moveToLast(-1);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testMoveToTop() {
		PriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "Second");
		list.insertElementAt(0, "Third");
		list.insertElementAt(0, "Fourth");
		list.moveToTop(3);
		assertEquals("First", list.getElementAt(0));
		assertEquals("Second", list.getElementAt(3));
		list.moveToTop(4);
	}

	@Test
	public void testToArray() {
		PriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "Second");
		list.insertElementAt(0, "Third");
		Object[] x = list.toArray();
		assertEquals("Third", x[0]);
		assertEquals("Second", x[1]);
		assertEquals("First", x[2]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testraisePriorityExceptionThrowing() {
		PriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "Second");
		list.insertElementAt(0, "Third");
		list.raisePriorityOf(4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLowerPriorityExceptionThrowing() {
		PriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "Second");
		list.insertElementAt(0, "Third");
		list.lowerPriorityOf(4);
	}

	// Write short test methods to ensure methods throw exceptions
	// when they are supposed to throw new IllegalArgumentException();
	// Please read the specs for what is illegal. Methods differ.
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionGetElementAtZeroWhenSizeIsZero() {
		PriorityList<String> list = new LinkedPriorityList<String>();
		list.getElementAt(0);
	}
}
