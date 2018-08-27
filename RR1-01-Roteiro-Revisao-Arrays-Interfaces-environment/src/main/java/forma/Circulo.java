package forma;

/** 
 * Laboratório de Programação 2
 * 
 * @author Gustavo Santos - 117210400
 * @lab Laboratório de Estrutura de Dados
 * @RR 01
 * @turma 01
 */
public class Circulo {
	
	private double raio;

	public Circulo(double raio) {
		this.raio = raio;
	}
	
	public double area() {
		return Math.PI * Math.pow(raio, 2);
	}
}
