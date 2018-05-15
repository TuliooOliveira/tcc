package br.tulio.tcc.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Usuario extends DominioGenerico{
	
	@Column(length = 50, nullable = false)
	private String login;
	
	@Column(length = 32, nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private Boolean ativo;
	 

}
