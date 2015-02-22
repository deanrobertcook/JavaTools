package datastructures;

public interface List<E> {
	public void insert(E value);
	
	public void insert(E value, int index);
	
	public void insertList(List<E> list, int index);
	
	public int search(E value);
	
	public void delete(int index);
	
	public E get(int index);
	
	public void sort();
	
	public E[] toArray();
}
