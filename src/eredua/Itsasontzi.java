package eredua;

public abstract class Itsasontzi {
	protected int konponketaPrezioa;
	protected int suntziketaIrabazia;
	private EgoeraState egoera;
	protected int luzera;
	
	public Itsasontzi() {
		this.konponketaPrezioa = 75;
		this.suntziketaIrabazia = 50;
		this.egoera=new Osoa();
	}
	
	/*protected float kalkulatuKonponketa(int zatiKop) {
		return zatiKop*konponketaPrezioa;
	}
	
	*/
	
	protected int kalkulatuIrabazia() {
		return luzera*suntziketaIrabazia;
	}
	
	
	
	public int getLuzera() {
		return luzera;
	}
	
	public boolean ukitutaDago() {
		if(egoera instanceof Ukituta) return true;
		return false;
	}
	public boolean osoaDago() {
		if(egoera instanceof Osoa) return true;
		return false;
	}
	
	public boolean urperatutaDago() {
		if(egoera instanceof Urperatuta) return true;
		return false;
	}
	
	public boolean ezkututaDago() {
		if(egoera instanceof Ezkutu) return true;
		return false;
	}

	public void egoeraAldatu (EgoeraState pEgoera){ //usarlo para poner un barco entero urperatuta
		egoera=pEgoera;	
	}
	
	public void egoeraKlik(Arma pArma) {
		egoera.egoeraKlik(this, pArma);
	}
}
