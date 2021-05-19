package modelo.ser;

public class Menor implements Comportamiento{
	public float factorDesarrollo;

	@Override
	public float alimentar(int sueldo,float esperanzaVida) {
		double factor = 5.55;
		
		if (sueldo == Edades.menor.getNecesidadVital()) {
			this.factorDesarrollo = this.factorDesarrollo + (float) factor;
		}else if (sueldo > 0 && sueldo < Edades.menor.getNecesidadVital()) {
			this.factorDesarrollo = this.factorDesarrollo + (float) ((sueldo * factor) / Edades.menor.getNecesidadVital());
		}
		return esperanzaVida;
	}

	public boolean isViable() {
		return this.factorDesarrollo >=55;
	}

	
}
