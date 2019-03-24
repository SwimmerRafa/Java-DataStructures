package mx.itesm.exercises;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import mx.itesm.util.Node;

public class LinkedListQueue<E> extends AbstractQueue<E> {

	private class LinkedListQueueIterator implements Iterator<E> {
		private int index = 0; //Indice en el que se empieca a recorrer la lista
		
		@Override
		public boolean hasNext() {
			//Si el tamaño es mayor al indice regresa true
			//Si el tamañp es menor al indice refresa false
			return (index < size);
		}

		@Override
		public E next() { 
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			else {
			Node<E> actualNode = head.next;
			for (int i = 0; i < index; i++) {
				actualNode = actualNode.next;
			}
			index++;
			return actualNode.value;
			}
		}
	}
	
	private Node<E> head;
	public int size;
	
	public LinkedListQueue() {
		head = new Node<E>();
		size = 0;
	}
	
	public LinkedListQueue(Collection<E> coll) {
		head = new Node<E>();
		size = 0;
		
		for (E element : coll) {
			offer(element);
		}
	}
	
	public boolean offer(E value) {
		if (value == null) {
			throw new NullPointerException();
		}
		
		Node<E> newNode = new Node<E>(value);
		Node<E> previousLast = head.previous;
		previousLast.next = newNode;
		newNode.next = head;
		head.previous = newNode;
		newNode.previous = previousLast;
		size++;
		
		return true;
	}
	
	public E peek() {
		if (size == 0) {
			return null;
		}
		
		return head.next.value;
	}
	
	public E poll() {
		if (size == 0) {
			return null;
		}
		
		Node<E> nodeToRemove = head.next;
		Node<E> newFirst = nodeToRemove.next;
		
		head.next = newFirst;
		newFirst.previous = head;
		nodeToRemove.next = null;
		nodeToRemove.previous = null;
		size--;
		
		return nodeToRemove.value;
	}
	
	public Iterator<E> iterator() {
		return new LinkedListQueueIterator();
	}
	
	public int size() {
		return size;
	}
}
