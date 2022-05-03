package eredua;

public class Ukituta implements EgoeraState{

	public void egoeraKlik(Itsasontzi pItsasontzi, Arma pArma) {
		if(pArma instanceof Misil) {
			pItsasontzi.egoeraAldatu(new Urperatuta());
		}else {System.out.println("Errore Ukituta dago");}
	}
}
