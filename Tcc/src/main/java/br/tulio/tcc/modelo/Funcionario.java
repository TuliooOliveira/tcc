package br.tulio.tcc.modelo;

import java.util.Date;

public class Funcionario extends Pessoa{
	private Integer codigo;
	private Double salario;
	private Date dataAdm;
	private Date dataDesl;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
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
