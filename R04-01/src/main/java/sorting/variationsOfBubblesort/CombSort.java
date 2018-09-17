package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (verify(array, leftIndex, rightIndex)) {

            int gap = (int) (rightIndex-leftIndex+1);
            boolean swapped = true;

            while (gap > 1 || swapped) {
                if (gap > 1)
                    gap = (int) (gap / 1.25);
                int i = leftIndex;
                swapped = false;
                while (i + gap < rightIndex+1) {
                    if (array[i].compareTo(array[i + gap]) > 0) {
                        util.Util.swap(array, i, i + gap);
                        swapped = true;
                    }
                    i++;
                }
            }
		}
	}

    private boolean verify(T[] array, int leftIndex, int rightIndex) {
        return (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length && array.length > 0);
    }
}
