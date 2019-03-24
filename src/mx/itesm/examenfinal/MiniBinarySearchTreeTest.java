package mx.itesm.examenfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MiniBinarySearchTreeTest {
	private MiniBinarySearchTree<Integer> tree1;
	private MiniBinarySearchTree<Integer> tree2;
	private MiniBinarySearchTree<Integer> tree3;
	private MiniBinarySearchTree<Integer> tree4;
	private MiniBinarySearchTree<Integer> tree5;
	
	private List<Integer> tree1List;
	private List<Integer> tree2List;
	private List<Integer> tree3List;
	private List<Integer> tree4List;
	private List<Integer> tree5List;
	
	@BeforeEach
	void setup() {
		tree1 = new MiniBinarySearchTree<Integer>();
		tree1.add(6);
		tree1.add(2);
		tree1.add(1);
		tree1.add(4);
		tree1.add(3);
		tree1.add(5);
		tree1.add(7);
		tree1.add(8);
		tree1.add(11);
		tree1.add(9);
		tree1.add(10);
		tree1.add(12);
		
		tree1List =  Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		
		tree2  = new MiniBinarySearchTree<Integer>();
		tree2.add(12);
		tree2.add(13);
		tree2.add(6);
		tree2.add(7);
		tree2.add(9);
		tree2.add(8);
		tree2.add(11);
		tree2.add(10);
		tree2.add(2);
		tree2.add(1);
		tree2.add(5);
		tree2.add(3);
		tree2.add(4);
		
		tree2List = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
		
		tree3 = new MiniBinarySearchTree<Integer>();
		tree3.add(4);
		tree3.add(5);
		tree3.add(2);
		tree3.add(1);
		tree3.add(3);
		
		tree3List = Arrays.asList(1, 2, 3, 4, 5);
		
		tree4 = new MiniBinarySearchTree<Integer>();
		
		tree4List = new LinkedList<Integer>();
		
		tree5 = new MiniBinarySearchTree<Integer>();
		tree5.add(4);
		
		tree5List = Arrays.asList(4);
	}

	@Test
	void testInorderTraversal() {
		assertIterableEquals(tree1List, tree1);
		assertIterableEquals(tree2List, tree2);
		assertIterableEquals(tree3List, tree3);
		assertIterableEquals(tree4List, tree4);
		assertIterableEquals(tree5List, tree5);
	}
	
	@Test
	void testHeight() {
		assertEquals(6, tree1.height());
		assertEquals(6, tree2.height());
		assertEquals(3, tree3.height());
		assertEquals(0, tree4.height());
		assertEquals(1, tree5.height());
	}
	
	@Test
	void testDiameter() {
		assertEquals(9, tree1.diameter());
		assertEquals(9, tree2.diameter());
		assertEquals(4, tree3.diameter());
		assertEquals(0, tree4.diameter());
		assertEquals(1, tree5.diameter());
	}

	@Test
	void testIsFull() {
		assertFalse(tree1.isFull());
		assertFalse(tree2.isFull());
		assertTrue(tree3.isFull());
		assertTrue(tree4.isFull());
		assertTrue(tree5.isFull());
	}

}
