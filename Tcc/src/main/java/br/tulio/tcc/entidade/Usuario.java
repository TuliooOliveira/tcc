package br.tulio.tcc.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Usuario extends DominioGenerico{
	
	/*
	@Column(length = 50, nullable = false)
	private String login;
	*/
	
	@Column(length = 32, nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private Character tipo;
	
	@Column(nullable = false)
	private Boolean ativo;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Cliente cliente;

	@OneToOne
	@JoinColumn(nullable = false)
	private Funcionario funcionario;

}
