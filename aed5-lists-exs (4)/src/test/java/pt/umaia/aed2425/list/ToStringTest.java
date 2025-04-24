package pt.umaia.aed2425.list;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToStringTest {

	protected <E> LinkedList<E> makeList() {

		return new LinkedList<>();
	}

	@Test
	void testToStringWithMultipleStrings() {

		LinkedList<String> list = makeList();
		list.add(0, "algoritmos");
		list.add(1, "e");
		list.add(2, "estruturas");
		list.add(3, "de");
		list.add(4, "dados");

		String expected = "[ algoritmos e estruturas de dados ]";
		assertEquals(expected, list.toString());
	}

	@Test
	void testToStringWithEmptyList() {

		LinkedList<String> list = makeList();

		String expected = "[ ]";
		assertEquals(expected, list.toString());
	}

	@Test
	void testToStringWithSpaces() {

		LinkedList<String> list = makeList();
		list.add(0, " ");
		list.add(0, " ");
		list.add(0, " ");

		String expected = "[       ]";
		assertEquals(expected, list.toString());
	}

	@Test
	void testToStringWithIntegersInReverseOrder() {

		LinkedList<Integer> list = makeList();
		list.add(0, 1);
		list.add(0, 2);
		list.add(0, 3);
		list.add(0, 4);
		list.add(0, 5);
		list.add(0, 6);
		list.add(0, 7);
		list.add(0, 8);
		list.add(0, 9);
		list.add(0, 10);

		String expected = "[ 10 9 8 7 6 5 4 3 2 1 ]";
		assertEquals(expected, list.toString());
	}

	@Test
	void testToStringWithIntegersInOrder() {

		LinkedList<Integer> list = makeList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);
		list.add(5, 6);
		list.add(6, 7);
		list.add(7, 8);
		list.add(8, 9);
		list.add(9, 10);

		String expected = "[ 1 2 3 4 5 6 7 8 9 10 ]";
		assertEquals(expected, list.toString());
	}

	@Test
	void testToStringWithSingleDouble() {

		LinkedList<Double> list = makeList();
		list.add(0, 1.42);

		String expected = "[ 1.42 ]";
		assertEquals(expected, list.toString());
	}

	@Test
	void testToStringWithNestedLists() {

		LinkedList<String> list1 = makeList();
		list1.add(0, "algoritmos");
		LinkedList<String> list2 = makeList();
		list2.add(0, "e");
		LinkedList<String> list3 = makeList();
		list3.add(0, "estruturas");
		LinkedList<String> list4 = makeList();
		list4.add(0, "de");
		LinkedList<String> list5 = makeList();
		list5.add(0, "dados");

		LinkedList<LinkedList<String>> list = makeList();
		list.add(0, list1);
		list.add(1, list2);
		list.add(2, list3);
		list.add(3, list4);
		list.add(4, list5);

		String expected = "[ [ algoritmos ] [ e ] [ estruturas ] [ de ] [ dados ] ]";
		assertEquals(expected, list.toString());
	}


	@Test
	void testToStringWithLargeNumberOfElements() {

		LinkedList<Integer> list = makeList();

		for (int i = 0; i < 100; i++) {
			list.add(0, i);
		}

		String expected = "[ 99 98 97 96 95 94 93 92 91 90 89 88 87 86 85 84 83 82 81 80 79 78 77 76 75 74 73 72 71 70 69 68 67 66 65 64 63 62 61 60 59 58 57 56 55 54 53 52 51 50 49 48 47 46 45 44 43 42 41 40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 ]";
		assertEquals(expected, list.toString());
	}

}
