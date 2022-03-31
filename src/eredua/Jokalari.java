package eredua;

public abstract class Jokalari {
	protected float dirua;
	protected ArmamentuZerrenda armak;
	protected ItsasontziZerrenda itsasontzi;
	public Jokalari ( float pD ) {
		dirua=pD;
		armak= new ArmamentuZerrenda();
		itsasontzi=new ItsasontziZerrenda();
	}
	
	protected ItsasontziZerrenda itsasontziak;
	protected abstract void txandaJokatu();
	protected abstract void tiroEgin();
	protected abstract void armamentuaErosi();
	protected abstract void ontziaKonpondu();
	protected abstract void radarraKontsultatu();
	
	protected void armamentuaHasieratu() {
		for(int i=0; i<20; i++) {
			armak.gehituOrdenatua(new Misil());
		}
		armak.gehituOrdenatua(new Bonba());
	}
	
}
