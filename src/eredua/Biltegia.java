package eredua;

public class Biltegia {

	private static Biltegia nireBiltegi = null;
	
	private Biltegia() {
		
	}
	
	public static Biltegia getNireBiltegi(){
		if (nireBiltegi == null) {
			nireBiltegi = new Biltegia();
		}
		return nireBiltegi;
	} 
}
