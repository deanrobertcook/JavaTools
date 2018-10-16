package org.theronin.javatools.datastructures;

/**
 *
 * @author dean
 * @param <E>
 */
public class MyLinkedList<E> implements List<E> {

	private Node<E> first;
	private Node<E> last;
	private int size;

	public MyLinkedList() {
		this.first = this.makeNode();
		this.last = this.first;
		this.size = 0;
	}
	
	/**
	 * Node Factory methods
	 * @return 
	 */
	protected Node<E> makeNode() {
		return new Node<>();
	}
	
	protected Node<E> makeNode(E element) {
		return new Node<>(element);
	}

	@Override
	public void insert(E element) {
		if (this.first == this.last && this.first.isEmpty()) { //empty list
			this.first.update(element);
		} else {
			this.last.insertAfter(element);
			this.last = this.last.getNext();
		}
		this.size++;
	}

	@Override
	public void insert(E element, int index) {
		Node<E> newNode = this.makeNode(element);
		if (index == 0) {
			newNode.replaceTail(this.first);
			this.first = newNode;
		} else {
			Node<E> previousNode = this.getNode(index - 1);
			Node<E> nextNode = previousNode.getNext();
			newNode.replaceTail(nextNode);
			previousNode.replaceTail(newNode);
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int search(E element) {
		if (this.size > 0) {
			Node<E> current = this.first;
			int index = 0;
			while (!current.element().equals(element) && current.hasNext()) {
				current = current.getNext();
				index++;
			}
			if (current.element().equals(element)) {
				return index;
			}
		}
		return -1;
	}

	@Override
	public boolean delete(E element) {
		if (this.size > 0) {

			Node<E> current = this.first;
			Node<E> previousNode = null;
			while (!current.element().equals(element) && current.hasNext()) {
				previousNode = current;
				current = current.getNext();
			}
			if (current.element().equals(element)) { //found the element
				if (previousNode != null && current.hasNext()) {
					//neither first nor last element
					Node<E> nextNode = current.getNext();
					previousNode.replaceTail(nextNode);

				} else if (previousNode != null && !current.hasNext()) {
					//last element
					previousNode.replaceTail(null);

				} else {
					//first element
					if (this.size == 1) {
						//first element no tail
						this.first.update(null);
					} else {
						//tail becomes first element
						this.first = current.getNext();
					}
				}
				//should have been removed!!
				this.size--;
				return true;
			} else { //coudln't find element
				return false;
			}
		}
		return false;
	}

	@Override
	public void sort() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void insertList(List list, int index) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public E get(int index) {
		Node<E> node = this.getNode(index);
		return node.element();
	}

	private Node<E> getNode(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Index must be greater than 0");
		} else if (index > this.size - 1) {
			throw new IndexOutOfBoundsException("Index must be less than the length of the List");
		} else {
			Node<E> current = this.first;
			int currIndex = 0;
			while (current.hasNext() && currIndex < index) {
				current = current.getNext();
				currIndex++;
			}
			return current;
		}
	}

	@Override
	public E[] toArray() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void fromArray(E[] array) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
