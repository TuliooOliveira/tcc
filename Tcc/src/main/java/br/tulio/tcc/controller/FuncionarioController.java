package br.tulio.tcc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.tulio.tcc.dao.CidadeDAO;
import br.tulio.tcc.dao.EstadoDAO;
import br.tulio.tcc.dao.FuncionarioDAO;
import br.tulio.tcc.entidade.Cidade;
import br.tulio.tcc.entidade.Cliente;
import br.tulio.tcc.entidade.Estado;
import br.tulio.tcc.entidade.Funcionario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FuncionarioController implements Serializable {

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private Estado estado;
	private List<Estado> estados;
	private List<Cidade> cidades;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

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

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@PostConstruct
	public void listar() {
		try {

			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os funcionários!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {

			funcionario = new Funcionario();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

			CidadeDAO cidadeDao = new CidadeDAO();
			cidades = cidadeDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar um novo funcionário!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {

			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.merge(funcionario);
			funcionarios = funcionarioDAO.listar();
			
			funcionario = new Funcionario();
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
			CidadeDAO cidadeDao = new CidadeDAO();
			cidades = cidadeDao.listar();
			
			Messages.addGlobalInfo("Funcionário salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o funcionário!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {

		try {

			funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionado");

			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.excluir(funcionario);

			funcionarios = funcionarioDAO.listar(); // -> Atualiza tabela de listagem ao salvar novo estado

			Messages.addGlobalInfo("Funcionário removido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover um cliente!");
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {

		try {

			funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionado");
			estado = funcionario.getCidade().getEstado();
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

			CidadeDAO cidadeDao = new CidadeDAO();
			cidades = cidadeDao.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar selecionar um funcionario!");
			erro.printStackTrace();
		}

	}

}
