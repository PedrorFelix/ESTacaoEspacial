package menu;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readNaves( );
		readEstacoes( );
		readReservas( );
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
				MenuNave mnave = new MenuNave( 600, 100, 550, 500 );
				mnave.menuPrincipal();
			};			
		};
		t2.start();
	}
	

	/** lê o ficheiro de texto com a informação das naves
	 */
	private static void readNaves( ){
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
