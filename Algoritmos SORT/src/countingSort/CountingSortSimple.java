package countingSort;

import java.util.Arrays;

/**
 *
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 */

public class CountingSortSimple {

	public static void sort(Integer[] array, int leftIndex, int rightIndex) {
		long delta = System.nanoTime();		
		
		
		int maior = 0;
		int menor = array[leftIndex];
		int size = array.length;
		int[] result = new int[size];
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
			else if (array[i] < menor) {
				menor = array[i];
			}
		}
		
		int[] indices = new int[maior-menor+1];

		for (int i = leftIndex; i <= rightIndex; i++) {
			indices[array[i] - menor]++;
		}

		for (int i = 1; i < indices.length; i++) {
			indices[i] = indices[i] + indices[i-1];
		}

		for (int i = rightIndex; i >= leftIndex; i--) {
			result[--indices[array[i] - menor]+leftIndex] = array[i];
		} 

		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = result[i];
		
		}
//		System.out.println("Sorteado: " + Arrays.toString(array));
		System.out.println(System.nanoTime() - delta);
	}
	
	public static void main(String[] args) {
		Integer[] array = new Integer[5000000];
		for (int j = 0; j < array.length; j++) {
			array[j] = ((int) (Math.random() * 5000000));
		} 
//		int[] array = {3,4,1,1};
//		int[] array = {-1577,1000,1200,-1700,1001};
		sort(array, 0, array.length-1);
		
	}
}
