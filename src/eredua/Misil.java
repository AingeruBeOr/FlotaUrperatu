package eredua;

public class Misil extends Arma {
	
	public Misil() {super(250);}
	
	public Misil(int pKantitatea) {
		super(250, pKantitatea);
	}
	
	public boolean erabili(int x, int y, Tablero tablero) {
		if(tablero.itsasontziaDuGelaxka(x, y)) ontziaUrperatu(x, y, tablero);
			else {
				FlotaUrperatu.getNireFlotaUrperatu().bistanEkintzaBurutu(x, y, 0);
				setChanged();
				notifyObservers(new int[] {x,y,0});
				tablero.gelaxkariArmaAplikatu(x, y, new Bonba());
				if(FlotaUrperatu.getNireFlotaUrperatu().getTxanda()) {
					JokNormal.getNireJok().ukituak[x][y]=true; 
				}else {
					Bot.getNireBot().ukituak[x][y]=true;
				}
			}	
		return true;
	}
	
	private void ontziaUrperatu(int x, int y, Tablero tablero) {
		gelaxkaUrperatu(x,y, tablero);
		if (x>0 && tablero.itsasontziaDuGelaxka(x-1, y) ) { 
			this.ezkerrekoakUrperatu( x-1, y, tablero); 	
		}
		if (x<9 && tablero.itsasontziaDuGelaxka(x+1, y)) {
			this.eskumakoakUrperatu( x+1, y, tablero);	
		}
		if (y>0 && tablero.itsasontziaDuGelaxka(x, y-1)) {
			this.goikoakUrperatu( x, y-1, tablero);	
		}
		if (y<9 && tablero.itsasontziaDuGelaxka(x, y+1)) {
			this.behekoakUrperatu( x, y+1, tablero);
		}
	}
	
	private void goikoakUrperatu ( int x, int y, Tablero tablero) {
		while (y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y, tablero);
			y--;
		}
	}
	private void behekoakUrperatu ( int x, int y, Tablero tablero) {
		while (y<=9 && tablero.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y, tablero);
			y++;
		}
	}
	private void ezkerrekoakUrperatu ( int x, int y, Tablero tablero) {
		while (x>=0 && tablero.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y, tablero);
			x--;
		}
	}
	
	private void eskumakoakUrperatu ( int x, int y, Tablero tablero) {
		while (x<=9 && tablero.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y, tablero);
			x++;
		}
	}
	
	public void gelaxkaUrperatu(int x, int y, Tablero tablero) {
		//FlotaUrperatu.getNireFlotaUrperatu().bistanEkintzaBurutu(x, y, 2);;
		setChanged();
		notifyObservers(new int[] {x,y,2});
		tablero.gelaxkariArmaAplikatu(x, y, new Misil());
		if(FlotaUrperatu.getNireFlotaUrperatu().getTxanda()) {
			JokNormal.getNireJok().ukituak[x][y]=true; 
		}else {
			Bot.getNireBot().ukituak[x][y]=true;
		}
	}
}
