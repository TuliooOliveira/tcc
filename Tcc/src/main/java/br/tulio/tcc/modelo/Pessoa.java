package br.tulio.tcc.modelo;

import java.lang.reflect.Constructor;
import java.util.Date;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private Date data_nasc;
	
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public Date getData_nasc() {
		return data_nasc;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}


}
