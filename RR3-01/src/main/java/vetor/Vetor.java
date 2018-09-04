package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T extends Comparable<T>> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int size;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator<T> comparadorMaximo, comparadorMinimo;

	public Vetor(int size) {
		super();
		this.size = size;
		this.indice = -1;
		this.arrayInterno = (T[]) new Comparable[size];
	}

	public void setComparadorMaximo(Comparator<T> comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator<T> comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		this.arrayInterno[++indice] = o;
	}

	// Remove um objeto do vetor
	public T remover(T o) {
		T resultado = null;
		boolean achou = false;
		int i = 0;
		while (i <= indice && !achou) {
			if (arrayInterno[i].equals(o)) {
				resultado = arrayInterno[i];
				arrayInterno[i] = arrayInterno[indice];
				arrayInterno[indice] = null;
				indice--;
				achou = true;
			}
			i++;
		}
		return resultado;
	}

	// Procura um elemento no vetor
	public T procurar(T o) {
		T resultado = null;
		boolean achou = false;
		int i = 0;
		while (i <= indice && !achou) {
			if (arrayInterno[i].equals(o)) {
				resultado = arrayInterno[i];
				achou = true;
			}
			i++;
		}
		return resultado;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		boolean vazio = true;
		if (indice != -1) vazio = false;
		return vazio;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		boolean cheio = false;
		if (indice == size - 1) cheio = true;
		return cheio;
	}
	
	public T maximo() {
		T resultado = null;
		if (!isVazio()) {
			resultado = arrayInterno[0];
			for (int i = 0; i <= indice; i++) {
				if (comparadorMaximo.compare(resultado, arrayInterno[i]) < 0) 
					resultado = arrayInterno[i];
			}
		}
		return resultado;
	}

	public T minimo() {
		T resultado = null;
		if (!isVazio()) {
			resultado = arrayInterno[0];
			for (int i = 0; i <= indice; i++) {
				if (comparadorMinimo.compare(resultado, arrayInterno[i]) < 0) 
					resultado = arrayInterno[i];
			}
		}
		return resultado;
	}
}

class ComparatorMaximo implements Comparator<Aluno> {

	@Override
	public int compare(Aluno a1, Aluno a2) {
		return (int) (a1.getMedia() - a2.getMedia());
	}
}

class ComparatorMinimo implements Comparator<Aluno> {

	@Override
	public int compare(Aluno a1, Aluno a2) {
		return (int) (a2.getMedia() - a1.getMedia());
	}
}