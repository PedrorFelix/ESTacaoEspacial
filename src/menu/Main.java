package menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import classes.Server;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readNaves( );
		readEstacoes( );
		readReservas( );
		Server server = new Server();
		Thread t1 = new Thread() {
			public void run() {
				MenuSistema aluguer = new MenuSistema( 20, 100, 550, 500 );
				aluguer.menuPrincipal();
				writeReservas( );
				System.exit( 0 );
			};			
		};
		t1.start();
		Thread t2 = new Thread() {
			public void run() {
				MenuNave mnave = new MenuNave( 600, 100, 550, 500, server);
				mnave.menuPrincipal();
			};			
		};
		t2.start();
	}
	

	/** lê o ficheiro de texto com a informação das naves
	 */
	private static void readNaves( ){
		try {
			File fich = new File("naves.txt");
			Scanner scanner = new Scanner(fich);
			String naves = "";
			while (scanner.hasNextLine()) {
				naves += scanner.nextLine() + "\n";
		    }
			System.out.println(naves);
		    scanner.close();
	    } catch (FileNotFoundException e) {
	    	System.out.println("O ficheiro n�o foi encontrado");
		     e.printStackTrace();
	    }
	}
	
	/** lê o ficheiro de texto com a informação das estações
	 */
	private static void readEstacoes( ){
	}

	/** lê o ficheiro de texto com a informação das reservas
	 */
	private static void readReservas( ){
	}

	/** grava o ficheiro de texto com a informação das reservas
	 */
	private static void writeReservas( ) {
	}
}
