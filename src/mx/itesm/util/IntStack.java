package mx.itesm.util;

import java.util.NoSuchElementException;

public class IntStack {
	private int[] elements;
	private int nextIndex;
	private int max;
	private int size;
	
	/**
	 * Creates an empty stack with a defined maximum capacity
	 * @param max the maximum number of elements this stack can hold
	 */
	public IntStack(int capacity) {
		this.max= capacity;
		elements = new int [capacity];
		nextIndex=0;
		size=0;
	}
	
	/**
	 * Pushes an item onto the top of this stack.
	 * @param x the item to be pushed onto this stack
	 * @throws IllegalStateException with the message "Stack Overflow" if the stack is at its maximum capacity
	 */
	public void push(int x) {
		 if(nextIndex > max - 1) {
			 throw new IllegalStateException("Stack Overflow");
		 }
		 
		 elements[nextIndex] = x;
		 nextIndex++;
		 size++;
	}
	
	/**
	 * Removes the item at the top of this stack and returns that item as the value of this function.
	 * @return The object at the top of this stack.
	 * @throws NoSuchElementException with the message "Stack Underflow" if the stack is empty
	 */
	public int pop() {
		if(size == 0) {
			 throw new NoSuchElementException("Stack Underflow");
		 }
		 
		 int element = elements[nextIndex - 1];
		 nextIndex--;
		 size--;
		 
		 return element;
	}
	
	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 * @return The object at the top of this stack.
	 * @throws NoSuchElementException with the message "Stack Underflow" if the stack is empty
	 */
	public int peek() {
		 if(size == 0) {
			 throw new NoSuchElementException("Stack Underflow"); 
		 }
		 
		 return elements[nextIndex - 1];
	}
	
	/**
	 * Test if the stack is empty
	 * @return true if and only if this stack contains no elements; false otherwise.
	 */
	public boolean isEmpty() {
		if(size == 0) 
			 return true;
		 
		 else 
			 return false;	 	
	}
	
	/**
	 * The number of elements that this stack currently holds.
	 * @return the number of elements contained in this stack.
	 */
	public int size() {
		return size;
	}
}
