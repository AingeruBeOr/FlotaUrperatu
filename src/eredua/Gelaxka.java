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
}
