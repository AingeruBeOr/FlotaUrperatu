package eredua;
import java.awt.Color;
import java.util.Observable;

import bista.Tablero;
public class FlotaUrperatu extends Observable{
	private static FlotaUrperatu nireFlota;
	//Matrize hauek true balioa badute, jada bertan misil bat erori da (eta ez da konponketarik egon)
	//private boolean[][] jokMatrizeUkitu;
	//private boolean[][] botMatrizeUkitu;
	//Matrize hauek true balioa badute ontzia dute barnean
	//private boolean[][] jokMatrizeOntzi;
	//private boolean[][] botMatrizeOntzi;
	// private boolean lehenengoRonda; Menuan jarri
	private boolean txanda; //True bada Jokalaria jolasten ari da, bestela bota
	
	private FlotaUrperatu() {
		txanda=true;
		//hasieratu();
	}
	
	public static FlotaUrperatu getNireFlotaUrperatu() {
		if (nireFlota==null) {
			nireFlota=new FlotaUrperatu();
		}
		return nireFlota;
	}
	
	/*private void hasieratu() {
		txanda = true;
	}*/
	
	/*private void hasieratuMatrizeak(){
		jokMatrizeUkitu= new boolean[10][10];
		botMatrizeUkitu= new boolean[10][10];
		jokMatrizeOntzi= new boolean[10][10];
		botMatrizeOntzi= new boolean[10][10];
		for(int l=0;l<10;l++) {
			for(int z=0;z<10;z++) {
				jokMatrizeOntzi[l][z]=false;
				jokMatrizeUkitu[l][z]=false;
				botMatrizeUkitu[l][z]=false;
			}
		}
	}*/
	
	public boolean getTxanda() {return this.txanda;}
	public void aldatuTxanda() {
		txanda=!txanda;
		setChanged();
		notifyObservers(null);
	}
	
	/*private void botariOntziakJarri() {
	//TODO FIJO QUE SE PUEDE HACER DE OTRA MANERA
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(i==0||i==2||i==4) {botMatrizeOntzi[i][j]=true;}
				else {botMatrizeOntzi[i][j]=false;}
			}
		}
		botMatrizeOntzi[0][4]=false;
		botMatrizeOntzi[0][8]=false;
		botMatrizeOntzi[0][9]=false;
		botMatrizeOntzi[2][3]=false;
		botMatrizeOntzi[2][6]=false;
		botMatrizeOntzi[2][9]=false;
		botMatrizeOntzi[4][2]=false;
		botMatrizeOntzi[4][4]=false;
		botMatrizeOntzi[4][6]=false;
		botMatrizeOntzi[4][8]=false;
	}*/
	
	public int botTxanda() {return Bot.getNireBot().tiroEgin();}
	

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
	/*private boolean ontzirenBatGeratzenDa() {
		boolean ontziBot=false;
		boolean ontziJok=false;
		
			for (int i=0; i<10; i++) {
				for (int j=0; j<10; j++) {
					if (jokMatrizeOntzi[i][j] ) {
						ontziJok=true;
					}
					if (botMatrizeOntzi[i][j] ) {
						ontziBot=true;
					}
				}
			}
		return ontziJok && ontziBot;
	}*/
	
		
	//TODO PRIBATUAN JARRI BEHARKO ZEN AGIAN ONTZIAK KOKATU-REN BARRUAN
	/*public void ontziaKokatu(int pX, int pY, boolean pHorizontal, int pLuz) {
		int kont=pLuz;
		int x=pX;
		int y=pY;
		while(kont>0) {
			jokMatrizeOntzi[x][y]=true;
			kont--;
			if(pHorizontal) {x++;}
			else {y++;}
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
					if(i>=0 && i<10 && j>=0 && j<10 && jokMatrizeOntzi[i][j]) {
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
	}*/
	
	/**
	 * Botaren matrizean (x,y) koordenatuan aurretik tiro egin den bueltatzen du.
	 * @param x
	 * @param y
	 * @return
	 */
	/*public boolean botMatrizeUkituta(int x, int y){return botMatrizeUkitu[x][y];}
	
	/**
	 * Botaren marizean (x,y) koordenatan ontzi bat dagoen ala ez bueltatzen du.
	 * @param x
	 * @param y
	 * @return
	 *
	public boolean botMatrizeOntziaDu(int x, int y){return botMatrizeOntzi[x][y];}
	

	public void botarenOntziaUkituDu(int x, int y) { //botaren matrizeak eguneratu, ukituta dagoela adierazi eta ontzirik ez dagoela 
		botMatrizeUkitu[x][y]=true;
		botMatrizeOntzi[x][y]=false;
	}
	
	public void uraUkituDu(int x, int y) {
		botMatrizeUkitu[x][y]=true;
	}
	public boolean jokMatrizeUkituta(int x, int y){return jokMatrizeUkitu[x][y];}

	public boolean jokMatrizeOntziaDu(int x, int y){return jokMatrizeOntzi[x][y];}

	public void jokalariarenOntziaUkituDu(int x, int y) { //jokalariaren matrizeak eguneratu, ukituta dagoela adierazi eta ontzirik ez dagoela 
		jokMatrizeUkitu[x][y]=true;
		jokMatrizeOntzi[x][y]=false;
	}
	
	public void uraUkituDuBota(int x, int y) {
		jokMatrizeUkitu[x][y]=true;
	}*/
	
	/**
	 * Misil tiroa egin bada, metodo honi deituko zaio. false bueltatuko du misil gabe geratu bada.
	 * @param x
	 * @param y
	 * @return
	 */
	/*public void misilTiroa( int x, int y) {
		if (x>0 && botMatrizeOntziaDu(x-1, y) ) { 
			this.ezkerrekoakAztertu( x-1, y); 	
		}
		if (x<9 && botMatrizeOntziaDu(x+1, y)) {
			this.eskumakoakAztertu( x+1, y);	
		}
					
		if (y>0 && botMatrizeOntziaDu(x, y-1)) {
			this.goikoakAztertu( x, y-1);	
		}
		if (y<9 && botMatrizeOntziaDu(x, y+1)) {
			this.behekoakAztertu( x, y+1);
		}
	}
	
	private void goikoakAztertu ( int x, int y) {
		while (y>=0 && botMatrizeOntziaDu(x, y)) {
			setChanged();
			notifyObservers(new int[] {x,y});
			botarenOntziaUkituDu(x, y);
			y--;
		}
	}
	private void behekoakAztertu ( int x, int y) {
		while (y<=9 && botMatrizeOntziaDu(x, y)) { 
			setChanged();
			notifyObservers(new int[] {x,y});
			botarenOntziaUkituDu(x, y);
			y++;
			
		}
	}
	private void ezkerrekoakAztertu ( int x, int y) {
		while (x>=0 && botMatrizeOntziaDu(x, y)) {
			setChanged();
			notifyObservers(new int[] {x,y});
			botarenOntziaUkituDu(x, y);
			x--;
			
		}
	}
	
	private void eskumakoakAztertu ( int x, int y) {
		while (x<=9 && botMatrizeOntziaDu(x, y)) {
			setChanged();
			notifyObservers(new int[] {x,y});
			botarenOntziaUkituDu(x, y);
			x++;
		}
	}*/
	
	/**
	 * "arma" armari -1 egingo dio kantitatean eta false bueltatuko du arma gehiagorik ez badu
	 * @param arma erabili den arma mota adierazten da
	 * @return
	 */
	public boolean armaErabiliDa(Arma arma) {
		return JokNormal.getNireJok().armaKantitateaEguneratu(arma);
	}
	
}
