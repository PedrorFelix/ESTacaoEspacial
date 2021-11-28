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
	public String verInfo() {
		String info = "";
		final Integer id = getId();
		info += "ID: " + id.toString() + "\n" +
				"NOME: " + getNome() +"\n" +
				"TIPO: Orbital\n"+
				"PROTOCOLOS: ";
		for(int i=0; i<getProtocolos().length; i++){
			String [] protocolos = getProtocolos();
			info += protocolos[i] + " ";
		}
		info +="\n"+
				"NUMERO PORTAS: " + getN_portas() + "\n"+
				"TEMPO MÁXIMO: " + getT_max();
		
		return info;
	}

	@Override
	public boolean validarReserva(Nave n, ArrayList<Reserva> reservas, TempoUniversal TU) {		
		
		int ocupacao = 0;//Ver reservas no tempo pedido
		for(int i=0; i<reservas.size(); i++) {
			TempoUniversal t = reservas.get(i).getTempo();
			if(! t.estaDisponivel(TU)) {
				ocupacao++;
			}	
		}
		if((getN_portas()-ocupacao)>0) {//n_portas - n_reservas	if n_portas>0 controlar duração
			TU.controlarDuracao(getT_max());
			return true;
		}
		//else false
		return false;
	}

}
