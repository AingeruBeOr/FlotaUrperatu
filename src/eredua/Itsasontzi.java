package eredua;

public abstract class Itsasontzi {
	protected int luzera;
	protected float konponketaPrezioa;
	protected float suntziketaIrabazia;
	
	public Itsasontzi() {}
	
	protected float kalulatuKonponketa(int zatiKop) {
		return zatiKop*konponketaPrezioa;
	}
	protected float kalulatuIrabazia(Itsasontzi pI) {
		return pI.luzera*suntziketaIrabazia;
	}
}
