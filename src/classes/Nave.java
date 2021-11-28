package classes;

public class Nave {

	private String id;
	private String nome;
	private int dimensoes[];
	private int massa;
	private int potencia;
	private String protocolos[];
	
	public Nave(String id, String nome, int dimensoes[], int massa, int potencia, String protocolos[]) {
		this.id =id;
		this.nome = nome;
		this.dimensoes = dimensoes;
		this.massa = massa;
		this.potencia = potencia;
		this.protocolos = protocolos;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int[] getDimensoes() {
		return dimensoes;
	}
	public void setDimensoes(int[] dimensoes) {
		this.dimensoes = dimensoes;
	}
	public int getMassa() {
		return massa;
	}
	public void setMassa(int massa) {
		this.massa = massa;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	public String[] getProtocolos() {
		return protocolos;
	}
	public void setProtocolos(String[] protocolos) {
		this.protocolos = protocolos;
	}
	
	public String getEspecs() {
		String info = 
				"ID: " + id +
				"\nNome: " + nome +
				"\nComprimento: " + dimensoes[0] +
				"\nAltura: " + dimensoes[1] +
				"\nLargura: " + dimensoes[2] +
				"\nMassa: " + massa +
				"\nPotência: " + potencia +
				"\nProtocolos:\n";
		for(int i = 0; i < protocolos.length; i++)
			info += "\n" + protocolos[i];
		return info;
	}
}
