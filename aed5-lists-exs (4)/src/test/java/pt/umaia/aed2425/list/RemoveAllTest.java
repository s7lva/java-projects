package pt.umaia.aed2425.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RemoveAllTest {

	protected <E> LinkedList<E> makeList() {

		return new LinkedList<>();
	}

	@Test
	void testRemoveAllEmpty() {

		LinkedList<String> list = makeList();

		assertEquals(0, list.size());

		list.removeAll("test string");

		assertEquals(0, list.size());
	}

	@Test
	void testRemoveAllSingleElement() {
		LinkedList<String> list = makeList();
		list.add(0, "test string");

		assertEquals(1, list.size());

		list.removeAll("test string");

		assertEquals(0, list.size());
	}

	@Test
	void testRemoveAllAllEqualElements() {
		LinkedList<String> list = makeList();
		list.add(0, "test string");
		list.add(0, "test string");
		list.add(0, "test string");

		assertEquals(3, list.size());

		list.removeAll("test string");

		assertEquals(0, list.size());
	}

	@Test
	void testRemoveAllElementNotPresent() {
		LinkedList<String> list = makeList();
		list.add(0, "element 1");
		list.add(1, "element 2");
		list.add(2, "element 3");

		assertEquals(3, list.size());

		list.removeAll("test string");

		assertEquals(3, list.size());
	}

	@Test
	void testRemoveAllWithLargeNumberOfElements() {
		LinkedList<Integer> list = makeList();

		for (int i = 0; i < 1000; i++) {
			list.add(i, i);
		}

		assertEquals(1000, list.size());
		assertEquals(500, list.get(500));

		list.removeAll(500);

		assertNotEquals(500, list.get(500));
		assertEquals(999, list.size());
	}

	@Test
	void testRemoveAllFromListOfLists() {
		LinkedList<LinkedList<String>> listOfLists = makeList();

		LinkedList<String> sublist1 = makeList();
		sublist1.add(0, "element 1");
		sublist1.add(1, "element 2");

		LinkedList<String> sublist2 = makeList();
		sublist2.add(0, "element 3");
		sublist2.add(1, "element 4");

		listOfLists.add(0, sublist1);
		listOfLists.add(1, sublist2);

		assertEquals(2, listOfLists.size());

		listOfLists.removeAll(sublist1);

		assertEquals(1, listOfLists.size());
		assertEquals(sublist2, listOfLists.get(0));
	}

	@Test
	void testRemoveAllLastElement() {
		LinkedList<String> list = makeList();
		list.add(0,"element 1");
		list.add(1,"element 2");
		list.add(2,"element 3");

		assertEquals(3, list.size());

		list.removeAll("element 3");

		assertEquals(2, list.size());
		assertEquals("element 1", list.get(0));
		assertEquals("element 2", list.get(1));
	}
}
