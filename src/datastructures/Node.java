package datastructures;

public class Node<E> {
	
	private Node<E> tail;
	private E value;
	
	public Node() {
		
	}
	
	public Node(E value) {
		this.value = value;
	}
	
	public boolean isEmpty() {
		return this.value == null;
	}
	
	public E value() {
		return this.value;
	}
	
	public void update(E element) {
		this.value = element;
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
	
	public void insertAfter(E value) {
		if (!this.hasNext()) {
			this.tail = new Node<>(value);
		}
	}
	
	public void replaceTail(Node<E> newTail) {
		this.tail = newTail;
	}
	
	public Node<E> previous() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
