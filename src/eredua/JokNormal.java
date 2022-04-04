package eredua;
import java.util.*;


public class JokNormal  extends Jokalari{

	public JokNormal( float pDiru ) {
		super(pDiru);
	}
	
	public void txandaJokatu() {}
	public void tiroEgin() {}
	public void armamentuaErosi() {}
	public void ontziaKonpondu() {}
	public void radarraKontsultatu() {}
	protected boolean tiroaOndoEginDu() {
		boolean ondo=true;
		setChanged();
		notifyObservers();
		return ondo;
	}

}
