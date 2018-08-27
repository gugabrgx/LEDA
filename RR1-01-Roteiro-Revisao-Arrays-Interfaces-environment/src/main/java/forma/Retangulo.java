package forma;

/** 
 * Laboratório de Programação 2
 * 
 * @author Gustavo Santos - 117210400
 * @lab Laboratório de Estrutura de Dados
 * @RR 01
 * @turma 01
 */
public class Retangulo implements Forma {

	private double altura;
	protected double base;
	
	public Retangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	public double area() {
		return base * altura;
	}
	
}
