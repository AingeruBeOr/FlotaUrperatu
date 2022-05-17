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
	 * @param tablero
	 * @return true bueltatuko du arma erabiltzea lortu badu eta false bestela
	 */
	public boolean erabili(int x, int y, Tablero tablero) {
		FlotaUrperatu fu=FlotaUrperatu.getNireFlotaUrperatu();
		if(tablero.itsasontziaDuGelaxka(x, y)) {
			if(!tablero.ezkutuaDago(x, y)) {
				if(this.ontziaOsoaDago(x, y, tablero)) {
					ezkutuaIpini(x, y, tablero);
					return true;
				}else {
					//posizio horretan dagoen itsasontzia ondoratuta dago:
					if(fu.getTxanda()) fu.bistanEkintzaBurutu(x, y, 10);
				}
			}
			else {
				//posizio horretan jadanik dago ezkutu bat:
				if(fu.getTxanda()) fu.bistanEkintzaBurutu(x, y, 9);
			}
		}
		else {
			//posizio horretan ezkutu bat ezin du ipini itsasontzirik ez dagoelako
			if(fu.getTxanda()) fu.bistanEkintzaBurutu(x, y, 8);
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
			tablero.gelaxkariArmaAplikatu(x, y, new Ezkutua());
			fu.bistanEkintzaBurutu(x, y, 7);
			y--;
		}
		y=hY+1;
		while (y<=9 && tablero.itsasontziaDuGelaxka(x, y)) { //beherantz begiratu
			tablero.gelaxkariArmaAplikatu(x, y, new Ezkutua());
			fu.bistanEkintzaBurutu(x, y, 7);
			y++;
		}
		y=hY;
		while (x>=0 && tablero.itsasontziaDuGelaxka(x, y)) { //ezkerrerantz begiratu
			tablero.gelaxkariArmaAplikatu(x, y, new Ezkutua());
			fu.bistanEkintzaBurutu(x, y, 7);
			x--;
		}
		x=hX+1;
		while (x<=9 && tablero.itsasontziaDuGelaxka(x, y)) { //eskuinerantz begiratu
			tablero.gelaxkariArmaAplikatu(x, y, new Ezkutua());
			fu.bistanEkintzaBurutu(x, y, 7);
			x++;
		}
	}
	
	/**
	 * Aurrebaldintza: badakigu (x,y) posizioan badagoela itsasontzi bat.
	 * (x,y) posizioan dagoen ontzia osoa dagoen edo punturen batean ukitua daogen jakiteko erabiltzen da.
	 * @param x koordenatua
	 * @param y koordenatua
	 * @param tablero
	 * @return
	 */
	private boolean ontziaOsoaDago(int x, int y, Tablero tablero) {
		if(!tablero.osoaDago(x, y)) return false;
		if (x>0 && tablero.itsasontziaDuGelaxka(x-1, y) ) if(!ezkerrekoakAztertu(x-1, y, tablero)) return false;
		if (x<9 && tablero.itsasontziaDuGelaxka(x+1, y)) if(!eskumakoakAztertu(x+1, y, tablero)) return false;
		if (y>0 && tablero.itsasontziaDuGelaxka(x, y-1)) if(!goikoakAztertu(x, y-1, tablero)) return false;
		if (y<9 && tablero.itsasontziaDuGelaxka(x, y+1)) if(!behekoakAztertu(x, y+1, tablero)) return false;
		return true;
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
			if (!tablero.osoaDago(x, y)) aurkitua=false;
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
			if (!tablero.osoaDago(x, y)) aurkitua=false;
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
			if (!tablero.osoaDago(x, y)) aurkitua=false;
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
			if (!tablero.osoaDago(x, y)) aurkitua = false;
			x++;
		}
		return aurkitua;
	}
}
