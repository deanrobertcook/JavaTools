package datastructures;

/**
 *
 * @author dean
 * @param <E>
 */
public class LinkedList<E> implements List<E> {

	private Node<E> first;
	private Node<E> last;
	private int size;

	public LinkedList(E[] array) {
		this();
		this.fromArray(array);
	}
	
	public LinkedList() {
		this.first = new Node<>();
		this.last = this.first;
		this.size = 0;
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
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int search(E element) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean delete(E value) {
		if (this.size > 0) {
			
			Node<E> current = this.first;
			Node<E> previousNode = null;
			while (current.value() != value && current.hasNext()) {				
				previousNode = current;
				current = current.getNext();
			}
			if (current.value() == value) { //found the element
				if (previousNode != null && current.hasNext()) {
					//neither first nor last element
					Node<E> nextNode = current.getNext();
					previousNode.replaceTail(nextNode);
					
				} else if (previousNode != null && !current.hasNext()){
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
			} else { //coudln't find value
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
		Node<E> current = this.first;
		int count = 0;
		while (current.hasNext() && count < index) {
			current = current.getNext();
			count++;
		}
		if (count == index) {
			return current.value();
		}
		return null;
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
