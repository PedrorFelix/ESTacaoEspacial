/*
    Esta classe representa uma Janela de consola que permite ao
    utilizador escrever nela. Permite ao programador escrever e
    limpar o seu conte�do.
    Utiliza a classe ConsolePanel desenvolvida por David Eck 
    
    Autor:  F. Sérgio Barbosa 

    Criada em 27 de Março de 2007.
    Ultima alteração em 23 de Setembro de 2021
*/

package consola;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Esta classe representa uma Janela de consola que permite ao
 * utilizador escrever nela. Permite ao programador escrever e
 * limpar o seu conteúdo.
 * Utiliza a classe ConsolePanel desenvolvida por David Eck
*/ 
public class SConsola {
	
	private ConsolePanel console = new ConsolePanel();
	private JFrame janela;

	public SConsola(String titulo, int x, int y, int comp, int alt) {
		janela = new ConsoleWindow( titulo, x, y, comp, alt );
	}
	
	public SConsola(String titulo, int comp, int alt) {
		janela = new ConsoleWindow( titulo, comp, alt );
	}
	
	public SConsola( String titulo ) {
		this( titulo, 500, 500);
	}
	
	public SConsola(int comp, int alt) {
		this( "Consola", comp, alt );
	}
	
	public SConsola( ){
		this( "Consola", 500, 500);
	}

	// redirecionar o input da Janela para a consola 
	public byte  readByte()   { return console.getlnByte(); }
	public short readShort()  { return console.getlnShort(); }
	public boolean readBoolean() { return console.getlnBoolean(); }
	public int   readInt()    { return console.getlnInt(); }
    public long  readLong()   { return console.getlnLong(); }
    public char  readChar()   { return console.getlnChar(); }
    public float readFloat()  { return console.getlnFloat();}
    public Double readDouble(){ return console.getlnDouble();}
    public String readWord()  { return console.getlnWord();}
    public String readLine()  { return console.getln(); }
    
    // redirecionar o output da Janela para a consola
    public void print( int x )       { console.put( x ); }
    public void println( int x )     { console.putln( x ); }
    public void print( long x )      { console.put( x ); }
    public void println( long x )    { console.putln( x ); }
    public void print( double x )    { console.put( x ); }
    public void println( double x )  { console.putln( x ); }
    public void print( char x )      { console.put( x ); }
    public void println( char x )    { console.putln( x ); }
    public void print( boolean x )   { console.put( x ); }
    public void println( boolean x ) { console.putln( x ); }
    public void print( String x )    { console.put( x ); }
    public void println( String x )  { console.putln( x ); }
    public void println( )           { console.putln(); }
    
    // limpar a consola
    public void clear() {
    	console.clear();
    }
    
	class ConsoleWindow extends JFrame {
		
		/** versão	 */
		private static final long serialVersionUID = 20210001;

		ConsoleWindow( String titulo, int x, int y, int comp, int alt) {
			setSize( comp, alt );
			setTitle( titulo );
			setLocation(x, y);
			setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			getContentPane().add( console, BorderLayout.CENTER );			
			setVisible( true );		
		}
		
		ConsoleWindow( String titulo, int comp, int alt) {
			this( titulo, 0, 0, comp, alt);		
		}
	}

	public void close(){
		janela.setVisible( false );
		janela.dispose();
	}
}
