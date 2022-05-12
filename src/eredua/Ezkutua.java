package eredua;

public class Ezkutua extends Arma{

	public Ezkutua() {super(300);}
	
	public Ezkutua(int pKantitatea) {
		super(300,pKantitatea);
	}
	
	/**
	 * Jokalariak (x,y) posizioan ezkutu bat jarri nahi dela adierazi du. 
	 * Bertan ezkutu bat jarri dezakeen konprobatuko da. Hala bada, ezkutua
	 * jarriko zaio bertan dagoen itsaontzi osoari.
	 * @param x koordenatua
	 * @param y koordenatua
	 */
	
	public boolean erabili(int x, int y, Tablero tablero) {
		FlotaUrperatu fu=FlotaUrperatu.getNireFlotaUrperatu();
		if(tablero.itsasontziaDuGelaxka(x, y)) {
			if(!tablero.ezkutuaDago(x, y)) {
				if(this.ontziaOsoaDago(x, y, tablero)) { //!super.ontziOsoaUrperatuDu(x, y)
					ezkutuaIpini(x, y, tablero);
					return true;
				}else {
					//posizio horretan dagoen itsasontzia ondoratuta dago:
					fu.bistanEkintzaBurutu(x, y, 10);
					/*setChanged();
					notifyObservers(new int[] {x,y,10});*/
				}
			}
			else {
				//posizio horretan jadanik dago ezkutu bat:
				fu.bistanEkintzaBurutu(x, y, 9);
				/*setChanged();
				notifyObservers(new int[] {x,y,9});*/
			}
		}
		else {
			//posizio horretan ezkutu bat ezin du ipini:
			fu.bistanEkintzaBurutu(x, y, 8);
			/*setChanged();
			notifyObservers(new int[] {x,y,8});*/
		}
		return false;
	}
	
	/**
	 * (x,y) posizioan level motako ezkutua jarriko da.
	 * @param x koordenatua
	 * @param y koordenatua
	 * @param level ezktuari jarriko zaion bizitza
	 */
	private void ezkutuaIpini(int x,int y, Tablero tablero) {
		FlotaUrperatu fu=FlotaUrperatu.getNireFlotaUrperatu();
		int hX=x;
		int hY=y;
		while(y>=0 && tablero.itsasontziaDuGelaxka(x, y)) { //gorantz begiratu
			//this.nireItsasontziak.setEzkutua(x, y, 2);
			tablero.gelaxkariArmaAplikatu(x, y, new Ezkutua());
			fu.bistanEkintzaBurutu(x, y, 7);
			/*setChanged();
			notifyObservers(new int[] {x,y,7});*/
			y--;
		}
		y=hY+1;
		while (y<=9 && tablero.itsasontziaDuGelaxka(x, y)) { //beherantz begiratu
			tablero.gelaxkariArmaAplikatu(x, y, new Ezkutua());
			fu.bistanEkintzaBurutu(x, y, 7);
			/*setChanged();
			notifyObservers(new int[] {x,y,7});*/
			y++;
		}
		y=hY;
		while (x>=0 && tablero.itsasontziaDuGelaxka(x, y)) { //ezkerrerantz begiratu
			tablero.gelaxkariArmaAplikatu(x, y, new Ezkutua());
			fu.bistanEkintzaBurutu(x, y, 7);
			/*setChanged();
			notifyObservers(new int[] {x,y,7});*/
			x--;
		}
		x=hX+1;
		while (x<=9 && tablero.itsasontziaDuGelaxka(x, y)) { //eskuinerantz begiratu
			tablero.gelaxkariArmaAplikatu(x, y, new Ezkutua());
			fu.bistanEkintzaBurutu(x, y, 7);
			/*setChanged();
			notifyObservers(new int[] {x,y,7});*/
			x++;
		}
	}
	
