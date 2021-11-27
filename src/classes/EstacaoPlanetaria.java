package classes;

public class EstacaoPlanetaria extends EstacaoDefault{

	private double g; //gravidade planeta/lua
	
	public EstacaoPlanetaria(int id, String nome,String[] protocolos, double g) {
		super(id, nome, 'P', protocolos);
		this.g = g;
	}
	

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	@Override
	public String verInfo() {
		String info = "";
		final Integer id = getId();
		info += "ID: " + id.toString() + "\n" +
				"NOME: " + getNome() +"\n" +
				"TIPO: " + getTipo() +"\n"+
				"PROTOCOLOS: ";
		for(int i=0; i<getProtocolos().length; i++){
			String [] protocolos = getProtocolos();
			info += protocolos[i] + " ";
		}
		info +="\n"+
				"GRAVIDADE LOCAL: " + getG();
		
		return info;
	}

	@Override
	public boolean validarReserva() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
