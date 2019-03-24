package mx.itesm.exercises;

import mx.itesm.util.LinkedList;
import mx.itesm.util.Node;
import java.util.Random;

public class LinkedListApplications{

	/**
	 * Tests if a word is a palindrome.
	 * @param word the string to test.
	 * @return true if word is a palindrome, false otherwise.
	 */
	public static boolean isPalindrome(String word) {
		
		LinkedList<Character> Characters = new LinkedList<Character>();
		
		    word = word.toLowerCase();
		    for(int i = 0; i< word.length();i++) {
		    	Character letra = word.charAt(i);
		    	Characters.addLast(letra);
		    }
		    
		   
		    if (Characters.size()<=1)
		    	return true;
		    
		    while(Characters.size()>1) {
		    	if(!Characters.getFirst().equals(Characters.getLast())) {
		    		return false;
		    	}
		    	Characters.removeFirst();
		    	Characters.removeLast();
		    }
		    return true;
	}
	
	/**
	 * Scrambles the individual letters of a string and returns a list
	 * of its characters in random order.
	 * @param word the string to scramble.
	 * @return a list of word's characters in random order.
	 */
	public static LinkedList<Character> jumbleLetters(String word) {
		
		LinkedList<Character> Characters = new LinkedList<Character>();
	    
		Random rnd = new Random(5);
		
		for(int i = 0; i < word.length(); i++) {
			Character letra = word.charAt(i);
			boolean random = rnd.nextBoolean();
			if (random == false) {
				Characters.addFirst(letra);
			}
			else 
				Characters.addLast(letra);
		}
		
		return Characters;
		
	}
	
	/**
	 * Selects a student from the list using the Josephus algorithm.
	 * @param students list of student names as strings.
	 * @param n the number of iterations before removing a student from the list.
	 * @return the name of our selected room partner.
	 * @throws IllegalArgumentException if students is an empty list or if n is out of range (2 <= n <= 7)
	 */
	public static String sortingHat(LinkedList<String> students, int n) {
		if (students.size()<= 0|| n<2 || n>7) {
			throw new IllegalArgumentException ("No elements in the list");
		}
		
		Node<String> actual = students.node(0);
		
		Node<String> nextNode = new Node<String>();
		
		while (students.size()>1) {
			for (int i = 1; i<n; i++) {
				actual = actual.next;
				if(actual.value == null) {
					actual = actual.next;
				}	
			}
			if(actual.next.value == null) {
				nextNode = actual.next.next;
			}
			else {
				nextNode = actual.next;
			}
			
			students.removeNode(actual);
			actual = nextNode;
		}
		return students.node(0).value;
	}			
	
}
