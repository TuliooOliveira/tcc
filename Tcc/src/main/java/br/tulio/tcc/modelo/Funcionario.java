package br.tulio.tcc.modelo;

import java.util.Date;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Funcionario extends Pessoa {
	private Double salario;
	private Date dataAdm;
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
