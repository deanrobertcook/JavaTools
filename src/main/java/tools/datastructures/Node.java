package tools.datastructures;

public class Node<E> {
	
	protected Node<E> tail;
	protected E element;
	
	public Node() {}
	
	public Node(E element) {
		this.element = element;
	}
	
	public boolean isEmpty() {
		return this.element == null;
	}
	
	public E element() {
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
	
	public void replaceTail(Node<E> newTail) {
		this.tail = newTail;
	}
	
	public Node<E> previous() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
