package eredua;

import java.util.Random;

public class Bot extends Jokalari{
	private int xR;
	private int yR;
	private boolean itsasontziaAurkitu;
	private static Bot nireBot;
	
	private Bot() {
		super();
		xR=10;
		yR=10;
		this.itsasontziaAurkitu=false;
		this.probazkoOntziakJarri();
		
	}
	public static Bot getNireBot() {
		if(nireBot==null) {
			nireBot=new Bot();
		}
		return nireBot;
	}
	
	public void txandaJokatu() {
		this.gertaeraLortu();
		FlotaUrperatu.getNireFlotaUrperatu().aldatuTxanda();
	}
	//********************************** ITSASONTZIAK IPINI *******************************************************
	public void probazkoOntziakJarri() {
		botarenItsasontziakKokatu();
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
		int luzera = 4;
		int horber =  r.nextInt(2);

		boolean horizontal;
		boolean kokatua = false;
		while (!kokatua){
			int x = r.nextInt(10);
			int y = r.nextInt(10);
			if (horber == 0){
				horizontal = true;
			}
			else{
				horizontal = false;
			}
			if (ontziaKokatuAhalDa(x, y, horizontal, luzera)){
				ontziaKokatu(x, y, horizontal, luzera);
				kokatua = true;
				System.out.println("Bot-ak hegazkinOntzia kokatu du : X--> "+x+" eta Y--> "+y);
			}
		}
	}

	private void itsaspekoaKokatu(){
		Random r = new Random();
		int luzera = 3;
		int horber = r.nextInt(2);
		boolean horizontal;
		boolean kokatua = false;
		while (!kokatua){
			int x = r.nextInt(10);
			int y = r.nextInt(10);
			if (horber == 0) horizontal = true;
			else horizontal = false;
			if (ontziaKokatuAhalDa(x, y, horizontal, luzera)){
				ontziaKokatu(x, y, horizontal, luzera);
				kokatua = true;
				System.out.println("Bot-ak itsaspekoa kokatu du : X--> "+x+" eta Y--> "+y);
			}
		}
	}

	private void suntzitzaileaKokatu(){
		Random r = new Random();
		int luzera = 2;
		int horber = r.nextInt(2);
		boolean horizontal;
		boolean kokatua = false;
		while (!kokatua){
			int x = r.nextInt(10);
			int y = r.nextInt(10);
			if (horber == 0) horizontal = true;
			else horizontal = false;
			if (ontziaKokatuAhalDa(x, y, horizontal, luzera)){
				ontziaKokatu(x, y, horizontal, luzera);
				kokatua = true;
				System.out.println("Bot-ak suntzitzailea kokatu du : X--> "+x+" eta Y--> "+y);
			}
		}
	}

	private void fragataKokatu(){
		Random r = new Random();
		int luzera = 1;
		int horber = r.nextInt(2);
		boolean horizontal;
		boolean kokatua = false;
		while (!kokatua){
			int x = r.nextInt(10);
			int y = r.nextInt(10);
			if (horber == 0) horizontal = true;
			else horizontal = false;
			if (ontziaKokatuAhalDa(x, y, horizontal, luzera)){
				ontziaKokatu(x, y, horizontal, luzera);
				kokatua = true;
				System.out.println("Bot-ak fragata kokatu du : X--> "+x+" eta Y--> "+y);
				
			}
		}
	}
	//************************************ GERTAERA RANDOM ***************************************************
	public void koordenatuakGogoratu(int x,int y) {
		System.out.println("Gorde dut koordenatua: x "+x+" eta y "+y);
		xR = x;
		yR = y;
		this.itsasontziaAurkitu=true;
	}
	
