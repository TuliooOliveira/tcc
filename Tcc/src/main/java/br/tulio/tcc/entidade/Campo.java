package br.tulio.tcc.entidade;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Campo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	private int qtdJogadores;
	
	private String local;
	
	private Boolean coberta;
	
	private Boolean ativo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQtdJogadores() {
		return qtdJogadores;
	}

	public void setQtdJogadores(int qtdJogadores) {
		this.qtdJogadores = qtdJogadores;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Boolean getCoberta() {
		return coberta;
	}

	public void setCoberta(Boolean coberta) {
		this.coberta = coberta;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	

}
