package mx.itesm.util;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class Sorting {
public static <T extends Comparable<T>> List<T> insertionsort(List<T> unorderedList) {
		
		// Copiamos los valores de unorderedList y los guardamos en una nueva lista.
		List<T> unorderedSection = new LinkedList<T>(unorderedList);
		List<T> orderedSection = new LinkedList<T>();
		
		while (!unorderedSection.isEmpty()) {
			T element = unorderedSection.remove(0);
			
			int index = 0;
			while (index < orderedSection.size() &&  element.compareTo(orderedSection.get(index)) >= 0) {
				index++;
			}
			
			orderedSection.add(index, element);
		}
		
		return orderedSection;
	}
	
	public static <T extends Comparable<T>> List<T> selectionsort(List<T> unorderedList) {
		List<T> result = new LinkedList<T>();
		List<T> copy = new LinkedList<T>(unorderedList);
		
		while(!copy.isEmpty()) {
			int minIndex = 0;
			for(int i = 0; i < copy.size(); i++) {
				if(copy.get(minIndex).compareTo(copy.get(i))>=1) {
					minIndex = i;
				}
			}
			result.add(copy.remove(minIndex));
		}
		return result;
	}

	public static List<Integer> bucketsort(List<Integer> unorderedList) {
		List<LinkedList<Integer>> buckets = new LinkedList<LinkedList<Integer>>();
        for (int i = 0; i < 10; i++) {
            buckets.add((new LinkedList<Integer>()));
        }
        for (int i = 0; i < unorderedList.size(); i++) {
            int current = unorderedList.get(i);
            
            for (int j = 0; j < buckets.size(); j++) {
                int low = 0 + (10 * j);
                int high = 9 + (10 * j);
                if (current >= low && current <= high) {
                    buckets.get(j).add(current);
                    break;
                }
            }
        }
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < buckets.size(); i++) {
        	Collections.sort(buckets.get(i));
            result.addAll(buckets.get(i));
        }
        
        return result;
	}

	public static <T extends Comparable<T>> List<T> bogosort(List<T> unorderedList) {
		List<T> copy = new LinkedList<T>(unorderedList);
		int i = 0;
    	for(; i <= copy.size() - 2; i++) {
    		if((copy.get(i).compareTo(copy.get(i + 1)) == 1)) {
    			i = -1;
    			Collections.shuffle(copy);
    		}
    	}
    	return copy;
	}

	public static <T extends Comparable<T>> List<T> quicksort(List<T> unorderedList) {
		//Caso base
		if(unorderedList.size() <= 1) return unorderedList;
		List<T> copy = new LinkedList<T>(unorderedList);
		T pivote = copy.remove(0);
		List<T> before = new LinkedList<T>();
    	List<T> after = new LinkedList<T>();
    	
    	while(!copy.isEmpty()) {
    		T element = copy.remove(0);
    		if(element.compareTo(pivote) >= 1) {
    			after.add(element);
    		}else {
    			before.add(element);
    		}
    	}
    	before = quicksort(before);
    	after = quicksort(after);
    	
    	List<T> result = new LinkedList<T>();
    	result.addAll(before);
    	result.add(pivote);
    	result.addAll(after);
    	
    	
    	return result;
	}

}
