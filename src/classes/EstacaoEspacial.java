package classes;

import java.util.ArrayList;

public class EstacaoEspacial extends EstacaoDefault{

	private int v_hangar; //volume hangar
	private int dim_porta[];//dimensoes porta do hangar
	private long t_max; //tempo maximo de estadia

	public EstacaoEspacial(int id, String nome,String[] protocolos, int v_hangar, int dim_porta[], long t_max) {
		super(id, nome, 'E', protocolos);
		this.v_hangar = v_hangar;
		this.dim_porta = dim_porta;
		this.t_max = t_max;
	}
	
	
	public int getV_hangar() {
		return v_hangar;
	}

	public void setV_hangar(int v_hangar) {
		this.v_hangar = v_hangar;
	}

	public int[] getDim_porta() {
		return dim_porta;
	}

	public void setDim_porta(int[] dim_porta) {
		this.dim_porta = dim_porta;
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
