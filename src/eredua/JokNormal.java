package eredua;
import java.util.*;


public class JokNormal  extends Jokalari{
	private static JokNormal nireJok;
	private JokNormal( float pDiru ) {
		super(pDiru);
	}
	public static JokNormal getNireJok() {
		if(nireJok==null) {
			nireJok=new JokNormal(1000);
		}
		return nireJok;
	}
	
	public void txandaJokatu() {}
	/*Integer bat pasatuko zaio adieraziko duena zer arma motarekin tiro egin duen:
	 * 0 -> Bonba
	 * 1 -> Misila
	 * 2 -> Radarra
	 * */
	public void tiroEgin(int x, int y,int pArma) {
		if (pArma==2) {
			//TODO RADARRA IMPLEMENTATU
		}else if (pArma==1){
			misilTiroa(x,y);
		}else {
			gelaxkaUkitutaIpini(x, y);
			//TODO: URPERATUTA DAGOEN KONPROBATU
		}	
	}
	
	public void armamentuaErosi() {}
	public void ontziaKonpondu() {}
	public void radarraKontsultatu() {}
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
