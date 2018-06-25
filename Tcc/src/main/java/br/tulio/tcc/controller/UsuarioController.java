package br.tulio.tcc.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.tulio.tcc.dao.FuncionarioDAO;
import br.tulio.tcc.dao.UsuarioDAO;
import br.tulio.tcc.entidade.Funcionario;
import br.tulio.tcc.entidade.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioController implements Serializable {

	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Funcionario> funcionarios;
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	
	@PostConstruct
	public void listar() {
		try {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			 usuarios = usuarioDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os usuários!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			
			usuario = new Usuario();
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar um novo usuário!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.merge(usuario);
			novo();
	    
			Messages.addGlobalInfo("Usuário removido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o usuário!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {

		try {

			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuario);

			usuarios = usuarioDAO.listar(); // -> Atualiza tabela de listagem ao salvar novo estado

			Messages.addGlobalInfo("Usuário removido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o usuário!");
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {

		try {

			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar selecionar o usuário!");
			erro.printStackTrace();
		}

	}

}
