package eredua;

import java.util.Random;

public class Bot extends Jokalari{
	int txanda;
	private static Bot nireBot;
	
	private Bot( float pDiru ) {
		super(pDiru);
		this.probazkoOntziakJarri();
	}
	public static Bot getNireBot() {
		if(nireBot==null) {
			nireBot=new Bot(1000);
		}
		return nireBot;
	}
	
	public void txandaJokatu() {}
	
	public void probazkoOntziakJarri() {
		nireItsasontziak.botariOntziakJarri();
	}
	
	public int tiroEgin() {
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
		boolean ukitua = false;
		do{
			x = r.nextInt(10);
			y = r.nextInt(10);
			if (!this.ukitutaZegoen(x, y)) {
				JokNormal.getNireJok().gelaxkaUkitutaIpini(x, y);
				ukitua = true;
			}
		}
		while(!ukitua);
		return (x+y*10);
	}
	
	public boolean tiroaOndoEginDu() {return true;}
	
	public void armamentuaErosi() {}
	
	public void ontziaKonpondu() {}
	
	public void radarraKontsultatu() {}
	
	public void ontziaKokatu(int pX, int pY, boolean pHorizontal, int pLuz) {
		nireItsasontziak.ontziaKokatu(pX, pY, pHorizontal, pLuz);
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

}
