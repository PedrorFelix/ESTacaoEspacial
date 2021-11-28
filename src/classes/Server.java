package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Server {
	
	private ArrayList<Reserva> reservas;
	private HashMap<String, Nave> naves;
	private HashMap<String, Estacao> estacoes;
	
	public Server() {
		reservas = new ArrayList<Reserva>();
		naves = new HashMap<String, Nave>();
		estacoes = new HashMap<String, Estacao>();
	}
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	
	public ArrayList<Reserva> getReservas(Nave nave) {
		ArrayList<Reserva> reservasNave = new ArrayList<Reserva>();
		for(int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).get_nave() == nave) {
				reservasNave.add(reservas.get(i));
			}
		}
		return reservasNave;
	}
	
	public ArrayList<Reserva> getReservas(Estacao est) {
		ArrayList<Reserva> reservasEst = new ArrayList<Reserva>();
		for(int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).get_estacao() == est) {
				reservasEst.add(reservas.get(i));
			}
		}
		return reservasEst;
	}
	
	public Reserva getReserva(Nave nave) {
		ArrayList<Reserva> reservasNave = getReservas(nave);
		return reservasNave.get(reservasNave.size() - 1);
	}
	
 	public void setReservas() {
		try {
			File fich = new File("reservas.txt");
			Scanner scanner = new Scanner(fich);
			while (scanner.hasNextLine()) {
				String[] reserva = scanner.nextLine().split("\t");
				reservas.add(new Reserva(Integer.parseInt(reserva[0]), estacoes.get(reserva[1]), naves.get(reserva[2]), new TempoUniversal(Long.parseLong(reserva[3]), Long.parseLong(reserva[4]))));
		    }
		    scanner.close();
	    } catch (FileNotFoundException e) {
	    	System.out.println("A lista de reservas não foi encontrada");
		     e.printStackTrace();
	    }
	}
 	
 	public void saveReservas() {
 		try {
 			File fich = new File("abc.txt");
 			if(!fich.exists())
 				fich.createNewFile();
 			FileWriter myWriter = new FileWriter(fich);
 			String resv = "";
 			for(Reserva r : reservas) {
 				resv += r.printReserva();
 			}
 			myWriter.write(resv);
 			myWriter.close();
 		} catch (IOException e) {
 			System.out.println("Erro a gravar reservas");
 			e.printStackTrace();
 		}
 	}
 	
	public HashMap<String, Nave> getNaves() {
		return naves;
	}
	public Nave getNave(String id) {
		return naves.get(id);
	}
	public void setNaves() {
		try {
			File fich = new File("naves.txt");
			Scanner scanner = new Scanner(fich);
			while (scanner.hasNextLine()) {
				String[] nave = scanner.nextLine().split("\t");
				String[] protocolos = new String[nave.length - 7];
				int[] dimensoes = {Integer.parseInt(nave[2]), Integer.parseInt(nave[3]), Integer.parseInt(nave[4])};
				int index = 0;
				for(int i = 7; i < nave.length; i++) {
					protocolos[index++] = nave[i];
				}
				naves.put(nave[0], new Nave(nave[0], nave[1], dimensoes, Integer.parseInt(nave[5]), Integer.parseInt(nave[6]), protocolos));
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
		try {
			File fich = new File("estacoes.txt");
			Scanner scanner = new Scanner(fich);
			while (scanner.hasNextLine()) {
				String[] estacao = scanner.nextLine().split("\t");
				String[] protocolos;
				int index;
				switch(estacao[1]) {
				case "O":
					protocolos = new String[estacao.length - 5];
					index = 0;
					for(int i = 5; i < estacao.length; i++) {
						protocolos[index++] = estacao[i];
					}
					estacoes.put(estacao[0], new EstacaoOrbital(Integer.parseInt(estacao[0]), estacao[2], protocolos, Integer.parseInt(estacao[3]), Long.parseLong(estacao[4])));
					break;
				case "W":
					protocolos = new String[estacao.length - 5];
					index = 0;
					for(int i = 5; i < estacao.length; i++) {
						protocolos[index++] = estacao[i];
					}
					estacoes.put(estacao[0], new EstacaoWormHole(Integer.parseInt(estacao[0]), estacao[2], protocolos, Integer.parseInt(estacao[3]), Long.parseLong(estacao[4])));
					break;
				case "E":
					protocolos = new String[estacao.length - 7];
					index = 0;
					for(int i = 7; i < estacao.length; i++) {
						protocolos[index++] = estacao[i];
					}
					index = 0;
					int[] dimensoes = {Integer.parseInt(estacao[4]), Integer.parseInt(estacao[5])};
					estacoes.put(estacao[0], new EstacaoEspacial(Integer.parseInt(estacao[0]), estacao[2], protocolos, Integer.parseInt(estacao[3]), dimensoes, Long.parseLong(estacao[6])));
					break;
				case "P":
					protocolos = new String[estacao.length - 4];
					index = 0;
					for(int i = 4; i < estacao.length; i++) {
						protocolos[index++] = estacao[i];
					}
					estacoes.put(estacao[0], new EstacaoPlanetaria(Integer.parseInt(estacao[0]), estacao[2], protocolos, Double.parseDouble(estacao[3])));
					break;
				}
		    }
		    scanner.close();
	    } catch (FileNotFoundException e) {
	    	System.out.println("A lista de estações não foi encontrada");
		     e.printStackTrace();
	    }
	}

}
