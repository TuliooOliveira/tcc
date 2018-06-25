package br.tulio.tcc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.tulio.tcc.dao.CidadeDAO;
import br.tulio.tcc.dao.ClienteDAO;
import br.tulio.tcc.dao.EstadoDAO;
import br.tulio.tcc.entidade.Cidade;
import br.tulio.tcc.entidade.Cliente;
import br.tulio.tcc.entidade.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteController implements Serializable {

	private Cliente cliente;
	private List<Cliente> clientes;
	private Estado estado;
	private List<Estado> estados;
	private List<Cidade> cidades;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
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

			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os clientes!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			
			cliente = new Cliente();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

			CidadeDAO cidadeDao = new CidadeDAO();
			cidades = cidadeDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar um novo cliente!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			cliente.setDataCadastro(new Date());
			clienteDAO.merge(cliente);

			clientes = clienteDAO.listar();

			cliente = new Cliente();

			estado = new Estado();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
			CidadeDAO cidadeDao = new CidadeDAO();
			cidades = cidadeDao.listar();
		
			Messages.addGlobalInfo("Cliente salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o cliente!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {

		try {

			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");

			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.excluir(cliente);

			clientes = clienteDAO.listar(); // -> Atualiza tabela de listagem ao salvar novo estado

			Messages.addGlobalInfo("Cliente removido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover um cliente!");
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {

		try {

			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
			estado = cliente.getCidade().getEstado();
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
			CidadeDAO cidadeDao = new CidadeDAO();
			cidades = cidadeDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar selecionar um cliente!");
			erro.printStackTrace();
		}

	}

}
