package classes;

public class TempoUniversal {
	private long t_in;
	private long t_out;
	
	public void setTUEntrada(long t_in) {
		this.t_in = t_in;
	}
	
	public void setTUSaida(long t_out) {
		this.t_out = t_out;
	}
	
	public long getTUEntrada() {
		return t_in;
	}
	
	public long getTUSaida() {
		return t_out;
	}
	
	public TempoUniversal() {
		t_in = 0;
		t_out = 0;
	}
	
	public TempoUniversal(long t_in, long t_out) {
		this.t_in = t_in;
		this.t_out = t_out;
	}
	
	// detetar se este espaço de tempo interseta outro tempo
	public boolean estaDisponivel(TempoUniversal TU){
		if(t_in >= TU.t_out && t_out > TU.t_in)
			return true;
		return false;
	}
	
	// detetar se a duracao e superior ao tempo maximo e se for diminuir o tempo de saida
	public void controlarDuracao(long t_max) {
		if(t_out - t_in > t_max) {
			t_out -= (t_out - t_in) - t_max;
		}
	}
	
	// ajusta o intervalo de tempo para corresponder ao tempo de travessia
	public void converterTempoTrav(long t_trav) {
		if(t_out - t_in != t_trav) {
			t_out -= t_in + t_trav;
		}
	}
}
