package modelo.ser;


import java.util.Observer;


import utiles.Utiles;

public class Ser {
	private static final int vidaMax = 120;
	private static final int vidaMin = 0;
	private MyObservable aAdultos = new MyObservable();
	private MyObservable aAnciano = new MyObservable();
	private MyObservable aEstado = new MyObservable();
	protected float esperanzaVida;
	protected int edad;
	private Comportamiento comportamiento;

	public Ser() {
		super();
		this.esperanzaVida = this.calculaEsperanzaVida(vidaMin, vidaMax);
		this.comportamiento = new Menor();
	}

	public boolean isAlive() {
		return this.edad <= this.esperanzaVida;
	}

	public boolean envejecer() {
		this.edad++;
		if (this.pasaAAdulto()) {
			if (((Menor)comportamiento).isViable()) {
				comportamiento = new Adulto();
			}else {
				this.edad = (int) esperanzaVida +1;
			}
			comportamiento = new Adulto();
			this.aAdultos.notifica(this);
		}
		if (this.pasaAAnciano()) {
			// Una solucion para no tener clases sin propiedades
			// son los objetos anonimos
			this.aEstado.notifica(comportamiento);
			this.comportamiento = new Comportamiento() {

				@Override
				public float alimentar(int sueldo, float esperanzaVida) {
					return recalcularVejez(sueldo, esperanzaVida);
				}

				float recalcularVejez(int sueldo, float esperanzaVida) {
					// TODO recalcular la esperanza de vida
					return esperanzaVida;
				}
			};
			this.aAnciano.notifica(this);
		}
		return this.isAlive();
	}

	public boolean vivir(int sueldo) {
		this.esperanzaVida = comportamiento.alimentar(sueldo, this.esperanzaVida);
		return this.envejecer();
	}

	public Ser(Ser ser) {
		this.edad = ser.edad;
		this.esperanzaVida = ser.esperanzaVida;
	}

	public float getEsperanzaVida() {
		return this.esperanzaVida;
	}

	public void setEsperanzaVida(float esperanzaVida) {
		this.esperanzaVida = esperanzaVida;
	}

	private int calculaEsperanzaVida(int minimo, int maximo) {
		return Utiles.dameNumero(maximo);
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	protected void recalcularEsperanzaDeVida(int sueldo) {
		// TODO recalculando
	}

	public boolean pasaAAnciano() {
		return edad == Edades.adulto.getEdadMaxima();
	}

	public boolean pasaAAdulto() {
		return edad == Edades.menor.getEdadMaxima();
	}

	public void addAdultoObserver(Observer obj) {
		aAdultos.addObserver(obj);

	}

	public void addAncianoObserver(Observer obj) {
		aAnciano.addObserver(obj);

	}
	
	public void addEstadoObserver(Observer obj) {
		aEstado.addObserver(obj);
		
	}

	public Comportamiento getComportamiento() {
		return comportamiento;
	}
}
