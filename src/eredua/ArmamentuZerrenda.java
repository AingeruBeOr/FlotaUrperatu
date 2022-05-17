package eredua;
import java.util.ArrayList;


public class ArmamentuZerrenda {
	private Bonba bonbak;
	private Misil misilak;
	private Radarra radarrak;
	private Ezkutua ezkutuak;
	
	public ArmamentuZerrenda(int m, int r, int e) {
		this.bonbak = new Bonba();
		this.misilak = new Misil(m);
		this.radarrak = new Radarra(r);
		this.ezkutuak = new Ezkutua(e);
	}
	
	/**
	 * Arma mota baten arma kopurua begiratzeko erabiltzen da
	 * @param arma arma mota
	 * @return arma mota kopurua
	 */
	public int getArmaKop(Arma arma) {
		int bueltatzeko = 0;
		if(arma instanceof Bonba) bueltatzeko = this.bonbak.getKop();
		else if(arma instanceof Misil) bueltatzeko = this.misilak.getKop();
		else if(arma instanceof Radarra) bueltatzeko = this.radarrak.getKop();
		else if(arma instanceof Ezkutua) bueltatzeko = this.ezkutuak.getKop();
		return bueltatzeko;
	}
	
	/**
	 * Adierazitako armari -1 egingo dio kantitatean
	 * @param arma arma mota
	 * @return arma mota kopurua
	 */
	public int armaKantitateaEguneratu(Arma arma) {
		int bueltatzeko = 0;
		if(arma instanceof Bonba) bueltatzeko = this.bonbak.kantitatea1unitateJaitsi();
		else if(arma instanceof Misil) bueltatzeko = this.misilak.kantitatea1unitateJaitsi();
		else if(arma instanceof Radarra) bueltatzeko = this.radarrak.kantitatea1unitateJaitsi();
		else if(arma instanceof Ezkutua) bueltatzeko = this.ezkutuak.kantitatea1unitateJaitsi();
		return bueltatzeko;
	}
	
	public void armamentuaErosi(Arma pArma,int pKop) {
		FlotaUrperatu fu=FlotaUrperatu.getNireFlotaUrperatu();
		if(pArma instanceof Bonba) {
			this.bonbak.setKop(getArmaKop(pArma) + pKop);
		}
		else if(pArma instanceof Misil) {
			this.misilak.setKop(getArmaKop(pArma) + pKop);
			fu.bistanEkintzaBurutu(0, pKop);
		} 
		else if(pArma instanceof Radarra) {
			this.radarrak.setKop(getArmaKop(pArma) + pKop);
			fu.bistanEkintzaBurutu(1, pKop);
		} 
		else if(pArma instanceof Ezkutua) {
			this.ezkutuak.setKop(getArmaKop(pArma) + pKop);
			fu.bistanEkintzaBurutu(2, pKop);
		}
	}
}	