package classes;

public class Nave {

	private static int id;
	private static String nome;
	private static int dimensoes[];
	private static int massa;
	private static int potencia;
	private static String protocolos[];
	
	
	
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Nave.id = id;
	}
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		Nave.nome = nome;
	}
	public static int[] getDimensoes() {
		return dimensoes;
	}
	public static void setDimensoes(int[] dimensoes) {
		Nave.dimensoes = dimensoes;
	}
	public static int getMassa() {
		return massa;
	}
	public static void setMassa(int massa) {
		Nave.massa = massa;
	}
	public static int getPotencia() {
		return potencia;
	}
	public static void setPotencia(int potencia) {
		Nave.potencia = potencia;
	}
	public static String[] getProtocolos() {
		return protocolos;
	}
	public static void setProtocolos(String[] protocolos) {
		Nave.protocolos = protocolos;
	}
	
	
	
	
}
