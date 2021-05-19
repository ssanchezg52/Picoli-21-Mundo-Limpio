package modelo.estado;

import java.util.ArrayList;

import modelo.presupuesto.Presupuesto;
import modelo.ser.Adulto;

//Elabora el presupuesto y decide sobre capital y deuda 
public class MinisterioHacienda {

	Presupuesto presupuesto;

	public Presupuesto generarPresupuesto(long cantidadMenores, long cantidadAncianos, 
			long cantidadTrabajadores, ArrayList<Adulto> parados) {
		
		this.presupuesto = new Presupuesto(cantidadMenores, cantidadAncianos, cantidadTrabajadores, parados);
		return this.presupuesto;
	}

	public void establecerPorcentajes(long capital) {
		this.presupuesto.establecerPorcentajes(capital);
		
	}

	public long getTotal() {
		return this.presupuesto.getTotal();
		
	}
	
	
}
