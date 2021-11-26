package classes;

import java.util.ArrayList;

public class EstacaoEspacial extends EstacaoDefault{

	private int v_hangar; //volume hangar
	private int dim_porta[];//dimensoes porta do hangar
	private long t_max; //tempo maximo de estadia

	@Override
	public ArrayList<String> verInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean estaDisponivel() {
		// TODO Auto-generated method stub
		return false;
	}
}
