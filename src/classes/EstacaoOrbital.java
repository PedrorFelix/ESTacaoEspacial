package classes;

import java.util.ArrayList;

public class EstacaoOrbital extends EstacaoDefault{

	private int n_portas; //numero de portas
	private long t_max; //tempo maximo estadia
	
	public EstacaoOrbital(int id, String nome, String[] protocolos, int n_portas, long t_max){
		super(id, nome, 'O', protocolos);
		this.n_portas = n_portas;
		this.t_max = t_max;
	}

	
	public int getN_portas() {
		return n_portas;
	}

	public void setN_portas(int n_portas) {
		this.n_portas = n_portas;
	}

	public long getT_max() {
		return t_max;
	}

	public void setT_max(long t_max) {
		this.t_max = t_max;
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
