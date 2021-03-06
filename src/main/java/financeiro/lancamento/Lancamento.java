package financeiro.lancamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import financeiro.categoria.Categoria;
import financeiro.cheque.Cheque;
import financeiro.conta.Conta;
import financeiro.usuario.Usuario;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private Integer lancamento;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="cod_usuario", nullable=true)
	@ForeignKey(name = "fk_lancamento_usuario")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "conta", nullable = false)
	@ForeignKey(name = "fk_lancamento_conta")
	private Conta conta;

	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "categoria", nullable = false)
	@ForeignKey(name = "fk_lancamento_categoria")
	private Categoria categoria;

	@Temporal(TemporalType.DATE)
	private Date data;
	private String descricao;
	@Column(precision = 10, scale = 2)
	private BigDecimal valor;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "lancamento")
	private Cheque cheque;

	public Integer getLancamento() {
		return lancamento;
	}

	public void setLancamento(Integer lancamento) {
		this.lancamento = lancamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cheque getCheque() {
		return cheque;
	}

	public void setCheque(Cheque cheque) {
		this.cheque = cheque;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, cheque, conta, data, descricao, lancamento, usuario, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(cheque, other.cheque)
				&& Objects.equals(conta, other.conta) && Objects.equals(data, other.data)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(lancamento, other.lancamento)
				&& Objects.equals(usuario, other.usuario) && Objects.equals(valor, other.valor);
	}

	
}
