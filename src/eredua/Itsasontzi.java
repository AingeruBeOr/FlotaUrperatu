package eredua;

public abstract class Itsasontzi {
	protected float konponketaPrezioa;
	protected float suntziketaIrabazia;
	
	public Itsasontzi() {
		this.konponketaPrezioa = 75;
		this.suntziketaIrabazia = 50;
	}
	
	protected float kalkulatuKonponketa(int zatiKop) {
		return zatiKop*konponketaPrezioa;
	}
	//protected float kalulatuIrabazia(Itsasontzi pI) {
		//return pI.luzera*suntziketaIrabazia;
	//}
}
