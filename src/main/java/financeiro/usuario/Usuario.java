package financeiro.usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = -2276215792742363279L;
	@Id
	@GeneratedValue
	private Integer codigo;
	private String nome;
	private String email;
	@NaturalId
	private String login;
	private String senha;
	private Date nascimento;
	private String celular;
	private String idioma;
	private boolean ativo;

	@ElementCollection(targetClass = String.class)
	@JoinTable(name = "usuario_permissao", uniqueConstraints = {
			@UniqueConstraint(columnNames = { "usuario", "permissao" }) }, joinColumns = @JoinColumn(name = "usuario"))
	@Column(name = "permissao", length = 50)
	private Set<String> permissao = new HashSet<String>();

	public Set<String> getPermissao() {
		return permissao;
	}

	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ativo, celular, codigo, email, idioma, login, nascimento, nome, permissao, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return ativo == other.ativo && Objects.equals(celular, other.celular) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(email, other.email) && Objects.equals(idioma, other.idioma)
				&& Objects.equals(login, other.login) && Objects.equals(nascimento, other.nascimento)
				&& Objects.equals(nome, other.nome) && Objects.equals(permissao, other.permissao)
				&& Objects.equals(senha, other.senha);
	}

}
