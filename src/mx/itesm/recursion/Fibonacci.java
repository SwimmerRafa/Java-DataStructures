package mx.itesm.recursion;

public class Fibonacci {
	
	private int[] fibs;
	private int maxN;
	
	public Fibonacci() {
		fibs = new int[200];
		fibs[0]= 0;
		fibs[1]= 1;
		maxN = 1;
	}
	
	public int getNumber(int n) {
		if (maxN < n) {
			fibs[n] = getNumber(n-1) + getNumber(n-2);
			maxN = n;
		}
		return fibs[n];
	}

}
