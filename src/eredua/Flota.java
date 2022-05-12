package eredua;

public class Flota {
	
	private ArmamentuZerrenda armak;
	private int dirua;
	
	public Flota() {
		dirua=1000;
		armak=new ArmamentuZerrenda(0,0,0);
	}
	/**
	 * Parametro bezala adierazitako arma motaren kantitatea -1 txikituko du
	 * @param arma eguneratuko duen arma mota
	 * @return arma mota horreatako zenbat unitate geratzen zaizkion
	 */
	public int armaKantitateaEguneratu(Arma arma) {return armak.armaKantitateaEguneratu(arma);}
	
	/**
	 * Parametro bezala pasatzen zaion arma kantitatea itzuliko du
	 * @param arma ezagutu nahi den arma motaren unitate kopurua
	 * @return 
	 */
	public int getArmaKop(Arma arma) {return armak.getArmaKop(arma);}
	
	/**
	 * Armamentua erostean, arma kantitatea eguneratu behar da.
	 * @param pArma eguneratuko den arma mota
	 * @param pKop erositako arma kopurua
	 */
	public void armamentuaErosi(Arma pArma, int pKop) {
		armak.armamentuaErosi(pArma, pKop);
	}
	
	/**
	 * Jokalariaren dirua bueltatzen du
	 * @return
	 */
	public int getDirua() {return this.dirua;}
	
	/**
	 * Jokalariraren dirua eguneratzen du
	 * @param pDiru geratuko den ditu kantitate berria
	 */
	public void setDirua(int pDiru) {this.dirua = pDiru;}
	

	public void erosketaPrezioaKendu(){ 
			  dirua = dirua - 75;
	}
		
	public void suntziketaPrezioaGehitu(){ 
			  dirua = dirua + 50;
	}
}
