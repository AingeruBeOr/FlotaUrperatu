package eredua;

public abstract class ArmamentuSuntsitzaile extends Arma {

	public ArmamentuSuntsitzaile() {
		super();	
	}

	
	public void Suntsitu() {
			
			//Primero, le pasamos las coordenadas
		
		int y = 0;
		int x = 0;
		Koordenatu k = new Koordenatu(x, y);

		k.jasoX();
		k.jasoY();
		
			//TODO
			//y ahora, depende de lo que sea, se hacen los cambios
			// si es agua --> ??
			// Si hay un barco --> matriz de ontziak a false, la de ukituak a true
			
	}
}
