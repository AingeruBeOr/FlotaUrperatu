package eredua;

import java.util.Random;

public class Bot extends Jokalari{
	int txanda;
	private static Bot nireBot;
	
	private Bot() {
		super();
		this.probazkoOntziakJarri();
	}
	public static Bot getNireBot() {
		if(nireBot==null) {
			nireBot=new Bot();
		}
		return nireBot;
	}
	public void zenbakiRandom() {
		Random zenbakia = new Random();
		//TODO
	}
	/*Maider --> Metodo bat egin dut tableroa hasieratzeko bere ontziekin
	
	public void hasieratuTablero() {
		setTablero(new Tablero());
	}
	*/
	public void txandaJokatu() {}
	//********************************** ITSASONTZIAK IPINI *******************************************************
	public void probazkoOntziakJarri() {
		nireItsasontziak.botariOntziakJarri();
	}
	public void ontziaKokatu(int pX, int pY, boolean pHorizontal, int pLuz) {
		nireItsasontziak.ontziaKokatu(pX, pY, pHorizontal, pLuz);
		//Random r = new Random();
	 	//int pX=0;
	 	//int pY=0;
		/*//TODO while (pX > 0 and pX<=10) do {
			
		} */
	}
	
	public boolean ontziaKokatuAhalDa(int pX, int pY, boolean pHorizontal, int pLuz) {
		return nireItsasontziak.ontziaKokatuAhalDa(pX, pY, pHorizontal, pLuz);
	}
	
	private void botarenItsasontziakKokatu(){
		hegazkinOntziaKokatu();
		itsaspekoaKokatu();
		itsaspekoaKokatu();
		suntzitzaileaKokatu();
		suntzitzaileaKokatu();
		suntzitzaileaKokatu();
		fragataKokatu();
		fragataKokatu();
		fragataKokatu();
		fragataKokatu();
	}

	private void hegazkinOntziaKokatu(){
		Random r = new Random();
		int x = r.nextInt(10);
		int y = r.nextInt(10);
		int luzera = 4;
		int horber = r.nextInt();
		boolean horizontal;
		boolean kokatua = false;
		while (!kokatua){
			if (horber % 2 == 0){
				horizontal = true;
			}

			else{
				horizontal = false;
			}
			
			if (ontziaKokatuAhalDa(x, y, horizontal, luzera)){
				ontziaKokatu(x, y, horizontal, luzera);
				kokatua = true;
			}
		}
	}

	private void itsaspekoaKokatu(){
		Random r = new Random();
		int x = r.nextInt(10);
		int y = r.nextInt(10);
		int luzera = 3;
		int horber = r.nextInt();
		boolean horizontal;
		boolean kokatua = false;
		while (!kokatua){
			if (horber % 2 == 0){
				horizontal = true;
			}

			else{
				horizontal = false;
			}
			
			if (ontziaKokatuAhalDa(x, y, horizontal, luzera)){
				ontziaKokatu(x, y, horizontal, luzera);
				kokatua = true;
			}
		}
	}

	private void suntzitzaileaKokatu(){
		Random r = new Random();
		int x = r.nextInt(10);
		int y = r.nextInt(10);
		int luzera = 2;
		int horber = r.nextInt();
		boolean horizontal;
		boolean kokatua = false;
		while (!kokatua){
			if (horber % 2 == 0){
				horizontal = true;
			}

			else{
				horizontal = false;
			}
			
			if (ontziaKokatuAhalDa(x, y, horizontal, luzera)){
				ontziaKokatu(x, y, horizontal, luzera);
				kokatua = true;
			}
		}
	}

