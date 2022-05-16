package eredua;

public abstract class Itsasontzi {
	protected int konponketaPrezioa;
	protected int suntziketaIrabazia;
	private EgoeraState egoera;
	protected int luzera;
	
	public Itsasontzi() {
		this.konponketaPrezioa = 75;
		this.suntziketaIrabazia = 50;
		this.egoera=new Osoa();
	}
	
	/**
	 * Itsasontzia urperatzeak dakarren irabazia adierazten du.
	 * @return irabazia
	 */
	protected int kalkulatuIrabazia() {
		return luzera*suntziketaIrabazia;
	}
	
	
	/**
	 * Itsasontziaren luzuera buletatzen du.
	 * @return itsasontziaren luzera.
	 */
	public int getLuzera() {
		return luzera;
	}
	/**
	 * Gelaxka batean itsasontziaren egoera ukituta dagoen ala ez adierazteko erabiltzen da.
	 * @return true gelaxka ukituta ez badago eta false bestela.
	 */
	public boolean ukitutaDago() {
		if(egoera instanceof Ukituta) return true;
		return false;
	}
	/**
	 * Galaxka batean itsasontziaren egoera ukitu gabea den adierazteko erabiltzen da.
	 * @return true gelaxka ukituta gabe badago eta false bestela.
	 */
	public boolean osoaDago() {
		if(egoera instanceof Osoa) return true;
		return false;
	}
	/**
	 * Isasontzia urperatuta dagoen ala ez jakiteko erabiltzen da.
	 * @return true itsasontzia urperatuta badago eta false bestela.
	 */
	public boolean urperatutaDago() {
		if(egoera instanceof Urperatuta) return true;
		return false;
	}
	/**
	 * Gelaxka batean ezkutua dagoen ala ez jakiteko erabiltzen da.
	 * @return true ezkutua badago eta false bestela
	 */
	public boolean ezkututaDago() {
		if(egoera instanceof Ezkutu) return true;
		return false;
	}
	
	/**
	 * Itsasontziaren gelaxkaren egoera aldatzeko earbiltzen da.
	 * @param pEgoera egoera
	 */
	public void egoeraAldatu(EgoeraState pEgoera){ //usarlo para poner un barco entero urperatuta
		egoera=pEgoera;	
	}
	
	/**
	 * Gelaxkan dagoen itsasontziaren gainean arma bat erabiltzen denean.
	 * @param pArma erabili den arma
	 */
	public void egoeraKlik(Arma pArma) {
		egoera.egoeraKlik(this, pArma);
	}
}
