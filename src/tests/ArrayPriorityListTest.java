package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import model.ArrayPriorityList;
import model.PriorityList;

/**
 * This unit test is for a generic collection that stores elements where indexes
 * represent priorities and the priorities can change in several ways.
 * ArrayPriortityList<E> uses an Object[] to store the elements.
 *
 * @author Omar R. Gebril
 *
 * @param <E>
 *            The type of all elements stored in this collection
 */
// You will have add JUnit 4 to the build path. The shortcut: hover over @Test
public class ArrayPriorityListTest {

	@Test
	public void testInsertToLeft() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		assertTrue(list.isEmpty());
		list.insertElementAt(0, "First");
		// Must shift array elements in this case
		list.insertElementAt(0, "New First");
		assertFalse(list.isEmpty());
		assertEquals("New First", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));
		list.insertElementAt(0, "Newer First");
		assertEquals("Newer First", list.getElementAt(0));
		list.insertElementAt(0, "1");
		list.insertElementAt(0, "2");
		list.insertElementAt(0, "3");
		list.lowerPriorityOf(1);
		assertEquals("1", list.getElementAt(1));
		assertEquals("2", list.getElementAt(2));
		list.insertElementAt(0, "4");
		list.insertElementAt(0, "5");
		list.raisePriorityOf(1);
		assertEquals("4", list.getElementAt(0));
		assertEquals("5", list.getElementAt(1));
		list.insertElementAt(0, "6");
		list.insertElementAt(0, "7");
		list.insertElementAt(0, "8");
		list.insertElementAt(0, "9");
		list.insertElementAt(0, "10");
		list.insertElementAt(0, "11");
		list.insertElementAt(0, "12");
		list.insertElementAt(0, "13");
		list.insertElementAt(1, "14");
		list.insertElementAt(0, "15");
		list.insertElementAt(0, "16");
		list.insertElementAt(0, "17");
		list.insertElementAt(0, "18");
		list.insertElementAt(0, "19");
		list.insertElementAt(0, "20");
		list.insertElementAt(0, "21");
		list.insertElementAt(0, "22");
		assertEquals("22", list.getElementAt(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMoveToTop() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		// Must shift array elements in this case
		list.insertElementAt(0, "New First");
		assertEquals("New First", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));
		list.insertElementAt(0, "Newer First");
		assertEquals("Newer First", list.getElementAt(0));
		list.moveToTop(2);
		assertEquals("First", list.getElementAt(0));
		assertEquals("Newer First", list.getElementAt(1));
		assertEquals("New First", list.getElementAt(2));
		assertEquals(3, list.size());
		list.moveToTop(4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMoveToLast() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		// Must shift array elements in this case
		list.insertElementAt(0, "New First");
		assertEquals("New First", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));
		list.insertElementAt(0, "Newer First");
		assertEquals("Newer First", list.getElementAt(0));
		list.moveToLast(0);
		assertEquals("New First", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));
		assertEquals("Newer First", list.getElementAt(2));
		assertEquals(3, list.size());
		list.moveToLast(3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveElementAt() {
		PriorityList<Integer> list = new ArrayPriorityList<Integer>();
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
		list.removeElementAt(4);
	}

	@Test
	public void testToArray() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		assertTrue(list.isEmpty());
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "Second");
		list.insertElementAt(0, "Third");
		list.insertElementAt(0, "Fourth");
		list.insertElementAt(0, "Fifth");
		list.insertElementAt(0, "Sixth");
		Object[] x = list.toArray();
		assertEquals("Sixth", x[0]);
		assertEquals("Fifth", x[1]);
		assertEquals("Fourth", x[2]);
		assertEquals("Third", x[3]);
		assertEquals("Second", x[4]);
		assertEquals("First", x[5]);
		assertEquals(6, x.length);

	}

	// Write short test methods to ensure methods throw exceptions
	// when they are supposed to throw new IllegalArgumentException();
	// Please read the specs for what is illegal. Methods differ.
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionGetElementAtZeroWhenSizeIsZero() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.getElementAt(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionInsertElementAtIndexOutOfRange() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(-1, "New First");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLowerPriority() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.lowerPriorityOf(1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRaisePriority() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.raisePriorityOf(1);
	}
}
