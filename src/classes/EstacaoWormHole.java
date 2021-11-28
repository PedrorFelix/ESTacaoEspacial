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
	public String verInfo() {
		String info ="";
		final Integer id = getId();
		info += "ID: " + id.toString() + "\n" +
				"NOME: " + getNome() +"\n" +
				"TIPO: Worm Hole\n"+
				"PROTOCOLOS: ";
		for(int i=0; i<getProtocolos().length; i++){
			String [] protocolos = getProtocolos();
			info += protocolos[i] + " ";
		}
		info +="\n"+
				"RAIO WORM HOLE: " + getRaio_wh() + "\n"+
				"TEMPO TRAVESIA: " + getT_trav();
		
		return info;
	}

	@Override
	public boolean validarReserva(Nave n, ArrayList<Reserva> reservas, TempoUniversal tempo) {
		boolean k =true;
		for(int i=0;i<n.getDimensoes().length;i++) {
			if(n.getDimensoes()[i]>getRaio_wh())
				k=false;
		}
		if(k) {
			tempo.controlarDuracao(t_trav);
			for (int i = 0; i < reservas.size(); i++) {
				if (!tempo.estaDisponivel(reservas.get(i).getTempo()))
					return false;
			} 
		}
		return true;
	}
}
