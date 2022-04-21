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
			gelaxkaUkitutaIpini(x, y);
			if (ontziOsoaUrperatuDu(x,y)){ 
				ontziaUrperatu(x,y);
			}
		}else if (pArma == 1){ 
			System.out.println("Misila erabiliko da");
			misilTiroa(x,y);
			int kop = super.armaKantitateaEguneratu(new Misil());
			setChanged();
			notifyObservers(new int[] {0,kop});
		}else if (pArma == 2) {
			radarraKontsultatu(x,y);
			int kop = super.armaKantitateaEguneratu(new Radarra());
			setChanged();
			notifyObservers(new int[] {1,kop});
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
