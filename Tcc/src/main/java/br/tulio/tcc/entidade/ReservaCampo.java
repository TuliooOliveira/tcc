package br.tulio.tcc.entidade;

import java.sql.Time;
import java.util.Date;

public class ReservaCampo {
	
	private Usuario usuario;
	private Campo campo;
	private Horarios horarios;
	private String observacoes;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Campo getCampo() {
		return campo;
	}
	public void setCampo(Campo campo) {
		this.campo = campo;
	}
	public Horarios getHorario() {
		return horarios;
	}
	public void setHorario(Horarios horarios) {
		this.horarios = horarios;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
}
