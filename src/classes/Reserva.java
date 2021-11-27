package classes;

public class Reserva {

	private int id;
	private Estacao est; // id estacao
	private Nave nave;//id nave
	private TempoUniversal tempo; // intervalo de tempo
	
	public Reserva(int id, Estacao est, Nave nave, TempoUniversal tempo) {
		this.id = id;
		this.est = est;
		this.nave = nave;
		this.tempo = tempo;
	}

	public TempoUniversal getTempo() {
		return tempo;
	}

	public void setTempo(TempoUniversal tempo) {
		this.tempo = tempo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Estacao get_estacao() {
		return est;
	}

	public void setId_est(Estacao est) {
		this.est = est;
	}

	public Nave get_nave() {
		return nave;
	}

	public void set_nave(Nave nave) {
		this.nave = nave;
	}

	
	public String getInfo() {
		return 	"ID: " + id +
				"\nEstação(ID/Nome): " + est.getId() + " / " + est.getNome() +
				"\nNave(ID/Nome): " + nave.getId() + " / " + nave.getNome() +
				"\nTempo de Entrada: " + tempo.getTUEntrada() +
				"\nTempo de Saida: " + tempo.getTUSaida();
	}
	
}
