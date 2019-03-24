package mx.itesm.util;
import java.util.Stack;
import mx.itesm.util.IntStack;

public class Arrays {

	public static int findMinimum(int array[]) {
		if (array.length <= 0) {
			return Integer.MIN_VALUE;
		}
		int Minimum = array[0];
		for(int i = 1; i< array.length;i++) {
			if(array[i] < Minimum) {
				Minimum = array[i];
			}
		}
	return Minimum;
	}	

	public static int findMaximum(int array[]) {
		if (array.length <= 0) {
			return Integer.MIN_VALUE;
		}
		int Maximum = array[0];
		for (int i = 1; i < array.length; i++) {
			if(array[i] > Maximum) {
				Maximum = array[i];
			}
		}
	return Maximum;
	}

	public static float findAverage(int array[]) {
		if (array.length <= 0) {
			return Integer.MIN_VALUE;
		}
		float sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		return sum / (float) array.length;
	}
	
	public static float sampleVariance(int array[]) {
		if (array.length <= 0) {
			return Integer.MIN_VALUE;
		}
		
		float average = findAverage(array);
		float sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += (array[i] - average) * (array[i] - average);
		}
		
		return sum / (float) array.length;
	}
	
	public static String toString(int[] array) {
		if (array.length == 0)
			return "[]";

		StringBuilder string = new StringBuilder();
		string.append("[");
		for (int i = 0; i < array.length; i++) {
			string.append(array[i]);
			if (i != array.length - 1) {
				string.append(", ");
			}
		}
		string.append("]");
		return string.toString();
		
	}
	
	public static void reverse(int[] array) {
		int x = 0;
		IntStack reverseStack = new IntStack(array.length);
		for (int i =0; i<array.length ;i++) {
			reverseStack.push(array[i]);
		}
		
		while(!reverseStack.isEmpty()) {
			array[x] = reverseStack.pop();
			
			x++;
			
		}
	}
	
	public static int indexOfLinear(int[] array, int target) {
		for (int i=0; i< array.length; i++) {
			if(array[i]==target) {
				return i;
			}
			else if (array[i]> target) {
				return -1;
			}
		}
		return -1;
	}
	//References of the book "Essential Algorithms"
	
	
	public static int indexOfBinary(int[] array, int target) {
		int min = 0;
		int max = array.length -1;
		
		while(min <= max) {
			int mid = (min + max) / 2;
			if(target <array[mid]) {
				max = mid -1;
			}
			else if (target > array[mid]) {
				min = mid +1;
			}
			else 
				return mid;
		}
		return -1;
	}
	//References of the book "Essential Algorithms"
	
	public static void insertionsort(int[] unorderedArray) {
		for(int i = 1; i < unorderedArray.length; i++) {
			for(int j = i-1; 0 <= j ;j--) {
				if(unorderedArray[j] > unorderedArray[j+1]) {
					
					int temp = unorderedArray[j];
					unorderedArray[j] = unorderedArray[j+1];
					unorderedArray[j+1] = temp;
				}
			}
		}
	}
	
	public static void selectionsort(int[] unorderedArray) {
		for(int i = 0; i < unorderedArray.length;i++) {
			int min = i;
			for(int j = i+1; j < unorderedArray.length; j++) {
				if(unorderedArray[j]<unorderedArray[min]) {
					min = j;
				}
			}
			int temp = unorderedArray[min];
			unorderedArray[min] =unorderedArray[i];
			unorderedArray[i] = temp;
		}
	}
	
	public static void bubblesort(int[] unorderedArray) {
		boolean not_sorted = false;
		
		while(!not_sorted) {
			not_sorted = true;
			
			for(int i = 0; i<unorderedArray.length-1; i++) {
				if(unorderedArray[i] > unorderedArray[i+1]) {
					int temp = unorderedArray[i];
					unorderedArray[i]= unorderedArray[i+1];
					unorderedArray[i+1]=temp;
					
					not_sorted = false;
				}
			}
		}
	}
	
	public static void quicksort(int[] unorderedArray, int minIndex, int maxIndex) {
		if (minIndex < maxIndex) {
			
			int divider = unorderedArray[minIndex];
			Stack<Integer> before = new Stack<Integer>();
			Stack<Integer> after = new Stack<Integer>();
			
			for(int i = minIndex+1; i <= maxIndex; i++) {
				if(unorderedArray[i] < divider) {
					before.push(unorderedArray[i]);
				}
				else{
					after.push(unorderedArray[i]);
				}
			}
			
			int index = minIndex;
			
			while(!before.isEmpty()) {
				unorderedArray[index++] = before.pop();
				//index++;
			}
			
			int midIndex = index;
			unorderedArray[index++]= divider;
			//index++;
			
			
			while(!after.isEmpty()) {
				unorderedArray[index++] = after.pop();
				//index++;
			}
			
			quicksort(unorderedArray, minIndex, midIndex-1);
			quicksort(unorderedArray, midIndex+1, maxIndex);
		}
	}
	
	public static void mergesort(int[] unorderedArray, int[] scratch, int minIndex, int maxIndex) {
		if (minIndex < maxIndex) { 
	
			int mid = (minIndex + maxIndex)/ 2;
			
			mergesort(unorderedArray, scratch, minIndex, mid);
			mergesort(unorderedArray, scratch, mid+1, maxIndex);
			
			//Merge the two sorted halves
			int left_index = minIndex;
			int right_index = mid+1;
			int scratch_index= left_index;
			
			while((left_index <= mid) && (right_index <= maxIndex)){
				if (unorderedArray[left_index] <= unorderedArray[right_index]) {
					scratch[scratch_index] = unorderedArray[left_index];
					left_index ++;
				}
				else {
					scratch[scratch_index] = unorderedArray[right_index];
					right_index++;
				}
				scratch_index++;
			}
			for(int i = left_index; i<= mid; i++) {
				scratch[scratch_index] = unorderedArray[i];
				scratch_index++;
			}
			for(int i = right_index; i<= maxIndex; i++) {
				scratch[scratch_index] = unorderedArray[i];
				scratch_index++;
			}
			for(int i= minIndex; i<= maxIndex; i++) {
				unorderedArray[i]= scratch[i];
			}
		}
	}
}
