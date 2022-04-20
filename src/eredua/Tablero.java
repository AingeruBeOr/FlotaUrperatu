package eredua;

import java.util.Observable;
import java.util.Arrays;

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
	public void botariOntziakJarri() {
		//TODO FIJO QUE SE PUEDE HACER DE OTRA MANERA
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					if(i==0||i==2||i==4) {
						tablero[i][j].aldatuItsasontzia(1);
						//TODO ESTO ESTA MAL FALTA DE PONER LOS BARCOS
						}
				}
			}
			tablero[0][4].aldatuItsasontzia(0);
			tablero[0][8].aldatuItsasontzia(0);
			tablero[0][9].aldatuItsasontzia(0);
			tablero[2][3].aldatuItsasontzia(0);
			tablero[2][6].aldatuItsasontzia(0);
			tablero[2][9].aldatuItsasontzia(0);
			tablero[4][2].aldatuItsasontzia(0);
			tablero[4][4].aldatuItsasontzia(0);
			tablero[4][6].aldatuItsasontzia(0);
			tablero[4][8].aldatuItsasontzia(0);
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
		//TODO UN IF PARA VER SI ES URPERATUTA
		System.out.println("Urperatuta gelaxka");
		tablero[x][y].aldatuEgoera(Egoera.URPERATUTA);
	}
	public void gelaxkaUkituaIpini(int x, int y) {
		//TODO UN IF PARA VER SI ES URPERATUTA
		tablero[x][y].aldatuEgoera(Egoera.UKITUA);
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
		System.out.println("ukitutaEdoUrperatuta x "+x+" eta y "+y);
		if(tablero[x][y].ukitutaDu() || tablero[x][y].urperatutaDu())
		{return true;}
		return false;
	}
	public boolean itsasontziaDuGelaxka(int x, int y) {return tablero[x][y].itsasontziaDagoZegoen();}
	
}
