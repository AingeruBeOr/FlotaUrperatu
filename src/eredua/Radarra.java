package eredua;

public class Radarra extends Arma{
	private int kontsultaKop;
	int x;
	int y;
	
	public Radarra(int kontsultaKop) {
		super();
		this.kontsultaKop = kontsultaKop;
		
	}
	
	public int ezarriKontsultak() {
		return kontsultaKop;
	}
	
	public void itzuliKoordenatuak() {
		x = 0;
		y = 0;
		//Koordenatu koord = new Koordenatu(x, y);
		//koord.jasoX();
		//koord.jasoY();
		
	}
}
