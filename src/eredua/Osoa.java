package eredua;

public class Osoa implements EgoeraState{
	
	public void egoeraKlik(Itsasontzi pItsasontzi, Arma pArma) {
		if(pArma instanceof Bonba) {				
			pItsasontzi.egoeraAldatu(new Ukituta());
		}
		else if (pArma instanceof Misil) {
			pItsasontzi.egoeraAldatu(new Urperatuta());
		}
		
	}

}

