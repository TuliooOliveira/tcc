package br.tulio.tcc.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Estado{
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)*/
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	//@Column(length = 2, nullable = false)
	@Column(nullable = false)
	private String sigla;
	
	//@Column(length = 50, nullable = false)
	@Column(nullable = false)
	private String nome;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

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
