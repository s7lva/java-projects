package pt.umaia.aed2425.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicateTest {

	protected <E> LinkedList<E> makeList() {

		return new LinkedList<>();
	}

	@Test
	void testDuplicateEmpty() {

		LinkedList<String> list = makeList();

		assertEquals(0, list.size());

		list.duplicate();

		assertEquals(0, list.size());
	}

	@Test
	void testDuplicateSingleElement() {
		LinkedList<String> list = makeList();
		list.add(0, "test string");

		assertEquals(1, list.size());

		list.duplicate();

		assertEquals(2, list.size());
		assertEquals("test string", list.get(0));
		assertEquals("test string", list.get(1));
	}

	@Test
	void testDuplicateMultipleElements() {
		LinkedList<String> list = makeList();
		list.add(0, "element 1");
		list.add(1, "element 2");
		list.add(2, "element 3");

		assertEquals(3, list.size());

		list.duplicate();

		assertEquals(6, list.size());
		assertEquals("element 1", list.get(0));
		assertEquals("element 1", list.get(1));
		assertEquals("element 2", list.get(2));
		assertEquals("element 2", list.get(3));
		assertEquals("element 3", list.get(4));
		assertEquals("element 3", list.get(5));


	}


	@Test
	void testDuplicateWithDuplicateElements() {
		LinkedList<String> list = makeList();
		list.add(0, "duplicate");
		list.add(1, "duplicate");
		list.add(2, "unique");

		assertEquals(3, list.size());

		list.duplicate();

		assertEquals(6, list.size());
		assertEquals("duplicate", list.get(0));
		assertEquals("duplicate", list.get(1));
		assertEquals("duplicate", list.get(2));
		assertEquals("duplicate", list.get(3));
		assertEquals("unique", list.get(4));
		assertEquals("unique", list.get(5));
	}

	@Test
	void testDuplicateWithVaryingLengths() {
		LinkedList<String> list = makeList();
		list.add(0,"short");
		list.add(1,"medium length");
		list.add(2,"a very long string element");

		assertEquals(3, list.size());

		list.duplicate();

		assertEquals(6, list.size());
		assertEquals("short", list.get(0));
		assertEquals("short", list.get(1));
		assertEquals("medium length", list.get(2));
		assertEquals("medium length", list.get(3));
		assertEquals("a very long string element", list.get(4));
		assertEquals("a very long string element", list.get(5));
	}

	@Test
	void testDuplicateNestedLists() {
	    LinkedList<LinkedList<Integer>> listOfLists = makeList();

	    LinkedList<Integer> sublist1 = makeList();
	    sublist1.add(0,1);
	    sublist1.add(1,2);

	    LinkedList<Integer> sublist2 = makeList();
	    sublist2.add(0,3);
	    sublist2.add(1,4);

	    listOfLists.add(0,sublist1);
	    listOfLists.add(1,sublist2);

	    assertEquals(2, listOfLists.size());

	    listOfLists.duplicate();

	    assertEquals(4, listOfLists.size());
	    assertEquals(sublist1, listOfLists.get(0));
	    assertEquals(sublist1, listOfLists.get(1));
	    assertEquals(sublist2, listOfLists.get(2));
	    assertEquals(sublist2, listOfLists.get(3));
	}

	@Test
	void testDuplicateEmptyNestedLists() {
	    LinkedList<LinkedList<Integer>> listOfLists = makeList();

	    LinkedList<Integer> sublist1 = makeList();
	    LinkedList<Integer> sublist2 = makeList();

	    listOfLists.add(0,sublist1);
	    listOfLists.add(0,sublist2);

	    assertEquals(2, listOfLists.size());

	    listOfLists.duplicate();

	    assertEquals(4, listOfLists.size());
		assertEquals(sublist2, listOfLists.get(0));
		assertEquals(sublist2, listOfLists.get(1));
		assertEquals(sublist1, listOfLists.get(2));
		assertEquals(sublist1, listOfLists.get(3));
	}
}
