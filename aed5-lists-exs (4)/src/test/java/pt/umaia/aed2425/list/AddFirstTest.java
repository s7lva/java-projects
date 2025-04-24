package pt.umaia.aed2425.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddFirstTest {

	protected <E> LinkedList<E> makeList() {

		return new LinkedList<>();
	}

	@Test
	void testAddToEmpty() {

		LinkedList<String> list = makeList();

		String stringToInsert = "first";

		assertEquals(0, list.size());

		list.addFirst(stringToInsert);

		assertEquals(1, list.size());
		assertEquals(stringToInsert, list.get(0));
	}

	@Test
	void testAddFirstToOneElementList() {
		LinkedList<String> list = makeList();
		list.add(0, "existing");

		String stringToInsert = "first";

		list.addFirst(stringToInsert);

		assertEquals(2, list.size());
		assertEquals(stringToInsert, list.get(0));
		assertEquals("existing", list.get(1));
	}

	@Test
	void testAddFirstToMultipleElementsList() {
		LinkedList<String> list = makeList();
		list.add(0, "one");
		list.add(1, "two");
		list.add(2, "three");

		String stringToInsert = "first";

		list.addFirst(stringToInsert);

		assertEquals(4, list.size());
		assertEquals(stringToInsert, list.get(0));
		assertEquals("one", list.get(1));
		assertEquals("two", list.get(2));
		assertEquals("three", list.get(3));
	}

	@Test
	void testAddToLonger() {

		LinkedList<String> list = makeList();
		list.add(0, "algoritmos");
		list.add(1, "e");
		list.add(2, "estruturas");
		list.add(3, "de");
		list.add(4, "dados");

		String stringToInsert = "UC:";

		assertEquals(5, list.size());

		list.addFirst(stringToInsert);

		assertEquals(6, list.size());
		assertEquals(stringToInsert, list.get(0));
		assertEquals("algoritmos", list.get(1));
	}

	@Test
	void testAddFirstWithIntegers() {
		LinkedList<Integer> list = makeList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);

		Integer intToInsert = 0;

		list.addFirst(intToInsert);

		assertEquals(4, list.size());
		assertEquals(intToInsert, list.get(0));
		assertEquals(1, list.get(1));
		assertEquals(2, list.get(2));
		assertEquals(3, list.get(3));
	}

	@Test
	void testAddFirstWithDoubles() {
		LinkedList<Double> list = makeList();
		list.add(0, 1.1);
		list.add(1, 2.2);
		list.add(2, 3.3);

		Double doubleToInsert = 0.0;

		list.addFirst(doubleToInsert);

		assertEquals(4, list.size());
		assertEquals(doubleToInsert, list.get(0));
		assertEquals(1.1, list.get(1));
		assertEquals(2.2, list.get(2));
		assertEquals(3.3, list.get(3));
	}

	@Test
	void testAddFirstWithBooleans() {
		LinkedList<Boolean> list = makeList();
		list.add(0, true);
		list.add(1, false);
		list.add(2, true);

		Boolean boolToInsert = false;

		list.addFirst(boolToInsert);

		assertEquals(4, list.size());
		assertEquals(boolToInsert, list.get(0));
		assertEquals(true, list.get(1));
		assertEquals(false, list.get(2));
		assertEquals(true, list.get(3));
	}
}
