package menu;

import classes.Server;

import java.util.ArrayList;
import java.util.HashMap;
import classes.Estacao;
import consola.SConsola;


/**
 * Classe respons�vel pela apresenta��o e
 * processamento do menu principal da aplica��o
 * @author <Daniel Pratas, Pedro F�lix>
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
	 * lista um resumo de todas as reservas
	 */
	private void verReservas() {
		aConsola.clear();
		for( int i=0; i < server.getReservas().size(); i++ ){
			aConsola.println(server.getReservas().get(i).getInfo());
			aConsola.println();
		}
		aConsola.readLine();		
	}

	
	/**
	 * lista a informa��o sobre uma esta��o
	 */
	private void verEstacao(){
		Estacao estacao = pedirEstacao();
		aConsola.println(estacao.verInfo());
		aConsola.println( "\n" );		
		aConsola.println("Reservas na esta��o\n" );
		for( int i=0; i < server.getReservas(estacao).size(); i++ ){
			aConsola.println(server.getReservas().get(i).getInfo());
			aConsola.println();
		}
		aConsola.readLine();
	}

	/** pede ao utilizador que indique uma esta��o, pedindo um id at�
	 * que seja introduzido um id v�lido
	 * @return a esta��o indicada pelo utilizador
	 */
	private Estacao pedirEstacao() {
		Integer id;
		HashMap<String, Estacao> estacoes = server.getEstacoes();
		do {
			aConsola.println( "N�mero da esta��o?");
			id = aConsola.readInt();
			if(estacoes.containsKey(id.toString()))
				return estacoes.get(id.toString());	
			
			aConsola.println("Essa esta��o n�o existe!");
		} while(!estacoes.containsKey(id.toString()));
		return null;
	}
}
