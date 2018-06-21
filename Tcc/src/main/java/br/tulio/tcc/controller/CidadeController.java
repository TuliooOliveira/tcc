package br.tulio.tcc.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.tulio.tcc.dao.CidadeDAO;
import br.tulio.tcc.dao.EstadoDAO;
import br.tulio.tcc.entidade.Cidade;
import br.tulio.tcc.entidade.Estado;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeController implements Serializable {
	
	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
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

			CidadeDAO cidadeDao = new CidadeDAO();
			cidades = cidadeDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar lista as cidades!");
			erro.printStackTrace();
		}

	}
	
	public void novo() {
		
		try {
			
		cidade = new Cidade();
		EstadoDAO estadoDAO = new EstadoDAO();
		estados = estadoDAO.listar();
		
	}catch (RuntimeException erro) {
		Messages.addGlobalError("Ocorreu um erro ao gerar uma nova cidade!");
		erro.printStackTrace();
	}
		}
	
	public void salvar() {

		try {

			CidadeDAO cidadeDao = new CidadeDAO();
			cidadeDao.merge(cidade);

			novo(); // -> atualiza objetos 
			cidades = cidadeDao.listar(); // -> Atualiza tabela de listagem ao salvar novo estado

			Messages.addGlobalInfo("Cidade salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a cidade!");
			erro.printStackTrace();
		}

	}
	
	// -> Captura o item que foi selecionado da tabela da view
	public void excluir(ActionEvent evento) {

		try {

			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
			
			CidadeDAO cidadeDao = new CidadeDAO();
			cidadeDao.excluir(cidade);

			cidades = cidadeDao.listar(); // -> Atualiza tabela de listagem ao salvar novo estado

			Messages.addGlobalInfo("Estado removido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover a cidade!");
			erro.printStackTrace();
		}

	}

	// Captura o item que foi selecionado da tabela da view
	public void editar(ActionEvent evento) {
		

		try {
			
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
			CidadeDAO cidadeDao = new CidadeDAO();
			cidades = cidadeDao.listar(); // -> Atualiza tabela de listagem ao salvar novo estado

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar selecionar uma cidade!");
			erro.printStackTrace();
		}

	}

}
