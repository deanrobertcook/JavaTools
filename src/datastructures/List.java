package datastructures;

public interface List {
	public void insert(Object value);
	
	public void insert(Object value, int index);
	
	public void insertList(List list, int index);
	
	public int search(Object value);
	
	public void delete(int index);
	
	public Object get(int index);
	
	public void sort();
	
	public Object[] toArray();
}
