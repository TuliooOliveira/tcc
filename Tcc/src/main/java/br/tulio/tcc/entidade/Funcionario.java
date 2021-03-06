package br.tulio.tcc.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings("serial")
@Entity
public class Funcionario extends Pessoa implements Serializable{
	
	@Column(length = 15)
	private String carteiraTrabalho;
	
	private Double salario;
	
	@Temporal(TemporalType.DATE)
	private Date dataAdm;
	
	@Temporal(TemporalType.DATE)
	private Date dataDesl;
	
	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Date getDataAdm() {
		return dataAdm;
	}

	public void setDataAdm(Date dataAdm) {
		this.dataAdm = dataAdm;
	}

	public Date getDataDesl() {
		return dataDesl;
	}

	public void setDataDesl(Date dataDesl) {
		this.dataDesl = dataDesl;

	}

	
}
