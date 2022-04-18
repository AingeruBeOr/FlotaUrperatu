package eredua;

public class Gelaxka {
	private Egoera egoera;
	private Itsasontzi itsasontzi;
	
	public Gelaxka( int pItsasontzi) {
		if(pItsasontzi==0) {
			egoera=Egoera.URA;
		}else {
			egoera=Egoera.ITSASONTZIA;
			itsasontzi=ItsasontziFactory.getNireItsasontziFactory().createItsasontzi(pItsasontzi);
		}
	}
	public boolean itsasontziaDu() {
		//TODO no se si esto da bien asi
		if(egoera.equals(Egoera.ITSASONTZIA)) {return true;}
		return false;
	}
	public boolean uraDu() {
		//TODO no se si esto da bien asi
		if(egoera.equals(Egoera.URA)) {return true;}
		return false;
	}
	public boolean ukitutaDu() {
		//TODO no se si esto da bien asi
		if(egoera.equals(Egoera.UKITUA)) {return true;}
		return false;
	}
	public boolean urperatutaDu() {
		//TODO no se si esto da bien asi
		if(egoera.equals(Egoera.URPERATUTA)) {return true;}
		return false;
	}
	public void aldatuEgoera(Egoera pE) {egoera=pE;}
}
