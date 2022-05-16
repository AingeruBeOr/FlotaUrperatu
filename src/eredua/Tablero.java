package eredua;


import java.util.Observable;
import java.util.Arrays;
import java.util.*;
import java.util.List;



import static java.util.stream.Collectors.*;

public class Tablero extends Observable{
	private Gelaxka[][] tablero;
	
	public Tablero() {
		tablero=new Gelaxka[10][10];
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				tablero[i][j]=new Gelaxka();
			}
		}
	}
	
	public boolean ontzirenBatGeratzenDa() {
		/*boolean ema=false;
			for (int i=0; i<10; i++) {
				for (int j=0; j<10; j++) {
					if (!(tablero[i][j].urperatutaDu()||tablero[i][j].uraDu())) { //tablero[i][j].itsasontziaDu()
						ema=true;
					}
				}
			}
		return ema;*/
		boolean ema=true;
		for (int i=0; i<10; i++) {
			ema=(ema && Arrays.stream(tablero[i])
					.filter(p->p.itsasontziaDago()).allMatch(p->p.urperatutaDu()));
		}
		return !ema;
	}
	
	
	/*
	public void gelaxkaUrperatutaIpini(int x, int y) {
		tablero[x][y].aldatuEgoera(Egoera.URPERATUTA);
	}
	public void gelaxkaUkituaIpini(int x, int y) {
		tablero[x][y].aldatuEgoera(Egoera.UKITUA);
	}
	*/
	
	public boolean urperatutaDago(int x, int y) {
		return tablero[x][y].urperatutaDu();
	}
	
	public boolean ukitutaDago(int x, int y) {
		return tablero[x][y].ukitutaDu();
	}
	public boolean osoaDago(int x, int y) {
		return tablero[x][y].osoaDago();
	}
	
	
	public void gelaxkaKonpondu(int x, int y) { 
		tablero[x][y].erreparatu();
		if(!FlotaUrperatu.getNireFlotaUrperatu().getTxanda()) {
			JokNormal.getNireJok().ukituak[x][y]=false; //gelaxka ez ukituta (itsasontzia) ipini
		}else {
			Bot.getNireBot().ukituak[x][y]=false; //gelaxka ez ukituta (itsasontzia) ipini
		} 
	}
	
	
	public boolean ontziaKokatuAhalDa(int pX, int pY, boolean pHorizontal, int pLuz) {
		boolean kokatu=true;
		int kont=pLuz;
		int x=pX;
		int y=pY;
		while(pX>=0 && pX<10 && pY>=0 && pY<10 && kokatu && kont>0) {
			for(int i=x-1; i<=x+1; i++) {
				for(int j=y-1; j<=y+1; j++) {
					if(i>=0 && i<10 && j>=0 && j<10 && !tablero[i][j].uraDu()) {
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
	public boolean itsasontziaDuGelaxka(int x, int y) {
		return tablero[x][y].itsasontziaDago();
	}
	
	/*public int ezkutuaXTxikitu(int x, int y, int k) {
		return tablero[x][y].ezkutuaXTxikitu(k);
	}
	public void setEzkutua(int x,int y, int level) {
		tablero[x][y].setEzkutua(level);		
	}*/
	public void gelaxkariArmaAplikatu(int x, int y, Arma pArma) {
		tablero[x][y].armaAplikatu(pArma);
	}
	
	public boolean ezkutuaDago(int x, int y) {
		return tablero[x][y].ezkutuaDago();
	}
	
	
	public int kalkulatuIrabazi(int x, int y) {
		return tablero[x][y].kalkulatuIrabazi();
	}
	
	
	
	
	/*botaren konponketarako
	public List<Gelaxka> urperatuak(int y){
		List<Gelaxka> l = null;
		for (int i=y; i<10; i++) {
			 l= Arrays.stream(tablero[i]).filter(p->p.ukitutaDu()).collect(toList());
			 System.out.println(l.size()+"ajajjjjjjjjjjsdjjdjj");
			 if (l.size()!=0) {
				 l.add((Gelaxka) Arrays.stream(tablero[i]).filter(p->p.ukitutaDu()));
			 }
			 System.out.println(l.size()+"aaaaaaaaaaaaaa");
		}
		System.out.println(l.size());
		return l;	
	}
	*/
}
