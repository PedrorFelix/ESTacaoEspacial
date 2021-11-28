package classes;

import java.util.ArrayList;

public class EstacaoEspacial extends EstacaoDefault{

	private int v_hangar; //volume hangar
	private int dim_porta[];//dimensoes porta do hangar
	private long t_max; //tempo maximo de estadia

	public EstacaoEspacial(int id, String nome,String[] protocolos, int v_hangar, int dim_porta[], long t_max) {
		super(id, nome, 'E', protocolos);
		this.v_hangar = v_hangar;
		this.dim_porta = dim_porta;
		this.t_max = t_max;
	}
	
	
	public int getV_hangar() {
		return v_hangar;
	}

	public void setV_hangar(int v_hangar) {
		this.v_hangar = v_hangar;
	}

	public int[] getDim_porta() {
		return dim_porta;
	}

	public void setDim_porta(int[] dim_porta) {
		this.dim_porta = dim_porta;
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
				"TIPO: Espacial\n"+
				"PROTOCOLOS: ";
		for(int i=0; i<getProtocolos().length; i++){
			String protocolos = getProtocolos()[i];
			info += protocolos + " ";
		}
		info +="\n"+
				"VOLUME DO HANGAR: " + getV_hangar() + "\n"+
				"DIMENSÕES DA PORTA: ";
		for(int i=0;i<getDim_porta().length; i++) {
			Integer dim = getDim_porta()[i];
			info += dim.toString() + " ";
		}
		info += "\n"+
				"TEMPO MÁXIMO: " + getT_max();
		
		return info;
	}

	@Override
	public boolean validarReserva(Nave n, ArrayList<Reserva> reservas, TempoUniversal tempo) {
		if (getDim_porta()[0]>n.getDimensoes()[0] && getDim_porta()[1]>n.getDimensoes()[1]) { //ver se cabe na porta
			int volumeOcupado = 0;//Ver a ocupacao
			for (int i = 0; i < reservas.size(); i++) {
				Nave nn = reservas.get(i).get_nave();
				int[] dim = nn.getDimensoes();
				int v = dim[0] + dim[1] + dim[2];
				volumeOcupado += v;
				v = 0;
			}
			//ver se cabe no hangar
			int[] dim = n.getDimensoes();
			int v = dim[0] + dim[1] + dim[2];
			if ((volumeOcupado + v) < getV_hangar())
				return true;
		}
		return false;
	}
}
