package financeiro.cheque;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import financeiro.conta.Conta;
import financeiro.lancamento.Lancamento;

@Entity
@Table(name = "cheque")
public class Cheque implements Serializable {

	public static final char SITUACAO_CHEQUE_BAIXO = 'B';
	public static final char SITUACAO_CHEQUE_CANCELADO = 'C';
	public static final char SITUACAO_CHEQUE_NAO_EMITIDO = 'N';
	
	@EmbeddedId
	private ChequeId chequeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "conta", referencedColumnName = "cod_conta", insertable = false, updatable = false)
	@ForeignKey(name = "fk_cheque_conta")
	private Conta conta;
	
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;
	
	@Column(nullable = false, precision = 1)
	private Character situacao;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "lancamento", referencedColumnName = "codigo", nullable = true)
	@ForeignKey(name = "fk_cheque_lancamento")
	private Lancamento lancamento;


	public ChequeId getChequeId() {
		return chequeId;
	}


	public void setChequeId(ChequeId chequeId) {
		this.chequeId = chequeId;
	}


	public Conta getConta() {
		return conta;
	}


	public void setConta(Conta conta) {
		this.conta = conta;
	}


	public Date getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public Character getSituacao() {
		return situacao;
	}


	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}


	public Lancamento getLancamento() {
		return lancamento;
	}


	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}


	@Override
	public int hashCode() {
		return Objects.hash(chequeId, conta, dataCadastro, lancamento, situacao);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cheque other = (Cheque) obj;
		return Objects.equals(chequeId, other.chequeId) && Objects.equals(conta, other.conta)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(lancamento, other.lancamento)
				&& Objects.equals(situacao, other.situacao);
	}
	
	
	
}
