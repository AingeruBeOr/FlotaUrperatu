package eredua;

public class Koordenatu {

	private int x;
	private int y;
	
	//Constructor
	public Koordenatu (int x, int y) {
		this.x = x;
		this.y = y; 
		
	}
	
	public int jasoX() {
		return x;
	}
	
	public int jasoY() {
		return y;
	}
	
	//Para recibir las coordenadas
	public String itzuliKoordenatuak() {
		return ("(" + x + ", " + y + ")");
	}
}
