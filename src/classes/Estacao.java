package classes;

public interface Estacao {
	String verInfo();
<<<<<<< Updated upstream
	boolean validarReserva();
	public int getId();
	public void setId(int id);
	public String getNome();
	public void setNome(String nome);
	public char getTipo();
	public void setTipo(char tipo);
	public String[] getProtocolos();
	public void setProtocolos(String[] protocolos);
=======
	boolean validarReserva(Nave n);
	
>>>>>>> Stashed changes
}
