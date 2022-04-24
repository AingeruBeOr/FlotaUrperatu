package eredua;

import java.util.Observable;
import java.util.*;

public abstract class Jokalari extends Observable{
	protected int dirua;
	protected ArmamentuZerrenda armak;
	protected Tablero nireItsasontziak;
	protected Tablero ukituak;
	
	public Jokalari () {
		dirua=1000;
		armak = new ArmamentuZerrenda(2,1,2); //2 misil, 1 radar eta 2 ezkutu
		//TODO
		ukituak=new Tablero();
		nireItsasontziak= new Tablero();
		//matrizeUkitu=new boolean[10][10];
		//matrizeOntzi=new boolean[10][10];
		/*for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				matrizeUkitu[i][j]=false;
			}
		}*/
	}
	
	protected abstract void txandaJokatu();
	protected abstract boolean tiroaOndoEginDu();
	protected abstract void armamentuaErosi();
	protected abstract void ontziaKonpondu();
	
	public boolean ontzirenBatGeratzenDa() {return nireItsasontziak.ontzirenBatGeratzenDa();}
	
	/**
	 * Parametro bezala adierazitako arma motaren kantitatea -1 txikituko du
	 * @param arma eguneratuko duen arma mota
	 * @return arma mota horreatako zenbat unitate geratzen zaizkion
	 */
	public int armaKantitateaEguneratu(Arma arma) {return armak.armaKantitateaEguneratu(arma);}
	
	/**
	 * Parametro bezala pasatzen zaion arma kantitatea itzuliko du
	 * @param arma ezagutu nahi den arma motaren unitate kopurua
	 * @return 
	 */
	public int getArmaKop(Arma arma) {return armak.getArmaKop(arma);}
	
	public int getDirua() {return this.dirua;}
	
	//************************************ UKITUAK ZEHAZTEKO ***********************************************
	
	/**
	 * true bueltatuko du jadanik bertan jo badu edo false bestela
	 * @param x: x koordenatua
	 * @param y: y koordenatua
	 * @return 
	 */
	public boolean ukitutaZegoen(int x, int y) {
		return ukituak.ukitutaEdoUrperatutaZegoen(x, y);
	}
	
	public boolean itsasontziaDaukat(int x,int y) {
		return this.nireItsasontziak.itsasontziaDuGelaxka(x, y);
	}
	
