package br.tulio.tcc.modelo;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Estado extends DominioGenerico{
	private String sigla;
	private String nome;
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    
	
}
