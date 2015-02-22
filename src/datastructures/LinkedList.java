package datastructures;

/**
 *
 * @author dean
 */
public class LinkedList<E> implements List<E> {

	private Node<E> first;
	private Node<E> current;
	private Node<E> last;

	public LinkedList() {
		this.first = new Node<>();
		this.last = this.first;
	}

	@Override
	public void insert(E element) {
		if (this.first == this.last && this.first.isEmpty()) { //empty list
			this.first.update(element);
		} else {
			this.last.insertAfter(element);
			this.last = this.last.getNext();
		}
	}

	@Override
	public void insert(E element, int index) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public int search(E element) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void delete(int index) {
		throw new UnsupportedOperationException("Not supported yet.");
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
		this.current = this.first;
		int count = 0;
		while (this.current.hasNext() && count < index) {
			this.current = this.current.getNext();
			count++;
		}
		if (count == index) {
			return this.current.get();
		}
		return null;
	}

	@Override
	public E[] toArray() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
