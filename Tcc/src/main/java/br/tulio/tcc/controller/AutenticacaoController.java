package br.tulio.tcc.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.tulio.tcc.dao.UsuarioDAO;
import br.tulio.tcc.entidade.Funcionario;
import br.tulio.tcc.entidade.Pessoa;
import br.tulio.tcc.entidade.Usuario;

@ManagedBean
@SessionScoped
public class AutenticacaoController {
	
	private Usuario usuario;
	private Usuario usuarioLogado;
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
		usuario.setFuncionario(new Funcionario());
	}

	public void autenticar() {
		try {
			
			UsuarioDAO usuarioDao = new UsuarioDAO();
			usuarioLogado = usuarioDao.autenticar(usuario.getFuncionario().getCpf(), usuario.getSenha());
			
			if (usuarioLogado == null) {
				Messages.addGlobalError("CPF e/ou senha incorretos!");
				iniciar();
				return;
			}
			
			Faces.redirect("./pages/principal.xhtml");
			Messages.addGlobalInfo("Bem vindo " + usuarioLogado.getLogin());
		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
	}

}
