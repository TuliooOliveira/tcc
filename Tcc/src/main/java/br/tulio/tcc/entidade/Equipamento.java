package br.tulio.tcc.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Equipamento implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_equip;
	
	@Column(length = 50)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Fabricante fabricante;
	
	@Temporal(TemporalType.DATE)
	private Date dataAquisicao;
	
	private Boolean disponivel;

	@ManyToMany(mappedBy = "equipamentos")
	private List<Campo> campos;
	

	public int getCodigo_equip() {
		return codigo_equip;
	}

	public void setCodigo_equip(int codigo_equip) {
		this.codigo_equip = codigo_equip;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}
	
}
