package tools.datastructures;

/**
 * @author Dean Cook<deanrobertcook@gmail.com>
 */
public class BinarySearchTree<K extends Comparable<K>, E> {

	private int size;
	private Node<K, E> root;

	public BinarySearchTree() {
		this.size = 0;
		this.root = null;
	}

	public int size() {
		return this.size;
	}

	public void insert(K key, E element) {
		Node<K, E> newNode = new Node<>(key, element);
		if (this.root == null) {
			this.root = newNode;
		} else {
			this.naiveRecursiveInsert(this.root, newNode);
		}
		this.size++;
	}

	private void naiveRecursiveInsert(Node<K, E> currentNode, Node<K, E> newNode) {
		if (newNode.compareTo(currentNode) > 0) {//greater than current
			if (!currentNode.hasRight()) {//reached a leaf
				currentNode.rightChild = newNode;
			} else {
				currentNode = currentNode.rightChild;
				this.naiveRecursiveInsert(currentNode, newNode);
			}
		} else if (newNode.compareTo(currentNode) < 0) {//less than current
			if (!currentNode.hasLeft()) {//reached a leaf
				currentNode.leftChild = newNode;
			} else {
				currentNode = currentNode.leftChild;
				this.naiveRecursiveInsert(currentNode, newNode);
			}
		} else {
			throw new IndexOutOfBoundsException("Record with key " + newNode.key.toString() + " already exists");
		}
	}

	public E search(K key) {
		if (this.root == null) {
			throw new IndexOutOfBoundsException("Tree is empty");
		}
		Node<K, E> searchNode = new Node<>(key);
		Node<K, E> currentNode = this.root;
		Node<K, E> foundNode = this.recursiveSearch(currentNode, searchNode);
		return foundNode.element;
	}

	private Node<K, E> recursiveSearch(Node<K, E> currentNode, Node<K, E> searchNode) {
		if (searchNode.compareTo(currentNode) == 0) { //keys match
			return currentNode;
		} else if (searchNode.compareTo(currentNode) < 0) { //search key is less than current key
			if (!currentNode.hasLeft()) {
				throw new IndexOutOfBoundsException("Could not find record with key " + searchNode.key.toString());
			} else {
				currentNode = currentNode.leftChild; //check left branch
				return this.recursiveSearch(currentNode, searchNode);
			}

		} else { //search key is greater than current key
			if (!currentNode.hasRight()) {
				throw new IndexOutOfBoundsException("Could not find record with key " + searchNode.key.toString());
			} else {
				currentNode = currentNode.rightChild; //check right branch
				return this.recursiveSearch(currentNode, searchNode);
			}
		}
	}

	public void delete(K key) {
		Node<K, E> searchNode = new Node<>(key, null);
		this.root = this.recursiveDelete(this.root, searchNode);
		this.size--;
	}

	private Node<K, E> recursiveDelete(Node<K, E> currentNode, Node<K, E> searchNode) {
		if (currentNode == null) {
			return null;
		} else if (searchNode.compareTo(currentNode) == 0) {//perform deletion
			if (currentNode.isLeaf()) {
				return null;
			} else if (!currentNode.hasRight()) {
				return currentNode.leftChild;
			} else if (!currentNode.hasLeft()) {
				return currentNode.rightChild;
			} else {
				Node<K, E> smallestRightNode = this.smallestNode(currentNode.rightChild);
				Node<K, E> replaceNode = new Node<>(smallestRightNode.key, smallestRightNode.element);
				Node<K, E> newRightTree = this.recursiveDelete(currentNode.rightChild, replaceNode);
				replaceNode.setRight(newRightTree);
				replaceNode.setLeft(currentNode.leftChild);
				return replaceNode;
			}
		} else if (searchNode.compareTo(currentNode) < 0) {
			return this.recursiveDelete(currentNode.leftChild, searchNode);
		} else {
			return this.recursiveDelete(currentNode.rightChild, searchNode);
		}
	}

	private Node<K, E> smallestNode(Node<K, E> currentNode) {
		if (!currentNode.hasLeft()) {
			return currentNode;
		} else {
			currentNode = currentNode.leftChild;
			return this.smallestNode(currentNode);
		}
	}

	class Node<K extends Comparable<K>, E> implements Comparable<Node<K, E>> {

		private final K key;
		private E element;
		private Node<K, E> leftChild;
		private Node<K, E> rightChild;

		public Node(K key) {
			this(key, null);
		}

		public Node(K key, E element) {
			this.key = key;
			this.element = element;
			this.leftChild = null;
			this.rightChild = null;
		}

		@Override
		public int compareTo(Node<K, E> otherNode) {
			return this.key.compareTo(otherNode.key);
		}

		public boolean isLeaf() {
			if (!this.hasLeft() && !this.hasRight()) {
				return true;
			}
			return false;
		}

		public boolean hasLeft() {
			boolean leftChildExists = (this.leftChild != null);
			return leftChildExists;
		}

		public boolean hasRight() {
			boolean rightChildExists = (this.rightChild != null);
			return rightChildExists;
		}

		public void setLeft(Node<K, E> node) {
			if (node == null) {
				this.leftChild = null;
			} else {
				//if the other node is greater than this one, fail
				if (this.compareTo(node) <= 0) {
					throw new IllegalStateException("New node must have key less than this node");
				}
				this.leftChild = node;
			}
		}

		public void setRight(Node<K, E> node) {
			if (node == null) {
				this.rightChild = null;
			} else {
				//if the other node is smaller than this one, fail
				if (this.compareTo(node) >= 0) {
					throw new IllegalStateException("New node must have key greater than this node");
				}
				this.rightChild = node;
			}
		}
	}
}
