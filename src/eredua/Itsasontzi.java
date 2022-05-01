package eredua;

public abstract class Itsasontzi {
	protected float konponketaPrezioa;
	protected float suntziketaIrabazia;
	private EgoeraState egoera;
	
	public Itsasontzi() {
		this.konponketaPrezioa = 75;
		this.suntziketaIrabazia = 50;
		this.egoera=new Osoa();
	}
	
	protected float kalkulatuKonponketa(int zatiKop) {
		return zatiKop*konponketaPrezioa;
	}
	//protected float kalulatuIrabazia(Itsasontzi pI) {
		//return pI.luzera*suntziketaIrabazia;
	//}
	
	
	public void egoeraAldatu (EgoeraState pEgoera){ //usarlo para poner un barco entero urperatuta
		egoera=pEgoera;	
	}
	
	public void egoeraKlik(Arma pArma) {
		egoera.egoeraKlik(this, pArma);
	}
}
