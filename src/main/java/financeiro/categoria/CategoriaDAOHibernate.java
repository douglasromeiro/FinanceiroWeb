package financeiro.categoria;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import financeiro.usuario.Usuario;

public class CategoriaDAOHibernate implements CategoriaDAO {
	
	private Session sessao;

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@Override
	public Categoria salvar(Categoria categoria) {
		Categoria merged = (Categoria) this.sessao.merge(categoria);
		this.sessao.flush();
		this.sessao.clear();
		return merged;
	}

	@Override
	public void excluir(Categoria categoria) {
		categoria = (Categoria) this.carregar(categoria.getCodigo());
		this.sessao.delete(categoria);
		this.sessao.flush();
		this.sessao.close();		
		
	}

	@Override
	public Categoria carregar(Integer categoria) {
		return (Categoria) this.sessao.get(Categoria.class, categoria);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listar(Usuario usuario) {
		String hql = "select c from Categoria c where c.pai is null and c.usuario = :usuario";
		Query query = this.sessao.createQuery(hql);
		query.setInteger("usuario", usuario.getCodigo());
		
		List<Categoria> lista = query.list();
		return lista;
	}

}
