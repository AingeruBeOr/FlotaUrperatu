package eredua;
public abstract class Jokalari {
	protected float dirua;
	protected ArmamentuZerrenda armak;
	protected Tablero nireItsasontziak;
	protected Tablero ukituak;
	
	public Jokalari ( float pDiru ) {
		
		dirua=pDiru;
		armak = new ArmamentuZerrenda(1,0,0);
		itsasontzi = new ItsasontziZerrenda();
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
	protected abstract int tiroEgin();
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
	
	public void ontziaUkitutaIpini(int x, int y) {
		if(ukituDuItsasontzia(x,y)) {
			//TODO
			/*setChanged();
			notifyObservers(PARAMETRO Q TE DIGA SI ES EL BOT y la casilla);*/
		}
		nireItsasontziak.gelaxkaUkituaIpini(x, y);
		this.ukituak.gelaxkaUkituaIpini(x,y);
	}
	//MISIL TIROA IZATEKOTAN
	public void misilTiroa( int x, int y) {
		if(this instanceof Bot) {
			if (x>0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x-1, y) ) { 
				this.ezkerrekoakAztertu( x-1, y); 	
			}
			if (x<9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x+1, y)) {
				this.eskumakoakAztertu( x+1, y);	
			}
						
			if (y>0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y-1)) {
				this.goikoakAztertu( x, y-1);	
			}
			if (y<9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y+1)) {
				this.behekoakAztertu( x, y+1);
			}
		}else {
			if (x>0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x-1, y) ) { 
				this.ezkerrekoakAztertu( x-1, y); 	
			}
			if (x<9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x+1, y)) {
				this.eskumakoakAztertu( x+1, y);	
			}
						
			if (y>0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y-1)) {
				this.goikoakAztertu( x, y-1);	
			}
			if (y<9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y+1)) {
				this.behekoakAztertu( x, y+1);
			}
		}
		
	}
	
	private void goikoakAztertu ( int x, int y) {
		if(this instanceof Bot) {
			while (y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				JokNormal.getNireJok().nireItsasontziak.gelaxkaUkituaIpini(x, y);
				y--;
			}
		}else {
			while (y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
				y--;
			}
		}
	}
	private void behekoakAztertu ( int x, int y) {
		if(this instanceof Bot) {
			while (y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				JokNormal.getNireJok().nireItsasontziak.gelaxkaUkituaIpini(x, y);
				y++;
			}
		}else {
			while (y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
				y++;
			}
		}
	}
	private void ezkerrekoakAztertu ( int x, int y) {
		if(this instanceof Bot) {
			while (y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				JokNormal.getNireJok().nireItsasontziak.gelaxkaUkituaIpini(x, y);
				x--;
			}
		}else {
			while (y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
				x--;
			}
		}
	}
	
	private void eskumakoakAztertu ( int x, int y) {
		if(this instanceof Bot) {
			while (y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				JokNormal.getNireJok().nireItsasontziak.gelaxkaUkituaIpini(x, y);
				x++;
			}
		}else {
			while (y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
				x++;
			}
		}
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
