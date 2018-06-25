package br.tulio.tcc.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Campo implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_campo;
	
	@Column(length = 10)
	private String nome;
	
	private int qtdJogadores;
	
	@Column(length = 30)
	private String local;
	
	@Column(nullable = false)
	private Boolean coberta;
	
	@Column(nullable = false)
	private Boolean ativo;
	
	@ManyToMany
	@JoinTable(name = "equipamento_uso", 
	joinColumns = @JoinColumn(name = "codigo_campo"),
	inverseJoinColumns = @JoinColumn(name = "codigo_equip"))
	private List<Equipamento> equipamentos;
	
	@ManyToMany
	@JoinTable(name = "reserva_campo", 
	joinColumns = @JoinColumn(name = "codigo_campo"),
	inverseJoinColumns = @JoinColumn(name = "codigo"))
	private List<Cliente> clientes;
	
	@Transient
	public String getCobertaFormatado(){
		String cobertaFormatado = "Não";
		
		if(coberta){
			cobertaFormatado = "Sim";
		}
		
		return cobertaFormatado;
	}
	
	@Transient
	public String getAtivoFormatado(){
		String ativoFormatado = "Não";
		
		if(ativo){
			ativoFormatado = "Sim";
		}
		
		return ativoFormatado;
	}
	
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	public int getCodigo_campo() {
		return codigo_campo;
	}

	public void setCodigo_campo(int codigo_campo) {
		this.codigo_campo = codigo_campo;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	

}
