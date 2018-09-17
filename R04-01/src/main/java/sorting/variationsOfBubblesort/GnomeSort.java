package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
        if (verify(array, leftIndex, rightIndex)) {
            int pivot = leftIndex;

            while (pivot < rightIndex - leftIndex) {
                if (array[pivot].compareTo(array[pivot + 1]) > 0) {
                    util.Util.swap(array, pivot, pivot + 1);
                    if (pivot > 0) {
                        pivot -= 2;
                    }
                }
                pivot++;
            }
        }
	}

	private boolean verify(T[] array, int leftIndex, int rightIndex) {
        return (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length && array.length > 0);
	}
}
