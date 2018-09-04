package recursao;

/** 
 * Laboratório de Programação 2
 * 
 * @author Gustavo Santos - 117210400
 * @lab Laboratório 
 */
public class Main {
	
	public static void main(String[] args) {
		int[] arrayInt = {1, 2, 3, 4};
		String[] arrayStr = {"a","b",null,"d",null,null,"g","h",null,"j"};
		MetodosRecursivos mr = new MetodosRecursivos();
		mr.calcularFatorial(12);
		mr.calcularFibonacci(8);
		mr.countNotNull(arrayStr);
		System.out.println(mr.potenciaDe2(4));
		System.out.println(mr.progressaoAritmetica(1, 3, 2));
		System.out.println(mr.progressaoGeometrica(2, 2, 3));
		mr.calcularSomaArray(arrayInt);
		
		
	}
}
