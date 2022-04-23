package eredua;

import java.util.Random;

public class Bot extends Jokalari{
	int txanda;
	private static Bot nireBot;
	
	private Bot() {
		super();
		txanda=0;
		//misilKop=2;
		//radarKop=2;
		//ezkutuKop=2;
		this.probazkoOntziakJarri();
		//this.txandaJokatu();
		
	}
	public static Bot getNireBot() {
		if(nireBot==null) {
			nireBot=new Bot();
		}
		return nireBot;
	}
	/*public void zenbakiRandom() {
		Random zenbakia = new Random();
		//TODO
	}*/
	/*Maider --> Metodo bat egin dut tableroa hasieratzeko bere ontziekin
	
	public void hasieratuTablero() {
		setTablero(new Tablero());
	}
	*/
	public void txandaJokatu() {		
		this.gertaeraLortu();
	}
	
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
	public boolean ontziOsoaUkituDu(int x, int y) {
		boolean urperatuta=false;
		boolean goikoak=false;
		boolean behekoak=false;
		boolean ezkerrekoak=false;
		boolean eskumakoak=false;	

		if(ukituDuItsasontzia(x,y)) {
			
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
	
	/**
	 *  true urperatuta ez dagoen gelaxka aurkitzen badu
	 * @param x
	 * @param y
	 * @return 
	 */
	private boolean goikoakAztertu(int x, int y) { 
		boolean aurkitua=false;
		while (!aurkitua && y>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
			if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
				aurkitua=true;
			}
			y--;
		}	
		return aurkitua;
	}
	
	private boolean behekoakAztertu(int x, int y) {
		boolean aurkitua=false;
		while (!aurkitua && y<=9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
			if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
				aurkitua=true;
			}
			y++;
		}	
		return aurkitua;
	}
	
	private boolean ezkerrekoakAztertu(int x, int y) {
		boolean aurkitua=false;
		while (!aurkitua && x>=0 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
			if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
				aurkitua=true;
			}
			x--;
		}	
		return aurkitua;
	}
	
	private boolean eskumakoakAztertu(int x, int y) {
		boolean aurkitua=false;
		while (!aurkitua && y<=9 && JokNormal.getNireJok().nireItsasontziak.itsasontziaDuGelaxka(x, y) ) {
			if (!JokNormal.getNireJok().nireItsasontziak.ukitutaEdoUrperatutaZegoen(x, y)) {
				aurkitua=true;
			}
			x++;
		}	
		return aurkitua;
	}
	
	//************************************ GERTAERA RANDOM ***************************************************
	//TODO MÉTODO PARA OBTENER NÚMEROS RANDOM Y QUE DEPENDIENDO DEL NÚMERO SE UTILICE UN ARMA DIFERENTE
	
	private void gertaeraLortu() {
		//limiteak ezarri
		Random r= new Random();
		int x, y;
		int min = 1;
		//int max = 10;
		
		//Zenbaki bat lortu
		int zenb = min + r.nextInt(10);
		
		System.out.println("Lortutako zenbakia: " + zenb);
		x = r.nextInt(10);
		y = r.nextInt(10);
		if (txanda==1) {
			misilTiroa(0,0);
		}else if(txanda==0){
			ezkutuaKokatu();
		}else{
			if (zenb == 4 && getArmaKop(new Misil()) >0) {misilTiroa(x, y);}
			else if (zenb == 7 && getArmaKop(new Radarra()) >0){radarraKontsultatu(x, y);}
			else if (zenb == 10 && getArmaKop(new Ezkutua()) >0) {ezkutuaKokatu();} 
			else {tiroEgin();}
		}
		txanda++;
	 }
	
	
	//*********************************************** TIROA *******************************************************
	private void tiroEgin() {
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
				System.out.println("Bot-ak bonba bat bota du (" + x + ", " + y + ") koordenatuetan");
			}
		}
		while(!tiro);
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
	private void misilTiroa( int x, int y) {
		System.out.println("Bot-ak misil bat kokatu du (" + x + ", " + y + ") koordenatuetan");
		if(JokNormal.getNireJok().ezkutuaDago(x, y)) {
			JokNormal.getNireJok().ezkutuaXTxikitu(x, y, 2);
		}else {
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
		}
		//misil kantitatea eguneratu:
		armaKantitateaEguneratu(new Misil());
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
	private void radarraKontsultatu(int x, int y) {
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
		System.out.println("Bot-ak radar bat kokatu du (" + x + ", " + y + ") koordenatuetan");
		if (!aurkituDu) {
			setChanged();
			notifyObservers(new int[] {x,y,6});
		}
		//radar kantitatea eguneratu:
		armaKantitateaEguneratu(new Radarra());
	}

	//********************************** EZKUTUA *******************************************************
	//Ezkutua ontzia babesten du misil batetik edo bi bonbetatik
	private void ezkutuaKokatu() {
		int x;
		int y;
		Random r=new Random();
		boolean ezkutuKokatua = false;	
		do{
			x = r.nextInt(10);
			y = r.nextInt(10);
			if (super.itsasontziaDaukat(x, y)) {
				if (!super.ezkutuaDago(x, y)) {
					if (!nireItsasontziak.urperatutaDago(x, y)) {
						super.ezkutuaIpini(x, y);
						armaKantitateaEguneratu(new Ezkutua());
						//ezkutuKop = ezkutuKop --;
						System.out.println("Bot-ak ezkutu bat kokatu du (" + x + ", " + y + ") koordenatuetan");
						ezkutuKokatua=true;
					}
				}
			}
		}while(!ezkutuKokatua);
	}
	
	@Override
	public void ezkutuaXTxikitu(int x, int y, int k) {
		int hX=x;
		int hY=y;
		int level = this.nireItsasontziak.ezkutuaXTxikitu(x,y, k);
		setChanged();
		notifyObservers(new int[] {x, y, 3, level});
		y--;
		while(y>=0 && nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			this.nireItsasontziak.ezkutuaXTxikitu(x,y, k);
			if(level == 0) {
				setChanged();
				notifyObservers(new int[] {x, y, 3, level});
			}
			y--;
		}
		y=hY+1;
		while (y<=9 && nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			this.nireItsasontziak.ezkutuaXTxikitu(x,y, k);
			if(level == 0) {
				setChanged();
				notifyObservers(new int[] {x, y, 3, level});
			}
			y++;
		}
		y=hY;
		x=hX-1;
		while (x>=0 && nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			this.nireItsasontziak.ezkutuaXTxikitu(x,y, k);
			if(level == 0) {
				setChanged();
				notifyObservers(new int[] {x, y, 3, level});
			}
			x--;
		}
		x=hX+1;
		while (x<=9 && nireItsasontziak.itsasontziaDuGelaxka(x, y)) {
			this.nireItsasontziak.ezkutuaXTxikitu(x,y, k);
			if(level == 0) {
				setChanged();
				notifyObservers(new int[] {x, y, 3, level});
			}
			x++;
		}
	}
	//********************************** EROSKETAK *******************************************************
		public void armamentuaErosi() {}
		
		public void ontziaKonpondu() {}

}
