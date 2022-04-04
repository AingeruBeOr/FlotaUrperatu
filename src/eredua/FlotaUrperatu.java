package eredua;
import java.awt.Color;
import java.util.Observable;

import bista.Tablero;
public class FlotaUrperatu extends Observable{
	private static FlotaUrperatu nireFlota;
	//Matrize hauek true balioa badute, jada bertan misil bat erori da (eta ez da konponketarik egon)
	private boolean[][] jokMatrizeUkitu;
	private boolean[][] botMatrizeUkitu;
	//Matrize hauek true balioa badute ontzia dute barnean
	private boolean[][] jokMatrizeOntzi;
	private boolean[][] botMatrizeOntzi;
	
	private JokNormal jokalaria;
	private Bot bot;
	
	// private boolean lehenengoRonda; Menuan jarri
	private boolean txanda; //True bada Jokalaria jolasten ari da, bestela bota
	
	private FlotaUrperatu() {
		hasieratu();
	}
	public static FlotaUrperatu getNireFlotaUrperatu() {
		if (nireFlota==null) {
			nireFlota=new FlotaUrperatu();
		}
		return nireFlota;
	}
	
	private void hasieratu() {
		this.hasieratuMatrizeak();
		txanda=true;
		bot= new Bot(1000);
		jokalaria = new JokNormal(1000);
		this.armamentuaHasieratu();	
	}
	
	private void hasieratuMatrizeak(){
		jokMatrizeUkitu= new boolean[10][10];
		botMatrizeUkitu= new boolean[10][10];
		jokMatrizeOntzi= new boolean[10][10];
		botMatrizeOntzi= new boolean[10][10];
		this.botariOntziakJarri();
		for(int l=0;l<10;l++) {
			for(int z=0;z<10;z++) {
				jokMatrizeOntzi[l][z]=false;
				jokMatrizeUkitu[l][z]=false;
				botMatrizeUkitu[l][z]=false;
			}
		}
	}
	private void botariOntziakJarri() {
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
	}
	
	
	
	public boolean jokoaAmaituDa() {
		boolean amaitu=false;
		if (!ontzirenBatGeratzenDa()) { 			//ez bada ontzirik geratzen
			if (!this.txanda) {  					//botaren txanda da --> jokalaria irabazlea zen aurreko rondan
				System.out.println("Irabazlea jokalaria da");
			}
			else {
				System.out.println("Irabazlea bot-a da");
			}
		}
		
		
		return amaitu;
	}
	
	private boolean ontzirenBatGeratzenDa() {
		boolean ontzirenBatGeratzenDa=false;
		
		while (!ontzirenBatGeratzenDa) {
			for (int i=0; i<10; i++) {
				for (int j=0; j<10; j++) {
					if (jokMatrizeOntzi[i][j] || botMatrizeOntzi [i][j] ) {
						ontzirenBatGeratzenDa=true;
					}
				}
			}
		}
		return ontzirenBatGeratzenDa;
	}
	
		
	//TODO PRIBATUAN JARRI BEHARKO ZEN AGIAN ONTZIAK KOKATU-REN BARRUAN
	public void ontziaKokatu(int pX, int pY, boolean pHorizontal, int pLuz) {
		int kont=pLuz;
		int x=pX;
		int y=pY;
		while(kont>0) {
			jokMatrizeOntzi[x][y]=true;
			kont--;
			if(pHorizontal) {x++;}
			else {y++;}
		}
		/*esto es para inrpimir las celdas 
		for(int l=0;l<10;l++) {
			for(int z=0;z<10;z++) {
				System.out.println(jokMatrizeOntzi[l][z]);
			}
		}
		*/
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
			//System.out.println("Kokatu ahal da momentuz: "+kokatu);
			//System.out.println("gelaxka: "+x+ " "+y);
			if(pHorizontal) {
				x++;
				if(x>10) {kokatu=false;}
			}
			else {
				y++;
				if(y>10) {kokatu=false;}
			}
		}
		if(kokatu) System.out.println("Ontzia bertan kokatu ahal da");
		else System.out.println("Ontzia ezin da kokatu hor");
		return kokatu;
	}
	private void armamentuaHasieratu() {
		jokalaria.armamentuaHasieratu();
		bot.armamentuaHasieratu();
	}
	
	public boolean botMatrizeUkituta(int x, int y){return botMatrizeUkitu[x][y];}
	public boolean botMatrizeOntziaDu(int x, int y){
		return botMatrizeOntzi[x][y];}
	

	public void botarenOntziaUkituDu(int x, int y) { //botaren matrizeak eguneratu, ukituta dagoela adierazi eta ontzirik ez dagoela 
		botMatrizeUkitu[x][y]=true;
		botMatrizeOntzi[x][y]=false;
	}
	
}
