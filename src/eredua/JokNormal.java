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
	
	
	/*
	 * Tablerotik adierazitako arma erabiltzen saiatuko da, lortzekotan txanda aldatu egingo da,
	 * eta arma kopurua eguneratuko du bere baliabideetan, bestela tableroari (beste metodo 
	 * batean) observable bidez jakinaraziko dio ezin dela arma bertan erabili eta txanda 
	 * mantenduko da.
	 * Arma mota beti izango du, bestela tablero bistan ezingo zelako klikatu
	 * */
	public void txandaJokatu(int x, int y, Arma pArma) {
		boolean erabiliDa;
		if(pArma instanceof Ezkutua) {
			erabiliDa=pArma.erabili(x, y, this.nireItsasontziak);
		}else {
			erabiliDa=pArma.erabili(x, y, Bot.getNireBot().nireItsasontziak); //BOOLEAN HORI ESANGO DU EA ARMA ERABILI DEN ALA EZ
			if((pArma instanceof Bonba || pArma instanceof Misil) && erabiliDa) {
				FlotaUrperatu.getNireFlotaUrperatu().aldatuTxanda();
			}
		}
		if(erabiliDa) {
			int kop = this.baliabideak.armaKantitateaEguneratu(pArma);
			int arma=0;
			if (pArma instanceof Radarra) arma=1;
			else if(pArma instanceof Ezkutua) arma=2;
			setChanged();
			notifyObservers(new int[] {arma,kop}); 
		}
	}
	
	
	
	//************************** ITSASONTZIAK KOKATU**************************************************
	//TODO, esta comentado porque lo he puesto en super porque es común
	/*public void ontziaKokatu(int pX, int pY, boolean pHorizontal, int pLuz) {
		nireItsasontziak.ontziaKokatu(pX, pY, pHorizontal, pLuz);
	}
	public boolean ontziaKokatuAhalDa(int pX, int pY, boolean pHorizontal, int pLuz) {
		return nireItsasontziak.ontziaKokatuAhalDa(pX, pY, pHorizontal, pLuz);
	}*/
	
	
	
	
	
	//********************************** UKITUAK *******************************************************
	
	@Override
	/*public boolean ukituDuItsasontzia(int x, int y) {
		if(Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) return true;
		else return false;
	}
	
	/**
	 * (x,y) posizioan dagoen itsasontzia urperatuta dagoen ala ez konprobatuko da.
	 * @param x koordenatua
	 * @param y koordenatua
	 * @return true itsasontzia urperatuta badago eta false bestela.
	 */
	/*public boolean ontziOsoaUkituDu(int x, int y) {
		boolean urperatuta=false;
		boolean goikoak=false;
		boolean behekoak=false;
		boolean ezkerrekoak=false;
		boolean eskumakoak=false;

		
			
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
		
		return urperatuta;
	}*/
	
	/**
	 * (x,y) posiziotik gora, itsasontzia duten gelaxkak badadude, hauek ukituta dauden ala ez aztertuko du. 
	 * @param x koordenatua
	 * @param y koordenatua
	 * @return true ukituta ez dagoen gelaxka aurkitzen badu edo false bestela.
	 */
	/*private boolean goikoakAztertu(int x, int y) { 
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
	/*private boolean behekoakAztertu(int x, int y) {
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
	/*private boolean ezkerrekoakAztertu(int x, int y) {
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
	/*private boolean eskumakoakAztertu(int x, int y) {
		boolean aurkitua=false;
		while (!aurkitua && x<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
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
	
	/*public void tiroEgin(int x, int y,int pArma) {
		if (pArma == 0) bonbaTiroa(x, y);
		else if (pArma == 1) misilTiroa(x,y);
		else if (pArma == 2) radarraKontsultatu(x,y);
		FlotaUrperatu.getNireFlotaUrperatu().aldatuTxanda();
	}
	
	/*private void bonbaTiroa(int x, int y) {
		if(Bot.getNireBot().ezkutuaDago(x, y)) Bot.getNireBot().ezkutuaXTxikitu(x, y, 1);
		else {
			if(ukituDuItsasontzia(x,y)) {
				if (ontziOsoaUkituDu(x,y)) ontziaUrperatu(x,y);
				else {
					setChanged();
					notifyObservers(new int[] {x,y,1});
				}
			}else {
				setChanged();
				notifyObservers(new int[] {x,y,0});
			}
			Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
			ukituak[x][y]=true; //JokNormal.getNireJok().ukituak.gelaxkaUkituaIpini(x, y);
		}
	}
	
	public void gelaxkaUrperatu(int x, int y) {
		setChanged();
		notifyObservers(new int[] {x,y,2});
		Bot.getNireBot().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
		ukituak[x][y]=true; //JokNormal.getNireJok().ukituak.gelaxkaUrperatutaIpini(x, y);
	}
	
	
	
	
	
	
	
	
	
	
	//********************************** MISIL TIROA *******************************************************
	private void misilTiroa( int x, int y) {	
		if(Bot.getNireBot().ezkutuaDago(x, y)) Bot.getNireBot().ezkutuaXTxikitu(x, y, 2);
		else if(ukituDuItsasontzia(x,y)) ontziaUrperatu(x, y);
			else {
				setChanged();
				notifyObservers(new int[] {x,y,0});
				Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
				ukituak[x][y]=true; //this.ukituak.gelaxkaUkituaIpini(x,y);
			}	
		//misil kantitatea eguneratu:
		int kop = this.baliabideak.armaKantitateaEguneratu(new Misil());
		setChanged();
		notifyObservers(new int[] {0,kop}); 
	}
	

	
	
	
	
	
	
	
	//****************************************ONTZI OSOA URPERATU*****************************************************
	
	
	private void ontziaUrperatu(int x, int y) {
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
	
	
	
	
	
	
	
	
	//******************************* RADARRA **************************************************************************
	
	public void radarraKontsultatu(int x, int y) {
		boolean aurkituDu=false;
		for(int i=x-1; i<=x+1; i++) {
			for(int j=y-1; j<=y+1; j++) {
				if(i>=0 && i<=9 && j>=0 && j<=9 ) {
					if (Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(i, j) && !Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(i, j)){
						setChanged();
						notifyObservers(new int[] {i,j,4});
						aurkituDu=true;
					}
					else if(!Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(i, j)) {
						setChanged();
						notifyObservers(new int[] {i,j,0});
						Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(i, j);
						ukituak[x][y]=true; //this.ukituak.gelaxkaUkituaIpini(i, j);
					}
						
				}
			}
		}
		if (!aurkituDu) {
			setChanged();
			notifyObservers(new int[] {x,y,6});
		}
		//radar kantitatea eguneratu:
		int kop = this.baliabideak.armaKantitateaEguneratu(new Radarra());
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
	/*public void ezkutuaJarri(int x, int y) {
		
		if(super.itsasontziaDaukat(x, y)) {
			if(!super.ezkutuaDago(x, y)) {
				if(!nireItsasontziak.urperatutaDago(x, y)) { //!super.ontziOsoaUrperatuDu(x, y)
					super.ezkutuaIpini(x, y);
					
					//ezkutu kantitatea eguneratu:
					int kop = this.baliabideak.armaKantitateaEguneratu(new Ezkutua());
					setChanged();
					notifyObservers(new int[] {2,kop}); 
					FlotaUrperatu.getNireFlotaUrperatu().aldatuTxanda();
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
	
	
	@Override
	public void ezkutuaXTxikitu(int x, int y, int k) {
		int hX=x;
		int hY=y;
		while(y>=0 && nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			int level=this.nireItsasontziak.ezkutuaXTxikitu(x,y, k);
			setChanged();
			notifyObservers(new int[] {x, y, 3, level});
			y--;
		}
		y=hY+1;
		while (y<=9 && nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			int level=this.nireItsasontziak.ezkutuaXTxikitu(x,y, k);
			setChanged();
			notifyObservers(new int[] {x, y, 3, level});
			y++;
		}
		y=hY;
		x=hX-1;
		while (x>=0 && nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			int level=this.nireItsasontziak.ezkutuaXTxikitu(x,y, k);
			setChanged();
			notifyObservers(new int[] {x,y,3, level});
			x--;
		}
		x=hX+1;
		while (x<=9 && nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			int level=this.nireItsasontziak.ezkutuaXTxikitu(x,y, k);
			setChanged();
			notifyObservers(new int[] {x,y,3, level});
			x++;
		}
	}*/
	
	
	
	//************************** KONPONKETAK **************************************************
		public void ontziaKonpondu(int x, int y) {
			System.out.println(x+"<--X, "+y+"<--Y");
			if(!nireItsasontziak.urperatutaDago(x,y) && nireItsasontziak.itsasontziaDuGelaxka(x, y) && nireItsasontziak.ukitutaDago(x, y)) {
				nireItsasontziak.gelaxkaKonpondu(x, y);
				baliabideak.erosketaPrezioaKendu(); 
				setChanged();
				notifyObservers(new int[] {x,y,11,0});
			}
			else{
				setChanged();
				notifyObservers(new int[] {x,y,12}); //System.out.println("Ezin duzu gelaxka hori konpondu");
			}
			
		}
	


}