	private boolean ontziaOsoaDago(int x, int y, Tablero tablero) {
		boolean osoa=true;
		boolean goikoak=true;
		boolean behekoak=true;
		boolean ezkerrekoak=true;
		boolean eskumakoak=true;
			
		if (x>0 && tablero.itsasontziaDuGelaxka(x-1, y) ) { 
			ezkerrekoak=this.ezkerrekoakAztertu( x-1, y, tablero); 
		}
		
		if (x<9 && tablero.itsasontziaDuGelaxka(x+1, y)) {
			eskumakoak=this.eskumakoakAztertu( x+1, y, tablero);
		}
					
		if (y>0 && tablero.itsasontziaDuGelaxka(x, y-1)) {
			goikoak=this.goikoakAztertu( x, y-1, tablero);	
		}
		
		if (y<9 && tablero.itsasontziaDuGelaxka(x, y+1)) {
			behekoak=this.behekoakAztertu( x, y+1, tablero);
		}
		
		if (ezkerrekoak && eskumakoak && goikoak && behekoak) { //guztiak ukituta daudenean, (ez duzu ez ukiturik aurkitu) orduan itsasontzia urperatuta dago
			osoa=true;
		}else osoa=false;
				
		return osoa;
	}
	
	/**
	 * (x,y) posiziotik gora, itsasontzia duten gelaxkak badadude, hauek ukituta dauden ala ez aztertuko du. 
	 * @param x koordenatua
	 * @param y koordenatua
	 * @return true ukituta ez dagoen gelaxka aurkitzen badu edo false bestela.
	 */
	private boolean goikoakAztertu(int x, int y, Tablero tablero) { 
		boolean aurkitua=true;
		while (aurkitua && y>=0 && tablero.itsasontziaDuGelaxka(x, y)) {
			if (!tablero.osoaDago(x, y)) {
				aurkitua=false;
			}
			y--;
		}
		return aurkitua;
	}
	
	/**
	 * (x,y) posiziotik behera, itsasontzia duten gelaxkak badadude, hauek ukituta dauden ala ez aztertuko du. 
	 * @param x koordenatua
	 * @param y koordenatua
	 * @return true ukituta ez dagoen gelaxka aurkitzen badu edo false bestela.
	 */
	private boolean behekoakAztertu(int x, int y, Tablero tablero) {
		boolean aurkitua=true;
		while (aurkitua && y<=9 && tablero.itsasontziaDuGelaxka(x, y)) {
			if (!tablero.osoaDago(x, y)) {
				aurkitua=false;
			}
			y++;
		}
		return aurkitua;
	}
	
	/**
	 * (x,y) posiziotik ezkerrera, itsasontzia duten gelaxkak badadude, hauek ukituta dauden ala ez aztertuko du. 
	 * @param x koordenatua
	 * @param y koordenatua
	 * @return true ukituta ez dagoen gelaxka aurkitzen badu edo false bestela.
	 */
	private boolean ezkerrekoakAztertu(int x, int y, Tablero tablero) {
		boolean aurkitua=true;
		while (aurkitua && x>=0 && tablero.itsasontziaDuGelaxka(x, y)) {
			if (!tablero.osoaDago(x, y)) {
				aurkitua=false;
			}
			x--;
		}
		return aurkitua;
	}
	
	/**
	 * (x,y) posiziotik eskuinera, itsasontzia duten gelaxkak badadude, hauek ukituta dauden ala ez aztertuko du. 
	 * @param x koordenatua
	 * @param y koordenatua
	 * @return true ukituta ez dagoen gelaxka aurkitzen badu edo false bestela.
	 */
	private boolean eskumakoakAztertu(int x, int y, Tablero tablero) {
		boolean aurkitua=true;
		while (aurkitua && x<=9 && tablero.itsasontziaDuGelaxka(x, y)) {
			if (!tablero.osoaDago(x, y)) {
				aurkitua=false;
			}
			x++;
		}
		return aurkitua;
	}
}
