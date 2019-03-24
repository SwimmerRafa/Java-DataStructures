package mx.itesm.util;

public class Node<T> {
	public T value;
	public Node<T> next;
	public Node<T> previous;
	
	public Node() {
		value = null;
		next = this;
		previous = this;
				
	}
	
	public Node (T value) {
		this.value = value;
		next = this;
		previous = this;
	}
	
}
