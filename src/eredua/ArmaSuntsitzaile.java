package eredua;

public interface ArmaSuntsitzaile {
	
	public default void ontziaUrperatu(int x, int y, Tablero tablero) {
		gelaxkaUrperatu(x,y, tablero);
		
		if (FlotaUrperatu.getNireFlotaUrperatu().getTxanda()){
			JokNormal.getNireJok().ontziaUrperatzeanDirua(tablero.kalkulatuIrabazi(x, y));
		}
		else Bot.getNireBot().ontziaUrperatzeanDirua(tablero.kalkulatuIrabazi(x, y));
		
		if (x>0 && tablero.itsasontziaDuGelaxka(x-1, y)) ezkerrekoakUrperatu( x-1, y, tablero); 	
		if (x<9 && tablero.itsasontziaDuGelaxka(x+1, y)) eskumakoakUrperatu( x+1, y, tablero);	
		if (y>0 && tablero.itsasontziaDuGelaxka(x, y-1)) goikoakUrperatu( x, y-1, tablero);	
		if (y<9 && tablero.itsasontziaDuGelaxka(x, y+1)) behekoakUrperatu( x, y+1, tablero);
	}
	
	private void goikoakUrperatu ( int x, int y, Tablero tablero) {
		while (y>=0 && tablero.itsasontziaDuGelaxka(x, y)) {
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
	private void gelaxkaUrperatu(int x, int y, Tablero tablero) {
		FlotaUrperatu.getNireFlotaUrperatu().bistanEkintzaBurutu(x, y, 2);;
		tablero.gelaxkariArmaAplikatu(x, y, new Misil());
		if(FlotaUrperatu.getNireFlotaUrperatu().getTxanda()) JokNormal.getNireJok().gelaxkaUkituaJarri(x, y);
		else Bot.getNireBot().gelaxkaUkituaJarri(x, y);
	}
}
