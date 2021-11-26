package menu;

import consola.SConsola;


/**
 * Classe responsável pela apresentação e
 * processamento do menu principal da aplicação
 * @author <por aqui nomes dos autores>
 */
public class MenuSistema {

	private SConsola aConsola; // a consola para a interface com o utilizador
	
	/**
	 * construtor da aplicação
	 * @param x coordenada x onde deve ser colocada a janela da consola
	 * @param y coordenada y onde deve ser colocada a janela da consola
	 * @param comp comprimento da janela da consola
	 * @param alt altura da janela da consola
	 */
	public MenuSistema( int x, int y, int comp, int alt ){
		aConsola = new SConsola( "ESTação Espacial", x, y, comp, alt );
	}

	/** 
	 * método que apresenta o menu principal da aplicação
	 */
	public void menuPrincipal(){
		String menu = "ESTação Espacial - central de comandos\n\n" + 
		              "R - ver Reservas\n" + 
		              "E - ver Estação\n\n\n" +
		              "X - sair\n\n";
		char op;
		do {
			aConsola.clear();
			aConsola.println( menu );
			op = Character.toUpperCase( aConsola.readChar() );
			switch( op ){
				case 'R':
					verReservas();
					break;
				case 'E':
					verEstacao();
					break;
				case 'X':
					break;
				default:
					aConsola.println("Opção Inválida\n\n");
					aConsola.readLine();
					break;
			}
		} while( op != 'X');
		aConsola.close();            
	}
	
	/**
	 * imprime a informação completa de uma reserva
	 */
	private String getInfoReserva( ){
		// TODO completar informação
		return "ID_RESERVA Estação: ID_ESTACAO - NOME_ESTACAO"+
				           "\nNave: ID_NAVE - NOME_NAVE" + 
				           "\nTUi: TU_ENTRADA  TUf: TU_SAIDA";
	}
	
		
	/**
	 * lista um resumo de todas as reservas
	 */
	private void verReservas() {
		aConsola.clear();

		// TODO  apresentar informação das reservas
		for( int i=0; i < 1; i++ ){
			aConsola.println( getInfoReserva( ) );
			aConsola.println();
		}
		aConsola.readLine();		
	}

	
	/**
	 * lista a informação sobre uma estação
	 */
	private void verEstacao(){
		// TODO pedir a estação
		pedirEstacao();
		
		aConsola.clear();
		// TODO completar informação
		aConsola.println( "Estação: NOME_ESTACAO" );
		
		aConsola.println( "Protocolos suportados" );
		aConsola.print( "PROTOCOLO1, ...");
		aConsola.println( "" );
		
		aConsola.println("Reservas na estação\n" );
		// TODO imprimir info das reservas
		for( int i=0; i < 1; i++ ){
			aConsola.println( getInfoReserva( ) );
		}
		aConsola.readLine();
	}

	/** pede ao utilizador que indique uma estação, pedindo um id até
	 * que seja introduzido um id válido
	 * @return a estação indicada pelo utilizador
	 */
	private Object pedirEstacao() {
		do {
			aConsola.println( "Número da estação?");
			int id = aConsola.readInt();
			// TODO ver se a estação existe
			if( false )
				aConsola.println("Essa estação não existe!");
		// TODO enquanto id não for válido 
		} while( false );
		return null;
	}
}
