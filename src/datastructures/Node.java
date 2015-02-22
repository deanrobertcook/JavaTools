package datastructures;

public class Node<E> {
	
	private Node<E> tail;
	private E element;
	
	public Node() {
		
	}
	
	public Node(E element) {
		this.element = element;
	}
	
	public boolean isEmpty() {
		return this.element == null;
	}
	
	public E get() {
		return this.element;
	}
	
	public void update(E element) {
		this.element = element;
	}
	
	public boolean hasNext() {
		return this.tail != null;
	}
	
	public Node<E> getNext() {
		if (this.hasNext()) {
			return this.tail;
		} 
		return null;
	}
	
	public void insertAfter(E element) {
		if (!this.hasNext()) {
			this.tail = new Node<>(element);
		}
	}
	
	public Node<E> previous() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
