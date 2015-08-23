package org.theronin.javatools.sort;

public interface Sorter <T extends Comparable<T>> {
	public void sort(T[] A);
}
