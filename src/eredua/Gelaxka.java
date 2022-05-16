package eredua;

public class Gelaxka{
	private Itsasontzi itsasontzi;
	
	public Gelaxka() {
		
	}
	
	public boolean uraDu() {
		if (itsasontzi==null) return true;
		return false;
	}
	
	public void armaAplikatu(Arma pArma) {
		if(itsasontzi!=null) itsasontzi.egoeraKlik(pArma);
	}
	
	/**
	 * Gekaxkan itsasontzia dagoen ala ez jakiteko erabiltzen da.
	 * @return true itsasontzia badago eta false bestela.
	 */
	public boolean itsasontziaDago() {
		return !uraDu();
	}
	/**
	 * Gelaxkan itsasontzia badago, ukitua dagoen adieraziko du.
	 * @return true itsasontzia badago eta ukituta badago, false beste kasu guztietan.
	 */
	public boolean ukitutaDu() {
		if(itsasontzi!=null && itsasontzi.ukitutaDago()) return true;
		return false;
	}
	
	public boolean urperatutaDu() {
		if(itsasontzi!=null && itsasontzi.urperatutaDago()) return true;
		return false;
	}
	public boolean ezkutuaDago() {
		if(itsasontzi!=null && itsasontzi.ezkututaDago()) return true;
		return false;
	}
	/**
	 * Gelaxkan itsasontzia badago, gelaxka hori ukitu gabe dagoen adieraziko du.
	 * @return 
	 */
	public boolean osoaDago() {
		if(itsasontzi!=null && itsasontzi.osoaDago()) return true;
		return false;
	}
	public void erreparatu() {
		if(itsasontzi!=null) this.itsasontzi.egoeraAldatu(new Osoa());
	}
	public void aldatuItsasontzia(int pL) {
		if(pL==0) itsasontzi=null;
		else itsasontzi=ItsasontziFactory.getNireItsasontziFactory().createItsasontzi(pL);
	}
	
	
	public int kalkulatuIrabazi() {
		int prezioa=0;
		if (itsasontzi!=null) prezioa=itsasontzi.kalkulatuIrabazia();
		return prezioa;
	}
}
