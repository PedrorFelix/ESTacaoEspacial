package menu;

import java.util.HashMap;

import classes.Reserva;
import classes.Estacao;
import classes.EstacaoEspacial;
import classes.EstacaoOrbital;
import classes.EstacaoPlanetaria;
import classes.EstacaoWormHole;
import classes.Nave;
import classes.Server;
import classes.TempoUniversal;
import consola.SConsola;

public class MenuNave {

	private SConsola consola; // a consola para a interface com o utilizador
	private Nave nave; // nave selecionada
	private Server server; // server para obter informa��o
	private Estacao estacao;
	
	/**
	 * construtor do menu da nave
	 * @param x coordenada x onde deve ser colocada a janela da consola
	 * @param y coordenada y onde deve ser colocada a janela da consola
	 * @param comp comprimento da janela da consola
	 * @param alt altura da janela da consola
	 */
	public MenuNave( int x, int y, int comp, int alt, Server server){
		consola = new SConsola( "ESTa��o Espacial - Simulador de Nave", x, y, comp, alt );
		this.server = server;
	}

	/** 
	 * m�todo que apresenta o menu principal da nave
	 */
	public void menuPrincipal(){
		char op;
		
		// at� ser escolhida uma nave v�lida
		while(nave == null) 
			mudarNave();
		do {
			String menu = "ESTa��o Espacial - Simula��o de Nave\n\n" +
					  "Nave: " + nave.getId() + "  " + nave.getNome() +"\n\n" +  
		              "R - nova Reserva\n" +
		              "V - Ver reservas\n" + 
		              "E - ver Especifica��es\n\n\n" + 
		              "N - mudar de Nave";
			consola.clear();
			consola.println( menu );
			if(!server.getReservas(nave).isEmpty())
				consola.println("\n\nProxima reserva:\n" + server.getReserva(nave).getInfo());
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
		TempoUniversal tempo = new TempoUniversal();
		consola.clear();
		consola.println("Menu de reservas\n\n"); 

		// pedir esta��o
		estacao = pedirEstacao();

		// validar protocolos da nave
		if(!estacao.validarProtocolos(nave.getProtocolos())){
			consola.println("Os protocolos n�o s�o suportados");
			consola.readLine();
			return;
		}
		
		// receber intervalo de tempo
		consola.println( "Qual o TU de entrada?" );
		tempo.setTUEntrada(consola.readLong());
		
		consola.println( "Qual o TU de sa�da?" );
		tempo.setTUSaida(consola.readLong());
		
		if (tempo.getTUEntrada() < 0 || tempo.getTUSaida() <= tempo.getTUEntrada()) {
			consola.println("Medidas de tempo inv�lidas");
		}
		
		// verificar se ja tem reserva nesse tempo
		for(int i = 0; i < server.getReservas(nave).size(); i++) {
			if(!tempo.estaDisponivel(server.getReservas(nave).get(i).getTempo())){
				consola.println("A nave j� tem um compromisso nesse per�odo!");
				consola.readLine();
				return;
			}
		}
		
		if(!estacao.validarReserva(nave, server.getReservas(estacao), tempo)){
			switch(estacao.getTipo()) {
			case 'O':
				consola.println("N�o h� portas disponiveis nesse intervalo de tempo");
				break;
			case 'W':
				consola.println("A nave n�o cabe no Worm Hole");
				break;
			case 'E':
				consola.println("A nave n�o cabe na esta��o");
				break;
			case 'P':
				consola.println("A nave n�o tem pot�ncia suficiente");
				break;
			}
			consola.readLine();
			return;
		}
			
		consola.println(
				"Esta��o(ID/Nome): " + estacao.getId() + " / " + estacao.getNome() +
				"\nTempo de Entrada: " + tempo.getTUEntrada() +
				"\nTempo de Saida: " + tempo.getTUSaida());
		
		consola.println("Confirmar reserva? (S/N)");
		char sim = Character.toUpperCase( consola.readChar() );
		if(sim != 'S')
			return;
	
		int index = server.getReservas().size() + 1;
		server.getReservas().add(new Reserva(index, estacao, nave, tempo));
		
		consola.println("Reserva criada com id: " + index);
		consola.readLine();
	}

	
	/**
	 * lista um resumo de todas as reservas
	 */
	private void verReservas() {
		consola.clear();
		if(server.getReservas(nave).isEmpty())
			consola.println("Sem reservas.");
		for(int i=0; i < server.getReservas(nave).size(); i++){
			consola.println(server.getReservas(nave).get(i).getInfo());
			consola.println();
		}
		consola.readLine();		
	}

	/** pede a identifica��o da esta��o
	 * e devolve a esta��o correta
	 * @return a esta��o que o utilizador escolheu
	 */
	private Estacao pedirEstacao() {
		Integer id;
		HashMap<String, Estacao> estacoes= server.getEstacoes();
		do {
			consola.println( "N�mero da esta��o?");
			id = consola.readInt();
			if(id<estacoes.size())
				return estacoes.get(id.toString());
			consola.println("Essa esta��o n�o existe!");
		} while(!estacoes.containsKey(id.toString()));
		return null;
	}

	/** imprime as especifica��es da nave
	 */
	private void verEspecificacoes() {
		consola.println(nave.getEspecs());
		consola.readLine();
	}

	/** muda de nave, pedindo ao utilizador a identifica��o da nova nave
	 */
	private void mudarNave() {
		consola.println( "N�mero da nave?");
		String id = consola.readLine();
		if(server.getNaves().containsKey(id)) {
			consola.println("Mudan�a efetuada.");
			nave = server.getNaves().get(id);
		}
		else 
			consola.println("Nave desconhecida! Mudan�a n�o efetuada");
		consola.readLine();
	}
}
