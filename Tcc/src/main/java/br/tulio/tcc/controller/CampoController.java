package br.tulio.tcc.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.tulio.tcc.dao.CampoDAO;
import br.tulio.tcc.dao.EstadoDAO;
import br.tulio.tcc.entidade.Campo;
import br.tulio.tcc.entidade.Estado;

//@Named	 // Bean CDI
@SuppressWarnings("serial")
@ManagedBean // Bean JSF
@ViewScoped // Tempo de vida dos objetos enquanto está na tela
public class CampoController implements Serializable {

	private Campo campo;
	private List<Campo> campos;
	
	

	public Campo getCampo() {
		return campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

	@PostConstruct
	public void listar() {

		try {

			CampoDAO campoDao = new CampoDAO();
			campos = campoDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar lista os campos!");
			erro.printStackTrace();
		}

	}

	public void novo() {
		campo = new Campo();
	}

	public void salvar() {

		try {

			CampoDAO campoDao = new CampoDAO();
			campoDao.merge(campo);

			novo();
			campos = campoDao.listar(); 

			Messages.addGlobalInfo("Campo salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o campo!");
			erro.printStackTrace();
		}

	}

	// -> Captura o item que foi selecionado da tabela da view
	public void excluir(ActionEvent evento) {

		try {

			campo = (Campo) evento.getComponent().getAttributes().get("campoSelecionado");
			
			CampoDAO campoDao = new CampoDAO();
			campoDao.excluir(campo);

			campos = campoDao.listar();  // -> Atualiza tabela de listagem

			Messages.addGlobalInfo("Campo removido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o campo!");
			erro.printStackTrace();
		}

	}

	// Captura o item que foi selecionado da tabela da view
	public void editar(ActionEvent evento) {
		campo = (Campo) evento.getComponent().getAttributes().get("campoSelecionado");
	}
}
