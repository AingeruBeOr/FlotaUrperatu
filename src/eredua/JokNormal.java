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
	
	/**
	 * (x,y) posizioan dagoen itsasontzia urperatuta dagoen ala ez konprobatuko da.
	 * @param x koordenatua
	 * @param y koordenatua
	 * @return true itsasontzia urperatuta badago eta false bestela.
	 */
	public boolean ontziOsoaUkituDu(int x, int y) {
		boolean urperatuta=false;
		boolean goikoak=false;
		boolean behekoak=false;
		boolean ezkerrekoak=false;
		boolean eskumakoak=false;

		if(ukituDuItsasontzia(x,y)) {
			
			if (x>0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x-1, y) ) { 
				ezkerrekoak=this.ezkerrekoakAztertu( x-1, y); 	
			}
			
			if (x<9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x+1, y)) {
				eskumakoak=this.eskumakoakAztertu( x+1, y);	
			}
						
			if (y>0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y-1)) {
				goikoak=this.goikoakAztertu( x, y-1);	
			}
			
			if (y<9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y+1)) {
				behekoak=this.behekoakAztertu( x, y+1);
			}
			
			if (!ezkerrekoak && !eskumakoak && !goikoak && !behekoak) { //guztiak ukituta daudenean, (ez duzu ez ukiturik aurkitu) orduan itsasontzia urperatuta dago
				urperatuta=true;
			}
			if (urperatuta) {
				setChanged();
				notifyObservers(new int[] {x,y,5});
			}			
		}
		return urperatuta;
	}
	
	/**
	 * (x,y) posiziotik gora, itsasontzia duten gelaxkak badadude, hauek ukituta dauden ala ez aztertuko du. 
	 * @param x koordenatua
	 * @param y koordenatua
	 * @return true ukituta ez dagoen gelaxka aurkitzen badu edo false bestela.
	 */
	private boolean goikoakAztertu(int x, int y) { 
		boolean aurkitua=false;
		while (!aurkitua && y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			if (!Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
				aurkitua=true;
			}
			y--;
		}
		return aurkitua;
	}
	
	/**
	 * (x,y) posiziotik behera, itsasontzia duten gelaxkak badadude, hauek ukituta dauden ala ez aztertuko du. 
	 * @param x koordenatua
	 * @param y koordenatua
	 * @return true ukituta ez dagoen gelaxka aurkitzen badu edo false bestela.
	 */
	private boolean behekoakAztertu(int x, int y) {
		boolean aurkitua=false;
		while (!aurkitua && y<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			if (!Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
				aurkitua=true;
			}
			y++;
		}
		return aurkitua;
	}
	
	/**
	 * (x,y) posiziotik ezkerrera, itsasontzia duten gelaxkak badadude, hauek ukituta dauden ala ez aztertuko du. 
	 * @param x koordenatua
	 * @param y koordenatua
	 * @return true ukituta ez dagoen gelaxka aurkitzen badu edo false bestela.
	 */
	private boolean ezkerrekoakAztertu(int x, int y) {
		boolean aurkitua=false;
		while (!aurkitua && x>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			if (!Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
				aurkitua=true;
			}
			x--;
		}
		return aurkitua;
	}
	
	/**
	 * (x,y) posiziotik eskuinera, itsasontzia duten gelaxkak badadude, hauek ukituta dauden ala ez aztertuko du. 
	 * @param x koordenatua
	 * @param y koordenatua
	 * @return true ukituta ez dagoen gelaxka aurkitzen badu edo false bestela.
	 */
	private boolean eskumakoakAztertu(int x, int y) {
		boolean aurkitua=false;
		while (!aurkitua && y<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			if (!Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
				aurkitua=true;
			}
			x++;
		}
		return aurkitua;
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
			gelaxkaUkitutaIpini(x, y);
			if (ontziOsoaUkituDu(x,y)){ 
				ontziaUrperatu(x,y);
			}
		}else if (pArma == 1){ 
			misilTiroa(x,y);
		}else if (pArma == 2) {
			radarraKontsultatu(x,y);
		}	
	}
	
	public void gelaxkaUkitutaIpini(int x, int y) {
		if(Bot.getNireBot().ezkutuaDago(x, y)) {
			Bot.getNireBot().ezkutuaXTxikitu(x, y, 1);;
		}else {
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
	}
	
	public void gelaxkaUrperatu(int x, int y) {
		setChanged();
		notifyObservers(new int[] {x,y,2});
		Bot.getNireBot().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
		JokNormal.getNireJok().ukituak.gelaxkaUrperatutaIpini(x, y);
	}
	//********************************** MISIL TIROA *******************************************************
	public void misilTiroa( int x, int y) {	
		if(Bot.getNireBot().ezkutuaDago(x, y)) {
			Bot.getNireBot().ezkutuaXTxikitu(x, y, 2);;
		}else {
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
	
	
	
	
	//****************************************ONTZI OSOA URPERATU*****************************************************
	
	
	
	//******************************* RADARRA **************************************************************************
	
	public void radarraKontsultatu(int x, int y) {
		boolean aurkituDu=false;
		for(int i=x-1; i<=x+1; i++) {
			for(int j=y-1; j<=y+1; j++) {
				if(i>=0 && i<=9 && j>=0 && j<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(i, j) && !Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(i, j)) {
					setChanged();
					notifyObservers(new int[] {i,j,4});
					aurkituDu=true;	
				}
			}
		}
		if (!aurkituDu) {
			setChanged();
			notifyObservers(new int[] {x,y,6});
		}
		//radar kantitatea eguneratu:
		int kop = armaKantitateaEguneratu(new Radarra());
		setChanged();
		notifyObservers(new int[] {1,kop});
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
