package financeiro.cheque;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChequeId implements Serializable {

	private static final long serialVersionUID = 6511059069332565416L;
	
	@Basic(optional = false)
	@Column(name = "cheque", nullable = false)
	private Integer cheque;
	
	@Basic(optional = false)
	@Column(name = "conta", nullable = false)
	private Integer conta;

	public Integer getCheque() {
		return cheque;
	}

	public void setCheque(Integer cheque) {
		this.cheque = cheque;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cheque, conta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChequeId other = (ChequeId) obj;
		return Objects.equals(cheque, other.cheque) && Objects.equals(conta, other.conta);
	}

	
}
