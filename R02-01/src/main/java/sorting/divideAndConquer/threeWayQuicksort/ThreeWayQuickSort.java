package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitos elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
	      if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length && array.length > 0) {
		  	if (rightIndex <= leftIndex) {
		        	return;
		        }
		        int menor = leftIndex, maior = rightIndex;
		        T vetor = array[leftIndex];
		        int indice = leftIndex + 1;
		        while (indice <= maior) {
		            if (array[indice].compareTo(vetor) < 0) {
		            	util.Util.swap(array, menor++, indice++);
		            }
		            else if (array[indice].compareTo(vetor) > 0) {
		            	util.Util.swap(array, indice, maior--);
		            }
		            else {
		            	indice++;
		            }
		        }
		        sort(array, leftIndex, menor-1);
		        sort(array, maior+1, rightIndex);
	      }
	}
	      

}
