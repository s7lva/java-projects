package pt.umaia.aed2425.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveIfTest {

	protected <E> LinkedList<E> makeList() {

		return new LinkedList<>();
	}

	// Predicates
	public static boolean isEven(Integer i) {
		return i % 2 == 0;
	}

	public static boolean isGreaterThanTen(Integer i) {
		return i > 10;
	}

	public static boolean containsLetterA(String s) {
		return s.contains("a");
	}

	public static boolean isInvalidEmail(String email) {
		return !email.contains("@") || !email.contains(".");
	}

	// Test cases
	@Test
	void testRemoveIfEmpty() {
		LinkedList<String> list = makeList();
		assertEquals(0, list.size());
		list.removeIf(s -> s.equals("hello"));
		assertEquals(0, list.size());
	}

	@Test
	void testRemoveIfEvenNumbers() {
		LinkedList<Integer> list = makeList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);

		assertEquals(5, list.size());

		list.removeIf(RemoveIfTest::isEven);

		assertEquals(3, list.size());
		assertEquals(1, list.get(0));
		assertEquals(3, list.get(1));
		assertEquals(5, list.get(2));
	}

	@Test
	void testRemoveIfGreaterThanTen() {
		LinkedList<Integer> list = makeList();
		list.add(0, 5);
		list.add(1, 15);
		list.add(2, 10);
		list.add(3, 20);

		assertEquals(4, list.size());

		list.removeIf(RemoveIfTest::isGreaterThanTen);

		assertEquals(2, list.size());
		assertEquals(5, list.get(0));
		assertEquals(10, list.get(1));
	}

	@Test
	void testRemoveIfContainsLetterA() {
		LinkedList<String> list = makeList();
		list.add(0, "apple");
		list.add(1, "banana");
		list.add(2, "cherry");
		list.add(3, "date");

		assertEquals(4, list.size());

		list.removeIf(RemoveIfTest::containsLetterA);

		assertEquals(1, list.size());
		assertEquals("cherry", list.get(0));
	}

	@Test
	void testRemoveIfInvalidEmails() {
		LinkedList<String> list = makeList();
		list.add(0, "valid.email@example.com");
		list.add(1, "invalid-email.com");
		list.add(2, "another.valid@example.com");
		list.add(3, "invalid-email@com");
		list.add(4, "valid@domain.com");
		list.add(5, "no-at-sign.com");
		list.add(6, "no-domain@com");
		list.add(7, "valid.email@domain.org");
		list.add(8, "invalid@domain");
		list.add(9, "valid.email@sub.domain.com");

		assertEquals(10, list.size());

		list.removeIf(RemoveIfTest::isInvalidEmail);

		assertEquals(5, list.size());
		assertEquals("valid.email@example.com", list.get(0));
		assertEquals("another.valid@example.com", list.get(1));
		assertEquals("valid@domain.com", list.get(2));
		assertEquals("valid.email@domain.org", list.get(3));
		assertEquals("valid.email@sub.domain.com", list.get(4));
	}

	@Test
	void testRemoveIfNoElementsRemoved() {
		LinkedList<Integer> list = makeList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);

		assertEquals(5, list.size());

		// Predicate that does not match any element
		list.removeIf(RemoveIfTest::isGreaterThanTen);

		assertEquals(5, list.size());
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));
		assertEquals(3, list.get(2));
		assertEquals(4, list.get(3));
		assertEquals(5, list.get(4));
	}
}
