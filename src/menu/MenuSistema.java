package menu;

import classes.Server;

import java.util.ArrayList;
import java.util.HashMap;
import classes.Estacao;
import consola.SConsola;


/**
 * Classe respons�vel pela apresenta��o e
 * processamento do menu principal da aplica��o
 * @author <por aqui nomes dos autores>
 */
public class MenuSistema {

	private SConsola aConsola; // a consola para a interface com o utilizador
	private Server server; // server para obter informa��o
	/**
	 * construtor da aplica��o
	 * @param x coordenada x onde deve ser colocada a janela da consola
	 * @param y coordenada y onde deve ser colocada a janela da consola
	 * @param comp comprimento da janela da consola
	 * @param alt altura da janela da consola
	 */
	public MenuSistema( int x, int y, int comp, int alt, Server server){
		aConsola = new SConsola( "ESTa��o Espacial", x, y, comp, alt );
		this.server = server;
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
		String estacao = pedirEstacao().verInfo();
		aConsola.println(estacao);
		aConsola.println( "\n" );		
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
	private Estacao pedirEstacao() {
		do {
			aConsola.println( "N�mero da esta��o?");
			Integer id = aConsola.readInt();
			HashMap<String, Estacao> estacoes= server.getEstacoes();
			if(id<estacoes.size())
				return estacoes.get(id.toString());	
			
			aConsola.println("Essa esta��o n�o existe!");
		// TODO enquanto id n�o for v�lido 
		} while( false );
		return null;
	}
}