	private void fragataKokatu(){
		Random r = new Random();
		int x = r.nextInt(10);
		int y = r.nextInt(10);
		int luzera = 1;
		int horber = r.nextInt();
		boolean horizontal;
		boolean kokatua = false;
		while (!kokatua){
			if (horber % 2 == 0){
				horizontal = true;
			}

			else{
				horizontal = false;
			}
			
			if (ontziaKokatuAhalDa(x, y, horizontal, luzera)){
				ontziaKokatu(x, y, horizontal, luzera);
				kokatua = true;
			}
		}
	}
	//********************************************** UKITUAK *******************************************************
	/**
	 * true bueltatuko du adieraztiako posizioan itsasontzi bat ukitu badu tiro egitean edo false bestela
	 * @param x: x koordenatua
	 * @param y: y koordenatua
	 * @return
	 */
	public boolean ukituDuItsasontzia(int x, int y) {
		if(JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) return true;
		else return false;
	}
	//*********************************************** TIROA *******************************************************
	public void tiroEgin() {
		/*
		txanda++;
		int x=txanda%10;
		int y=txanda/10;
		JokNormal.getNireJok().ontziaUkitutaIpini(x, y);
		return txanda;
		*/
		
	 	Random r = new Random();
	 	int x=0;
	 	int y=0;
		boolean tiro = false;
		do{
			x = r.nextInt(10);
			y = r.nextInt(10);
			if (!this.ukitutaZegoen(x, y)) {
				if(JokNormal.getNireJok().ezkutuaDago(x, y)) {
					JokNormal.getNireJok().ezkutuaXTxikitu(x, y, 1);
				}else {
					gelaxkaUkitutaIpini(x, y);
				}
				tiro = true;
			}
		}
		while(!tiro);
		//return (x+y*10);
	}
	public void gelaxkaUkitutaIpini(int x, int y) {
		if(ukituDuItsasontzia(x,y)) {
			setChanged();
			notifyObservers(new int[] {x,y,1});
		}else {
			setChanged();
			notifyObservers(new int[] {x,y,0});
		}
		JokNormal.getNireJok().nireItsasontziak.gelaxkaUkituaIpini(x, y);
		Bot.getNireBot().ukituak.gelaxkaUkituaIpini(x, y);
		
	}
	
	public void gelaxkaUrperatu(int x, int y) {
		setChanged();
		notifyObservers(new int[] {x,y,2});
		JokNormal.getNireJok().nireItsasontziak.gelaxkaUrperatutaIpini(x, y);
		Bot.getNireBot().ukituak.gelaxkaUrperatutaIpini(x, y);
	}
	
	
	public boolean tiroaOndoEginDu() {return true;}
	
	//********************************** MISIL TIROA *******************************************************
	public void misilTiroa( int x, int y) {
		if(ukituDuItsasontzia(x,y)) {
			gelaxkaUrperatu(x,y);
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
			setChanged();
			notifyObservers(new int[] {x,y,0});
			JokNormal.getNireJok().nireItsasontziak.gelaxkaUkituaIpini(x, y);
			this.ukituak.gelaxkaUkituaIpini(x,y);
		}
		//misil kantitatea eguneratu:
		int kop = armaKantitateaEguneratu(new Misil());
		setChanged();
		notifyObservers(new int[] {0,kop}); 
	}
	
	private void goikoakUrperatu ( int x, int y) {
		while (y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y);
			y--;
		}
	}
	private void behekoakUrperatu ( int x, int y) {
		while (y<=9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y);
			y++;
		}
	}
	private void ezkerrekoakUrperatu ( int x, int y) {
		while (x>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y);
			x--;
		}
	}
	
	private void eskumakoakUrperatu ( int x, int y) {
		while (x<=9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			gelaxkaUrperatu(x,y);
			x++;
		}
	}
	
	
	public void ontziaUrperatu(int x, int y) {
		gelaxkaUrperatu(x,y);
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
	}
	//********************************** RADAR *******************************************************
	public void radarraKontsultatu(int x, int y) {
		boolean aurkituDu=false;
		for(int i=x-1; i<=x+1; i++) {
			for(int j=y-1; j<=y+1; j++) {
				if(i>=0 && i<=9 && j>=0 && j<=9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(i, j) && !JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(i, j)) {
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
		//radar kantitatea eguneratu:
		int kop = armaKantitateaEguneratu(new Radarra());
		setChanged();
		notifyObservers(new int[] {1,kop});
	}
	//********************************** EZKUTUA *******************************************************
	//Ezkutua ontzia babesten du misil batetik edo bi bonbetatik
	public void ezkutuaKokatu() {
		boolean ezkutuKokatua = false;
		{
			do {
				//TODO el true lo he puesto para q no de error
			} while (true);
		}
		//TODO
	}
	
	//********************************** EROSKETAK *******************************************************
		public void armamentuaErosi() {}
		
		public void ontziaKonpondu() {}

}
