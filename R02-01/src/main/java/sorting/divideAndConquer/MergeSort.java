package sorting.divideAndConquer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex < rightIndex && rightIndex >= 0 && leftIndex < array.length
				&& array.length != 1) {
			T[] esquerda = Arrays.copyOfRange(array, leftIndex, rightIndex/2);
			T[] direita = Arrays.copyOfRange(array, rightIndex/2+1, rightIndex);
			sort(esquerda, leftIndex, rightIndex/2);
			sort(direita, rightIndex/2+1, rightIndex);
			merge(esquerda, direita);
		}
	}

	private List<T> merge(T[] esquerda, T[] direita) {
		List<T> result = new LinkedList<T>();

		while (esquerda.length > 0 && direita.length > 0) {
			if (esquerda[0].compareTo(direita[0]) <= 0) {
				result.add(esquerda[0]);
				esquerda = Arrays.copyOfRange(esquerda, 1, esquerda.length); 
			} else {
				result.add(direita[0]);
				direita = Arrays.copyOfRange(direita, 1, direita.length); 
			}
		}
		if (esquerda.length > 0) {
			for (int i = 0; i < esquerda.length; i++) {
				result.add(esquerda[i]);
			}
		}
		if (direita.length > 0) {
			for (int i = 0; i < direita.length; i++) {
				result.add(direita[i]);
			}
		}
		System.out.println(result);
		return result;
	}
}
