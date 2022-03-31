package eredua;
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
		bot= new Bot();//SARTU DIRUA
		jokalaria = new JokNormal();//SARTU DIRUA
		this.armamentuaHasieratu();
		
	}
	


	private void ontziakKokatu() {
		
	}
	public boolean ontziaKokatuAhalDa(int pX, int pY, boolean pHorizontal, int pLuz) {
		boolean kokatu=true;
		
		if(!jokMatrizeOntzi[pX][pY]) {
			while(jokMatrizeOntzi[pX][pY]!=null && kokatu && !jokMatrizeOntzi[pX][pY]) {
				//TODO
			}
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
