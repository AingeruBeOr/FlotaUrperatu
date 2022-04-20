package eredua;

import java.util.Observable;

public abstract class Jokalari extends Observable{
	protected float dirua;
	protected ArmamentuZerrenda armak;
	protected Tablero nireItsasontziak;
	protected Tablero ukituak;
	
	public Jokalari ( float pDiru ) {
		
		dirua=pDiru;
		armak = new ArmamentuZerrenda(1,0,0);
		//TODO
		ukituak=new Tablero();
		nireItsasontziak= new Tablero();
		//matrizeUkitu=new boolean[10][10];
		//matrizeOntzi=new boolean[10][10];
		/*for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				matrizeUkitu[i][j]=false;
			}
		}*/
	}
	
	protected abstract void txandaJokatu();
	protected abstract boolean tiroaOndoEginDu();
	protected abstract void armamentuaErosi();
	protected abstract void ontziaKonpondu();
	protected abstract void radarraKontsultatu();
	
	public boolean ontzirenBatGeratzenDa() {
		return nireItsasontziak.ontzirenBatGeratzenDa();
	}
	
	public boolean armaKantitateaEguneratu(Arma arma) {
		return armak.armaKantitateaEguneratu(arma);
	}
	
	//************************************ UKITUAK ZEHAZTEKO ***********************************************
	
	/**
	 * true bueltatuko du jadanik bertan jo badu edo false bestela
	 * @param x: x koordenatua
	 * @param y: y koordenatua
	 * @return 
	 */
	public boolean ukitutaZegoen(int x, int y) {
		return ukituak.ukitutaEdoUrperatutaZegoen(x, y);
	}
	
	/**
	 * true bueltatuko du adieraztiako posizioan itsasontzi bat ukitu badu edo false bestela
	 * @param x: x koordenatua
	 * @param y: y koordenatua
	 * @return
	 */
	public boolean ukituDuItsasontzia(int x, int y) {
		if(nireItsasontziak.itsasontziaDuGelaxka(x, y)) return true;
		else return false;
	}
	
	public void gelaxkaUrperatu(int x, int y) {
		
		setChanged();
		notifyObservers(new int[] {x,y,2});
		if(this instanceof Bot) {
			JokNormal.getNireJok().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
		}else {
			Bot.getNireBot().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
		}
		this.ukituak.gelaxkaUrperatutaIpini(x,y);
	}
	
