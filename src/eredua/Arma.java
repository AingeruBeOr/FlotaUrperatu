package eredua;
import java.util.Observable;

public abstract class Arma extends Observable {
	protected int prezioa;
	protected int kantitatea;
	
	public Arma() {}
	
	public Arma(int pPrezioa) {
		prezioa = pPrezioa;
	}
	
	public Arma(int pPrezioa, int pKantitatea) {
		this.prezioa = pPrezioa;
		this.kantitatea = pKantitatea;
	}
	
	public int kantitatea1unitateJaitsi() {
		return --kantitatea;
	}
	
	public int getKop() {
		return kantitatea;
	}
	
	public void setKop(int pKop) {this.kantitatea = pKop;}
	
	public int getPrezioa() {
		return prezioa;
	}
	
	/**
	 * 
	 * @param x arma erabiliko den tableoaren gaineko x koordenatua
	 * @param y arma erabiliko den tableraren gaineko y koordenatua
	 * @param tablero Tablero klasearen instantzia bat da non arma berearen gainean erabili beharko den
	 * @return true bueltatuko du arma erabiltzea lortu bada eta false bestela
	 */
	public abstract boolean erabili(int x, int y, Tablero tablero);
	
	protected void ontziaUrperatu(int x, int y, Tablero tablero) {
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
	
	protected void goikoakUrperatu ( int x, int y, Tablero tablero) {
		while (y>=0 && tablero.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y, tablero);
			y--;
		}
	}
	
	protected void behekoakUrperatu ( int x, int y, Tablero tablero) {
		while (y<=9 && tablero.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y, tablero);
			y++;
		}
	}
	
	protected void ezkerrekoakUrperatu ( int x, int y, Tablero tablero) {
		while (x>=0 && tablero.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y, tablero);
			x--;
		}
	}
	
	protected void eskumakoakUrperatu ( int x, int y, Tablero tablero) {
		while (x<=9 && tablero.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y, tablero);
			x++;
		}
	}
	protected void gelaxkaUrperatu(int x, int y, Tablero tablero) {
		FlotaUrperatu.getNireFlotaUrperatu().bistanEkintzaBurutu(x, y, 2);;
		tablero.gelaxkariArmaAplikatu(x, y, new Misil());
		if(FlotaUrperatu.getNireFlotaUrperatu().getTxanda()) JokNormal.getNireJok().gelaxkaUkituaJarri(x, y);
		else Bot.getNireBot().gelaxkaUkituaJarri(x, y);
	}
}
