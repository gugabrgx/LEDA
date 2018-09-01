package produto;


/**
 * Classe usada para generalizar os repositorios dos produtos nao
 * pereciveis e dos produtos pereciveis que nao utilizam ArrayList.
 * @author gustavolbs
 *
 * @param <T>
 */
public class RepositorioProdutosArray<T extends Produto> implements InterfaceRepositorios<T> {

	private T[] produtos;
	private int index = -1;

	public RepositorioProdutosArray(int size) {
		super();
		this.produtos = (T[]) new Object[size];
	}

	private int procurarIndice(int codigo) {
		int i = 0;
		int retorno = -1;
		boolean achou = false;
		while ((i <= index) && !achou) {
			if (produtos[i].getCodigo() == codigo) {
				retorno = i;
				achou = true;
			}
			i = i + 1;
		}
		return retorno;
	}

	@Override
	public boolean existe(int codigo) {
		boolean existe = false;
		if (this.procurarIndice(codigo) != -1) existe = true;
		return existe;
	}

	@Override
	public void inserir(T produto) {
		produtos[++index] = produto;
	}

	@Override
	public void atualizar(T produto) {
		if (existe(produto.getCodigo()))
			produtos[procurarIndice(produto.getCodigo())] = produto;
		else 
			throw new RuntimeException("Produto nao encontrado");
	}

	@Override
	public void remover(int codigo) {
		if (this.procurarIndice(codigo) != -1) {
			produtos[this.procurarIndice(codigo)] = produtos[index];
			produtos[index] = null;
			index--;
		} else {
			throw new RuntimeException("Produto nao encontrado");
		}
	}

	@Override
	public T procurar(int codigo) {
		T retorno = null;
		if (this.procurarIndice(codigo) != -1) 
			retorno = produtos[this.procurarIndice(codigo)];
		else 
			throw new RuntimeException("Produto nao encontrado");
		return retorno;
	}
}
