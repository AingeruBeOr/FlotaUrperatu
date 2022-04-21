package eredua;

import java.util.Observable;

public abstract class Jokalari extends Observable{
	protected float dirua;
	protected ArmamentuZerrenda armak;
	protected Tablero nireItsasontziak;
	protected Tablero ukituak;
	
	public Jokalari () {
		dirua=1000;
		armak = new ArmamentuZerrenda(2,2,2); //2 misil, 2 radar eta 2 ezkutu
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
	
	public boolean ontzirenBatGeratzenDa() {
		return nireItsasontziak.ontzirenBatGeratzenDa();
	}
	
	public int armaKantitateaEguneratu(Arma arma) {
		return armak.armaKantitateaEguneratu(arma);
	}
	
	public int getArmaKop(Arma arma) {
		return armak.getArmaKop(arma);
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
		/*
		 * return this.nireItsasontziak.itsasontziaDuGelaxka(x,y);
		 * */
		
		FlotaUrperatu fu =FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			if(JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) return true;
			else return false;
		}else {
			if(Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) return true;
			else return false;
		}

	}
	
	public void gelaxkaUrperatu(int x, int y) {
		FlotaUrperatu fu =FlotaUrperatu.getNireFlotaUrperatu();
		setChanged();
		notifyObservers(new int[] {x,y,2});
		if(!fu.getTxanda()) {
			JokNormal.getNireJok().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
			Bot.getNireBot().ukituak.gelaxkaUrperatutaIpini(x, y);
		}else {
			Bot.getNireBot().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
			JokNormal.getNireJok().ukituak.gelaxkaUrperatutaIpini(x, y);
		}
	}
	
	public void gelaxkaUkitutaIpini(int x, int y) {
		FlotaUrperatu fu =FlotaUrperatu.getNireFlotaUrperatu();
		if(ukituDuItsasontzia(x,y)) {
			setChanged();
			notifyObservers(new int[] {x,y,1});
		}else {
			setChanged();
			notifyObservers(new int[] {x,y,0});
		}
		//TODO IGUAL ES AL REVES
		if(!fu.getTxanda()) {
			JokNormal.getNireJok().nireItsasontziak.gelaxkaUkituaIpini(x, y);
			Bot.getNireBot().ukituak.gelaxkaUkituaIpini(x, y);
		}else {
			Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
			JokNormal.getNireJok().ukituak.gelaxkaUkituaIpini(x, y);
		}
	}
	
	
	//MISIL TIROA IZATEKOTAN
	public void misilTiroa( int x, int y) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		
		if(ukituDuItsasontzia(x,y)) {
			gelaxkaUrperatu(x,y);
			System.out.println("Misilak itsasontzia aurkitu du");
			if(!fu.getTxanda()) {
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
			if(!fu.getTxanda()) {
				JokNormal.getNireJok().nireItsasontziak.gelaxkaUkituaIpini(x, y);
			}else {
				Bot.getNireBot().nireItsasontziak.gelaxkaUkituaIpini(x, y);
			}
			this.ukituak.gelaxkaUkituaIpini(x,y);
		}
		
		
	}
	
	private void goikoakUrperatu ( int x, int y) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				y--;
			}
		}else {
			while (y>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				y--;
			}
		}
	}
	private void behekoakUrperatu ( int x, int y) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (y<=9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				y++;
			}
		}else {
			while (y<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				y++;
			}
		}
	}
	private void ezkerrekoakUrperatu ( int x, int y) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (x>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				x--;
			}
		}else {
			while (x>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				x--;
			}
		}
	}
	
	private void eskumakoakUrperatu ( int x, int y) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (x<=9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				x++;
			}
		}else {
			while (x<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				gelaxkaUrperatu(x,y);
				x++;
			}
		}
	}
	
	
	public void ontziaUrperatu(int x, int y) {
		gelaxkaUrperatu(x,y);
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
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
		boolean urperatuta=false;
		boolean goikoak=false;
		boolean behekoak=false;
		boolean ezkerrekoak=false;
		boolean eskumakoak=false;

		if(ukituDuItsasontzia(x,y)) {
			FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
			if(!fu.getTxanda()) {
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
			}
			if (!ezkerrekoak && !eskumakoak && !goikoak && !behekoak) { //guztiak ukituta daudenean, (ez duzu ez ukiturik aurkitu) orduan itsasontzia urperatuta dago
				urperatuta=true;
			}
			if (urperatuta) {
				setChanged();
				notifyObservers(new int[] {x,y,5});
			}			
		}
		return urperatuta;
	}
	
	private boolean goikoakAztertu(int x, int y) { //true urperatuta ez dagoen gelaxka aurkitzen badu
		boolean aurkitua=false;
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
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
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (!aurkitua && y<=9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
				if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				y++;
			}	
		}else {
			while (!aurkitua && y<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
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
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (!aurkitua && x>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
				if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				x--;
			}	
		}else {
			while (!aurkitua && x>=0 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
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
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(!fu.getTxanda()) {
			while (!aurkitua && y<=9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
				if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				x++;
			}	
		}else {
			while (!aurkitua && y<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
				if (!Bot.getNireBot().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
					aurkitua=true;
				}
				x++;
			}
		}
		return aurkitua;
	}
	
	
	
	public void radarraKontsultatu(int x, int y) {
		boolean aurkituDu=false;
		for(int i=x-1; i<=x+1; i++) {
			for(int j=y-1; j<=y+1; j++) {
				if(i>=0 && i<=9 && j>=0 && j<=9 && Bot.getNireBot().nireItsasontziak.itsasontziaDuGelaxka(i, j)) {
					setChanged();
					notifyObservers(new int[] {i,j,4});
					aurkituDu=true;
					
				}
			}
		}
		if (!aurkituDu) {
			setChanged();
			notifyObservers(new int[] {x,y,6});
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
