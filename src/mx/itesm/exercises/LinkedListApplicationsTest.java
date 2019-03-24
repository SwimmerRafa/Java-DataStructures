package mx.itesm.exercises;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import mx.itesm.util.LinkedList;;

class LinkedListApplicationsTest {

	@Test
	void isPalindromeTest() {		
		assertTrue(LinkedListApplications.isPalindrome("lEveL"));
		assertTrue(LinkedListApplications.isPalindrome("1991"));
		assertTrue(LinkedListApplications.isPalindrome("AnitaLavaLaTina"));
		assertTrue(LinkedListApplications.isPalindrome("AnulaLaLuna"));
		assertFalse(LinkedListApplications.isPalindrome("HELAEh"));
		assertFalse(LinkedListApplications.isPalindrome("Ramonar"));
		assertFalse(LinkedListApplications.isPalindrome("DirDamenMadrid"));
		assertTrue(LinkedListApplications.isPalindrome("a"));
		assertTrue(LinkedListApplications.isPalindrome(""));
	}
	
	@Test
	void jumbleLettersTest() {
		LinkedList<Character> scramble1 = LinkedListApplications.jumbleLetters("tank");
		assertEquals('n', (char) scramble1.get(0));
		assertEquals('a', (char) scramble1.get(1));
		assertEquals('t', (char) scramble1.get(2));
		assertEquals('k', (char) scramble1.get(3));
		
		LinkedList<Character> scramble2 = LinkedListApplications.jumbleLetters("AnitaLavaLaTina");
		assertEquals('n', (char) scramble2.get(0));
		assertEquals('i', (char) scramble2.get(1));
		assertEquals('L', (char) scramble2.get(2));
		assertEquals('a', (char) scramble2.get(3));
		assertEquals('a', (char) scramble2.get(4));
		assertEquals('a', (char) scramble2.get(5));
		assertEquals('i', (char) scramble2.get(6));
		assertEquals('n', (char) scramble2.get(7));
		assertEquals('A', (char) scramble2.get(8));
		assertEquals('t', (char) scramble2.get(9));
		assertEquals('L', (char) scramble2.get(10));
		assertEquals('v', (char) scramble2.get(11));
		assertEquals('a', (char) scramble2.get(12));
		assertEquals('T', (char) scramble2.get(13));
		assertEquals('a', (char) scramble2.get(14));
		
		LinkedList<Character> scramble3 = LinkedListApplications.jumbleLetters("");
		assertEquals(0, scramble3.size());
		assertThrows(NoSuchElementException.class, () -> scramble3.getFirst());
	}
	@Test
    void sortingHatTest() {
		LinkedList<String> katnissEverdeenList1 = new LinkedList<String>("Peeta", "Gale", "Haymitch", "Primrose", "Effie");
		LinkedList<String> katnissEverdeenList2 = new LinkedList<String>("Peeta", "Gale", "Haymitch", "Primrose", "Effie");
		LinkedList<String> harryPotterList1 = new LinkedList<String>("Hermione", "Ron", "Draco", "Sirius", "Dobby", "Ginny", "Neville", "Remus", "Severus");
		LinkedList<String> harryPotterList2 = new LinkedList<String>("Hermione", "Ron", "Draco", "Sirius", "Dobby", "Ginny", "Neville", "Remus", "Severus");
		LinkedList<String> homerSimpsonList1 = new LinkedList<String>("Marge", "Bart", "Maggie", "Lisa");
		LinkedList<String> homerSimpsonList2 = new LinkedList<String>("Marge", "Bart", "Maggie", "Lisa");
		LinkedList<String> emptyList = new LinkedList<String>();
		LinkedList<String> testList1 = new LinkedList<String>("One", "Two");
        
		assertEquals("Gale", LinkedListApplications.sortingHat(katnissEverdeenList1, 5));
		assertEquals("Primrose", LinkedListApplications.sortingHat(katnissEverdeenList2, 3));
		assertEquals("Ron", LinkedListApplications.sortingHat(harryPotterList1, 7));
		assertEquals("Hermione", LinkedListApplications.sortingHat(harryPotterList2, 4));
		assertEquals("Marge", LinkedListApplications.sortingHat(homerSimpsonList1, 2));
		assertEquals("Maggie", LinkedListApplications.sortingHat(homerSimpsonList2, 6));
		assertThrows(IllegalArgumentException.class, () -> LinkedListApplications.sortingHat(emptyList, 5));
		assertThrows(IllegalArgumentException.class, () -> LinkedListApplications.sortingHat(testList1, 0));
		assertThrows(IllegalArgumentException.class, () -> LinkedListApplications.sortingHat(testList1, 1));
		assertThrows(IllegalArgumentException.class, () -> LinkedListApplications.sortingHat(testList1, 8));
		assertThrows(IllegalArgumentException.class, () -> LinkedListApplications.sortingHat(testList1, 9));
		
    }
}
