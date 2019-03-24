package mx.itesm.exercises;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class StacksAndQueuesApplicationsTest {
	 @Test
	    public void testBalancedBrackets() {
	        assertTrue(StacksAndQueuesApplications.balancedBrackets(""));
	        assertTrue(StacksAndQueuesApplications.balancedBrackets("(7)"));
	        assertTrue(
	        		StacksAndQueuesApplications.balancedBrackets("[]{}()([]{})"));
	        assertTrue(StacksAndQueuesApplications.balancedBrackets(
	                "[({(([[{}][{}][{}]]))})]"));
	        assertFalse(StacksAndQueuesApplications.balancedBrackets("{"));
	        assertFalse(StacksAndQueuesApplications.balancedBrackets("]({})"));
	        assertFalse(StacksAndQueuesApplications.balancedBrackets("(((("));
	        assertFalse(StacksAndQueuesApplications.balancedBrackets("))))"));
	        assertFalse(StacksAndQueuesApplications.balancedBrackets("(]{)[}"));
	        assertFalse(StacksAndQueuesApplications
	                .balancedBrackets("[]{}()[]{})([])"));
	        assertFalse(StacksAndQueuesApplications.balancedBrackets(
	                "[[({(([[{}][{}][{}]]))})]"));
	    }

	    @Test
	    public void testMerge() {
	        Queue<Integer> q1, q2, qResult;

	        q1 = new LinkedList<>();
	        q2 = new LinkedList<>();
	        qResult = new LinkedList<>();
	        assertEquals(qResult, StacksAndQueuesApplications.merge(q1, q2));

	        q1 = new LinkedList<>(
	                Arrays.asList(3, 4, 6, 6, 7, 8, 10));
	        q2 = new LinkedList<>();
	        qResult = new LinkedList<>(
	                Arrays.asList(3, 4, 6, 6, 7, 8, 10));
	        assertEquals(qResult, StacksAndQueuesApplications.merge(q1, q2));

	        q1 = new LinkedList<>();
	        q2 = new LinkedList<>(
	                Arrays.asList(1, 2, 3, 4, 5, 6, 6, 10, 15));
	        qResult = new LinkedList<>(
	                Arrays.asList(1, 2, 3, 4, 5, 6, 6, 10, 15));
	        assertEquals(qResult, StacksAndQueuesApplications.merge(q1, q2));

	        q1 = new LinkedList<>(
	                Arrays.asList(3, 4, 6, 6, 7, 8, 10));
	        q2 = new LinkedList<>(
	                Arrays.asList(1, 2, 3, 4, 5, 6, 6, 10, 15));
	        qResult = new LinkedList<>(Arrays.asList(1, 2, 3, 3,
	                4, 4, 5, 6, 6, 6, 6, 7, 8, 10, 10, 15));
	        assertEquals(qResult, StacksAndQueuesApplications.merge(q1, q2));
	    }

	    @Test
	    public void testPostfixEvaluation() {
	        assertEquals(42, StacksAndQueuesApplications.postfixEvaluation("42"));
	        assertEquals(26,
	        		StacksAndQueuesApplications.postfixEvaluation("20 6 +"));
	        assertEquals(14,
	        		StacksAndQueuesApplications.postfixEvaluation("20 6 -"));
	        assertEquals(120,
	        		StacksAndQueuesApplications.postfixEvaluation("20 6 *"));
	        assertEquals(3,
	        		StacksAndQueuesApplications.postfixEvaluation("20 6 /"));
	        assertEquals(8, StacksAndQueuesApplications
	                .postfixEvaluation("1 5 2 * 20 6 / - +"));
	        assertEquals(108, StacksAndQueuesApplications.postfixEvaluation(
	                "4 8 15 16 23 42 + + + + +"));
	        assertThrows(IllegalArgumentException.class,
	                () -> StacksAndQueuesApplications
	                        .postfixEvaluation("1 2 3 *"));
	        assertThrows(IllegalArgumentException.class,
	                () -> StacksAndQueuesApplications
	                        .postfixEvaluation("1 2 3 * * *"));
	        assertThrows(IllegalArgumentException.class,
	                () -> StacksAndQueuesApplications.postfixEvaluation("+"));
	        assertThrows(IllegalArgumentException.class,
	                () -> StacksAndQueuesApplications.postfixEvaluation("-"));
	        assertThrows(IllegalArgumentException.class,
	                () -> StacksAndQueuesApplications.postfixEvaluation("/"));
	        assertThrows(IllegalArgumentException.class,
	                () -> StacksAndQueuesApplications.postfixEvaluation(""));
	        assertThrows(IllegalArgumentException.class,
	                () -> StacksAndQueuesApplications.postfixEvaluation("1 2 @"));
	        assertThrows(IllegalArgumentException.class,
	                () -> StacksAndQueuesApplications.postfixEvaluation(
	                        "10 11 + 5 % 13 *"));
	    }

	    @Test
	    public void testConvertInfixToPostfix() {
	        assertEquals("42",
	        		StacksAndQueuesApplications.convertInfixToPostfix("42"));
	        assertEquals("1 2 +",
	        		StacksAndQueuesApplications.convertInfixToPostfix("1 + 2"));
	        assertEquals("1 2 * 3 +", StacksAndQueuesApplications
	                .convertInfixToPostfix("1 * 2 + 3"));
	        assertEquals("1 2 + 3 + 4 +", StacksAndQueuesApplications
	                .convertInfixToPostfix("1 + 2 + 3 + 4"));
	        assertEquals("1 2 +",
	        		StacksAndQueuesApplications.convertInfixToPostfix("(1 + 2)"));
	        assertEquals("1 2 3 4 + + +",
	        		StacksAndQueuesApplications.convertInfixToPostfix(
	                        "(1 + (2 + (3 + 4)))"));
	        assertEquals("1 2 3 * +", StacksAndQueuesApplications
	                .convertInfixToPostfix("1 + 2 * 3"));
	        assertEquals("1 2 + 3 *", StacksAndQueuesApplications
	                .convertInfixToPostfix("(1 + 2) * 3"));
	        assertEquals("1 2 3 * + 4 +", StacksAndQueuesApplications
	                .convertInfixToPostfix("1 + 2 * 3 + 4"));
	        assertEquals("1 2 + 3 4 + *",
	        		StacksAndQueuesApplications.convertInfixToPostfix(
	                        "(1 + 2) * (3 + 4)"));
	        assertEquals("1 2 + 3 4 * 5 / -",
	        		StacksAndQueuesApplications.convertInfixToPostfix(
	                        "1 + 2 - 3 * 4 / 5"));
	        assertEquals("1 2 / 3 * 4 - 5 +",
	        		StacksAndQueuesApplications.convertInfixToPostfix(
	                        "1 / 2 * 3 - 4 + 5"));
	        assertEquals("1 2 / 3 4 * - 5 +",
	        		StacksAndQueuesApplications.convertInfixToPostfix(
	                        "1 / 2 - 3 * 4 + 5"));
	        assertEquals("1 2 3 - + 4 5 / *",
	        		StacksAndQueuesApplications.convertInfixToPostfix(
	                        "(1 + (2 - 3)) * (4 / 5)"));
	        assertEquals("1 2 3 - / 4 5 + *",
	        		StacksAndQueuesApplications.convertInfixToPostfix(
	                        "1 / (2 - 3) * (4 + 5)"));
	        assertEquals("1 2 3 - 4 5 + * /",
	        		StacksAndQueuesApplications.convertInfixToPostfix(
	                        "1 / ((2 - 3) * (4 + 5))"));
	        assertEquals("1 2 3 4 * - 5 + /",
	        		StacksAndQueuesApplications.convertInfixToPostfix(
	                        "1 / (2 - 3 * 4 + 5)"));
	        assertEquals("42",
	        		StacksAndQueuesApplications.convertInfixToPostfix("(42)"));
	        assertEquals("42", StacksAndQueuesApplications
	                .convertInfixToPostfix("(((42)))"));
	        assertEquals("1 2 +",
	        		StacksAndQueuesApplications.convertInfixToPostfix("(1 + 2)"));
	        assertEquals("1 2 *", StacksAndQueuesApplications
	                .convertInfixToPostfix("(((1) * (2)))"));
	    }


}
