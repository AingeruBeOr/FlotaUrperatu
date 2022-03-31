package eredua;
import java.awt.Color;
import java.util.Observable;
public class FlotaUrperatu extends Observable{
	private static FlotaUrperatu nireFlota;
	//Matrize hauek true balioa badute jada bertan misil bat erori da (eta ez da konponketarik egon)
	private boolean[][] jokMatrizeUkitu;
	private boolean[][] botMatrizeUkitu;
	//Matrize hauek true balioa badute ontzia dute barnean
	private boolean[][] jokMatrizeOntzi;
	private boolean[][] botMatrizeOntzi;
	
	private JokNormal jokalaria;
	private Bot bot;
	
	// private boolean lehenengoRonda; Menuan jarri
	private boolean txanda; //True bada Jokalaria jolasten ari da, bestela bota
	
	private FlotaUrperatu() {}
	public static FlotaUrperatu getNireFlotaUrperatu() {
		if (nireFlota==null) {
			nireFlota=new FlotaUrperatu();
		}
		return nireFlota;
	}
	
	private void hasieratuMatrizeak(){
		jokMatrizeUkitu= new boolean[10][10];
		botMatrizeUkitu= new boolean[10][10];
		jokMatrizeOntzi= new boolean[10][10];
		botMatrizeOntzi= new boolean[10][10];
		for(int l=0;l<10;l++) {
			for(int z=0;z<10;z++) {
				jokMatrizeOntzi[l][z]=false;
				botMatrizeOntzi[l][z]=false;
				jokMatrizeUkitu[l][z]=false;
				botMatrizeUkitu[l][z]=false;
			}
		}
	}
	
	public void hasieratu() {
		this.hasieratuMatrizeak();
		txanda=true;
		bot= new Bot(1000);
		jokalaria = new JokNormal(1000);
		this.armamentuaHasieratu();
		this.ontziakKokatu();
		
	}
	


	private void ontziakKokatu() {
		System.out.println("GOGORATU: Adierazi itsasontziaren lehenengo gelaxka. "
				+ "Horizontalean hurrengo gelaxkak eskuinerantz jarriko dira. "
				+ "Bertikalean aldiz, beheruntz joango dira");
		System.out.println("Sartu hegazkin-ontzi bat (4 posizio)");	
		for(int i=0; i<2; i++) {
			System.out.println("Sartu itsaspeko bat (3 posizio)");
		}
		for(int i=0; i<3; i++) {
			System.out.println("Sartu suntzitzaile bat (2 posizio)");
		}
		for(int i=0; i<4; i++) {
			System.out.println("Sartu fragata bat (posizio 1)");
		}
	}
	//PRIBATUAN JARRI BEHARKO ZEN AGIAN ONTZIAKKOKATU-REN BARRUAN
	public void ontziaKokatu(int pX, int pY, boolean pHorizontal, int pLuz) {
		int kont=pLuz;
		int x=pX;
		int y=pY;
		while(pLuz>0) {
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
					if(i>=0 && i<5 && j>=0 && j<5 && jokMatrizeOntzi[x][y]) {
						kokatu=false;
					}
				}
			}
			kont--;
			if(pHorizontal) {x++;}
			else {y++;}
		}
		return kokatu;
	}
	private void armamentuaHasieratu() {
		jokalaria.armamentuaHasieratu();
		bot.armamentuaHasieratu();
	}
	
	
	/*private void aurrekontuaEsleitu() {
		
	}*/
}
