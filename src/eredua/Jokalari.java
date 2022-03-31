package eredua;

public abstract class Jokalari {
	protected float dirua;
	public Jokalari ( float pD ) {dirua=pD;}
	protected ItsasontziZerrenda itsasontziak;
	protected abstract void txandaJokatu();
	protected abstract void tiroEgin();
	protected abstract void armamentuaErosi();
	protected abstract void ontziaKonpondu();
	protected abstract void radarraKontsultatu();
	
}
