package mx.itesm.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArraysTest {

	@Test
	public void testFindMinimum() {
		assertEquals(1, Arrays.findMinimum(new int[]{8, 2, 5, 4, 10, 3, 1, 9, 7}));
		assertEquals(-65, Arrays.findMinimum(new int[]{-22, 89, 205, -32, 0, 1, -4, 102, -3, -65, 2}));
		assertEquals(0, Arrays.findMinimum(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
		assertEquals(2, Arrays.findMinimum(new int[] {11, 10, 9, 8, 7, 6, 5, 4, 3, 2}));
		assertEquals(3, Arrays.findMinimum(new int[] {3, 3, 3, 3, 3, 3}));
		assertEquals(Integer.MIN_VALUE, Arrays.findMinimum(new int[]{}));
	}
	
	@Test
	public void testFindMaximum() {
		assertEquals(10, Arrays.findMaximum(new int[]{8, 2, 5, 4, 10, 3, 1, 9, 7}));
		assertEquals(205, Arrays.findMaximum(new int[]{-22, 89, 205, -32, 0, 1, -4, 102, -3, -65, 2}));
		assertEquals(9, Arrays.findMaximum(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
		assertEquals(11, Arrays.findMaximum(new int[] {11, 10, 9, 8, 7, 6, 5, 4, 3, 2}));
		assertEquals(3, Arrays.findMaximum(new int[] {3, 3, 3, 3, 3, 3}));
		assertEquals(Integer.MIN_VALUE, Arrays.findMaximum(new int[]{}));
	}
	
	@Test
	public void testFindAverage() {
		assertEquals(49.0f / 9.0f, Arrays.findAverage(new int[]{8, 2, 5, 4, 10, 3, 1, 9, 7}));
		assertEquals(273.0f / 11.0f, Arrays.findAverage(new int[]{-22, 89, 205, -32, 0, 1, -4, 102, -3, -65, 2}));
		assertEquals(45.0f / 10.0f, Arrays.findAverage(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
		assertEquals(65.0f / 10.0f, Arrays.findAverage(new int[] {11, 10, 9, 8, 7, 6, 5, 4, 3, 2}));
		assertEquals(18.0f / 6.0f, Arrays.findAverage(new int[] {3, 3, 3, 3, 3, 3}));
		assertEquals(Integer.MIN_VALUE, Arrays.findAverage(new int[]{}));
	}
	
	@Test
	public void testSampleVariance() {
		assertEquals(100.0f / 10.0f, Arrays.sampleVariance(new int[]{8, 2, 5, 4, 10, 3, 1, 9, 7, 1}));
		assertEquals(59342.0f / 12.0f, Arrays.sampleVariance(new int[]{-22, 89, 205, -32, 0, 1, -4, 102, -3, -65, 2, 27}));
		assertEquals(110.0f / 11.0f, Arrays.sampleVariance(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
		assertEquals(110.0f / 11.0f, Arrays.sampleVariance(new int[] {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
		assertEquals(0.0f, Arrays.sampleVariance(new int[] {3, 3, 3, 3, 3, 3}));
		assertEquals(Integer.MIN_VALUE, Arrays.sampleVariance(new int[]{}));
	}
	
	@Test
	public void testToString() {
		assertEquals("[8, 2, 5, 4, 10, 3, 1, 9, 7, 1]", Arrays.toString(new int[]{8, 2, 5, 4, 10, 3, 1, 9, 7, 1}));
		assertEquals("[-22, 89, 205, -32, 0, 1, -4, 102, -3, -65, 2, 27]", Arrays.toString(new int[]{-22, 89, 205, -32, 0, 1, -4, 102, -3, -65, 2, 27}));
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
		assertEquals("[11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]", Arrays.toString(new int[] {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
		assertEquals("[3, 3, 3, 3, 3, 3]", Arrays.toString(new int[] {3, 3, 3, 3, 3, 3}));
		assertEquals("[]", Arrays.toString(new int[]{}));
	}
	
	@Test
    public void testReverse() {
		int[] array1 = { 0, 1, 2, 3, 4, 5, 6, 7 };
		int[] array1ReversedTest = { 7, 6, 5, 4, 3, 2, 1, 0 };
		Arrays.reverse(array1);
		assertTrue(array1.length == array1ReversedTest.length);
		for (int i = 0; i < array1.length; i++) {
			assertEquals(array1[i], array1ReversedTest[i]);
		}
		
		int[] array2 = {};
		int[] array2ReversedTest = {};
		Arrays.reverse(array2);
		assertTrue(array2.length == array2ReversedTest.length);
		for (int i = 0; i < array2.length; i++) {
			assertEquals(array2[i], array2ReversedTest[i]);
		}
	}
	
	@Test
	public void testIndexOfLinear() {
		int[] array1 = { 0, 1, 2, 3, 4, 5, 6, 7 };
		for (int i = 0; i < array1.length; i++) {
			assertEquals(i, Arrays.indexOfLinear(array1, i));
		}
		assertEquals(-1, Arrays.indexOfLinear(array1, 8));
		assertEquals(-1, Arrays.indexOfLinear(array1, 503));
		assertEquals(-1, Arrays.indexOfLinear(array1, -50));
		
		int[] array2 = { -43, -24, -9, 0, 13, 43, 99, 99, 102, 329 };
		assertEquals(2, Arrays.indexOfLinear(array2, -9));
		assertEquals(6, Arrays.indexOfLinear(array2, 99));
		assertEquals(9, Arrays.indexOfLinear(array2, 329));
		assertEquals(-1, Arrays.indexOfLinear(array2, -30));
		assertEquals(-1, Arrays.indexOfLinear(array2, 50));
	}
	
	@Test
	public void testIndexOfBinary() {
		int[] array1 = { 0, 1, 2, 3, 4, 5, 6, 7 };
		for (int i = 0; i < array1.length; i++) {
			assertEquals(i, Arrays.indexOfBinary(array1, i));
		}
		assertEquals(-1, Arrays.indexOfBinary(array1, 8));
		assertEquals(-1, Arrays.indexOfBinary(array1, 503));
		assertEquals(-1, Arrays.indexOfBinary(array1, -50));
		
		int[] array2 = { -43, -24, -9, 0, 13, 43, 99, 102, 329 };
		assertEquals(2, Arrays.indexOfBinary(array2, -9));
		assertEquals(6, Arrays.indexOfBinary(array2, 99));
		assertEquals(8, Arrays.indexOfBinary(array2, 329));
		assertEquals(-1, Arrays.indexOfBinary(array2, -30));
		assertEquals(-1, Arrays.indexOfBinary(array2, 50));
	}
	@Test
	public void  testSelectionsort() {
		int[] array1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Arrays.selectionsort(array1);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array1));
		
		int[] array2 = { 209, -32, -43, 0, 20, 12, -11, 111, 32, 0, 1 };
		Arrays.selectionsort(array2);
		assertEquals("[-43, -32, -11, 0, 0, 1, 12, 20, 32, 111, 209]", java.util.Arrays.toString(array2));
		
		int[] array3 = { 2, 1, 1, 1, 1, 0, 0, 0, -1, -1 };
		Arrays.selectionsort(array3);
		assertEquals("[-1, -1, 0, 0, 0, 1, 1, 1, 1, 2]", java.util.Arrays.toString(array3));
		
		int[] array4 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Arrays.selectionsort(array4);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array4));
		
		int[] array5 = { };
		Arrays.selectionsort(array5);
		assertEquals("[]", java.util.Arrays.toString(array5));
	}
	
	@Test
	public void  testInsertionsort() {
		int[] array1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Arrays.insertionsort(array1);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array1));
		
		int[] array2 = { 209, -32, -43, 0, 20, 12, -11, 111, 32, 0, 1 };
		Arrays.insertionsort(array2);
		assertEquals("[-43, -32, -11, 0, 0, 1, 12, 20, 32, 111, 209]", java.util.Arrays.toString(array2));
		
		int[] array3 = { 2, 1, 1, 1, 1, 0, 0, 0, -1, -1 };
		Arrays.insertionsort(array3);
		assertEquals("[-1, -1, 0, 0, 0, 1, 1, 1, 1, 2]", java.util.Arrays.toString(array3));
		
		int[] array4 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Arrays.insertionsort(array4);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array4));
		
		int[] array5 = { };
		Arrays.insertionsort(array5);
		assertEquals("[]", java.util.Arrays.toString(array5));
	}
	
	@Test
	public void  testBubblesort() {
		int[] array1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Arrays.bubblesort(array1);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array1));
		
		int[] array2 = { 209, -32, -43, 0, 20, 12, -11, 111, 32, 0, 1 };
		Arrays.bubblesort(array2);
		assertEquals("[-43, -32, -11, 0, 0, 1, 12, 20, 32, 111, 209]", java.util.Arrays.toString(array2));
		
		int[] array3 = { 2, 1, 1, 1, 1, 0, 0, 0, -1, -1 };
		Arrays.bubblesort(array3);
		assertEquals("[-1, -1, 0, 0, 0, 1, 1, 1, 1, 2]", java.util.Arrays.toString(array3));
		
		int[] array4 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Arrays.bubblesort(array4);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array4));
		
		int[] array5 = { };
		Arrays.bubblesort(array5);
		assertEquals("[]", java.util.Arrays.toString(array5));
	}
	
	@Test
	public void  testQuicksort() {
		int[] array1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Arrays.quicksort(array1, 0, array1.length - 1);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array1));
		
		int[] array2 = { 209, -32, -43, 0, 20, 12, -11, 111, 32, 0, 1 };
		Arrays.quicksort(array2, 0, array2.length - 1);
		assertEquals("[-43, -32, -11, 0, 0, 1, 12, 20, 32, 111, 209]", java.util.Arrays.toString(array2));
		
		int[] array3 = { 2, 1, 1, 1, 1, 0, 0, 0, -1, -1 };
		Arrays.quicksort(array3, 0, array3.length - 1);
		assertEquals("[-1, -1, 0, 0, 0, 1, 1, 1, 1, 2]", java.util.Arrays.toString(array3));
		
		int[] array4 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Arrays.quicksort(array4, 0, array4.length - 1);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array4));
		
		int[] array5 = { };
		Arrays.quicksort(array5, 0, array5.length - 1);
		assertEquals("[]", java.util.Arrays.toString(array5));
	}
	
	@Test
	public void  testMergesort() {
		int[] array1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Arrays.mergesort(array1, new int[array1.length], 0, array1.length - 1);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array1));
		
		int[] array2 = { 209, -32, -43, 0, 20, 12, -11, 111, 32, 0, 1 };
		Arrays.mergesort(array2, new int[array2.length], 0, array2.length - 1);
		assertEquals("[-43, -32, -11, 0, 0, 1, 12, 20, 32, 111, 209]", java.util.Arrays.toString(array2));
		
		int[] array3 = { 2, 1, 1, 1, 1, 0, 0, 0, -1, -1 };
		Arrays.mergesort(array3, new int[array3.length], 0, array3.length - 1);
		assertEquals("[-1, -1, 0, 0, 0, 1, 1, 1, 1, 2]", java.util.Arrays.toString(array3));
		
		int[] array4 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Arrays.mergesort(array4, new int[array4.length], 0, array4.length - 1);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array4));
		
		int[] array5 = { };
		Arrays.mergesort(array5, new int[array5.length], 0, array5.length - 1);
		assertEquals("[]", java.util.Arrays.toString(array5));
	}

}
