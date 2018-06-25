package br.tulio.tcc.entidade;

import java.io.Serializable;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class EquipamentoEmUso implements Serializable{
	
	private Equipamento equipamento;
	private ReservaDeCampo campoReservado;
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public ReservaDeCampo getCampoReservado() {
		return campoReservado;
	}
	public void setCampoReservado(ReservaDeCampo campoReservado) {
		this.campoReservado = campoReservado;
	}
	
}
