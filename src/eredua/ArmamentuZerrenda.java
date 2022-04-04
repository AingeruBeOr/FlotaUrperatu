package eredua;
import java.util.ArrayList;


public class ArmamentuZerrenda {
	private Bonba bonba;
	private Misil misil;
	private Radarra radar;
	private Ezkutua ezkutua;
	
	public ArmamentuZerrenda(int pMisilKop,int pRadarKop, int pEzkutuKop) {
		this.bonba = new Bonba(0,100);
		this.misil = new Misil(10,pMisilKop);
		this.radar = new Radarra(10,pRadarKop);
		this.ezkutua = new Ezkutua(10,pEzkutuKop);
	}
	
	public void gehituOrdenatua(Arma pA) { 
		//Lehenengo misilak eta azkenak bonbak
		/*if (pA instanceof Misil) {
			
		}else if(pA instanceof Bonba) {}*/
	}

}
