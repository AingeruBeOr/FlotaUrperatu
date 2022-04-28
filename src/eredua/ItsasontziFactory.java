package eredua;

public class ItsasontziFactory {
	private static ItsasontziFactory nFactory;
	
	private ItsasontziFactory() {}
	
	public static ItsasontziFactory getNireItsasontziFactory() {
		if(nFactory==null) {
			nFactory=new ItsasontziFactory();
		}
		return nFactory;
	}
	
	public Itsasontzi createItsasontzi(int pMota) {
		Itsasontzi i=null;
		if(pMota==1) {i=new Fragata();}
		else if(pMota==2) {i=new Suntzitzaile();}
		else if(pMota==3) {i=new Itsaspeko();}
		else if(pMota==4) {i=new HegazkinOntzi();}
		return i;
	}
}
