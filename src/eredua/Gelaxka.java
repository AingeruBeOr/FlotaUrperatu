package eredua;

public class Gelaxka{
	private Itsasontzi itsasontzi;
	
	//private Egoera egoera;
	
	//private int ezkutua; // 0 --> ezkuturik ez ; 1 --> ezkutu erdia ; 2 --> ezkutu osoa
	
	public Gelaxka() {
		
	}
	
	public boolean uraDu() {
		if (itsasontzi==null) {
			return true;
		}
		return false;
	}
	
	public void armaAplikatu(Arma pArma) {
		if(itsasontzi!=null) itsasontzi.egoeraKlik(pArma);
	}
	
	public boolean itsasontziaDago() {
		return !uraDu();
	}
	
	public boolean ukitutaDu() {
		if(itsasontzi.ukitutaDago()) {return true;}
		return false;
	}
	public boolean urperatutaDu() {
		if(itsasontzi.urperatutaDago()) {return true;}
		return false;
	}
	public boolean ezkutuaDago() {
		if(itsasontzi.ezkututaDago()) {return true;}
		return false;
	}
	public void erreparatu() {
		this.itsasontzi.egoeraAldatu(new Osoa());
	}
	public void aldatuItsasontzia(int pL) {
		if(pL==0) {
			itsasontzi=null;
		}else {
			itsasontzi=ItsasontziFactory.getNireItsasontziFactory().createItsasontzi(pL);
		}
	}
	/*
	public Gelaxka( int pItsasontzi) {
		if(pItsasontzi==0) {
			egoera=Egoera.URA;
		}else {
			egoera=Egoera.ITSASONTZIA;
			itsasontzi=ItsasontziFactory.getNireItsasontziFactory().createItsasontzi(pItsasontzi);
		}
		ezkutua = 0;
	}
	
	public boolean itsasontziaDu() { //este metodo te dice si la egoera es = itsasontzi
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
	
	public void aldatuItsasontzia(int pL) {
		if(pL==0) {
			egoera=Egoera.URA;
			itsasontzi=null;
		}else {
			egoera=Egoera.ITSASONTZIA;
			itsasontzi=ItsasontziFactory.getNireItsasontziFactory().createItsasontzi(pL);
		}
	}
	
	
	public boolean itsasontziaDagoZegoen() { 
		if (itsasontzi!=null) {
			return true;
		}
		return false;
	}
	
	public void setEzkutua(int level) {
		ezkutua = level;
	}
	public int ezkutuaXTxikitu(int k) {
		if(k==2) ezkutua=0;
		else ezkutua--;
		return ezkutua;
	}
	
	public boolean ezkutuaDago() {
		if(ezkutua == 1 || ezkutua == 2) return true;
		else return false;
	}
	
	*/
}
