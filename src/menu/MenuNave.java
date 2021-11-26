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
		consola = new SConsola( "ESTação Espacial - Simulador de Nave", x, y, comp, alt );
	}

	/** 
	 * mï¿½todo que apresenta o menu principal da nave
	 */
	public void menuPrincipal(){
		char op;
		
		// TODO ver se já tem nave escolhida, senão pedir
		// atÃ© ser escolhida uma nave válida
		while( Math.abs( 4 ) != 4 ) 
			mudarNave();
		
		do {
			// TODO alterar este menu
			String menu = "ESTação Espacial - Simulação de Nave\n\n" +
					  "Nave: " + "IDNAVE" + "  " + "NOMENAVE" +"\n\n" +  
		              "R - nova Reserva\n" +
		              "V - Ver reservas\n" + 
		              "E - ver Especificações\n\n\n" + 
		              "N - mudar de Nave";

			consola.clear();
			consola.println( menu );
			if( true ) // TODO ver qual a prÃ³xima reserva , se houver
				consola.println("\n\nProxima reserva: " + getReservaInfo( ) );
			else
				consola.println("\n\nNão tem reservas");
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
					consola.println("Opção Inválida\n\n");
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

		// pedir estação
		pedirEstacao();

		// TODO ver se nave pode usar a estação
		if( false ){
			consola.println("Não pode usar essa estação!");
			consola.readLine();
			return;
		}
		
		consola.println( "Qual o TU de entrada?\n" );
		int entradaTU = consola.readInt();
		
		consola.println( "Qual o TU de saída?\n" );
		int saidaTU = consola.readInt();
				
		// TODO ver se nave está ocupada nesse periodo
		if( false /* */){
			consola.println("A nave já tem um compromisso nesse período!");
			consola.readLine();
			return;
		}
		
		// TODO testar se pode ser reservada
		// ver se a estação aceita a reserva e em que perÃ­odo de tempo
		// se sim indica qual a reserva que pode realmente fazer
		if(  false /* se não pode reservar */ ){
			consola.println("A reserva não pode ser efetuada");
			consola.readLine();
			return;
		}
			
		// TODO completar esta informação
		consola.println("Estação: " + "NOME ESTAÇÃO" + "\nNave: "+ "NOME NAVE" +
				         "\nTU entrada: "+ "TU_ENTRADA" + "\nTU saída: " + "TU_SAIDA" );
		
		consola.println("Confirmar reserva? (S/N)");
		char sim = Character.toUpperCase( consola.readChar() );
		if( sim != 'S' )
			return;
	
		// TODO criar a reserva
		
		// TODO completar a informação
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

	/** pede a identificação da estação
	 * e devolve a estação correta
	 * @return a estação que o utilizador escolheu
	 */
	private Object pedirEstacao() {
		do {
			consola.print( "Número da estação? ");
			int id = consola.readInt();
			// TODO ver se estação existe
			if( false )
				consola.println("Estação desconhecida!");
		// TODO ver se estação Ã© reconhecida
		} while( false );
		return null;
	}

	/** imprime as especificaçÃµes da nave
	 */
	private void verEspecificacoes() {
		// TODO completar as informaçÃµes
		consola.println( "ID_NAVE" + "  " + "NOME_NAVE" );
		consola.println( "Potência: POTENCIA_NAVE  massa: MASSA_NAVE" );
		consola.println( "DimensÃµes (Comp x Larg x Alt): COMP x LARG x ALT" );
		
		consola.println("\nProtocolos");
		consola.println( "PROTOCOLO1" + ", " );
		consola.readLine();
	}

	/** muda de nave, pedindo ao utilizador a identificação da nova nave
	 */
	private void mudarNave() {
		consola.println( "Número da nave?");
		int id = consola.readInt();
		// TODO ver se nave existe
		if( true ) {
			consola.println("Mudança efetuada.");
		}
		else 
			consola.println("Nave desconhecida! Mudança não efetuada");
		
		consola.readLine();
	}
	
	/** devolve a informação de uma reserva em formato de texto
	 */
	private String getReservaInfo( ) {
		// TODO completar a informação
		return "ID_RESERVA estação: ID_ESTACAO - NOME_ESTACAO  TUi: TU_ENTRADA  TUf: TU_SAIDA";
	}
}
