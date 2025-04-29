package pt.umaia.aed2425.list;

import java.util.function.Predicate;

public class LinkedList<E> {

	private java.lang.Object list;

	protected static class Node<E> {

		private E element;
		private Node<E> next;

		public Node(E element) {
			this.element = element;
			this.next = null;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
	}

	protected Node<E> first;
	protected int size;

	public LinkedList() {
		this.first = null;
		this.size = 0;
	}

	public int size() {
		return size;
	}

	/**
	 * Returns the element at the given index.
	 *
	 * @param index the index where the element is - needs to be in range [0, size[
	 * @return the found element
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size()
	 */
	public E get(int index) {

		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException(index);
		}

		Node<E> current = first;
		int currentIndex = 0;

		while (currentIndex < index) {

			current = current.getNext();
			currentIndex++;
		}

		return current.getElement();
	}

	/**
	 * Returns the index of the fiven element, or -1 if the element is not present.
	 *
	 * @param searchValue the element to search
	 * @return the index of the element if found, -1 otherwise
	 */
	public int indexOf(E searchValue) {

		Node<E> current = first;
		int currentIndex = 0;

		while (current != null) {

			if (current.getElement().equals(searchValue)) {

				return currentIndex;
			}

			current = current.getNext();
			currentIndex++;
		}

		return -1;
	}

	/**
	 * Inserts the given element at the given index.
	 *
	 * @param element the element to insert
	 * @param index   the index where the element will be added - needs to be in range [0, size]
	 * @throws IndexOutOfBoundsException if index < 0 or index > size()
	 */
	public void add(int index, E element) {

		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException(index);
		}

		Node<E> newNode = new Node<>(element);
		size++;

		if (index == 0) {

			newNode.setNext(first);
			first = newNode;
			return;
		}

		Node<E> current = first;
		int currentIndex = 0;

		while (currentIndex < index - 1) {

			current = current.getNext();
			currentIndex++;
		}

		newNode.setNext(current.getNext());
		current.setNext(newNode);
	}

	/**
	 * Removes the element on the given index.
	 *
	 * @param index the index of the element to be removed - needs to be in range [0, size[
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size()
	 */
	public void remove(int index) {

		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException(index);
		}

		size--;

		if (index == 0) {

			first = first.getNext();
			return;
		}

		Node<E> current = first;
		int currentIndex = 0;

		while (currentIndex < index - 1) {

			current = current.getNext();
			currentIndex++;
		}

		current.setNext(current.getNext().getNext());
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("["); //inicia a frase (conjunto de strings) com [

		Node<E> current = first; //inicia a partir do primeiro no da lista
		boolean firstElement = true;


		while (current != null) {
			if (!firstElement) {
				sb.append(" ");
			} else {
				sb.append(current.getElement());
				firstElement = false;
				current = current.getNext();
			}
		}

		sb.append(" ]");
		return sb.toString();

	}

	public void addFirst(E element) {
		Node<E> newNode = new Node<>(element);
		newNode.setNext(first);
		first = newNode;
		size++;
		//complexidade temporal O(1) OU SEJA PERCORRE SEJA O NUMERO EXISTENTe
		//de dados de uma vez sempre da mesma forma e adiciona uma nova primeira posição ao Node<e> uma posição nova 0.
	}

	public void removeAll(E element) {
		for (int i = size - 1; i >= 0; i--) {
			if (element.equals(get(i))) {
				remove(i);


			}
		}
	}

	public void duplicate() {
		for (int i = 0; i < size(); i++) {//estrutura que limita de onde a onde as alterações serão feitas da posição 0 a ultima da list
			E element = get(i);//vai buscar o elemento
			add(i + 1, element);//Adiciona mais um ao elemento anterior
			i++;//passa para o seguinte e repete processo
			//processo em O(n)
		}

	}

	public void printList() {
		duplicate();  // Duplicar os elementos antes de imprimir
		System.out.println(toString());  // Chama o método toString() para exibir a lista
	}

		// Método removeIf
		public void removeIf(Predicate<E> condition) {
			boolean modified = false;

			for (int i = 0; i < size(); i++) {
				if (condition.test(get(i))) {
					remove(i);
					i--;  // Evita pular o próximo elemento
					modified = true;
				}
			}

			if (modified) {
				printList();  // Exibe a lista apenas se houve modificações
			}
		}


		public static boolean containsLetterA(String s) {
			return s.contains("a");
		}


		public static boolean isGreaterThanTen(Integer i) {
			return (i >=10);
		}


		public static boolean isInvalidEmail(String email) {
			return !email.contains("@") || !email.contains(".");
		}

		// Outros métodos da lista (get, add, remove, etc.) aqui
	}
