package classes;

import java.util.ArrayList;

public interface Estacao {
	
	public int getId();
	public String getNome();
	public char getTipo();
	public String[] getProtocolos();
	public void setId(int id);
	public void setNome(String nome);
	public void setTipo(char tipo);
	public void setProtocolos(String[] protocolos);
	String verInfo();
	boolean validarProtocolos(String[] protocolosNave);
	boolean validarReserva(Nave n, ArrayList<Reserva> reservas, TempoUniversal TU);
}
