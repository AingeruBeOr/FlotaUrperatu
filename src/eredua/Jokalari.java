package eredua;
public abstract class Jokalari {
	protected float dirua;
	protected ArmamentuZerrenda armak;
	protected ItsasontziZerrenda itsasontzi;
	protected boolean[][] matrizeUkitu;
	protected boolean[][] matrizeOntzi;
	protected ItsasontziZerrenda itsasontziak;
	
	public Jokalari ( float pDiru ) {
		matrizeUkitu=new boolean[10][10];
		matrizeOntzi=new boolean[10][10];
		dirua=pDiru;
		armak = new ArmamentuZerrenda(1,0,0);
		itsasontzi = new ItsasontziZerrenda();
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				matrizeUkitu[i][j]=false;
			}
		}
	}
	
	protected abstract void txandaJokatu();
	protected abstract int tiroEgin();
	protected abstract boolean tiroaOndoEginDu();
	protected abstract void armamentuaErosi();
	protected abstract void ontziaKonpondu();
	protected abstract void radarraKontsultatu();
	
	public boolean armaKantitateaEguneratu(Arma arma) {
		return armak.armaKantitateaEguneratu(arma);
	}
	
	public Arma getArma(Arma arma) {
		return this.armak.getArma(arma);
	}
	
	/*protected void armamentuaHasieratu() {
		Misil a = new Misil();
		armak.gehituOrdenatua(a);
	}*/
}
