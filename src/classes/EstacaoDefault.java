package classes;

public abstract class  EstacaoDefault  implements Estacao {
	
	private int id;
	private String nome;
	private char tipo;
	private String protocolos[];
	
	public EstacaoDefault(int id, String nome, char tipo, String[] protocolos) {		
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.protocolos = protocolos;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String[] getProtocolos() {
		return protocolos;
	}

	public void setProtocolos(String[] protocolos) {
		this.protocolos = protocolos;
	}

	abstract public String verInfo();
	
	public boolean validarProtocolos(String[] protocolosNave) {
		for (int i = 0; i < protocolos.length; i++) {
			for (int j = 0; j < protocolosNave.length; j++) {
				if (protocolos[i].equals(protocolosNave[j]))
					return true;
			}
		}
		return false;
	}
}
