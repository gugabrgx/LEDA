package vetor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import vetor.Aluno;

public class TestVetor {
	private Vetor<Aluno> vetor1, vetor2;
	private Aluno aluno, outroAluno;

	@Before
	public void Inicializa() throws Exception {
		vetor1 = new Vetor<Aluno>(10);
		vetor2 = new Vetor<Aluno>(1);
		aluno = new Aluno("Vandin", 1.7);
		outroAluno = new Aluno("Cleidyson", 2.3);
		ComparatorMaximo cMax = new ComparatorMaximo();
		ComparatorMinimo cMin = new ComparatorMinimo();
		vetor1.setComparadorMaximo(cMax);
		vetor1.setComparadorMinimo(cMin);
		vetor2.setComparadorMaximo(cMax);
		vetor2.setComparadorMinimo(cMin);
	}

	@Test
	public void testInserir() {
		assertTrue(vetor1.isVazio());
		vetor1.inserir(aluno);
		assertFalse(vetor1.isVazio());
	}

	@Test
	public void testRemover() {
		vetor1.inserir(aluno);
		assertFalse(vetor1.isVazio());
		vetor1.remover(aluno);
		assertTrue(vetor1.isVazio());
	}

	@Test
	public void testProcurar() {
		vetor1.inserir(aluno);
		Aluno procurado = vetor1.procurar(aluno);
		assertEquals(aluno, procurado);
		procurado = vetor1.procurar(outroAluno);
		assertTrue(outroAluno != procurado);
	}

	@Test
	public void testIsVazio() {
		assertTrue(vetor2.isVazio());
	}

	@Test
	public void testIsCheio() {
		for (int i = 0; i < 10; i++) {
			vetor1.inserir(aluno);
		}
		assertTrue(vetor1.isCheio());
	}

	@Test
	public void testMaximo() {
		vetor1.inserir(aluno);
		vetor1.inserir(outroAluno);
		Aluno maximo = vetor1.maximo();
		assertEquals(outroAluno, maximo);
	}

	@Test
	public void testMinimo() {
		vetor1.inserir(aluno);
		vetor1.inserir(outroAluno);
		Aluno minimo = vetor1.minimo();
		assertEquals(aluno, minimo);
	}

}
