package br.tulio.tcc.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import br.tulio.tcc.dao.CampoDAO;
import br.tulio.tcc.dao.ClienteDAO;
import br.tulio.tcc.dao.ReservaDeCampoDAO;
import br.tulio.tcc.entidade.Campo;
import br.tulio.tcc.entidade.Cliente;
import br.tulio.tcc.entidade.Funcionario;
import br.tulio.tcc.entidade.ReservaDeCampo;

@ManagedBean
@ViewScoped
public class ResevarController {

	private Cliente cliente;
	private Campo campo;
	private ScheduleModel reservas;
	private List<Funcionario> funcionarios;
	private List<Campo> campos;
	private List<Cliente> clientes;
	private ReservaDeCampo reservasCampo;

	private ScheduleEvent event = new DefaultScheduleEvent();

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public ScheduleModel getReservas() {
		return reservas;
	}

	public void setReservas(ScheduleModel reservas) {
		this.reservas = reservas;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ReservaDeCampo getReservasCampo() {
		return reservasCampo;
	}

	public void setReservasCampo(ReservaDeCampo reservasCampo) {
		this.reservasCampo = reservasCampo;
	}

	@PostConstruct
	public void listar() {
		reservas = new DefaultScheduleModel();
	}

	public void novo(SelectEvent evento) {
		
		try {
			
		event = new DefaultScheduleEvent("", (Date) evento.getObject(), (Date) evento.getObject());

		reservasCampo = new ReservaDeCampo();

		ClienteDAO clienteDAO = new ClienteDAO();
		clientes = clienteDAO.listar();

		CampoDAO campoDAO = new CampoDAO();
		campos = campoDAO.listar();
		
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova reserva!");
			erro.printStackTrace();
		}
		}

	public void salvar() {
		
		try {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(reservasCampo.getData());
		calendar.add(Calendar.DATE, 1);
		reservasCampo.setData(calendar.getTime());

		cliente = new Cliente();
		campo = new Campo();

		ReservaDeCampoDAO reservaDeCampoDAO = new ReservaDeCampoDAO();
		reservaDeCampoDAO.merge(reservasCampo);

		ClienteDAO clienteDAO = new ClienteDAO();
		clientes = clienteDAO.listar();

		CampoDAO campoDAO = new CampoDAO();
		campos = campoDAO.listar();

		Messages.addGlobalInfo("Reservado com sucesso");
	} catch (RuntimeException erro) {
		Messages.addGlobalError("Ocorreu um erro ao tentar reservar um campo!");
		erro.printStackTrace();
	}
		
	}

}
