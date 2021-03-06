package financeiro.lancamento;

import java.util.Date;
import java.util.List;

import financeiro.conta.Conta;
import financeiro.util.DAOFactory;

public class LancamentoRN {
	
	private LancamentoDAO lancamentoDAO;

	public LancamentoRN() {	
		this.lancamentoDAO = DAOFactory.criarLancamentoDAO();
	}
	
	public void salvar(Lancamento lancamento) {
		this.lancamentoDAO.salvar(lancamento);
	}
	
	public void excluir(Lancamento lancamento) {
		this.lancamentoDAO.excluir(lancamento);
	}
	
	public Lancamento carregar(Integer lancamento) {
		return this.lancamentoDAO.carregar(lancamento);
	}
	
	public float saldo(Conta conta, Date date) {
		float saldoInicial = conta.getSaldoInicial();
		float saldoNaData = this.lancamentoDAO.saldo(conta, date);
		return saldoInicial + saldoNaData;
	}
	
	public List<Lancamento> listar(Conta conta, Date dataInicio, Date DataFim){
		return this.lancamentoDAO.listar(conta, dataInicio, DataFim);
	}

}
