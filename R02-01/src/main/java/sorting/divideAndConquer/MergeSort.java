package sorting.divideAndConquer;

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
		if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length
				&& array.length > 0) {
			int meio = ((rightIndex + leftIndex) / 2);
			sort(array, leftIndex, meio);
			sort(array, meio + 1, rightIndex);
			merge(array, leftIndex, meio, rightIndex);
		}
	}

	@SuppressWarnings("unchecked")
	public void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		T[] copia = (T[]) new Comparable[array.length];

		for (int i = leftIndex; i <= rightIndex; i++) {
			copia[i] = array[i];
		}

		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;

		while (i <= middle && j <= rightIndex) {
			if (copia[i].compareTo(copia[j]) < 0) {
				array[k] = copia[i];
				i++;
			} else {
				array[k] = copia[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			array[k] = copia[i];
			i++;
			k++;
		}

		while (j <= rightIndex) {
			array[k] = copia[j];
			j++;
			k++;
		}
	}
}