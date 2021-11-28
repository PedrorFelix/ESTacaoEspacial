package menu;

import classes.Server;

public class Main {

	private static Server server = new Server(); // server para buscar informa��o
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readNaves( );
		readEstacoes( );
		readReservas( );
		Thread t1 = new Thread() {
			public void run() {
				MenuSistema aluguer = new MenuSistema( 20, 100, 550, 500, server);
				aluguer.menuPrincipal();
				writeReservas();
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
		server.setNaves();
	}
	
	/** lê o ficheiro de texto com a informação das estações
	 */
	private static void readEstacoes( ){
		server.setEstacoes();
	}

	/** lê o ficheiro de texto com a informação das reservas
	 */
	private static void readReservas( ){
		server.setReservas();
	}

	/** grava o ficheiro de texto com a informação das reservas
	 */
	private static void writeReservas() {
		server.saveReservas();
	}
}
