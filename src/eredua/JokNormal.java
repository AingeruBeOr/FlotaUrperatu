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
	
	public void txandaJokatu() {}
	
	/**
	 * Integer bat pasatuko zaio adieraziko duena zer arma motarekin tiro egin duen:
	 * 		0 -> Bonba
	 * 		1 -> Misila
	 * 		2 -> Radarra
	 * @param x koordenatua
	 * @param y koordenatua
	 * @param pArma arma mota
	 */
	public void tiroEgin(int x, int y,int pArma) {
		if (pArma == 0){
			
			if(Bot.getNireBot().ezkutuaDago(x, y)) {
				//TODO ESTO ESTA MAL
				Bot.getNireBot().ezkutuaIpini(x, y, 1);
			}else {
				gelaxkaUkitutaIpini(x, y);
				if (ontziOsoaUrperatuDu(x,y)){ 
					ontziaUrperatu(x,y);
				}
			}
		}else if (pArma == 1){ 
			System.out.println("Misila erabiliko da");
			misilTiroa(x,y);
		}else if (pArma == 2) {
			radarraKontsultatu(x,y);
		}	
	}
	
	/**
	 * Jokalariak (x,y) posizioan ezkutu bat jarri nahi dela adierazi du. 
	 * Bertan ezkutu bat jarri dezakeen konprobatuko da. Hala bada, ezkutua
	 * jarriko zaio bertan dagoen itsaontzi osoari.
	 * @param x koordenatua
	 * @param y koordenatua
	 */
	public void ezkutuaJarri(int x, int y) {
		if(super.itsasontziaDaukat(x, y)) {
			if(!super.ezkutuaDago(x, y)) {
				if(!nireItsasontziak.urperatutaDago(x, y)) { //!super.ontziOsoaUrperatuDu(x, y)
					super.ezkutuaIpini(x, y, 2);
					
					//ezkutu kantitatea eguneratu:
					int kop = armaKantitateaEguneratu(new Ezkutua());
					setChanged();
					notifyObservers(new int[] {2,kop}); 
				}
				else {
					//posizio horretan dagoen itsasontzia ondoratuta dago:
					setChanged();
					notifyObservers(new int[] {x,y,10});
				}
			}
			else {
				//posizio horretan jadanik dago ezkutu bat:
				setChanged();
				notifyObservers(new int[] {x,y,9});
			}
		}
		else {
			//posizio horretan ezkutu bat ezin du ipini:
			setChanged();
			notifyObservers(new int[] {x,y,8});
		}
		
	}
	
	public void armamentuaErosi() {}
	public void ontziaKonpondu() {}
	protected boolean tiroaOndoEginDu() {
		
		return true;
	}
	public void ontziaKokatu(int pX, int pY, boolean pHorizontal, int pLuz) {
		nireItsasontziak.ontziaKokatu(pX, pY, pHorizontal, pLuz);
	}
	public boolean ontziaKokatuAhalDa(int pX, int pY, boolean pHorizontal, int pLuz) {
		return nireItsasontziak.ontziaKokatuAhalDa(pX, pY, pHorizontal, pLuz);
	}
	
	protected void ontziaUkituDu(int x, int y) {}
	protected void uraUkituDu(int x, int y) {}

}
