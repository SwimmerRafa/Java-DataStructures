package mx.itesm.util;

import java.util.AbstractList;
import java.util.NoSuchElementException;

public class ArrayList<E> extends AbstractList<E> {
	private int listCapacity;
	private int listSize;
	private E[] data;
	
	@SuppressWarnings("unchecked")
	public ArrayList(E... elements) {
		listCapacity = 10;
		listSize = 0;
		
		data = (E[]) new Object[listCapacity];
		for (E element : elements) {
            add(element);
        }
	}
	
	@Override
	public E get(int index) {
		if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
	}

	@Override
	public int size() {
		return listSize;
	}
	
	public int capacity() {
		return listCapacity;
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
			E old = data[index];
	        data[index] = element;
	        return old;	 
		}
    }
    
    @Override
    public void add(int index, E element) {
    	if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException ("Index out of range");	
		}
		if (element == null) {
			throw new  NullPointerException ("Index value is null");
		}
		
		else {
			if (data.length == size()) ensureCapacity(capacity() * 2); //Double the capacity
	        for (int i = listSize; i > index; i--) { //Iterates starting with the listSize in reverse
	            data[i] = data[i - 1]; //
	        }
	        data[index] = element; //Insert the element in the index indicated
	        listSize++; //Add 1 per element added
			       
	    }	
    }

    @Override
    public E remove(int index) {
    	if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException ("Index out of range");	
		}
    	
    	E remove = data[index];
    	for (int i = index; i< listSize; i++){
    		data[i] = data[i+1];
    	}
    	listSize --;
    	return remove;
    }
    
    public E getFirst() {
    	if (size()<= 0) {
			throw new NoSuchElementException ("No elements in the list");
    	}
    	return data[0];
	}
	
	public E getLast() {
		if (size()<= 0) {
			throw new NoSuchElementException ("No elements in the list");
    	}
		return data[size() -1];
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		listSize = 0;
	    listCapacity = 10;
	    data = (E[]) new Object[listCapacity];
	}
	
	public void trimToSize() {
		listCapacity = size();
		
		@SuppressWarnings("unchecked")
		E[] tempData =  (E[]) new Object[listCapacity];
		for (int i = 0; i < listSize; i++) {
			tempData[i] = data[i];
		}
		data = tempData;
	} 
	
	//Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number 
	//of elements specified by the minimum capacity argument.
	
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int minCapacity) {
        if (minCapacity < listCapacity) return; //no changes
        listCapacity = listCapacity * 2;// it double the capacity
        E[] old = data; //References the data in the old array
        data = (E[]) new Object[minCapacity]; //data is an array with the capacity of the minimum
        for (int i = 0; i < size(); i++) {//Iterates the size of the array  
            data[i] = old[i]; //insert the elements of old data in the data array
        }
	}
}
