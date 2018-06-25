package br.tulio.tcc.entidade;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity 
public class ReservaDeCampo implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente cliente;
	
	@Id
	@ManyToOne
	@JoinColumn(nullable = false)
	private Campo campo;
	
	@Id
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Id
	@Temporal(TemporalType.TIME)
	private Date hora;
	
	// 1- Manhã
	// 2- Tarde
	// 3- Noite
	@Column(nullable = false)
	private Character turno;
	
	@Column(length = 50)
	private String observacoes;
	
	@Column(length = 20)
	private String local;
	
	private Double valor;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Campo getCampo() {
		return campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Character getTurno() {
		return turno;
	}

	public void setTurno(Character turno) {
		this.turno = turno;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
