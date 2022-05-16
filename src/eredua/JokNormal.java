package eredua;
import java.util.*;


public class JokNormal  extends Jokalari{
	private static JokNormal nireJok;
	
	private JokNormal() {super();}
	
	public static JokNormal getNireJok() {
		if(nireJok==null) {
			nireJok=new JokNormal();
		}
		return nireJok;
	}
	
	/**
	 * Tablerotik adierazitako arma erabiltzen saiatuko da, lortzekotan txanda aldatu egingo da,
	 * eta arma kopurua eguneratuko du bere baliabideetan, bestela tableroari (beste metodo 
	 * batean) observable bidez jakinaraziko dio ezin dela arma bertan erabili eta txanda 
	 * mantenduko da.
	 * Arma mota beti izango du, bestela tablero bistan ezingo zelako klikatu
	 * @param x
	 * @param y
	 * @param pArma
	 */
	public void txandaJokatu(int x, int y, Arma pArma) {
		boolean erabiliDa; //BOOLEAN HORI ESANGO DU EA pArma ERABILTZEA DEN ALA EZ
		if(pArma instanceof Ezkutua) erabiliDa = pArma.erabili(x, y, this.nireItsasontziak);
		else erabiliDa = pArma.erabili(x, y, Bot.getNireBot().nireItsasontziak); 
		if(erabiliDa) {
			if(pArma instanceof Bonba || pArma instanceof Misil) FlotaUrperatu.getNireFlotaUrperatu().aldatuTxanda();
			int kop = this.baliabideak.armaKantitateaEguneratu(pArma);
			int arma=0;
			if (pArma instanceof Radarra) arma = 1;
			else if(pArma instanceof Ezkutua) arma = 2;
			setChanged();
			notifyObservers(new int[] {arma,kop}); 
		}
	}
	
	//************************** KONPONKETAK **************************************************
	public void ontziaKonpondu(int x, int y) {
		System.out.println(x+"<--X, "+y+"<--Y");
		if(nireItsasontziak.itsasontziaDuGelaxka(x, y) && nireItsasontziak.ukitutaDago(x, y)) {
			nireItsasontziak.gelaxkaKonpondu(x, y);
			baliabideak.erosketaPrezioaKendu(); 
			setChanged();
			notifyObservers(new int[] {x,y,11,0});
		}
		else{
			setChanged();
			notifyObservers(new int[] {x,y,12});
		}
	}
}
