package br.tulio.tcc.modelo;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class Pessoa extends DominioGenerico {
	
	private String nome;
	private String cpf;
	private Date data_nasc;
	private String fone;

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

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

}
