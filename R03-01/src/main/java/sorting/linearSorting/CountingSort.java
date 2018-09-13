package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 */
public class CountingSort extends AbstractSorting<Integer> {

    @Override
    public void sort(Integer[] array, int leftIndex, int rightIndex) {
        if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length
                && array.length > 0) {
            int maior = 0;
            int menor = array[leftIndex];
            int[] result = new int[array.length];

            for (int i = leftIndex; i <= rightIndex; i++) {
                if (array[i] > maior) {
                    maior = array[i];
                } else if (array[i] < menor) {
                    menor = array[i];
                }
            }

            int[] indices = new int[maior - menor + 1];

            for (int i = leftIndex; i <= rightIndex; i++) {
                indices[array[i] - menor]++;
            }

            for (int i = 1; i < indices.length; i++) {
                indices[i] = indices[i] + indices[i - 1];
            }

            for (int i = rightIndex; i >= leftIndex; i--) {
                result[--indices[array[i] - menor] + leftIndex] = array[i];
            }

            for (int i = leftIndex; i <= rightIndex; i++) {
                array[i] = result[i];

            }
        }
    }
}
