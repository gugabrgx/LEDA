package sorting.mergeSort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 */

public class MergeSortSimple {

	public void mergeSort(int[] array, int leftIndex, int rightIndex) {
		if (rightIndex == 1) return;
		if (leftIndex > rightIndex) {
			return;
		} else {
			System.out.println("N RODA");
			mergeSort(array, leftIndex, rightIndex/2);
			mergeSort(array, rightIndex/2+1, rightIndex);
            merge(array, leftIndex, rightIndex/2, rightIndex);
		}
	}
	
	public void merge(int[] array, int left, int middle, int right) {
		System.out.println("EAE PARÇA");
		List<Integer> result = new LinkedList<Integer>();
		int esquerda[] = new int[middle];
		int direita[] = new int[right-middle];
		for (int i = left; i <= middle; i++) {
			esquerda[i] = array[i];
		}
		for (int i = middle+1; i <= right; i++) {
			direita[i] = array[i];
		}
		System.out.println(Arrays.toString(esquerda));
		System.out.println(Arrays.toString(direita));
		int e = 0, d = 0;
		while(e < esquerda.length  && d < direita.length) {
			if (esquerda[e] <= direita[d]) {
				result.add(esquerda[e]);
				e++;
			} else {
				result.add(direita[d]);
				d++;
			}
		}
		
		if (e < esquerda.length) {
			for (int i = e; i < esquerda.length; i++) {
				result.add(esquerda[e]);
			}
		}
		if (d < direita.length) {
			for (int i = d; i < direita.length; i++) {
				result.add(direita[d]);
			}
		}
		System.out.println(result);
	}
	
	
}
