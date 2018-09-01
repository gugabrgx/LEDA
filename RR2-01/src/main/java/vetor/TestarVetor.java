package vetor;

public class TestarVetor {

	public static void main(String[] args) {
		Vetor<Aluno> vetor = new Vetor<Aluno>(2);
		Aluno a1 = new Aluno("Vandin", 1.7);
		Aluno a2 = new Aluno("Cleidyson", 2.3);
		ComparatorMaximo cMax = new ComparatorMaximo();
		vetor.setComparadorMaximo(cMax);
		ComparatorMinimo cMin = new ComparatorMinimo();
		vetor.setComparadorMinimo(cMin);
		
		vetor.inserir(a1);
		vetor.inserir(a2);
		
		System.out.println(vetor.maximo());
		System.out.println(vetor.minimo());
		System.out.println(cMax.compare(a1, a2));
		System.out.println(cMin.compare(a1, a2));
		System.out.println(vetor.isCheio());
		System.out.println(vetor.isVazio());
		System.out.println(vetor.procurar(a1));
		
	}
}
