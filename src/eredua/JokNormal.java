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
	//************************** ITSASONTZIAK KOKATU**************************************************
	public void ontziaKokatu(int pX, int pY, boolean pHorizontal, int pLuz) {
		nireItsasontziak.ontziaKokatu(pX, pY, pHorizontal, pLuz);
	}
	public boolean ontziaKokatuAhalDa(int pX, int pY, boolean pHorizontal, int pLuz) {
		return nireItsasontziak.ontziaKokatuAhalDa(pX, pY, pHorizontal, pLuz);
	}
	//********************************** UKITUAK *******************************************************
	/**
	 * true bueltatuko du adieraztiako posizioan itsasontzi bat ukitu badu tiro egitean edo false bestela
	 * @param x: x koordenatua
	 * @param y: y koordenatua
	 * @return
	 */
	public boolean ukituDuItsasontzia(int x, int y) {
		if(Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) return true;
		else return false;
	}
	//********************************** TIROA *******************************************************
	
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
				if (ontziOsoaUkituDu(x,y)){ 
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
	public void gelaxkaUkitutaIpini(int x, int y) {
		if(ukituDuItsasontzia(x,y)) {
			setChanged();
			notifyObservers(new int[] {x,y,1});
		}else {
			setChanged();
			notifyObservers(new int[] {x,y,0});
		}
		Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
		JokNormal.getNireJok().ukituak.gelaxkaUkituaIpini(x, y);
	}
	
	public void gelaxkaUrperatu(int x, int y) {
		setChanged();
		notifyObservers(new int[] {x,y,2});
		Bot.getNireBot().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
		JokNormal.getNireJok().ukituak.gelaxkaUrperatutaIpini(x, y);
	}
	//********************************** MISIL TIROA *******************************************************
	public void misilTiroa( int x, int y) {	
		if(ukituDuItsasontzia(x,y)) {
			gelaxkaUrperatu(x,y);
			if (x>0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x-1, y) ) { 
				this.ezkerrekoakUrperatu( x-1, y); 	
			}
			if (x<9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x+1, y)) {
				this.eskumakoakUrperatu( x+1, y);	
			}
						
			if (y>0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y-1)) {
				this.goikoakUrperatu( x, y-1);	
			}
			if (y<9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y+1)) {
				this.behekoakUrperatu( x, y+1);
			}
		}else {
			setChanged();
			notifyObservers(new int[] {x,y,0});
			Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
			this.ukituak.gelaxkaUkituaIpini(x,y);
		}
		//misil kantitatea eguneratu:
		int kop = armaKantitateaEguneratu(new Misil());
		setChanged();
		notifyObservers(new int[] {0,kop}); 
	}
	
	private void goikoakUrperatu ( int x, int y) {
		while (y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y);
			y--;
		}
	}
	private void behekoakUrperatu ( int x, int y) {
		while (y<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y);
			y++;
		}
	}
	private void ezkerrekoakUrperatu ( int x, int y) {
		while (x>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y);
			x--;
		}
	}
	
	private void eskumakoakUrperatu ( int x, int y) {
		while (x<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y);
			x++;
		}
	}
	
	
	public void ontziaUrperatu(int x, int y) {
		gelaxkaUrperatu(x,y);
		if (x>0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x-1, y) ) { 
			this.ezkerrekoakUrperatu( x-1, y); 	
		}
		if (x<9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x+1, y)) {
			this.eskumakoakUrperatu( x+1, y);	
		}
					
		if (y>0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y-1)) {
			this.goikoakUrperatu( x, y-1);	
		}
		if (y<9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y+1)) {
			this.behekoakUrperatu( x, y+1);
		}
	}
	//********************************* EZKUTUA **************************************************
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
	//************************** EROSKETAK **************************************************
	public void armamentuaErosi() {}
	public void ontziaKonpondu() {}
	protected boolean tiroaOndoEginDu() {
		
		return true;
	}
	

}
