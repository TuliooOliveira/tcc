package br.tulio.tcc.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.tulio.tcc.dao.EstadoDAO;
import br.tulio.tcc.entidade.Estado;

//@Named	 // Bean CDI
@ManagedBean //Bean JSF
@ViewScoped // Tempo de vida dos objetos enquanto está na tela 
public class EstadoController {
	
	private Estado estado;
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void novo() {
		estado = new Estado();
	}

	public void salvar() {
		
		try {
			
			EstadoDAO estadoDao = new EstadoDAO();
			estadoDao.salvar(estado);
			novo();
			Messages.addGlobalInfo("Estado salvo com sucesso!");
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Estado!");
		}


		/*String texto = "Teste message";
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto);

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);*/
	}
}
