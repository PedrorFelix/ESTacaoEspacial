package classes;

public class Reserva {

	private int id;
	private int id_est; // id estacao
	private int id_nave;//id nave
	private long t_in;//utu de entrada
	private long t_out;//utu de saida
	
	public Reserva(int id, int id_est, int id_nave, long t_in, long t_out) {
		super();
		this.id = id;
		this.id_est = id_est;
		this.id_nave = id_nave;
		this.t_in = t_in;
		this.t_out = t_out;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_est() {
		return id_est;
	}

	public void setId_est(int id_est) {
		this.id_est = id_est;
	}

	public int getId_nave() {
		return id_nave;
	}

	public void setId_nave(int id_nave) {
		this.id_nave = id_nave;
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
