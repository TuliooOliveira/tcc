package br.tulio.tcc.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Cliente extends Pessoa implements Serializable{
	
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	
	@ManyToMany(mappedBy = "clientes")
	private List<Campo> campos;
	
	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Cliente [getCodigo()=" + getCodigo() + "]";
	}

}
