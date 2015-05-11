package tools.sort;

public interface Sorter <T extends Comparable<T>> {
	public void sort(T[] A);
}
