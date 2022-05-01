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
		if(tablero.itsasontziaDuGelaxka(x, y)) {
			if(!tablero.ezkutuaDago(x, y)) {
				if(!tablero.urperatutaDago(x, y)) { //!super.ontziOsoaUrperatuDu(x, y)
					ezkutuaIpini(x, y, tablero);
					return true;
				}else {
					//posizio horretan dagoen itsasontzia ondoratuta dago:
					setChanged();
					notifyObservers(new int[] {x,y,10});
				}
			}
			else {
				//posizio horretan jadanik dago ezkutu bat:
				setChanged();
				notifyObservers(new int[] {x,y,9});
			}
		}
		else {
			//posizio horretan ezkutu bat ezin du ipini:
			setChanged();
			notifyObservers(new int[] {x,y,8});
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
		int hX=x;
		int hY=y;
		while(y>=0 && tablero.itsasontziaDuGelaxka(x, y)) { //gorantz begiratu
			//this.nireItsasontziak.setEzkutua(x, y, 2);
			tablero.gelaxkariArmaAplikatu(x, y, new Ezkutua());
			setChanged();
			notifyObservers(new int[] {x,y,7});
			y--;
		}
		y=hY+1;
		while (y<=9 && tablero.itsasontziaDuGelaxka(x, y)) { //beherantz begiratu
			tablero.gelaxkariArmaAplikatu(x, y, new Ezkutua());
			setChanged();
			notifyObservers(new int[] {x,y,7});
			y++;
		}
		y=hY;
		while (x>=0 && tablero.itsasontziaDuGelaxka(x, y)) { //ezkerrerantz begiratu
			tablero.gelaxkariArmaAplikatu(x, y, new Ezkutua());
			setChanged();
			notifyObservers(new int[] {x,y,7});
			x--;
		}
		x=hX+1;
		while (x<=9 && tablero.itsasontziaDuGelaxka(x, y)) { //eskuinerantz begiratu
			tablero.gelaxkariArmaAplikatu(x, y, new Ezkutua());
			setChanged();
			notifyObservers(new int[] {x,y,7});
			x++;
		}
	}
}
