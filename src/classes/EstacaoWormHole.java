package classes;

import java.util.ArrayList;

public class EstacaoWormHole extends EstacaoDefault{

	private int raio_wh; //raio wormhole
	private long t_trav; //tempo travesia
	
	public EstacaoWormHole(int id, String nome,String[] protocolos, int raio_wh, long t_trav) {
		super(id, nome, 'W', protocolos);
		this.raio_wh = raio_wh;
		this.t_trav = t_trav;
	}

	
	public int getRaio_wh() {
		return raio_wh;
	}

	public void setRaio_wh(int raio_wh) {
		this.raio_wh = raio_wh;
	}

	public long getT_trav() {
		return t_trav;
	}

	public void setT_trav(long t_trav) {
		this.t_trav = t_trav;
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
