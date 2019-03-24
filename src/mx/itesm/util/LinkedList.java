package mx.itesm.util;

import java.util.AbstractList;
import java.util.NoSuchElementException;

public class LinkedList<E> extends AbstractList<E>{
	private Node<E> head;
	private int size;
	
	public LinkedList() {
		head = new Node<E>();
		size = 0;
	}
	
	public void addFirst(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		
		Node<E> firstNode = new Node<E>(element);
		Node<E> previousFirst = head.next;
		
		head.next= firstNode;
		firstNode.next = previousFirst;
		previousFirst.previous = firstNode;
		firstNode.previous = head;
		
		size ++;
	}
	
	public void addLast(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		
		Node<E> lastNode = new Node<E>(element);
		Node<E> prevLast = head.previous;
		
		prevLast.next = lastNode;
		lastNode.next = head;
		head.previous = lastNode;
		lastNode.previous= prevLast;
		
		size++;
	}
	
	/**
	 * Gets the node at specified index.
	 * @param index the index of the node to get
	 * @return not at specified position
	 * @throws IndexOutOfBoundsException if the index is out of range 
	 * (index < 0 || index >= size())
	 */
	public Node<E> node(int index){
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException ("Index out of range");
		}
		Node<E> currentNode = head.next;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		
		return currentNode;
	}

	@Override
	public E get(int index) {
		return node(index).value;
	}

	@Override
	public int size() {

		return size;
	}
	
	public  String toStringReverse() {
	Node<E> currentNode = head.previous;
	
		if(currentNode == head){
		return "[]";
		}
		String returnValue = "[" + currentNode.value; 
		while (currentNode.previous != head) {
		currentNode = currentNode.previous;
		returnValue += ", " + currentNode.value;
		
		}
	
		returnValue += "]";
		return returnValue;
	}
	
	@Override
	public void add(int index, E element) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException ("Index out of range");	
		}
		if (element == null) {
			throw new  NullPointerException ("Index value is null");
		}
		
		if (index == size()) {
			addLast(element);
		}
		
		else {
			Node <E> newNode = new Node<E>(element);
			Node <E> nodeIndex = node(index);
			Node <E> prevNode = nodeIndex.previous;
			
			newNode.next = nodeIndex;
			newNode.previous = prevNode;
			nodeIndex.previous = newNode;
			prevNode.next = newNode;
			
			size++;
		}
		
	}
	
	@Override
	public E set(int index, E element) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException ("Index out of range");	
		}
		if (element == null) {
			throw new  NullPointerException ("Index value is null");
		}
		
		else {
			Node <E> newNode = new Node<E>(element);
			Node <E> nodeIndex = node(index);
			Node <E> prevNode = nodeIndex.previous;
			Node <E> nextNode = nodeIndex.next;
			
			nodeIndex.next = null;
			nodeIndex.previous = null;
			
			newNode.next = nextNode;
			newNode.previous = prevNode;
			prevNode.next = newNode;
			nextNode.previous = newNode;
			
			return nodeIndex.value;
		}
		
	}
	
	/**
	 * Removes and returns the first element from this list.
	 * @return the first element from this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeFirst() {
		if (size()<= 0) {
			throw new NoSuchElementException ("No elements in the list");
		}
		else {
			Node<E> firstNode = head.next;
			Node<E> nodeNext = firstNode.next;
			
			firstNode.next = null;
			firstNode.previous = null;
			nodeNext.previous = head;
			head.next = nodeNext;
			
			size--;
			return firstNode.value;
		}
	}
	
	/**
	 * Removes and returns the last element from this list.
	 * @return the last element from this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeLast() {
		if (size()<= 0) {
			throw new NoSuchElementException ("No elements in the list");
		}
		else {

			Node<E> prevLast = head.previous;
			Node<E> newLast = prevLast.previous;
			
			newLast.next = head;
			head.previous = newLast;
			prevLast.next = null;
			prevLast.previous= null;

			
			size--;
			return prevLast.value;
		}
	}
	
	@Override
	public E remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException ("Index out of range");	
		}
		else {
			Node <E> nodeIndex = node(index);
			Node <E> nodeIprev = nodeIndex.previous;
			Node <E> nodeInext= nodeIndex.next;
			
			nodeIndex.next = null;
			nodeIndex.previous = null;
			nodeIprev.next = nodeInext;
			nodeInext.previous = nodeIprev;
			
			size--;
			return nodeIndex.value;
		}	
	}
	
	
	@SafeVarargs
	public LinkedList(E... elements) {
		head = new Node <E>();
		size = 0;
		
		for (E element : elements) {
			addLast(element);
		}
	}
	

	public E getFirst() {
		if (size()<= 0) {
			throw new NoSuchElementException ("No elements in the list");
		}
		else {
			Node<E> firstNode = head.next;
			return firstNode.value;
			
		}
	}
	
	public E getLast() {
		if (size()<= 0) {
			throw new NoSuchElementException ("No elements in the list");
		}
		else {
			Node<E> lastNode = head.previous;
			return lastNode.value;	
		}
	}

	public void addLast(int i, char c) {
		// TODO Auto-generated method stub
		
	}
	
	public void removeNode(Node<E> nodo) {
		if (size()<= 0) {
			throw new NoSuchElementException ("No elements in the list");
		}
		Node<E> actual = head.next;
		
		while(actual != nodo) {
			actual = actual.next;
		}
		
		actual.previous.next = actual.next;
		actual.next.previous = actual.previous;
		actual.next= null;
		actual.previous = null;
		
		size --;
	}
	
	public int removeAfter(int index, int n) {
		Node<E> currentNode = node(index);
		
		int indexToRemove = index;
		for (int i = 0; i < n - 1; i++) {
			currentNode = currentNode.next;
			indexToRemove++;
			
			if (currentNode == head) {
				currentNode = currentNode.next;
				indexToRemove = 0;
			}
		}
		
		remove(indexToRemove);
		
		if (indexToRemove == size()) {
			indexToRemove = 0;
		}
		
		return indexToRemove;
	}
}
