package financeiro.usuario;

import java.util.List;

import financeiro.util.DAOFactory;

public class UsuarioRN {

	private UsuarioDAO usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
		
	}
	
	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
		
	}
	
	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
		
	}
	
	public void salvar(Usuario usuário) {
		Integer codigo = usuário.getCodigo();
		if(codigo == null || codigo == 0) {
			this.usuarioDAO.salvar(usuário);
		}else {
			this.usuarioDAO.atualizar(usuário);
		}
	}
	
	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
		
	}
	
	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}
	
}
