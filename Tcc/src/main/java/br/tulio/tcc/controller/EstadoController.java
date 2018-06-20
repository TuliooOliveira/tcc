package br.tulio.tcc.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.tulio.tcc.dao.EstadoDAO;
import br.tulio.tcc.entidade.Estado;

//@Named	 // Bean CDI
@ManagedBean // Bean JSF
@ViewScoped // Tempo de vida dos objetos enquanto está na tela
public class EstadoController {

	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {

		try {

			EstadoDAO estadoDao = new EstadoDAO();
			estados = estadoDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar lista os estados!");
			erro.printStackTrace();
		}

	}

	public void novo() {
		estado = new Estado();
	}

	public void salvar() {

		try {

			EstadoDAO estadoDao = new EstadoDAO();
			estadoDao.salvar(estado);

			novo();
			estados = estadoDao.listar(); // -> Atualiza tabela de listagem ao salvar novo estado

			Messages.addGlobalInfo("Estado salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o estado!");
			erro.printStackTrace();
		}

		/*
		 * String texto = "Teste message"; FacesMessage message = new
		 * FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto);
		 * 
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * context.addMessage(null, message);
		 */
	}

	// Captura o item que foi selecionado da tabela da view
	public void excluir(ActionEvent evento) {
		
		try {

			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			EstadoDAO estadoDao = new EstadoDAO();
			estadoDao.excluir(estado);
			
			novo();
			estados = estadoDao.listar(); // -> Atualiza tabela de listagem ao salvar novo estado

			Messages.addGlobalInfo("Estado salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o estado!");
			erro.printStackTrace();
		}
		
	}
}
