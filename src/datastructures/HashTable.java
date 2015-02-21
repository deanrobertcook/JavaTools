package datastructures;

import utility.Utility;

/**
 *
 * @author dean
 */
public class HashTable {
	
	private String[] backingArray;
	
	public HashTable() {
		this(10);
	}
	
	public HashTable(int initialSize) {
		this.backingArray = new String[initialSize];
	}
	
	public void insert(String index, String value) {
		int hash = this.sumCharValueHash(index);
		//no collision
		if (this.backingArray[hash] == null) {
			this.backingArray[hash] = value;
		} else {
			
		}
	}
	
	private int sumCharValueHash(String index) {
		char[] indexChars = index.toCharArray();
		int hash = 0;
		for (int i = 0; i < indexChars.length; i++) {
			hash += (int)indexChars[i];
		}
		hash = Utility.pow(hash, 2);
		hash = hash % this.backingArray.length;
		return hash;
	}
	
	public String get(String index) {
		int hash = this.sumCharValueHash(index);
		String value = this.backingArray[hash];
		return value;
	}
}
