package eredua;
import java.util.*;


public class JokNormal  extends Jokalari{
	private static JokNormal nireJok;
	private JokNormal( float pDiru ) {
		super(pDiru);
	}
	public static JokNormal getNireJok() {
		if(nireJok==null) {
			nireJok=new JokNormal(1000);
		}
		return nireJok;
	}
	
	public void txandaJokatu() {}
	public int tiroEgin() {return 0;}
	public void armamentuaErosi() {}
	public void ontziaKonpondu() {}
	public void radarraKontsultatu() {}
	protected boolean tiroaOndoEginDu() {
		
		return true;
	}
	
	

}
