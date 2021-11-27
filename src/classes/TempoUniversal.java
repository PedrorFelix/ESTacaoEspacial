package classes;

public class TempoUniversal {
	private long t_in;
	private long t_out;
	
	public TempoUniversal() {
		t_in = 0;
		t_out = 0;
	}
	
	public TempoUniversal(long t_in, long t_out) {
		this.t_in = t_in;
		this.t_out = t_out;
	}
	
	public boolean estaDisponivel(TempoUniversal TU){
		if(t_in >= TU.t_out && t_out > TU.t_in)
			return true;
		return false;
	}
	
	public void controlarDuracao(long t_max) {
		if(t_out - t_in > t_max) {
			t_out -= (t_out - t_in) - t_max;
		}
	}
}
