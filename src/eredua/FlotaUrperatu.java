package eredua;
import java.util.Observable;
public class FlotaUrperatu extends Observable{
	//Matrize hauek true balioa badute jada bertan misil bat erori da (eta ez da konponketarik egon)
	private boolean[][] jokMatrizeUkitu;
	private boolean[][] botMatrizeUkitu;
	//Matrize hauek true balioa badute ontzia dute barnean
	private boolean[][] jokMatrizeOntzi;
	private boolean[][] botMatrizeOntzi;
	
	private JokNormal jokalaria;
	private Bot bot;
	
	private boolean lehenengoRonda;
	private boolean txanda; //True bada Jokalaria jolasten ari da, bestela bota
	
	public static void main(String[] args) {
		

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
		lehenengoRonda=true;
		bot= new Bot();
		jokalaria = new JokNormal();
		this.armamentuaHasieratu();
	}
	
	private boolean lehenengoRondaDa() {
		return this.lehenengoRonda;
	}

	public void ontziakKokatu() {
		
	}
	
	private void armamentuaHasieratu() {
		
	}
	
	/*private void aurrekontuaEsleitu() {
		
	}*/
}
