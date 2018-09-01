package produto;

/**
 * Interface usada para base da criacao das classes RepositorioProduto.
 * @author gustavolbs
 *
 * @param <T>
 */
public interface InterfaceRepositorios<T extends Produto> {

	public abstract boolean existe(int codigo);

	public abstract void inserir(T produto);

	public abstract void atualizar(T produto);

	public abstract void remover(int codigo);

	public abstract T procurar(int codigo);
}