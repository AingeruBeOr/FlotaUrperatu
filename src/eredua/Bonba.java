package eredua;

public class Bonba extends Arma {
	
	public Bonba() {super();}
	
	public boolean erabili(int x, int y, Tablero tablero) {
		if(tablero.ezkutuaDago(x, y)) tablero.ezkutuaXTxikitu(x, y, 1);
		else {
			if(tablero.itsasontziaDuGelaxka(x, y)) {
				if (ontziOsoaUkituDu(x,y)) ontziaUrperatu(x,y);
				else {
					setChanged();
					notifyObservers(new int[] {x,y,1});
				}
			}else {
				setChanged();
				notifyObservers(new int[] {x,y,0});
			}
			Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
			ukituak[x][y]=true; //JokNormal.getNireJok().ukituak.gelaxkaUkituaIpini(x, y);
		}
		return true;
	}
}
