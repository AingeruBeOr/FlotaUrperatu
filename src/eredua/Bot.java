package eredua;

public class Bot extends Jokalari{

	public Bot( float pD ) {
		super(pD);
		boolean matrizea[][]=new boolean[10][10];
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(i==0||i==2||i==4) {matrizea[i][j]=true;}
				else {matrizea[i][j]=false;}
			}
		}
		matrizea[0][4]=false;
		matrizea[0][8]=false;
		matrizea[0][9]=false;
		matrizea[2][3]=false;
		matrizea[2][6]=false;
		matrizea[2][9]=false;
		matrizea[4][2]=false;
		matrizea[4][4]=false;
		matrizea[4][6]=false;
		matrizea[4][8]=false;
		super.matrizeOntzi=matrizea;
	}
	public void txandaJokatu() {}
	public void tiroEgin() {}
	public void armamentuaErosi() {}
	public void ontziaKonpondu() {}
	public void radarraKontsultatu() {}
}
