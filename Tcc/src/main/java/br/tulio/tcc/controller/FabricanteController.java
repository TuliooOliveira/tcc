package br.tulio.tcc.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.tulio.tcc.dao.FabricanteDAO;
import br.tulio.tcc.entidade.Fabricante;

//@Named	 // Bean CDI
@SuppressWarnings("serial")
@ManagedBean // Bean JSF
@ViewScoped // Tempo de vida dos objetos enquanto está na tela
public class FabricanteController implements Serializable {

	private Fabricante fabricante;
	private List<Fabricante> fabricantes;
	
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	@PostConstruct
	public void listar() {

		try {

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar lista os fabricantes!");
			erro.printStackTrace();
		}

	}

	public void novo() {
		fabricante = new Fabricante();
	}

	public void salvar() {

		try {

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.merge(fabricante);

			novo();
			fabricantes = fabricanteDAO.listar();

			Messages.addGlobalInfo("Fabricante salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o fabricante!");
			erro.printStackTrace();
		}

	}

	// -> Captura o item que foi selecionado da tabela da view
	public void excluir(ActionEvent evento) {

		try {

			fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
			
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO .excluir(fabricante);

			fabricantes = fabricanteDAO .listar(); 

			Messages.addGlobalInfo("Fabricante removido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o fabricante!");
			erro.printStackTrace();
		}

	}

	// Captura o item que foi selecionado da tabela da view
	public void editar(ActionEvent evento) {
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
	}
}
