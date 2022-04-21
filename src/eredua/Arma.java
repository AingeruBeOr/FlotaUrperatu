package eredua;

public abstract class Arma {
	protected float prezioa;
	protected int kantitatea;
	
	public Arma() {}
	
	public Arma(int pPrezioa, int pKantitatea) {
		this.prezioa = pPrezioa;
		this.kantitatea = pKantitatea;
	}
	
	public int kantitatea1unitateJaitsi() {
		return --kantitatea;
	}
	
	public int getKop() {
		return kantitatea;
	}
}
