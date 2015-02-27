package datastructures;

public interface List<E> {
	public void insert(E value);
	
	public void insert(E value, int index);
	
	public void insertList(List<E> list, int index);
	
	public boolean isEmpty();
	
	public int size();
	
	public int search(E value);
	
	public boolean delete(E value);
	
	public E get(int index);
	
	public void sort();
	
	public E[] toArray();
	
	public void fromArray(E[] array);
}
