package eredua;

public class Bot extends Jokalari{
	int txanda;
	private static Bot nireBot;
	
	private Bot( float pDiru ) {
		super(pDiru);
		nireItsasontziak.botariOntziakJarri();
	}
	public static Bot getNireBot() {
		if(nireBot==null) {
			nireBot=new Bot(1000);
		}
		return nireBot;
	}
	
	public void txandaJokatu() {}
	public int tiroEgin() {
		txanda++;
		int x=txanda%10;
		int y=txanda/10;
		JokNormal.getNireJok().ontziaUkitutaIpini(x, y);
		return txanda;
	}
	public boolean tiroaOndoEginDu() {return true;}
	public void armamentuaErosi() {}
	public void ontziaKonpondu() {}
	public void radarraKontsultatu() {}
	
}
