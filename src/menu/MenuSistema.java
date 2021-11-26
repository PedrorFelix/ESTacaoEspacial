package menu;

import consola.SConsola;


/**
 * Classe respons�vel pela apresenta��o e
 * processamento do menu principal da aplica��o
 * @author <por aqui nomes dos autores>
 */
public class MenuSistema {

	private SConsola aConsola; // a consola para a interface com o utilizador
	
	/**
	 * construtor da aplica��o
	 * @param x coordenada x onde deve ser colocada a janela da consola
	 * @param y coordenada y onde deve ser colocada a janela da consola
	 * @param comp comprimento da janela da consola
	 * @param alt altura da janela da consola
	 */
	public MenuSistema( int x, int y, int comp, int alt ){
		aConsola = new SConsola( "ESTa��o Espacial", x, y, comp, alt );
	}

	/** 
	 * m�todo que apresenta o menu principal da aplica��o
	 */
	public void menuPrincipal(){
		String menu = "ESTa��o Espacial - central de comandos\n\n" + 
		              "R - ver Reservas\n" + 
		              "E - ver Esta��o\n\n\n" +
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
					aConsola.println("Op��o Inv�lida\n\n");
					aConsola.readLine();
					break;
			}
		} while( op != 'X');
		aConsola.close();            
	}
	
	/**
	 * imprime a informa��o completa de uma reserva
	 */
	private String getInfoReserva( ){
		// TODO completar informa��o
		return "ID_RESERVA Esta��o: ID_ESTACAO - NOME_ESTACAO"+
				           "\nNave: ID_NAVE - NOME_NAVE" + 
				           "\nTUi: TU_ENTRADA  TUf: TU_SAIDA";
	}
	
		
	/**
	 * lista um resumo de todas as reservas
	 */
	private void verReservas() {
		aConsola.clear();

		// TODO  apresentar informa��o das reservas
		for( int i=0; i < 1; i++ ){
			aConsola.println( getInfoReserva( ) );
			aConsola.println();
		}
		aConsola.readLine();		
	}

	
	/**
	 * lista a informa��o sobre uma esta��o
	 */
	private void verEstacao(){
		// TODO pedir a esta��o
		pedirEstacao();
		
		aConsola.clear();
		// TODO completar informa��o
		aConsola.println( "Esta��o: NOME_ESTACAO" );
		
		aConsola.println( "Protocolos suportados" );
		aConsola.print( "PROTOCOLO1, ...");
		aConsola.println( "" );
		
		aConsola.println("Reservas na esta��o\n" );
		// TODO imprimir info das reservas
		for( int i=0; i < 1; i++ ){
			aConsola.println( getInfoReserva( ) );
		}
		aConsola.readLine();
	}

	/** pede ao utilizador que indique uma esta��o, pedindo um id at�
	 * que seja introduzido um id v�lido
	 * @return a esta��o indicada pelo utilizador
	 */
	private Object pedirEstacao() {
		do {
			aConsola.println( "N�mero da esta��o?");
			int id = aConsola.readInt();
			// TODO ver se a esta��o existe
			if( false )
				aConsola.println("Essa esta��o n�o existe!");
		// TODO enquanto id n�o for v�lido 
		} while( false );
		return null;
	}
}
