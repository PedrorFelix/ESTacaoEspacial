package classes;

public class Reserva {

	private int id;
	private Estacao est; // id estacao
	private Nave nave;//id nave
	private long t_in;//tu de entrada
	private long t_out;//tu de saida
	
	public Reserva(int id, Estacao est, Nave nave, long t_in, long t_out) {
		this.id = id;
		this.est = est;
		this.nave = nave;
		this.t_in = t_in;
		this.t_out = t_out;
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

	public long getT_in() {
		return t_in;
	}

	public void setT_in(long t_in) {
		this.t_in = t_in;
	}

	public long getT_out() {
		return t_out;
	}

	public void setT_out(long t_out) {
		this.t_out = t_out;
	}
	
	
}
