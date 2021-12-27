package financeiro.bolsa.acao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import financeiro.usuario.Usuario;

public class AcaoDAOHibernate implements AcaoDAO {

	private Session sessao;
	
	
	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@Override
	public void salvar(Acao acao) {
		this.sessao.saveOrUpdate(acao);
		
	}

	@Override
	public void excluir(Acao acao) {
		this.sessao.delete(acao);
		
	}

	@Override
	public Acao carregar(String codigo) {
		
		return (Acao) this.sessao.get(Acao.class, codigo);
	}

	@Override
	public List<Acao> listar(Usuario usuario) {
		Criteria criteria = this.sessao.createCriteria(Acao.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		return criteria.list();
	}

}
