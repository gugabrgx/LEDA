package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length
				&& array.length > 0) {
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
		}
	}
}
