package mx.itesm.util;

public class IntegerNode {
	public int value;
	public IntegerNode next;
	public IntegerNode prev;
	
	public IntegerNode() {
		value = -1;
		next = this;
		prev = this;
	}
	
	public IntegerNode(int value) {
		this.value = value;
		next = this;
		prev = this;
	}
} 