	/**
	 * true bueltatuko du adieraztiako posizioan itsasontzi bat ukitu badu tiro egitean edo false bestela
	 * @param x: x koordenatua
	 * @param y: y koordenatua
	 * @return
	 */
	public boolean ukituDuItsasontzia(int x, int y) {
		FlotaUrperatu fu =FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			if(JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) return true;
			else return false;
		}else {
			if(Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) return true;
			else return false;
		}
	}
	
	
	
	/*public void gelaxkaUrperatu(int x, int y) {
		FlotaUrperatu fu =FlotaUrperatu.getNireFlotaUrperatu();
		setChanged();
		notifyObservers(new int[] {x,y,2});
		if(!fu.getTxanda()) {
			JokNormal.getNireJok().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
			Bot.getNireBot().ukituak.gelaxkaUrperatutaIpini(x, y);
		}else {
			Bot.getNireBot().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
			JokNormal.getNireJok().ukituak.gelaxkaUrperatutaIpini(x, y);
		}
	}*/
	
	/*public void gelaxkaUkitutaIpini(int x, int y) {
		FlotaUrperatu fu =FlotaUrperatu.getNireFlotaUrperatu();
		if(ukituDuItsasontzia(x,y)) {
			setChanged();
			notifyObservers(new int[] {x,y,1});
		}else {
			setChanged();
			notifyObservers(new int[] {x,y,0});
		}
		if(!fu.getTxanda()) {
			JokNormal.getNireJok().nireItsasontziak.gelaxkaUkituaIpini(x, y);
			Bot.getNireBot().ukituak.gelaxkaUkituaIpini(x, y);
		}else {
			Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
			JokNormal.getNireJok().ukituak.gelaxkaUkituaIpini(x, y);
		}
	}*/
	
	
	// **************************************** MISIL TIROA IZATEKOTAN *******************************************
	
	/*public void misilTiroa( int x, int y) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		
		if(ukituDuItsasontzia(x,y)) {
			gelaxkaUrperatu(x,y);
			System.out.println("Misilak itsasontzia aurkitu du");
			if(!fu.getTxanda()) {
				if (x>0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x-1, y) ) { 
					this.ezkerrekoakUrperatu( x-1, y); 	
				}
				if (x<9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x+1, y)) {
					this.eskumakoakUrperatu( x+1, y);	
				}
							
				if (y>0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y-1)) {
					this.goikoakUrperatu( x, y-1);	
				}
				if (y<9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y+1)) {
					this.behekoakUrperatu( x, y+1);
				}
			}else {
				
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
		}else {
			setChanged();
			notifyObservers(new int[] {x,y,0});
			if(!fu.getTxanda()) {
				JokNormal.getNireJok().nireItsasontziak.gelaxkaUkituaIpini(x, y);
			}else {
				Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
			}
			this.ukituak.gelaxkaUkituaIpini(x,y);
		}
		//misil kantitatea eguneratu:
		int kop = armaKantitateaEguneratu(new Misil());
		setChanged();
		notifyObservers(new int[] {0,kop}); 
	}
	
	private void goikoakUrperatu ( int x, int y) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				y--;
			}
		}else {
			while (y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				y--;
			}
		}
	}
	private void behekoakUrperatu ( int x, int y) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (y<=9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				y++;
			}
		}else {
			while (y<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				y++;
			}
		}
	}
	private void ezkerrekoakUrperatu ( int x, int y) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (x>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				x--;
			}
		}else {
			while (x>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				x--;
			}
		}
	}
	
	private void eskumakoakUrperatu ( int x, int y) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (x<=9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				x++;
			}
		}else {
			while (x<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				x++;
			}
		}
	}
	
	
	public void ontziaUrperatu(int x, int y) {
		gelaxkaUrperatu(x,y);
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			if (x>0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x-1, y) ) { 
				this.ezkerrekoakUrperatu( x-1, y); 	
			}
			if (x<9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x+1, y)) {
				this.eskumakoakUrperatu( x+1, y);	
			}
						
			if (y>0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y-1)) {
				this.goikoakUrperatu( x, y-1);	
			}
			if (y<9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y+1)) {
				this.behekoakUrperatu( x, y+1);
			}
		}else {
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
	}*/
	
	/**
	 * (x,y) posizioan dagoen ontzi osoa ukituta dagoen ala ez adierziko du
	 * @param x
	 * @param y
	 * @return true (x,y) posizioan dagoen itsasontzia ondoratuta badago
	 */
	/*public boolean ontziOsoaUkituDu(int x, int y) {
		boolean urperatuta=false;
		boolean goikoak=false;
		boolean behekoak=false;
		boolean ezkerrekoak=false;
		boolean eskumakoak=false;
		
		/*pruebaaa de que las casillas se ukituan como tiene k ser
		for (int i=0; i<=9;i++) {
			for (int j=0; j<=9;j++) {
				System.out.println("JOKALARIA:");
				System.out.println(i+ " "+ j+" " +Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(i, j));
				System.out.println(i+ " "+ j+" " +JokNormal.getNireJok().ukituak.ukitutaEdoUrperatutaZegoen(i, j));
				System.out.println("BOT:");
				System.out.println(i+ " "+ j+" " +JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(i, j));
				System.out.println(i+ " "+ j+" " +Bot.getNireBot().ukituak.ukitutaEdoUrperatutaZegoen(i, j));
			}
		}
		
		*/
		

		/*if(ukituDuItsasontzia(x,y)) {
			FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
			if(!fu.getTxanda()) {
				if (x>0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x-1, y) ) { 
					ezkerrekoak=this.ezkerrekoakAztertu( x-1, y); 	
				}
				if (x<9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x+1, y)) {
					eskumakoak=this.eskumakoakAztertu( x+1, y);	
				}
							
				if (y>0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y-1)) {
					goikoak=this.goikoakAztertu( x, y-1);	
				}
				
				if (y<9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y+1)) {
					behekoak=this.behekoakAztertu( x, y+1);
				}	
			}else {
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
	 *  true urperatuta ez dagoen gelaxka aurkitzen badu
	 * @param x
	 * @param y
	 * @return 
	 */
	/*private boolean goikoakAztertu(int x, int y) { 
		boolean aurkitua=false;
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (!aurkitua && y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
				if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				y--;
			}	
		}else {
			while (!aurkitua && y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				if (!Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				y--;
			}
		}
		return aurkitua;
	}
	
	private boolean behekoakAztertu(int x, int y) {
		boolean aurkitua=false;
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (!aurkitua && y<=9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
				if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				y++;
			}	
		}else {
			while (!aurkitua && y<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				if (!Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				y++;
			}
		}
		return aurkitua;
	}
	
	private boolean ezkerrekoakAztertu(int x, int y) {
		boolean aurkitua=false;
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (!aurkitua && x>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
				if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				x--;
			}	
		}else {
			while (!aurkitua && x>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				if (!Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				x--;
			}
		}
		return aurkitua;
	}
	
	private boolean eskumakoakAztertu(int x, int y) {
		boolean aurkitua=false;
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (!aurkitua && y<=9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
				if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				x++;
			}	
		}else {
			while (!aurkitua && y<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				if (!Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				x++;
			}
		}
		return aurkitua;
	}*/
	
	
	
	
	//******************************* RADARRA **************************************************************************
	/*
	public void radarraKontsultatu(int x, int y) {
		boolean aurkituDu=false;
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			for(int i=x-1; i<=x+1; i++) {
				for(int j=y-1; j<=y+1; j++) {
					if(i>=0 && i<=9 && j>=0 && j<=9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(i, j) && !JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(i, j)) {
						setChanged();
						notifyObservers(new int[] {i,j,4});
						aurkituDu=true;	
					}
				}
			}
		}
		else {
			for(int i=x-1; i<=x+1; i++) {
				for(int j=y-1; j<=y+1; j++) {
					if(i>=0 && i<=9 && j>=0 && j<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(i, j) && !Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(i, j)) {
						setChanged();
						notifyObservers(new int[] {i,j,4});
						aurkituDu=true;	
					}
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
	*/
	
	
	
	
	//************************** EZKUTUA **********************************************************************************
	
	/**
	 * Adierazitako (x,y) posizioan dagoen itsasontzia k aldiz txikituko da bere bizitza.
	 * @param x koordenatua
	 * @param y koordenatua
	 * @param k ezkutua txikituko den balio kopurua
	 */
	public abstract void ezkutuaXTxikitu(int x, int y, int k);
	
	/**
	 * (x,y) posizioan level motako ezkutua jarriko da.
	 * @param x koordenatua
	 * @param y koordenatua
	 * @param level ezktuari jarriko zaion bizitza
	 */
	public void ezkutuaIpini(int x,int y) {
		int hX=x;
		int hY=y;
		while(y>=0 && nireItsasontziak.itsasontziaDuGelaxka(x, y)) { //gorantz begiratu
			this.nireItsasontziak.setEzkutua(x, y, 2);
			setChanged();
			notifyObservers(new int[] {x,y,7});
			y--;
		}
		y=hY+1;
		while (y<=9 && nireItsasontziak.itsasontziaDuGelaxka(x, y)) { //beherantz begiratu
			this.nireItsasontziak.setEzkutua(x, y, 2);
			setChanged();
			notifyObservers(new int[] {x,y,7});
			y++;
		}
		y=hY;
		while (x>=0 && nireItsasontziak.itsasontziaDuGelaxka(x, y)) { //ezkerrerantz begiratu
			this.nireItsasontziak.setEzkutua(x, y, 2);
			setChanged();
			notifyObservers(new int[] {x,y,7});
			x--;
		}
		x=hX+1;
		while (x<=9 && nireItsasontziak.itsasontziaDuGelaxka(x, y)) { //eskuinerantz begiratu
			this.nireItsasontziak.setEzkutua(x, y, 2);
			setChanged();
			notifyObservers(new int[] {x,y,7});
			x++;
		}
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return true bueltatuko du (x,y) posizioan ezkutu bat badago
	 */
	public boolean ezkutuaDago(int x, int y) {
		return this.nireItsasontziak.ezkutuaDago(x, y);
	}
	
	//TODO BESTE
	
	/*public Arma getArma(Arma arma) {
		return this.armak.getArma(arma);
	}*/
	
	/*protected void armamentuaHasieratu() {
		Misil a = new Misil();
		armak.gehituOrdenatua(a);
	}*/
}
