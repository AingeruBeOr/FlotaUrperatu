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
						//tablero.gelaxkariArmaAplikatu(i, j, new Radarra());
						
						/*setChanged();
						notifyObservers(new int[] {i,j,4});*/
						aurkituDu=true;
					}
					else if(!tablero.itsasontziaDuGelaxka(i,j)) {
						fu.bistanEkintzaBurutu(i,j,0);
						/*setChanged();
						notifyObservers(new int[] {i,j,0});*/
						//tablero.gelaxkariArmaAplikatu(x, y, new Bonba());
						if(FlotaUrperatu.getNireFlotaUrperatu().getTxanda()) {
							System.out.println("Ukitu dudan kasilla: x "+i+" eta y "+j);
							//JokNormal.getNireJok().ukituak[i][j]=true; 
							JokNormal.getNireJok().nireUkituetanGelaxkaAldatu(x, y);
						}else {
							//Bot.getNireBot().ukituak[i][j]=true;
							Bot.getNireBot().nireUkituetanGelaxkaAldatu(x, y);
						}
					}
				}			
			}
		}
		if (!aurkituDu) {
			fu.bistanEkintzaBurutu(x,y,4);
			/*setChanged();
			notifyObservers(new int[] {x,y,6});*/
		}
		return true;
	}
}

