package datastructures;

import java.util.Objects;
import utility.Util;

/**
 *
 * @author dean
 */
public class HashTable<K, E> {

	private LinkedList<KeyValuePair<K, E>>[] backingArray;

	public HashTable() {
		this(10);
	}

	public HashTable(int initialSize) {
		this.backingArray = new LinkedList[initialSize];
		for (int i = 0; i < backingArray.length; i++) {
			backingArray[i] = new LinkedList<>();
		}
	}

	public void insert(K key, E value) {
		int hash = this.hash(key);
		KeyValuePair<K, E> keyValuePair = new KeyValuePair<>(key, value);
		this.backingArray[hash].insert(keyValuePair);
	}

	private int hash(K key) {
		if (key instanceof String) {
			return this.sumCharValueHash((String) key);
		}
		return -1;
	}

	private int sumCharValueHash(String key) {
		char[] indexChars = key.toCharArray();
		int hash = 0;
		for (int i = 0; i < indexChars.length; i++) {
			hash += (int) indexChars[i];
		}
		hash = (int) Math.pow((double) hash, (double) 2);
		hash = hash % this.backingArray.length;
		return hash;
	}

	public E get(K key) {
		int hash = this.hash(key);
		KeyValuePair<K, E> searchKey = new KeyValuePair<>(key, null);
		int listIndex = this.backingArray[hash].search(searchKey);
		KeyValuePair<K, E> keyValuePair = this.backingArray[hash].get(listIndex);
		return keyValuePair.value;
	}
	
	class KeyValuePair<K, E> {
		K key;
		E value;

		public KeyValuePair(K key, E value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public boolean equals(Object anObject) {
			if (this == anObject) {
				return true;
			}
			if (anObject instanceof KeyValuePair) {
				KeyValuePair otherKeyValuePair = (KeyValuePair) anObject;
				if (otherKeyValuePair.key == this.key) {
					return true;
				}
			}
			return false;
		}
	}
}
