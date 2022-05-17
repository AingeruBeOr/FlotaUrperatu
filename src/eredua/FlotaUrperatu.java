package eredua;
import java.awt.Color;
import java.util.Observable;

import bista.Irabazlea;
import bista.Tablero;

public class FlotaUrperatu extends Observable{
	private static FlotaUrperatu nireFlota;
	private boolean txanda; //True bada Jokalaria jolasten ari da, bestela bota
	
	private FlotaUrperatu() {
		txanda=true;
	}
	
	public static FlotaUrperatu getNireFlotaUrperatu() {
		if (nireFlota==null) {
			nireFlota=new FlotaUrperatu();
		}
		return nireFlota;
	}
	
	public void bistanEkintzaBurutu(int pArma, int pKop) {
		setChanged();
		notifyObservers(new int[] {pArma, pKop});
	}
	public void bistanEkintzaBurutu(int x, int y, int pCase) {
		setChanged();
		notifyObservers(new int[] {x, y, pCase});
	}
	public void bistanEkintzaBurutu(int x, int y, int pCase, int level) {
		setChanged();
		notifyObservers(new int[] {x, y, pCase, level});
	}
	public void bistanEkintzaBurutu(int x, int y, int pCase, int level, int lehena) {
		setChanged();
		notifyObservers(new int[] {x, y, pCase, level, lehena});
	}
	/**
	 * 
	 * @return
	 */
	public boolean getTxanda() {return this.txanda;}
	
	/**
	 * 
	 */
	public void aldatuTxanda() {
		if(jokoaAmaituDa()) {
			Irabazlea.main(null);
			//Tableroa kendu:
			setChanged();
			notifyObservers(new int[] {0});
		}
		else {
			txanda=!txanda;
			setChanged();
			notifyObservers(null);
			if(txanda) System.out.println("\n\n************ Jokalariaren txanda ****************");
			else {
				System.out.println("\n\n************ BOT-aren txanda ****************");
				Bot.getNireBot().txandaJokatu();
			}
		}		
	}
	
	/**
	 * 
	 * @return true jokoa amaitu bada
	 */
	private boolean jokoaAmaituDa() {
		return !(Bot.getNireBot().ontzirenBatGeratzenDa() && 
				JokNormal.getNireJok().ontzirenBatGeratzenDa());
	}
	
}