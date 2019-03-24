package mx.itesm.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListTest {

	private ArrayList<String> stringList;
	private ArrayList<Integer> integerList;
	private ArrayList<Float> floatList;

	@BeforeEach
	void setUp() throws Exception {
		stringList = new ArrayList<String>("verde", "rojo", "amarillo", "azul");
		integerList = new ArrayList<Integer>(4, 8, 15, 16, 23, 42);
		floatList = new ArrayList<Float>();
	}

	@Test
	void testGet() {
		assertEquals("rojo", stringList.get(1));
		assertEquals("azul", stringList.get(3));
		assertEquals((Integer) 4, integerList.get(0));
		assertEquals((Integer) 42, integerList.get(5));
		assertThrows(IndexOutOfBoundsException.class, () -> {
			floatList.get(0);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			stringList.get(-1);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			integerList.get(6);
		});
	}

	@Test
	void testSize() {
		assertEquals(4, stringList.size());
		assertEquals(6, integerList.size());
		assertEquals(0, floatList.size());
	}

	@Test
	void testIsEmpty() {
		assertFalse(stringList.isEmpty());
		assertFalse(integerList.isEmpty());
		assertTrue(floatList.isEmpty());
	}

	@Test
	void testSet() {
		assertEquals("verde", stringList.set(0, "blanco"));
		assertEquals("blanco", stringList.set(0, "negro"));
		assertEquals("negro", stringList.get(0));
		assertEquals(42, (int) integerList.set(5, -10));
		assertEquals(-10, (int) integerList.get(5));
		assertThrows(IndexOutOfBoundsException.class, () -> {
			floatList.set(5, 3.14f);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			stringList.set(-1, "morado");
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			integerList.set(6, 109);
		});
		assertThrows(NullPointerException.class, () -> {
			stringList.set(2,  null);
		});
	}

	@Test
	void testAdd() {
		stringList.add("negro");
		assertEquals(5, stringList.size());
		assertEquals("negro", stringList.get(4));
		stringList.add(5, "rosa");
		assertEquals(6, stringList.size());
		assertEquals("rosa", stringList.get(5));
		assertThrows(IndexOutOfBoundsException.class, () -> {
			stringList.add(7, "morado");
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			stringList.add(-1, "morado");
		});
		
		integerList.add(0, 1);
		assertEquals(7, integerList.size());
		assertIterableEquals(new ArrayList<Integer>(1, 4, 8, 15, 16, 23, 42), integerList);
		integerList.add(108);
		integerList.add(109);
		integerList.add(110);
		integerList.add(111);
		assertEquals(11, integerList.size());
		assertIterableEquals(new ArrayList<Integer>(1, 4, 8, 15, 16, 23, 42, 108, 109, 110, 111), integerList);
		assertEquals(20, integerList.capacity());
		assertThrows(NullPointerException.class, () -> {
			integerList.add(0, null);
		});
	}

	@Test
	void testRemove() {
		assertEquals("verde", stringList.remove(0));
		assertEquals(3, stringList.size());
		assertEquals("azul", stringList.remove(2));
		assertEquals(2, stringList.size());
		assertIterableEquals(new ArrayList<String>("rojo", "amarillo"), stringList);
		for (int x : new ArrayList<Integer>(4, 8, 15, 16, 23, 42)) {
			assertEquals(x, (int) integerList.remove(0));
		}
		assertEquals(0, integerList.size());
		assertThrows(IndexOutOfBoundsException.class, () -> {
			floatList.remove(0);
		});
	}
	
	@Test
	void testGetFirst() {
		assertEquals("verde", stringList.getFirst());
		stringList.remove(0);
		assertEquals("rojo", stringList.getFirst());
		
		assertEquals(4, (int) integerList.getFirst());
		integerList.remove(0);
		integerList.remove(0);
		assertEquals(15, (int) integerList.getFirst());
		integerList.add(0, 21);
		assertEquals(21, (int) integerList.getFirst());
		
		assertThrows(NoSuchElementException.class, () -> {
			floatList.getFirst();
		});
	}
	
	@Test
	void testGetLast() {
		assertEquals("azul", stringList.getLast());
		stringList.remove(stringList.size() - 1);
		assertEquals("amarillo", stringList.getLast());
		
		assertEquals(42, (int) integerList.getLast());
		integerList.remove(integerList.size() - 1);
		integerList.remove(integerList.size() - 1);
		assertEquals(16, (int) integerList.getLast());
		integerList.add(37);
		assertEquals(37, (int) integerList.getLast());
		
		assertThrows(NoSuchElementException.class, () -> {
			floatList.getLast();
		});
	}
	
	@Test
	void testClear() {
		integerList.add(0, 1);
		assertEquals(7, integerList.size());
		assertIterableEquals(new ArrayList<Integer>(1, 4, 8, 15, 16, 23, 42), integerList);
		integerList.add(108);
		integerList.add(109);
		integerList.add(110);
		integerList.add(111);
		assertEquals(11, integerList.size());
		assertIterableEquals(new ArrayList<Integer>(1, 4, 8, 15, 16, 23, 42, 108, 109, 110, 111), integerList);
		assertEquals(20, integerList.capacity());
		integerList.clear();
		assertEquals(10, integerList.capacity());
		assertEquals(0, integerList.size());
		assertThrows(IndexOutOfBoundsException.class, () -> {
			integerList.get(0);
		});
		assertIterableEquals(new ArrayList<Integer>(), integerList);
		
		stringList.clear();
		assertEquals(10, stringList.capacity());
		assertEquals(0, stringList.size());
	}
	
	@Test
	void testTrimToSize() { 
		integerList.add(0, 1);
		assertEquals(7, integerList.size());
		assertIterableEquals(new ArrayList<Integer>(1, 4, 8, 15, 16, 23, 42), integerList);
		integerList.add(108);
		integerList.add(109);
		integerList.add(110);
		integerList.add(111);
		assertEquals(11, integerList.size());
		assertIterableEquals(new ArrayList<Integer>(1, 4, 8, 15, 16, 23, 42, 108, 109, 110, 111), integerList);
		assertEquals(20, integerList.capacity()); 
		integerList.trimToSize();
		assertEquals(11, integerList.capacity());
		assertEquals(11, integerList.size());
		assertIterableEquals(new ArrayList<Integer>(1, 4, 8, 15, 16, 23, 42, 108, 109, 110, 111), integerList);
		
		assertEquals(10,  stringList.capacity());
		assertEquals(4, stringList.size());
		stringList.trimToSize();
		assertEquals(4, stringList.capacity());
		assertEquals(4, stringList.size());
		assertIterableEquals(new ArrayList<String>("verde", "rojo", "amarillo", "azul"), stringList);
	}

}
