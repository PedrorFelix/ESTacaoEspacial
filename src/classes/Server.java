package classes;

import java.util.ArrayList;

public class Server {
	
	private ArrayList<Reserva> reservas;
	private ArrayList<Nave> naves;
	private ArrayList<Estacao> estacoes;
	
	public Server() {}
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	public ArrayList<Nave> getNaves() {
		return naves;
	}
	public void setNaves(ArrayList<Nave> naves) {
		this.naves = naves;
	}
	public ArrayList<Estacao> getEstacoes() {
		return estacoes;
	}
	public void setEstacoes(ArrayList<Estacao> estacoes) {
		this.estacoes = estacoes;
	}
	
	
	
	

}
