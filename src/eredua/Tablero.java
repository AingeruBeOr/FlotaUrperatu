package eredua;

import java.util.Observable;
import java.util.Arrays;
import java.util.*;

public class Tablero extends Observable{
	private Gelaxka[][] tablero;
	
	public Tablero() {
		tablero=new Gelaxka[10][10];
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				tablero[i][j]=new Gelaxka(0);
			}
		}
	}
	
	public boolean ontzirenBatGeratzenDa() {
		boolean ema=false;
			for (int i=0; i<10; i++) {
				for (int j=0; j<10; j++) {
					if (tablero[i][j].itsasontziaDu()) {
						ema=true;
					}
				}
			}
		return ema;
	}
	public void gelaxkaUrperatutaIpini(int x, int y) {
		tablero[x][y].aldatuEgoera(Egoera.URPERATUTA);
	}
	public void gelaxkaUkituaIpini(int x, int y) {
		tablero[x][y].aldatuEgoera(Egoera.UKITUA);
	}
	public boolean urperatutaDago(int x, int y) {
		return tablero[x][y].urperatutaDu();
	}
	
	
	public boolean ukitutaDago(int x, int y) {
		return tablero[x][y].ukitutaDu();
	}
	
	public void gelaxkaKonpondu(int x, int y) { //gelaxka ez ukituta (itsasontzia) ipini
		tablero[x][y].aldatuEgoera(Egoera.ITSASONTZIA);
	}
	
	
	public boolean ontziaKokatuAhalDa(int pX, int pY, boolean pHorizontal, int pLuz) {
		boolean kokatu=true;
		int kont=pLuz;
		int x=pX;
		int y=pY;
		while(pX>=0 && pX<10 && pY>=0 && pY<10 && kokatu && kont>0) {
			for(int i=x-1; i<=x+1; i++) {
				for(int j=y-1; j<=y+1; j++) {
					if(i>=0 && i<10 && j>=0 && j<10 && tablero[i][j].itsasontziaDu()) {
						kokatu=false;
					}
				}
			}
			kont--;
			if(pHorizontal) {
				x++;
				if(x>10) {kokatu=false;}
			}
			else {
				y++;
				if(y>10) {kokatu=false;}
			}
		}
		return kokatu;
	}
	public void ontziaKokatu(int pX, int pY, boolean pHorizontal, int pLuz) {
		int kont=pLuz;
		int x=pX;
		int y=pY;
		while(kont>0) {
			tablero[x][y].aldatuItsasontzia(pLuz);
			kont--;
			if(pHorizontal) {x++;}
			else {y++;}
		}
	}
	public boolean ukitutaEdoUrperatutaZegoen(int x, int y) {
		if(tablero[x][y].ukitutaDu() || tablero[x][y].urperatutaDu()){
			return true;
		}
		return false;
	}
	public boolean itsasontziaDuGelaxka(int x, int y) {return tablero[x][y].itsasontziaDagoZegoen();}
	
	public int ezkutuaXTxikitu(int x, int y, int k) {
		return tablero[x][y].ezkutuaXTxikitu(k);
	}
	public void setEzkutua(int x,int y, int level) {
		tablero[x][y].setEzkutua(level);		
	}
	
	public boolean ezkutuaDago(int x, int y) {
		return tablero[x][y].ezkutuaDago();
	}
	
}
