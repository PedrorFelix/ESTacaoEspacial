package menu;

import classes.Server;

import java.util.ArrayList;
import java.util.HashMap;
import classes.Estacao;
import consola.SConsola;


/**
 * Classe responsável pela apresentação e
 * processamento do menu principal da aplicação
 * @author <por aqui nomes dos autores>
 */
public class MenuSistema {

	private SConsola aConsola; // a consola para a interface com o utilizador
	private Server server; // server para obter informação
	/**
	 * construtor da aplicação
	 * @param x coordenada x onde deve ser colocada a janela da consola
	 * @param y coordenada y onde deve ser colocada a janela da consola
	 * @param comp comprimento da janela da consola
	 * @param alt altura da janela da consola
	 */
	public MenuSistema( int x, int y, int comp, int alt, Server server){
		aConsola = new SConsola( "ESTação Espacial", x, y, comp, alt );
		this.server = server;
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
		String estacao = pedirEstacao().verInfo();
		aConsola.println(estacao);
		aConsola.println( "\n" );		
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
	private Estacao pedirEstacao() {
		do {
			aConsola.println( "Número da estação?");
			Integer id = aConsola.readInt();
			HashMap<String, Estacao> estacoes= server.getEstacoes();
			if(id<estacoes.size())
				return estacoes.get(id.toString());	
			
			aConsola.println("Essa estação não existe!");
		// TODO enquanto id não for válido 
		} while( false );
		return null;
	}
}
