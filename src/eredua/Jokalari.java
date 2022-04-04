package eredua;
import java.util.Observable;
public abstract class Jokalari extends Observable {
	protected float dirua;
	protected ArmamentuZerrenda armak;
	protected ItsasontziZerrenda itsasontzi;
	protected boolean[][] matrizeUkitu;
	protected boolean[][] matrizeOntzi;
	protected ItsasontziZerrenda itsasontziak;
	
	public Jokalari ( float pD ) {
		matrizeUkitu=new boolean[10][10];
		matrizeOntzi=new boolean[10][10];
		dirua=pD;
		armak= new ArmamentuZerrenda();
		itsasontzi=new ItsasontziZerrenda();
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				matrizeUkitu[i][j]=false;
			}
		}
	}
	
	protected abstract void txandaJokatu();
	protected abstract void tiroEgin();
	protected abstract boolean tiroaOndoEginDu();
	protected abstract void armamentuaErosi();
	protected abstract void ontziaKonpondu();
	protected abstract void radarraKontsultatu();
	
	protected void armamentuaHasieratu() {
		Misil a = new Misil();
		armak.gehituOrdenatua(a);
	}
}
