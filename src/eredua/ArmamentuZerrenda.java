package eredua;
import java.util.ArrayList;


public class ArmamentuZerrenda {
	private Bonba bonbak;
	private Misil misilak;
	private Radarra radarrak;
	private Ezkutua ezkutuak;
	
	public ArmamentuZerrenda(int pMisilKop,int pRadarKop, int pEzkutuKop) {
		this.bonbak = new Bonba();
		this.misilak = new Misil(pMisilKop);
		this.radarrak = new Radarra(pRadarKop);
		this.ezkutuak = new Ezkutua(pEzkutuKop);
	}
	
	public int armaKantitateaEguneratu(Arma arma) {
		int bueltatzeko = 0;
		if(arma instanceof Bonba) bueltatzeko = this.bonbak.kantitatea1unitateJaitsi();
		else if(arma instanceof Misil) bueltatzeko = this.misilak.kantitatea1unitateJaitsi();
		else if(arma instanceof Radarra) bueltatzeko = this.radarrak.kantitatea1unitateJaitsi();
		else if(arma instanceof Ezkutua) bueltatzeko = this.ezkutuak.kantitatea1unitateJaitsi();
		return bueltatzeko;
	}
	
	public int getArmaKop(Arma arma) {
		int bueltatzeko = 0;
		if(arma instanceof Bonba) bueltatzeko = this.bonbak.getKop();
		else if(arma instanceof Misil) bueltatzeko = this.misilak.getKop();
		else if(arma instanceof Radarra) bueltatzeko = this.radarrak.getKop();
		else if(arma instanceof Ezkutua) bueltatzeko = this.ezkutuak.getKop();
		return bueltatzeko;
	}
	
	/*public Arma getArma(Arma arma) {
		Arma bueltatzeko = null;
		if(arma instanceof Bonba) bueltatzeko = this.bonbak;
		else if(arma instanceof Misil) 	bueltatzeko =  this.misilak;
		else if(arma instanceof Radarra) bueltatzeko = this.radarrak;
		else if(arma instanceof Ezkutua) bueltatzeko =  this.ezkutuak;
		return bueltatzeko;
	}*/
}	