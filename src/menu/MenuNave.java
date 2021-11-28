package menu;

import java.util.HashMap;

import classes.Reserva;
import classes.Estacao;
import classes.Nave;
import classes.Server;
import classes.TempoUniversal;
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
			if(!server.getReservas(nave).isEmpty())
				consola.println("\n\nProxima reserva:\n" + server.getReserva(nave).getInfo());
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
		TempoUniversal tempo = new TempoUniversal();
		consola.clear();
		consola.println("Menu de reservas\n\n"); 

		// pedir estação
		estacao = pedirEstacao();

		// validar protocolos da nave
		if(!estacao.validarProtocolos(nave.getProtocolos())){
			consola.println("Não pode usar essa estação!");
			consola.readLine();
			return;
		}
		
		// receber intervalo de tempo
		consola.println( "Qual o TU de entrada?" );
		tempo.setTUEntrada(consola.readLong());
		
		consola.println( "Qual o TU de saída?" );
		tempo.setTUSaida(consola.readLong());
		
		for(int i = 0; i < server.getReservas(nave).size(); i++) {
			if(tempo.estaDisponivel(server.getReservas().get(i).getTempo())){
				consola.println("A nave já tem um compromisso nesse período!");
				consola.readLine();
				return;
			}
		}
		
		if(!estacao.validarReserva(nave, server.getReservas(estacao), tempo)){
			consola.println("A reserva não pode ser efetuada");
			consola.readLine();
			return;
		}
			
		consola.println(
				"Estação(ID/Nome): " + estacao.getId() + " / " + estacao.getNome() +
				"\nNave(ID/Nome): " + nave.getId() + " / " + nave.getNome() +
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

	/** pede a identificação da estação
	 * e devolve a estação correta
	 * @return a estação que o utilizador escolheu
	 */
	private Estacao pedirEstacao() {
		Integer id;
		HashMap<String, Estacao> estacoes= server.getEstacoes();
		do {
			consola.println( "Número da estação?");
			id = consola.readInt();
			if(id<estacoes.size())
				return estacoes.get(id.toString());
			consola.println("Essa estação não existe!");
		} while(!estacoes.containsKey(id.toString()));
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
}
