package classes;

import java.util.ArrayList;

public class EstacaoPlanetaria extends EstacaoDefault{

	private double g; //gravidade planeta/lua
	
	public EstacaoPlanetaria(int id, String nome,String[] protocolos, double g) {
		super(id, nome, 'P', protocolos);
		this.g = g;
	}
	

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	@Override
	public ArrayList<String> verInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validarReserva() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
