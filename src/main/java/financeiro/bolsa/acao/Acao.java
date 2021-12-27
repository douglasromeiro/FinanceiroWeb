package financeiro.bolsa.acao;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import financeiro.usuario.Usuario;

@Entity
@Table(name = "acao")
public class Acao implements Serializable {


	private static final long serialVersionUID = 3829007103119111605L;
	@Id
	@GeneratedValue
	@Column(name = "cod_acao")
	private Integer codigo;
	
	@Column(nullable =false, length = 10)
	private String sigla;

	@Column(length = 10)
	private String descricao;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@Column(nullable = false, length = 1)
	private Character origem;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "cod_usuario", nullable = false)
	private Usuario usuario;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Character getOrigem() {
		return origem;
	}

	public void setOrigem(Character origem) {
		this.origem = origem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, descricao, origem, quantidade, sigla, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acao other = (Acao) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(origem, other.origem) && Objects.equals(quantidade, other.quantidade)
				&& Objects.equals(sigla, other.sigla) && Objects.equals(usuario, other.usuario);
	}
	
	
}
