package mx.itesm.exercises;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class StacksAndQueuesApplications {
	
	public static boolean balancedBrackets(String expr) {
		
		Deque<Character> stack = new LinkedList<Character>();
		for (int i=0; i < expr.length(); i++) {
			Character simbolo = expr.charAt(i);
			if (simbolo == '['|| simbolo == '(' || simbolo == '{') {
				stack.push(simbolo);
			}
			else if(simbolo == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(simbolo == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }           
            } else if(simbolo == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
		}
		
		if (stack.isEmpty()) 
			return true;
		else
			return false;
	}

	public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2) {
		Queue<Integer> qResult = new LinkedList<Integer>();
		
		while (!q1.isEmpty() && !q2.isEmpty()) {
			
			if(q1.peek() < q2.peek()) {
				qResult.add(q1.poll());
			}
			else
				qResult.add(q2.poll());
		}
		
		while(!q1.isEmpty()) {
			qResult.add(q1.poll());
		}
		
		while(!q2.isEmpty()) {
			qResult.add(q2.poll());
		}
		
		return qResult;
		
	}

	public static int postfixEvaluation(String expr) {
		Deque<Integer> stack = new LinkedList<Integer>();
		Queue<String> elements = tokenize(expr);

		while (!elements.isEmpty()) {
			String element = elements.remove();
			if (Character.isDigit(element.charAt(0))) {
				stack.push(Integer.parseInt(element));
			} else if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
				if (stack.size() < 2) {
					throw new IllegalArgumentException();
				}
				int b = stack.pop();
				int a = stack.pop();

				if (element.equals("+")) {
					stack.push(a + b);
				} else if (element.equals("-")) {
					stack.push(a - b);
				} else if (element.equals("*")) {
					stack.push(a * b);
				} else if (element.equals("/")) {
					stack.push(a / b);
				}
			} else {
				throw new IllegalArgumentException();
			}
		}

		if (stack.size() == 1) {
			return stack.pop();
		}

		throw new IllegalArgumentException();
	}

	public static String convertInfixToPostfix(String expr) {
		Deque<String> stack = new LinkedList<String>();
		Queue<String> queue = new LinkedList<String>();

		Queue<String> elements = tokenize(expr);

		while (!elements.isEmpty()) {
			String element = elements.remove();

			if (Character.isDigit(element.charAt(0))) {
				queue.add(element);
			} else if (element.equals("(")) {
				stack.push(element);
			} else if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					if (hasHigherPrecedence(stack.peek(), element)) {
						queue.add(stack.pop());
					} else {
						break;
					}
				}
				stack.push(element);
			} else if (element.equals(")")) {
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					queue.add(stack.pop());
				}
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
		}

		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}

		String result = "";
		while (queue.size() > 1) {
			result += queue.remove() + " ";
		}
		result += queue.remove();

		return result;
	}

	public static java.util.Queue<String> tokenize(String in) {
		java.util.regex.Pattern p = java.util.regex.Pattern.compile("(\\s)|(\\d+)|(.)");
		java.util.regex.Matcher m = p.matcher(in);
		java.util.Queue<String> result = new java.util.LinkedList<String>();
		while (m.find()) {
			if (m.group(1) == null) {
				result.add(m.group());
			}
		}
		return result;
	}

	public static boolean hasHigherPrecedence(String stackTop, String operator) {
		return !((stackTop.equals("+") || stackTop.equals("-")) && (operator.equals("*") || operator.equals("/")));
	}
	
	public static String reverseParenthesis (String expr) {
		/*Deque<Deque<Character>> collectionOfStacks = new LinkedList<Deque<Character>>();
		String result = "";
		
		for(int i = 0; i< expr.length();i++) {
			char element = expr.charAt(i);
		
			if(element == '(') {
				collectionOfStacks.push(new LinkedList<Character>());
			}else if (element== ')') {
				
				Deque<Character> lastStack = collectionOfStacks.pop();
				while (lastStack.isEmpty()) {
					if(collectionOfStacks.isEmpty()) {
						result += lastStack.pop();
					} else {
						collectionOfStacks.peek().push(lastStack.pop());
					}
				}	
			}else {
				if(collectionOfStacks.isEmpty()) {
					result += element;
				}else {
					collectionOfStacks.peek().push(element);
				}
			}
		}
		
		return result;*/
		
		Deque<Character> stack = new LinkedList<Character>();
		Queue<Character> queue = new LinkedList<Character>();
		
		for (int i = 0; i <expr.length(); i++) {
			char element = expr.charAt(i);
			
			if (element==')') {
				char elementInStack = stack.pop();
				while(elementInStack != '(') {
					queue.add(elementInStack);
					elementInStack = stack.pop();
				}
				while (!queue.isEmpty()) {
					stack.push(queue.remove());
				}
			}else {
				stack.push(element);
			}
		}
		
		String result = "";
		while (!stack.isEmpty()) {
			result = stack.pop() + result;
		}
		
		return result;
	}
}
