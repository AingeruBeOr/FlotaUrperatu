package eredua;

public abstract class Arma {
	protected int prezioa;
	protected int kantitatea;
	
	public Arma() {}
	
	public Arma(int pPrezioa) {
		prezioa = pPrezioa;
	}
	
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
	
	public void setKop(int pKop) {this.kantitatea = pKop;}
	
	public int getPrezioa() {
		return prezioa;
	}
}
