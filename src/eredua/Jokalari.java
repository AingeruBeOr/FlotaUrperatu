package eredua;

import java.util.Observable;
import java.util.*;

public abstract class Jokalari extends Observable{
	//protected int dirua;
	//private ArmamentuZerrenda armak;
	protected Flota baliabideak;
	protected Tablero nireItsasontziak;
	protected boolean [][]  ukituak;
	
	public Jokalari () {
		//dirua=1000;
		//armak = new ArmamentuZerrenda();
		baliabideak=new Flota();
		ukituak=new boolean[10][10]; //falsen daude
		nireItsasontziak= new Tablero();
	}
	
	
	protected abstract void ontziaKonpondu(int x, int y);
	
	public boolean ontzirenBatGeratzenDa() {return nireItsasontziak.ontzirenBatGeratzenDa();}
	
	/**
	 * Parametro bezala adierazitako arma motaren kantitatea -1 txikituko du
	 * @param arma eguneratuko duen arma mota
	 * @return arma mota horreatako zenbat unitate geratzen zaizkion
	 */
	
	//public int armaKantitateaEguneratu(Arma arma) {return armak.armaKantitateaEguneratu(arma);}
	
	/**
	 * Parametro bezala pasatzen zaion arma kantitatea itzuliko du
	 * @param arma ezagutu nahi den arma motaren unitate kopurua
	 * @return 
	 */
	
	public int getArmaKop(Arma arma) {return baliabideak.getArmaKop(arma);}
	
	/**
	 * Armamentua erostean, arma kantitatea eguneratu behar da.
	 * @param pArma eguneratuko den arma mota
	 * @param pKop erositako arma kopurua
	 */
	public void armamentuaErosi(Arma pArma, int pKop) {
		baliabideak.armamentuaErosi(pArma, pKop);
	}
	
	/**
	 * Jokalariaren dirua bueltatzen du
	 * @return
	 */
	public int getDirua() {return baliabideak.getDirua();}
	
	/**
	 * Jokalariraren dirua eguneratzen du
	 * @param pDiru geratuko den ditu kantitate berria
	 */
	public void setDirua(int pDiru) {baliabideak.setDirua(pDiru);}
	
	//************************************ UKITUAK ZEHAZTEKO ***********************************************
	
	/**
	 * true bueltatuko du jadanik bertan jo badu edo false bestela
	 * @param x x koordenatua
	 * @param y y koordenatua
	 * @return 
	 */
	public boolean ukitutaZegoen(int x, int y) {
		return ukituak[x][y];
	}
	
	public boolean itsasontziaDaukat(int x,int y) {
		return this.nireItsasontziak.itsasontziaDuGelaxka(x, y);
	}
	
	/**
	 * true bueltatuko du adieraztiako posizioan itsasontzi bat ukitu badu tiro egitean edo false bestela
	 * @param x x koordenatua
	 * @param y y koordenatua
	 * @return
	 */
	//public abstract boolean ukituDuItsasontzia(int x, int y);
	
	//************************** ITSASONTZIAK KOKATU**************************************************
	
	public void ontziaKokatu(int pX, int pY, boolean pHorizontal, int pLuz) {
		nireItsasontziak.ontziaKokatu(pX, pY, pHorizontal, pLuz);
	}
	public boolean ontziaKokatuAhalDa(int pX, int pY, boolean pHorizontal, int pLuz) {
		return nireItsasontziak.ontziaKokatuAhalDa(pX, pY, pHorizontal, pLuz);
	}
	
	//************************** RADARRA **********************************************************************************
	//protected abstract void radarraKontsultatu(int x, int y);
	
	//************************** EZKUTUA **********************************************************************************
	
	/**
	 * Adierazitako (x,y) posizioan dagoen itsasontzia k aldiz txikituko da bere bizitza.
	 * @param x koordenatua
	 * @param y koordenatua
	 * @param k ezkutua txikituko den balio kopurua
	 */
	//public abstract void ezkutuaXTxikitu(int x, int y, int k);
	
	/**
	 * (x,y) posizioan level motako ezkutua jarriko da.
	 * @param x koordenatua
	 * @param y koordenatua
	 * @param level ezktuari jarriko zaion bizitza
	/*public void ezkutuaIpini(int x,int y) {
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
}
