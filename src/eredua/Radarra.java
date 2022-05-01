package eredua;

public class Radarra extends Arma{
	
	public Radarra() {super(400);}
	
	public Radarra(int pKantitatea) {
		super(400, pKantitatea);
	}
	
	public boolean erabili(int x, int y, Tablero tablero) {
		boolean aurkituDu=false;
		for(int i=x-1; i<=x+1; i++) {
			for(int j=y-1; j<=y+1; j++) {
				if(i>=0 && i<=9 && j>=0 && j<=9 ) {
					if (tablero.itsasontziaDuGelaxka(i, j) && !tablero.ukitutaEdoUrperatutaZegoen(i, j)){
						setChanged();
						notifyObservers(new int[] {i,j,4});
						aurkituDu=true;
					}
					else if(!tablero.itsasontziaDuGelaxka(i, j)) {
						setChanged();
						notifyObservers(new int[] {i,j,0});
						tablero.gelaxkariArmaAplikatu(x, y, new Bonba());
						if(FlotaUrperatu.getNireFlotaUrperatu().getTxanda()) {
							JokNormal.getNireJok().ukituak[x][y]=true; 
						}else {
							Bot.getNireBot().ukituak[x][y]=true;
						}
					}
				}			
			}
		}
		if (!aurkituDu) {
			setChanged();
			notifyObservers(new int[] {x,y,6});
		}
		return true;
	}
}

