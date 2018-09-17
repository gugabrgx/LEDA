package sorting.mergeSort;

/**
 *
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 */

public class Main {

	public static void main(String[] args) {

		int[] array = {21, 23, 2, 34, 245, 33, 66};

		MergeSortSimple mss = new MergeSortSimple();
		mss.mergeSort(array, 0, array.length);
	}

}
