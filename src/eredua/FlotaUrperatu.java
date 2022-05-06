package eredua;
import java.awt.Color;
import java.util.Observable;

import bista.Irabazlea;
import bista.Tablero;
import java.util.*;
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
	public boolean getTxanda() {return this.txanda;}
	public void aldatuTxanda() {
		txanda=!txanda;
		setChanged();
		notifyObservers(null);
		if(jokoaAmaituDa()) {
			Irabazlea.main(null);
			//Tableroa kendu:
			setChanged();
			notifyObservers(new int[] {0});
		}
		else if(!txanda){
			Bot.getNireBot().txandaJokatu();
		}
		
	}
	
	public void botTxanda() { 
		Bot.getNireBot().txandaJokatu();
	}
	

	public boolean jokoaAmaituDa() {
		return !ontzirenBatGeratzenDa();
	}
	
	private boolean ontzirenBatGeratzenDa() {
		return (Bot.getNireBot().ontzirenBatGeratzenDa() && 
				JokNormal.getNireJok().ontzirenBatGeratzenDa());
	}
	
}