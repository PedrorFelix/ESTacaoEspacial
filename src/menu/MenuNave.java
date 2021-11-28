package menu;

import java.util.HashMap;

import classes.Estacao;
import classes.Nave;
import classes.Server;
import consola.SConsola;

public class MenuNave {

	private SConsola consola; // a consola para a interface com o utilizador
	private Nave nave; // nave selecionada
	private Server server; // server para obter informação
	private Estacao estacao;
	
	/**
	 * construtor do menu da nave
	 * @param x coordenada x onde deve ser colocada a janela da consola
	 * @param y coordenada y onde deve ser colocada a janela da consola
	 * @param comp comprimento da janela da consola
	 * @param alt altura da janela da consola
	 */
	public MenuNave( int x, int y, int comp, int alt, Server server){
		consola = new SConsola( "ESTação Espacial - Simulador de Nave", x, y, comp, alt );
		this.server = server;
	}

	/** 
	 * método que apresenta o menu principal da nave
	 */
	public void menuPrincipal(){
		char op;
		
		// até ser escolhida uma nave válida
		while(nave == null) 
			mudarNave();
		do {
			String menu = "ESTação Espacial - Simulação de Nave\n\n" +
					  "Nave: " + nave.getId() + "  " + nave.getNome() +"\n\n" +  
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
		// ver se a estação aceita a reserva e em que período de tempo
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
	private Estacao pedirEstacao() {
		do {
			consola.println( "Número da estação?");
			Integer id = consola.readInt();
			HashMap<String, Estacao> estacoes= server.getEstacoes();
			if(id<estacoes.size())
				return estacoes.get(id.toString());	
			
			consola.println("Essa estação não existe!");
		// TODO enquanto id não for válido 
		} while( false );
		return null;
	}

	/** imprime as especificações da nave
	 */
	private void verEspecificacoes() {
		consola.println(nave.getEspecs());
		consola.readLine();
	}

	/** muda de nave, pedindo ao utilizador a identificação da nova nave
	 */
	private void mudarNave() {
		consola.println( "Número da nave?");
		String id = consola.readLine();
		if(server.getNaves().containsKey(id)) {
			consola.println("Mudança efetuada.");
			nave = server.getNaves().get(id);
		}
		else 
			consola.println("Nave desconhecida! Mudança não efetuada");
		consola.readLine();
	}
	
	/** devolve a informação de uma reserva em formato de texto
	 */
	private String getReservaInfo( ) {
		
		return "ID_RESERVA estação: ID_ESTACAO - NOME_ESTACAO  TUi: TU_ENTRADA  TUf: TU_SAIDA";
	}
}
