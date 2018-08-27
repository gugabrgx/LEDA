package forma;

/** 
 * Laboratório de Programação 2
 * 
 * @author Gustavo Santos - 117210400
 * @lab Laboratório de Estrutura de Dados
 * @RR 01
 * @turma 01
 */
public class Quadrado extends Retangulo {

	public Quadrado(double base, double altura) {
		super(base, altura);
	}

	@Override
	public double area() {
		return Math.pow(base, 2);
	}
}
