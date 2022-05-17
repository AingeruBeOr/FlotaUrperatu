package eredua;

public class Radarra extends Arma{
	
	public Radarra() {super(400);}
	
	public Radarra(int pKantitatea) {
		super(400, pKantitatea);
	}
	
	public boolean erabili(int x, int y, Tablero tablero) {
		FlotaUrperatu fu=FlotaUrperatu.getNireFlotaUrperatu();
		boolean aurkituDu=false;
		for(int i=x-1; i<=x+1; i++) {
			for(int j=y-1; j<=y+1; j++) {
				if(i>=0 && i<=9 && j>=0 && j<=9 ) {
					if (tablero.itsasontziaDuGelaxka(i,j) && !tablero.ukitutaEdoUrperatutaZegoen(i,j)){
						fu.bistanEkintzaBurutu(i,j,4);
						if(!fu.getTxanda()) Bot.getNireBot().koordenatuakGogoratu(i, j);
						aurkituDu=true;
					}
					else if(!tablero.itsasontziaDuGelaxka(i,j)) {
						fu.bistanEkintzaBurutu(i,j,0);
						if(FlotaUrperatu.getNireFlotaUrperatu().getTxanda()) JokNormal.getNireJok().ukituak[i][j]=true; 
						else Bot.getNireBot().ukituak[i][j]=true;
					}
				}			
			}
		}
		if (!aurkituDu) fu.bistanEkintzaBurutu(x,y,6);
		return true;
	}
}

