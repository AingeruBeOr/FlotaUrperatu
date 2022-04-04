package eredua;

public class Radarra extends Arma{
	
	public Radarra(int pPrezioa, int pKantitatea) {
		super(pPrezioa, pKantitatea);
	}
	
	/*public int ezarriKontsultak() {
		return kontsultaKop;
	}*/
	
	public void itzuliKoordenatuak() {
		int x = 0;
		int y = 0;
		Koordenatu koord = new Koordenatu(x, y);
		koord.jasoX();
		koord.jasoY(); 
		
	}
}

