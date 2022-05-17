package eredua;

import java.util.Observable;
import java.util.*;

public abstract class Jokalari extends Observable{
	protected Flota baliabideak;
	protected Tablero nireItsasontziak;
	protected boolean [][]  ukituak;
	
	public Jokalari () {
		baliabideak = new Flota();
		ukituak = new boolean[10][10]; //falsen daude
		nireItsasontziak= new Tablero();
	}
	
	/**
	 * (x,y) posizioan dagoen ontzia konpontzeko erabiltzen da
	 * @param x koordenatua
	 * @param y koordenatua
	 */
	protected abstract void ontziaKonpondu(int x, int y);
	
	/**
	 * 
	 * @return true urperatu gabeko ontziak geratzen badira eta false bestela
	 */
	public boolean ontzirenBatGeratzenDa() {return nireItsasontziak.ontzirenBatGeratzenDa();}
	
	public void ontziaUrperatzeanDirua(int pDirua) {
		baliabideak.suntziketaPrezioaGehitu(pDirua);
	}
	
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
	
	public void gelaxkaUkituaJarri(int x, int y) {
		this.ukituak[x][y] = true;
	}
	
	public boolean itsasontziaDaukat(int x,int y) {
		return this.nireItsasontziak.itsasontziaDuGelaxka(x, y);
	}
	
	//************************** ITSASONTZIAK KOKATU**************************************************
	
	public void ontziaKokatu(int pX, int pY, boolean pHorizontal, int pLuz) {
		nireItsasontziak.ontziaKokatu(pX, pY, pHorizontal, pLuz);
	}
	public boolean ontziaKokatuAhalDa(int pX, int pY, boolean pHorizontal, int pLuz) {
		return nireItsasontziak.ontziaKokatuAhalDa(pX, pY, pHorizontal, pLuz);
	}
}
