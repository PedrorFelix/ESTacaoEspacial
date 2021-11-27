package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Server {
	
	private ArrayList<Reserva> reservas;
	private HashMap<String, Nave> naves;
	private HashMap<String, Estacao> estacoes;
	
	public Server() {}
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	public HashMap<String, Nave> getNaves() {
		return naves;
	}
	public void setNaves() {
		try {
			File fich = new File("naves.txt");
			Scanner scanner = new Scanner(fich);
			while (scanner.hasNextLine()) {
				String[] nave = scanner.nextLine().split("\t");
				String[] protocolos = new String[nave.length - 7];
				int[] dimensoes = new int[3];
				int index = 0;
				for(int i = 2; i < 5; i++) {
					dimensoes[index++] = Integer.parseInt(nave[i]);
				}
				index = 0;
				for(int i = 7; i < nave.length; i++) {
					protocolos[index++] = nave[i];
				}
				naves.add(new Nave(nave[1], dimensoes, nave[5], nave[6], protocolos));
		    }
		    scanner.close();
	    } catch (FileNotFoundException e) {
	    	System.out.println("A lista de naves não foi encontrada");
		     e.printStackTrace();
	    }
	}
	public HashMap<String, Estacao> getEstacoes() {
		return estacoes;
	}
	public void setEstacoes() {
		
	}
	
	
	
	

}
