package eredua;

public abstract class Arma {
	protected float prezioa;
	protected int kantitatea;
	
	public Arma() {};
	public Arma(int pPrezioa, int pKantitatea) {
		this.prezioa = pPrezioa;
		this.kantitatea = pKantitatea;
	}
	
	public boolean kantitatea1unitateJaitsi() {
		kantitatea--;
		if(kantitatea == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
}
