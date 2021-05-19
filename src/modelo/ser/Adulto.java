package modelo.ser;

public class Adulto implements Comportamiento {
	private long ahorro;

	@Override
	public float alimentar(int sueldo, float esperanzaVida) {
		int necesidadVitalSatisfecha = 0;
		int resto = sueldo - Edades.adulto.getNecesidadVital();
		// resto sera -20
		this.ahorro += resto;
		// ahorros -10
		if (ahorro < 0) {
			necesidadVitalSatisfecha = (int) (Edades.adulto.getNecesidadVital() - ahorro);
			this.ahorro = 0;
		}

		return recalcularEsperanzaDeVida(necesidadVitalSatisfecha, esperanzaVida);
	}

	private float recalcularEsperanzaDeVida(int necesidadVitalSatisfecha, float esperanzaVida) {
		double acumulador = 0;
		double factorUno = 1;
		if (necesidadVitalSatisfecha != 0) {
			for (int i = 99; i >= necesidadVitalSatisfecha; i--) {
				acumulador = (acumulador + (factorUno / Edades.adulto.getNecesidadVital()));
			}
		}else {
			acumulador = 1.00;
		}
		return esperanzaVida - (float) acumulador;
	}
	
	public long getAhorro() {
		return this.ahorro;
	}

	public long calculaNecesidad() {
		long necesidad = 0;
		long l = Edades.adulto.getNecesidadVital() - ahorro;
		if (l > 0) {
			necesidad = l;
		}
		return l;
	}

}
