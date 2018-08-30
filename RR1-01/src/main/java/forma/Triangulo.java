package forma;

/** 
 * Laboratório de Programação 2
 * 
 * @author Gustavo Santos - 117210400
 * @lab Laboratório de Estrutura de Dados
 * @RR 01
 * @turma 01
 */
public class Triangulo implements Forma {
	
	private double base;
	private double altura;
	
	public Triangulo(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}
	
	@Override
	public double area() {
		return (base * altura)/2;
	}
}
