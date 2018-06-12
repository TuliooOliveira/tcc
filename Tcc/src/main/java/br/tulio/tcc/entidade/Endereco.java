package br.tulio.tcc.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Endereco extends DominioGenerico {
	
	@Column(length = 8, nullable = false)
	private String cep;
	
	@Column(length = 100)
	private String rua;
	
	private Integer numero;
	
	@Column(length = 50)
	private String complemento;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cidade cidade;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	

}
