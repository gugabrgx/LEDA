package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array) {
		int result = 0;  
		if(array == null || array.length==0) {
	        result = 0;
	    }
	    else {
	        result = somaArray(array, array.length-1);
	    }
		System.out.println(result);
	    return result;
	}
	
	private int somaArray(int[] array, int arraySize) {
		int result = 0;
	    if(arraySize == 0) {
	        result =  array[arraySize];
	    }
	    else {
	        result = array[arraySize] + somaArray(array, arraySize-1);
	    }
	    return result;
	}

	public long calcularFatorial(int n) {
		long result = 1;
		if (n == 0)
			result = 1;
		else
			result = n * calcularFatorial(n - 1);
		System.out.println(n + "! = " + result);
		return result;
	}
	
	private int resultFibonacci(int n) {
		int result = 1;

		if (n == 1 || n == 2) {
			result = 1;
		} else {
			result = resultFibonacci(n - 1) + resultFibonacci(n - 2);
		}

		return result;
	}

	public void calcularFibonacci(int n) {
		for (int i = 1; i <= n; i++) {
            System.out.print(resultFibonacci(i) + ", ");
        }
	}
	
	public int countNotNull(Object[] array) {
		int result = 0;
		result = contaNaoNulosArray(array, 0);
		System.out.println(result);
		return result;
	}
	
	private int contaNaoNulosArray(Object[] array, int indice) {
		int result = 0;
		if (array[indice] != null) 
			result++;
		if (indice != array.length - 1) 
			result = result + contaNaoNulosArray(array, indice + 1);
		return result;
	}

	public long potenciaDe2(int expoente) {
		long result = 1;
		if (expoente == 0) {
			
		}
		else {
			result = 2 * potenciaDe2(expoente - 1);
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if (n == 1) {
			
		} else {
			result = progressaoAritmetica(termoInicial, razao, n-1) + razao;
		}
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if (n == 1) {
			
		} else {
			result = razao * progressaoGeometrica(termoInicial, razao, n-1);
		}
		return result;
	}

}
