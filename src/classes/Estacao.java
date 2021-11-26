package classes;

import java.util.ArrayList;

public interface Estacao {
	ArrayList<Reserva> verReservas();
	ArrayList<String> verInfo();
	boolean estaDisponivel();
}