	public void gelaxkaUkitutaIpini(int x, int y) {
		if(ukituDuItsasontzia(x,y)) {
			setChanged();
			notifyObservers(new int[] {x,y,1});
		}else {
			setChanged();
			notifyObservers(new int[] {x,y,0});
		}
		//TODO IGUAL ES AL REVES
		if(this instanceof Bot) {
			JokNormal.getNireJok().nireItsasontziak.gelaxkaUkituaIpini(x, y);
		}else {
			Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
		}
		this.ukituak.gelaxkaUkituaIpini(x,y);
	}
	
	
	//MISIL TIROA IZATEKOTAN
	public void misilTiroa( int x, int y) {
		if(ukituDuItsasontzia(x,y)) {
			gelaxkaUrperatu(x,y);
			if(this instanceof Bot) {
				if (x>0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x-1, y) ) { 
					this.ezkerrekoakUrperatu( x-1, y); 	
				}
				if (x<9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x+1, y)) {
					this.eskumakoakUrperatu( x+1, y);	
				}
							
				if (y>0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y-1)) {
					this.goikoakUrperatu( x, y-1);	
				}
				if (y<9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y+1)) {
					this.behekoakUrperatu( x, y+1);
				}
			}else {
				if (x>0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x-1, y) ) { 
					this.ezkerrekoakUrperatu( x-1, y); 	
				}
				if (x<9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x+1, y)) {
					this.eskumakoakUrperatu( x+1, y);	
				}
							
				if (y>0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y-1)) {
					this.goikoakUrperatu( x, y-1);	
				}
				if (y<9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y+1)) {
					this.behekoakUrperatu( x, y+1);
				}
			}
		}else {
			setChanged();
			notifyObservers(new int[] {x,y,0});
			if(this instanceof Bot) {
				JokNormal.getNireJok().nireItsasontziak.gelaxkaUkituaIpini(x, y);
			}else {
				Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
			}
			this.ukituak.gelaxkaUkituaIpini(x,y);
		}
		
		
	}
	
	private void goikoakUrperatu ( int x, int y) {
		if(this instanceof Bot) {
			while (y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				JokNormal.getNireJok().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
				y--;
			}
		}else {
			while (y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				Bot.getNireBot().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
				y--;
			}
		}
	}
	private void behekoakUrperatu ( int x, int y) {
		if(this instanceof Bot) {
			while (y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				JokNormal.getNireJok().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
				y++;
			}
		}else {
			while (y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				Bot.getNireBot().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
				y++;
			}
		}
	}
	private void ezkerrekoakUrperatu ( int x, int y) {
		if(this instanceof Bot) {
			while (y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				JokNormal.getNireJok().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
				x--;
			}
		}else {
			while (y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				Bot.getNireBot().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
				x--;
			}
		}
	}
	
	private void eskumakoakUrperatu ( int x, int y) {
		if(this instanceof Bot) {
			while (y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				JokNormal.getNireJok().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
				x++;
			}
		}else {
			while (y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				Bot.getNireBot().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
				x++;
			}
		}
	}
	
	
	public void ontziaUrperatu(int x, int y) {
			gelaxkaUrperatu(x,y);
			if(this instanceof Bot) {
				if (x>0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x-1, y) ) { 
					this.ezkerrekoakUrperatu( x-1, y); 	
				}
				if (x<9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x+1, y)) {
					this.eskumakoakUrperatu( x+1, y);	
				}
							
				if (y>0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y-1)) {
					this.goikoakUrperatu( x, y-1);	
				}
				if (y<9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y+1)) {
					this.behekoakUrperatu( x, y+1);
				}
			}else {
				if (x>0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x-1, y) ) { 
					this.ezkerrekoakUrperatu( x-1, y); 	
				}
				if (x<9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x+1, y)) {
					this.eskumakoakUrperatu( x+1, y);	
				}
							
				if (y>0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y-1)) {
					this.goikoakUrperatu( x, y-1);	
				}
				if (y<9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y+1)) {
					this.behekoakUrperatu( x, y+1);
				}
			}
	}
	
	public boolean ontziOsoaUrperatuDu(int x, int y) {
		boolean aurkitua=false;
		boolean guztiakAztertu=false;
		boolean goikoak=false;
		boolean behekoak=false;
		boolean ezkerrekoak=false;
		boolean eskumakoak=false;

		if(ukituDuItsasontzia(x,y)) {			
			while (!aurkitua && !guztiakAztertu) { //ontziaren zati ez ukitua aurkitzen ez duzun bitartean eta amaitzen (guztiak aztertu) ez den bitartean
				if(this instanceof Bot) {
					if (x>0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x-1, y) ) { 
						ezkerrekoak=this.ezkerrekoakAztertu( x-1, y); 	
					}
					if (x<9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x+1, y)) {
						eskumakoak=this.eskumakoakAztertu( x+1, y);	
					}
								
					if (y>0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y-1)) {
						goikoak=this.goikoakAztertu( x, y-1);	
					}
					if (y<9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y+1)) {
						behekoak=this.behekoakAztertu( x, y+1);
					}
					if (ezkerrekoak && eskumakoak && goikoak && behekoak) {
						aurkitua=true;
					}
					guztiakAztertu=true;
				}else {
					if (x>0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x-1, y) ) { 
						ezkerrekoak=this.ezkerrekoakAztertu( x-1, y); 	
					}
					if (x<9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x+1, y)) {
						eskumakoak=this.eskumakoakAztertu( x+1, y);	
					}
								
					if (y>0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y-1)) {
						goikoak=this.goikoakAztertu( x, y-1);	
					}
					if (y<9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y+1)) {
						behekoak=this.behekoakAztertu( x, y+1);
					}
					if (ezkerrekoak && eskumakoak && goikoak && behekoak) {
						aurkitua=true;
					}
					guztiakAztertu=true;
				}
			}
		}
		return aurkitua;
	}
	
	private boolean goikoakAztertu(int x, int y) {
		boolean aurkitua=false;
		if(this instanceof Bot) {
			while (!aurkitua && y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
				if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				y--;
			}	
		}else {
			while (!aurkitua && y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				if (!Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				y--;
			}
		}
		return aurkitua;
	}
	
	private boolean behekoakAztertu(int x, int y) {
		boolean aurkitua=false;
		if(this instanceof Bot) {
			while (!aurkitua && y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
				if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				y++;
			}	
		}else {
			while (!aurkitua && y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				if (!Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				y++;
			}
		}
		return aurkitua;
	}
	
	private boolean ezkerrekoakAztertu(int x, int y) {
		boolean aurkitua=false;
		if(this instanceof Bot) {
			while (!aurkitua && y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
				if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				x--;
			}	
		}else {
			while (!aurkitua && y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				if (!Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				x--;
			}
		}
		return aurkitua;
	}
	
	private boolean eskumakoakAztertu(int x, int y) {
		boolean aurkitua=false;
		if(this instanceof Bot) {
			while (!aurkitua && y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
				if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				x++;
			}	
		}else {
			while (!aurkitua && y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				if (!Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				x++;
			}
		}
		return aurkitua;
	}
	
	
	
	
	
	
	//TODO BESTE
	
	/*public Arma getArma(Arma arma) {
		return this.armak.getArma(arma);
	}*/
	
	/*protected void armamentuaHasieratu() {
		Misil a = new Misil();
		armak.gehituOrdenatua(a);
	}*/
}
