package eredua;

public class Radarra extends Arma{
	private int kontsultaKop;
	
	public Radarra(int kontsultaKop) {
		super();
		this.kontsultaKop = kontsultaKop;
		
	}
	
	public int ezarriKontsultak() {
		return kontsultaKop;
	}
	
	public void itzuliKoordenatuak() {
		int x = 0;
		int y = 0;
		Koordenatu koord = new Koordenatu(x, y);
		koord.jasoX();
		koord.jasoY();
		
	}
}
