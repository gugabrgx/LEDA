package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
        if ( array == null || array.length == 0 ) {
            return null;
        } if (array.length == 1) {
            return array[0];
        }
	    return auxiliar(array, 0, array.length-1, x);
	}

    public static Integer floori(Integer[] array, Integer x) {
        if (array == null || array.length == 0) {
            return null;
        }
        return auxiliar(array, 0, array.length-1, x);
    }

    private static Integer auxiliar(Integer array[], Integer leftIndex, Integer rightIndex, Integer x) {
        int iteracoes = 1;
        iteracoes++;
        int maior = max(array);
        int meio = leftIndex + (rightIndex - leftIndex)/2;
        if (meio == x) {
            return meio;
        }
        if (array[meio] > x) {
            return auxiliar(array, leftIndex, meio-1, x);
        }
        if (maior < x && iteracoes >= array.length/2)
            return meio;

        return auxiliar(array, meio+1, rightIndex, x);
    }

    private static Integer max(Integer[] array) {
        int maior = 0;
	    for (Integer i: array) {
            if (i > maior) maior = i;
        }
        return maior;
    }





    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7,8,9,0};
	    System.out.println(floori(array, 10));
    }

}
