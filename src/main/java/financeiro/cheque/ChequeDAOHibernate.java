package financeiro.cheque;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import financeiro.conta.Conta;

public class ChequeDAOHibernate implements ChequeDAO {
	
	private Session sessao;
	
	public void setSession(Session sessao) {
		this.sessao = sessao;
	}

	@Override
	public void salvar(Cheque cheque) {
		this.sessao.saveOrUpdate(cheque);
		
	}

	@Override
	public void excluir(Cheque cheque) {
		this.sessao.delete(cheque);
		
	}

	@Override
	public Cheque carregar(ChequeId chequeId) {
		return  (Cheque) this.sessao.get(Cheque.class, chequeId);
	}

	@Override
	public List<Cheque> listar(Conta conta) {
		Criteria criteria = this.sessao.createCriteria(Cheque.class);
		criteria.add(Restrictions.eq("conta", conta));
		return criteria.list();
	}

}
