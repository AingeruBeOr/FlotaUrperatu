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
					JokNormal.getNireJok().gelaxkaUkitutaIpini(x, y);
				}
				tiro = true;
			}
		}
		while(!tiro);
		//return (x+y*10);
	}
	
	public boolean tiroaOndoEginDu() {return true;}
	
	
	//********************************** RADAR *******************************************************
	public void radarraKontsultatu() {
		//TODO
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
