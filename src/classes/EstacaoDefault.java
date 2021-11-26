package classes;

import java.util.ArrayList;

public abstract class  EstacaoDefault  implements Estacao {
	
	private int id;
	private String nome;
	private char tipo;
	private String protocolos[];
	@Override
	public ArrayList<Reserva> verReservas() {
		return null;
		// TODO Auto-generated method stub
	}
}
