package eredua;

import java.util.Observable;

public class Tablero extends Observable{
	private Gelaxka[][] tablero;
	
	public Tablero() {
		tablero=new Gelaxka[10][10];
	}
}
