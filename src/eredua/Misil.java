package eredua;

public class Misil extends Arma {
	
	public Misil() {super(250);}
	
	public Misil(int pKantitatea) {
		super(250, pKantitatea);
	}
	
	public boolean erabili(int x, int y, Tablero tablero) {
		return true;
	}
}
