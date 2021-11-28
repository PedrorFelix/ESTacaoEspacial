package menu;

import classes.Server;

import java.util.ArrayList;
import java.util.HashMap;
import classes.Estacao;
import consola.SConsola;


/**
 * Classe responsável pela apresentação e
 * processamento do menu principal da aplicação
 * @author <Daniel Pratas, Pedro Félix>
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
	 * lista a informação sobre uma estação
	 */
	private void verEstacao(){
		Estacao estacao = pedirEstacao();
		aConsola.println(estacao.verInfo());
		aConsola.println( "\n" );		
		aConsola.println("Reservas na estação\n" );
		for( int i=0; i < server.getReservas(estacao).size(); i++ ){
			aConsola.println(server.getReservas().get(i).getInfo());
			aConsola.println();
		}
		aConsola.readLine();
	}

	/** pede ao utilizador que indique uma estação, pedindo um id até
	 * que seja introduzido um id válido
	 * @return a estação indicada pelo utilizador
	 */
	private Estacao pedirEstacao() {
		Integer id;
		HashMap<String, Estacao> estacoes = server.getEstacoes();
		do {
			aConsola.println( "Número da estação?");
			id = aConsola.readInt();
			if(estacoes.containsKey(id.toString()))
				return estacoes.get(id.toString());	
			
			aConsola.println("Essa estação não existe!");
		} while(!estacoes.containsKey(id.toString()));
		return null;
	}
}
