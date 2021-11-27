package classes;

import java.util.ArrayList;

public abstract class  EstacaoDefault  implements Estacao {
	
	private int id;
	private String nome;
	private char tipo;
	private String protocolos[];
	
	abstract public ArrayList<String> verInfo();

	abstract public boolean validarReserva();
}
