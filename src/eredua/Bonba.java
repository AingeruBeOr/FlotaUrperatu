package eredua;
import java.util.Random;

public class Bonba extends Arma implements ArmaSuntsitzaile{
	
	public Bonba() {super();}
	
	/**
	 * Hurrengoa egiten da:
	 * <ol>
	 * 		<li>Parametroaren tableroan (x,y) kooordenatuan itsasontzia badago:
	 * 		<ol>
	 * 			<li>(x,y) koordenatuan tableroa badago:</li>
	 * 		</ol>
	 * 		</li>
	 * 		<li>Parametroaren tableroan (x,y) kooordenatuan itsasontzia ez badago:</li>
	 * 		
	 * </ol>
	 */
	@Override
	public boolean erabili(int x, int y, Tablero tablero) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		boolean ezkutuaDago = false;
		if(tablero.itsasontziaDuGelaxka(x, y)) {
			if(tablero.ezkutuaDago(x, y)) {
				ezkutuaDago = true;
				if(!fu.getTxanda()) Bot.getNireBot().koordenatuakGogoratu(x, y);
				this.ezkutuaTxikitu(x, y, tablero);
			}
			else {
				if (ontziOsoaUkituDu(x,y, tablero)) ontziaUrperatu(x, y, tablero);
				else {
					tablero.gelaxkariArmaAplikatu(x, y, new Bonba());;
					fu.bistanEkintzaBurutu(x, y,1);
				}
			}
		}
		else {
			fu.bistanEkintzaBurutu(x, y, 0);
		}
		if(!ezkutuaDago) {
			if(FlotaUrperatu.getNireFlotaUrperatu().getTxanda()) JokNormal.getNireJok().gelaxkaUkituaJarri(x, y);
			else Bot.getNireBot().gelaxkaUkituaJarri(x, y);
		}
		return true;
	}
	
	/**
	 * (x,y) posizioan dagoen itsasontzia urperatuta dagoen ala ez konprobatuko da.
	 * @param x koordenatua
	 * @param y koordenatua
	 * @return true itsasontzia urperatuta badago eta false bestela.
	 */
	public boolean ontziOsoaUkituDu(int x, int y, Tablero tablero) {
		boolean urperatuta=false;
		boolean goikoak=false;
		boolean behekoak=false;
		boolean ezkerrekoak=false;
		boolean eskumakoak=false;
		FlotaUrperatu fu= FlotaUrperatu.getNireFlotaUrperatu();
		Random r=new Random();
		int gogoratu=r.nextInt(5);
		
		if (x>0 && tablero.itsasontziaDuGelaxka(x-1, y) ) { 
			ezkerrekoak=this.ezkerrekoakAztertu(x-1, y, tablero); 	
			if(!fu.getTxanda() && gogoratu==1) Bot.getNireBot().koordenatuakGogoratu(x-1, y);
		}
		
		if (x<9 && tablero.itsasontziaDuGelaxka(x+1, y)) {
			eskumakoak=this.eskumakoakAztertu( x+1, y, tablero);
			if(!fu.getTxanda() && gogoratu==1) Bot.getNireBot().koordenatuakGogoratu(x+1, y);
		}
					
		if (y>0 && tablero.itsasontziaDuGelaxka(x, y-1)) {
			goikoak=this.goikoakAztertu( x, y-1, tablero);	
			if(!fu.getTxanda() && gogoratu==1) Bot.getNireBot().koordenatuakGogoratu(x, y-1);
		}
		
		if (y<9 && tablero.itsasontziaDuGelaxka(x, y+1)) {
			behekoak=this.behekoakAztertu( x, y+1, tablero);
			if(!fu.getTxanda() && gogoratu==1) Bot.getNireBot().koordenatuakGogoratu(x, y+1);
		}
		
		if (!ezkerrekoak && !eskumakoak && !goikoak && !behekoak) { //guztiak ukituta daudenean, (ez duzu ez ukiturik aurkitu) orduan itsasontzia urperatuta dago
			urperatuta=true;
		}
		if (urperatuta) FlotaUrperatu.getNireFlotaUrperatu().bistanEkintzaBurutu(x, y, 5);
		return urperatuta;
	}
	
	/**
	 * (x,y) posiziotik gora, itsasontzia duten gelaxkak badadude, hauek ukituta dauden ala ez aztertuko du. 
	 * @param x koordenatua
	 * @param y koordenatua
	 * @return true ukituta ez dagoen gelaxka aurkitzen badu edo false bestela.
	 */
	private boolean goikoakAztertu(int x, int y, Tablero tablero) { 
		boolean aurkitua=false;
		while (!aurkitua && y>=0 && tablero.itsasontziaDuGelaxka(x, y)) {
			if (!tablero.ukitutaEdoUrperatutaZegoen(x, y)) {
				aurkitua=true;
			}
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
		boolean aurkitua=false;
		while (!aurkitua && y<=9 && tablero.itsasontziaDuGelaxka(x, y)) {
			if (!tablero.ukitutaEdoUrperatutaZegoen(x, y)) {
				aurkitua=true;
			}
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
		boolean aurkitua=false;
		while (!aurkitua && x>=0 && tablero.itsasontziaDuGelaxka(x, y)) {
			if (!tablero.ukitutaEdoUrperatutaZegoen(x, y)) {
				aurkitua=true;
			}
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
		boolean aurkitua=false;
		while (!aurkitua && x<=9 && tablero.itsasontziaDuGelaxka(x, y)) {
			if (!tablero.ukitutaEdoUrperatutaZegoen(x, y)) {
				aurkitua=true;
			}
			x++;
		}
		return aurkitua;
	}
	
	private void ezkutuaTxikitu(int x, int y, Tablero tablero) {
		FlotaUrperatu fu= FlotaUrperatu.getNireFlotaUrperatu();
		int hX=x;
		int hY=y;
		int lehena=0;
		while(y>=0 && tablero.itsasontziaDuGelaxka(x, y)) {
			tablero.gelaxkariArmaAplikatu(x, y, new Bonba());;
			if(tablero.ezkutuaDago(x, y)) fu.bistanEkintzaBurutu(x, y, 3, 1, lehena);
			else fu.bistanEkintzaBurutu(x, y, 3, 0, lehena);
			lehena++;
			y--;
		}
		y=hY+1;
		while (y<=9 && tablero.itsasontziaDuGelaxka(x, y)) {
			tablero.gelaxkariArmaAplikatu(x, y, new Bonba());;
			if(tablero.ezkutuaDago(x, y)) fu.bistanEkintzaBurutu(x, y, 3, 1, lehena);
			else fu.bistanEkintzaBurutu(x, y, 3, 0, lehena);
			y++;
		}
		y=hY;
		x=hX-1;
		while (x>=0 && tablero.itsasontziaDuGelaxka(x, y)) {
			tablero.gelaxkariArmaAplikatu(x, y, new Bonba());;
			if(tablero.ezkutuaDago(x, y)) fu.bistanEkintzaBurutu(x, y, 3, 1, lehena);
			else fu.bistanEkintzaBurutu(x, y, 3, 0, lehena);
			x--;
		}
		x=hX+1;
		while (x<=9 && tablero.itsasontziaDuGelaxka(x, y)) {
			tablero.gelaxkariArmaAplikatu(x, y, new Bonba());;
			if(tablero.ezkutuaDago(x, y)) fu.bistanEkintzaBurutu(x, y, 3, 1, lehena);
			else fu.bistanEkintzaBurutu(x, y, 3, 0, lehena);
			x++;
		}
	}
}
