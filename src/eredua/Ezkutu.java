package eredua;

public class Ezkutu implements EgoeraState{
	private int bizitza;
	
	public Ezkutu() {
		bizitza=2;
	}
	
	public void egoeraKlik(Itsasontzi pItsasontzi, Arma pArma) {
		if(pArma instanceof Bonba) {
			bizitza--;
		}
		else if (pArma instanceof Misil) {
			bizitza=0;
		}
		if (bizitza==0) {
			pItsasontzi.egoeraAldatu(new Osoa());
		}
	}
}