	private void gertaeraLortu() {
		Random r = new Random();
		int zenb = r.nextInt(10); 
		int x = r.nextInt(10);
		int y = r.nextInt(10);
		boolean tiro = false;
		if(itsasontziaAurkitu) {
			zenb=0;
			x=xR;
			y=yR;
			yR=10;
			xR=10;
			itsasontziaAurkitu=false;
			System.out.println("Erabiliko dut koordenatua: x "+x+" eta y "+y);
		}
		do {		
			if ((zenb == 9 || zenb == 4) && getArmaKop(new Ezkutua()) > 0) ezkutuaErabili(x,y);
			else if(!ukituak[x][y]) {
				if (zenb == 8) {
					if(getArmaKop(new Misil()) >0) {
						misilErabili(x, y);
						tiro=true;
					} 
				}
				else if(zenb == 7 && getArmaKop(new Radarra()) > 0) radarraErabili(x, y);
				else if(zenb == 6 && getDirua() > 75) ontziaKonpondu(x,y);
				else if(zenb == 5) armamentuErosketa();
				else {
					new Bonba().erabili(x, y, JokNormal.getNireJok().nireItsasontziak);
					tiro=true;
					System.out.println("Bonba bota dut koordenatua: x "+x+" eta y "+y);
				}
			}
			x = r.nextInt(10);
			y = r.nextInt(10);
			zenb=r.nextInt(10);
		} while(!tiro);
	 }
	
	//*********************************************** TIROAK *******************************************************
		
	public void misilErabili(int x, int y) {
		new Misil().erabili(x, y, JokNormal.getNireJok().nireItsasontziak);
		System.out.println("Misila erabili dut: x "+x+" eta y "+y);
		this.baliabideak.armaKantitateaEguneratu(new Misil());
	}
	
	public void radarraErabili(int x, int y) {
		new Radarra().erabili(x, y, JokNormal.getNireJok().nireItsasontziak);
		System.out.println("Radarra erabili dut: x "+x+" eta y "+y);
		this.baliabideak.armaKantitateaEguneratu(new Radarra());
	}
	
	public void ezkutuaErabili(int x, int y) {
		boolean erabili = new Ezkutua().erabili(x, y, nireItsasontziak);
		if(erabili) {
			System.out.println("Ezkutua jarri dut x "+x+" eta y "+y);
			this.baliabideak.armaKantitateaEguneratu(new Ezkutua());
		}
	}

	
		
		
	//************************** KONPONKETAK **************************************************

	
	@Override
	public void ontziaKonpondu (int x, int y) {
		boolean konpondua=false;
		int i=x;
		int j=y;
		while(i<=9 && !konpondua) {
			while(j<=9 && !konpondua) {
				if(nireItsasontziak.itsasontziaDuGelaxka(i, j) && nireItsasontziak.ukitutaDago(i, j)) {
					nireItsasontziak.gelaxkaKonpondu(i, j);
					baliabideak.erosketaPrezioaKendu(); 
					System.out.println("Bot-ak konpondu du X --> "+i+" eta  Y --> "+j);
					setChanged();
					notifyObservers(new int[] {i,j,11,1});	
					konpondua = true;
				}
				j++;
			}
			j=0;
			i++;
		}
	}
	
	//************************** EROSKETAK ***********************************************************
	private void armamentuErosketa() {
		System.out.println("Botak duen dirua hurrengoa da: "+getDirua());
		while(getDirua() > new Misil().getPrezioa()) {
			if(getDirua() > new Radarra().getPrezioa()) {
				armamentuaErosi(new Radarra(),1);
				System.out.println("Radar bat erosi du bot-ak");
			}
			if(getDirua() > new Ezkutua().getPrezioa()) {
				armamentuaErosi(new Ezkutua(),1);
				System.out.println("Ezkutu bat erosi du bot-ak");
			}
			if(getDirua() > new Misil().getPrezioa()) {
				armamentuaErosi(new Misil(),1);
				System.out.println("Misil bat erosi du bot-ak");
			}
		}
		System.out.println("Botari geratu zaion dirua hurrengoa da: "+getDirua());
	}
}
