package eredua;

public class Misil extends Arma implements ArmaSuntsitzaile{
	
	public Misil() {super(250);}
	
	public Misil(int pKantitatea) {
		super(250, pKantitatea);
	}
	
	public boolean erabili(int x, int y, Tablero tablero) {
		FlotaUrperatu fu=FlotaUrperatu.getNireFlotaUrperatu();
		if(tablero.itsasontziaDuGelaxka(x, y)) {
			if(tablero.ezkutuaDago(x, y)) {
				if(!fu.getTxanda()) Bot.getNireBot().koordenatuakGogoratu(x, y);
				ezkutuaKendu(x,y, tablero);
			}
			else ontziaUrperatu(x, y, tablero);
		}else {
				FlotaUrperatu.getNireFlotaUrperatu().bistanEkintzaBurutu(x, y, 0);
				tablero.gelaxkariArmaAplikatu(x, y, new Bonba());
				if(FlotaUrperatu.getNireFlotaUrperatu().getTxanda()) JokNormal.getNireJok().gelaxkaUkituaJarri(x, y);
				else Bot.getNireBot().gelaxkaUkituaJarri(x, y);
			}	
		return true;
	}	
	
	private void ezkutuaKendu(int x, int y, Tablero tablero) {
		FlotaUrperatu fu= FlotaUrperatu.getNireFlotaUrperatu();
		int hX=x;
		int hY=y;
		while(y>=0 && tablero.itsasontziaDuGelaxka(x, y)) {
			tablero.gelaxkariArmaAplikatu(x, y, new Bonba());;
			fu.bistanEkintzaBurutu(x, y, 3, 0,0);
			y--;
		}
		y=hY+1;
		while (y<=9 && tablero.itsasontziaDuGelaxka(x, y)) {
			tablero.gelaxkariArmaAplikatu(x, y, new Bonba());;
			fu.bistanEkintzaBurutu(x, y, 3, 0,0);
			y++;
		}
		y=hY;
		x=hX-1;
		while (x>=0 && tablero.itsasontziaDuGelaxka(x, y)) {
			tablero.gelaxkariArmaAplikatu(x, y, new Bonba());;
			fu.bistanEkintzaBurutu(x, y, 3, 0,0);
			x--;
		}
		x=hX+1;
		while (x<=9 && tablero.itsasontziaDuGelaxka(x, y)) {
			tablero.gelaxkariArmaAplikatu(x, y, new Bonba());;
			fu.bistanEkintzaBurutu(x, y, 3, 0,0);
			x++;
		}
	}
}
