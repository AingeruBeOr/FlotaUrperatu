package eredua;
import java.awt.Color;
import java.util.Observable;

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
	
	public boolean getTxanda() {return this.txanda;}
	public void aldatuTxanda() {
		txanda=!txanda;
		setChanged();
		notifyObservers(null);
	}
	
	public void botTxanda() { 
		Bot.getNireBot().txandaJokatu();
	}
	

	public boolean jokoaAmaituDa() {
		boolean amaitu=false;
		if (!ontzirenBatGeratzenDa()) { 	
			amaitu=true;
		}
		return amaitu;
	}
	
	private boolean ontzirenBatGeratzenDa() {
		return (Bot.getNireBot().ontzirenBatGeratzenDa() && 
				JokNormal.getNireJok().ontzirenBatGeratzenDa());
	}
	
}