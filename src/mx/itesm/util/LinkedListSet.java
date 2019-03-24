package mx.itesm.util;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListSet<E> extends AbstractSet<E>{
	
	private class LinkedListSetIterator implements Iterator<E>{
		
		private Node<E> currentNode = head;
		private boolean illegalState = true;

		@Override
		public boolean hasNext() {
			return currentNode.next != head;
		}

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			currentNode = currentNode.next;
			illegalState = false;
			return currentNode.value;
		}
		
		@Override
		public void remove(){
			if(illegalState) {
				throw new IllegalStateException();
			}
			
			Node<E> nodeToRemove = currentNode;
			Node<E> nextNode = nodeToRemove.next;
			Node<E> prevNode = nodeToRemove.previous;
			
			prevNode.next = nextNode;
			nextNode.previous=prevNode;
			nodeToRemove.next = null;
			nodeToRemove.previous = null;
			
			currentNode = prevNode;
			
			size--;
			
			illegalState = true;
		}
	}
	
	private Node<E> head;
	private int size;
	
	public LinkedListSet() {
		head = new Node<E>();
		size=0;
	}
	
	public LinkedListSet(Collection<E> coll) {
		head = new Node<E>();
		size =0;
		
		addAll(coll);
	}
	 
	public boolean add(E value) {
		if (contains(value)) {
			return false;
		}
		
		Node<E> nodeToAdd = new Node<E>(value);
		Node<E> prevLast = head.previous;
		
		prevLast.next = nodeToAdd;
		nodeToAdd.next = head;
		head.previous = nodeToAdd;
		nodeToAdd.previous = prevLast;
		
		size++;
		
		return true;
	}
	
	public E get (int index) {
		Node<E> currentNode = head.next;
		
		for(int i = 0; i < index; i++) {
			currentNode = head.next;
		}
		
		return currentNode.value;
	}
	
	public E remove (int index) {
		Node<E> currentNode = head.next;
		
		for(int i= 0; i<index;i++) {
			currentNode = currentNode.next;
		}
		
		Node<E> nextNode = currentNode.next;
		Node<E> prevNode = currentNode.previous;
		
		prevNode.next = nextNode;
		nextNode.previous=prevNode;
		currentNode.next = null;
		currentNode.previous=null;
		
		size--;
		
		return currentNode.value;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListSetIterator();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		LinkedListSet<Character> myLittleSet = new LinkedListSet<Character>();
		myLittleSet.add('A');
		myLittleSet.add('B');
		myLittleSet.add('C');
		myLittleSet.add('E');
		myLittleSet.add('D');
		myLittleSet.add('F');
		myLittleSet.add('G');
		myLittleSet.add('H');
		myLittleSet.add('I');
		myLittleSet.add('J');
		System.out.println(myLittleSet);
		myLittleSet.add('A');
		System.out.println(myLittleSet);
		myLittleSet.remove(1);
		System.out.println(myLittleSet);
		
		//Iterator<Character> it = myLittleSet.iterator();
		//while(it.hasNext()) {
			//it.next();
		//}
		
		for(Iterator<Character>i = myLittleSet.iterator(); i.hasNext();) {
			char item = i.next();
			if(item%2==0) {
				i.remove();
			}
		}
		System.out.println(myLittleSet);
	}
	
}
