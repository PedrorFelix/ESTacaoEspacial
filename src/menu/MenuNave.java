package menu;

import consola.SConsola;

public class MenuNave {

	private SConsola consola; // a consola para a interface com o utilizador
	
	/**
	 * construtor do menu da nave
	 * @param x coordenada x onde deve ser colocada a janela da consola
	 * @param y coordenada y onde deve ser colocada a janela da consola
	 * @param comp comprimento da janela da consola
	 * @param alt altura da janela da consola
	 */
	public MenuNave( int x, int y, int comp, int alt ){
		consola = new SConsola( "ESTa��o Espacial - Simulador de Nave", x, y, comp, alt );
	}

	/** 
	 * m�todo que apresenta o menu principal da nave
	 */
	public void menuPrincipal(){
		char op;
		
		// TODO ver se j� tem nave escolhida, sen�o pedir
		// até ser escolhida uma nave v�lida
		while( Math.abs( 4 ) != 4 ) 
			mudarNave();
		
		do {
			// TODO alterar este menu
			String menu = "ESTa��o Espacial - Simula��o de Nave\n\n" +
					  "Nave: " + "IDNAVE" + "  " + "NOMENAVE" +"\n\n" +  
		              "R - nova Reserva\n" +
		              "V - Ver reservas\n" + 
		              "E - ver Especifica��es\n\n\n" + 
		              "N - mudar de Nave";

			consola.clear();
			consola.println( menu );
			if( true ) // TODO ver qual a próxima reserva , se houver
				consola.println("\n\nProxima reserva: " + getReservaInfo( ) );
			else
				consola.println("\n\nN�o tem reservas");
			op = Character.toUpperCase( consola.readChar() );
			switch( op ){
				case 'R':
					novaReserva();
					break;
				case 'V':
					verReservas();
					break;
				case 'E':
					verEspecificacoes();
					break;
				case 'N':
					mudarNave();
					break;
				default:
					consola.println("Op��o Inv�lida\n\n");
					break;
			}
		} while( true );
	}

	/**
	 * fazer uma nova reserva 
	 */
	private void novaReserva() {
		consola.clear();
		consola.println("Menu de reservas\n\n"); 

		// pedir esta��o
		pedirEstacao();

		// TODO ver se nave pode usar a esta��o
		if( false ){
			consola.println("N�o pode usar essa esta��o!");
			consola.readLine();
			return;
		}
		
		consola.println( "Qual o TU de entrada?\n" );
		int entradaTU = consola.readInt();
		
		consola.println( "Qual o TU de sa�da?\n" );
		int saidaTU = consola.readInt();
				
		// TODO ver se nave est� ocupada nesse periodo
		if( false /* */){
			consola.println("A nave j� tem um compromisso nesse per�odo!");
			consola.readLine();
			return;
		}
		
		// TODO testar se pode ser reservada
		// ver se a esta��o aceita a reserva e em que período de tempo
		// se sim indica qual a reserva que pode realmente fazer
		if(  false /* se n�o pode reservar */ ){
			consola.println("A reserva n�o pode ser efetuada");
			consola.readLine();
			return;
		}
			
		// TODO completar esta informa��o
		consola.println("Esta��o: " + "NOME ESTA��O" + "\nNave: "+ "NOME NAVE" +
				         "\nTU entrada: "+ "TU_ENTRADA" + "\nTU sa�da: " + "TU_SAIDA" );
		
		consola.println("Confirmar reserva? (S/N)");
		char sim = Character.toUpperCase( consola.readChar() );
		if( sim != 'S' )
			return;
	
		// TODO criar a reserva
		
		// TODO completar a informa��o
		consola.println("Reserva criada com id: " + "ID_RESERVA" );
		consola.readLine();
	}

	
	/**
	 * lista um resumo de todas as reservas
	 */
	private void verReservas() {
		consola.clear();
		 
		// TODO ver se tem reservas
		if( false )
			consola.println("Sem reservas.");
		
		for( int i=0; i < 1; i++  ){
			consola.println( getReservaInfo( ) );
		}
		consola.readLine();		
	}

	/** pede a identifica��o da esta��o
	 * e devolve a esta��o correta
	 * @return a esta��o que o utilizador escolheu
	 */
	private Object pedirEstacao() {
		do {
			consola.print( "N�mero da esta��o? ");
			int id = consola.readInt();
			// TODO ver se esta��o existe
			if( false )
				consola.println("Esta��o desconhecida!");
		// TODO ver se esta��o é reconhecida
		} while( false );
		return null;
	}

	/** imprime as especifica�ões da nave
	 */
	private void verEspecificacoes() {
		// TODO completar as informa�ões
		consola.println( "ID_NAVE" + "  " + "NOME_NAVE" );
		consola.println( "Pot�ncia: POTENCIA_NAVE  massa: MASSA_NAVE" );
		consola.println( "Dimensões (Comp x Larg x Alt): COMP x LARG x ALT" );
		
		consola.println("\nProtocolos");
		consola.println( "PROTOCOLO1" + ", " );
		consola.readLine();
	}

	/** muda de nave, pedindo ao utilizador a identifica��o da nova nave
	 */
	private void mudarNave() {
		consola.println( "N�mero da nave?");
		int id = consola.readInt();
		// TODO ver se nave existe
		if( true ) {
			consola.println("Mudan�a efetuada.");
		}
		else 
			consola.println("Nave desconhecida! Mudan�a n�o efetuada");
		
		consola.readLine();
	}
	
	/** devolve a informa��o de uma reserva em formato de texto
	 */
	private String getReservaInfo( ) {
		// TODO completar a informa��o
		return "ID_RESERVA esta��o: ID_ESTACAO - NOME_ESTACAO  TUi: TU_ENTRADA  TUf: TU_SAIDA";
	}
}
