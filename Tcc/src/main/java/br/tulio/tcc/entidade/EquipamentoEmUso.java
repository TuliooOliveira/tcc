package br.tulio.tcc.entidade;

import javax.persistence.Entity;

@Entity
public class EquipamentoEmUso {
	
	private Equipamento equipamento;
	private ReservaCampo campoReservado;
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public ReservaCampo getCampoReservado() {
		return campoReservado;
	}
	public void setCampoReservado(ReservaCampo campoReservado) {
		this.campoReservado = campoReservado;
	}
	
}
