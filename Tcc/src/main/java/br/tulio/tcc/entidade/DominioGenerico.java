package br.tulio.tcc.entidade;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public class DominioGenerico implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
