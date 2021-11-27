package classes;

import java.util.ArrayList;

public interface Estacao {
	ArrayList<String> verInfo();
	boolean validarReserva();
	String getNome();
	
	int getId();
	
	char getTipo();
	
	String[] getProtocolos();
	
}
