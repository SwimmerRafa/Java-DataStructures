package mx.itesm.util;

import java.util.AbstractQueue;
import java.util.Iterator;

public class CircularArrayQueue<E> extends AbstractQueue<E>{

	public static final int MAX_DEFAULT_CAPACITY = 10;
	private E[] data;
	private int size;
	private int capacity;
	
	public CircularArrayQueue() {
		this(MAX_DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		this.data = (E[]) new Object[capacity];
	}
	
	private boolean isFull() {
		return size == capacity;
	}
	
	@Override
	public boolean offer(E element) {
		// Si la fila esta llena, no agrego nada y regreso false
		
		//Si la fila tiene espacio, agrego element al final de la fila
		//Incremento el tamaño y regreso true
		
		return false;
	}

	@Override
	public E peek() {
		// Si la fila esta vacia, entonces regresamos null.
		
		// Si la fila tiene al menos un elemento, regresamos
		// el valor al inicio de la misma.
				
		return null;
	}

	@Override
	public E poll() {
		// Si la fila esta vacia, regresamos null.
		
		// Si la fila tiene al menos un elemento, quitamos y 
		// regresamos el valor al inicio de la misma. Disminuimos
		// el tamanio de la fila en 1.
				
		// Cuidado: puede darse el caso que el indice de inicio de la fila
		// pase del final del arreglo al inicio del arreglo.
		
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// Regresa una instancia de un iterador sobre los elementos de 
		// la fila circular basada en arreglos.
		return null;
	}

	@Override
	public int size() {
		// Regresa el tamanio de esta fila.
		return 0;
	}

}
