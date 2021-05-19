package presentador;

import java.util.ArrayList;

import modelo.estado.MinisterioHacienda;
import modelo.estado.MinisterioIndustria;
import modelo.estado.MinisterioSocial;
import modelo.presupuesto.Presupuesto;
import modelo.ser.Adulto;
import modelo.ser.Ser;

public class Estado {
	// Lo que le piden al estado que fabrique
	private long demanda = 0;
	// el aumento de produccion en este periodo
	private float porcentajeAumento;
	// lo cantidad que puede producir el estado
	private long produccionPotencial = 0;
	// lo que realmente produce el estado
	private long produccion;
	// La cantidad que cada trabajador produce por periodo
	private int potenciaTrabajador = 450;
	// dinero que tiene el estado o deuda
	private long capital = 0;
	private final ArrayList<Ser> seres = new ArrayList<>();
	MinisterioHacienda ministerioHacienda;
	MinisterioIndustria ministerioIndustria;
	MinisterioSocial ministerioSocial;

	public Estado(long demanda) {
		this.ministerioHacienda = new MinisterioHacienda();
		this.ministerioIndustria = new MinisterioIndustria();
		this.ministerioSocial = new MinisterioSocial();
		for (int i = 0; i < demanda / potenciaTrabajador; i++) {
			this.ministerioSocial.naceSer();
		}
		// Esto es la historia
		int historia = 0;
		do {
			terminarPeriodo();
			comenzarPeriodo();
			historia++;
		} while (historia < 120);
	}

	private void comenzarPeriodo() {
		// TODO Auto-generated method stub
		long trabajadoresNecesarios=demanda-this.ministerioIndustria.getProduccionPotencial(potenciaTrabajador);
		this.ministerioIndustria.contratar(trabajadoresNecesarios);
		long trabajadoresFaltantes=trabajadoresNecesarios-this.ministerioIndustria.getTrabajadoresSize();
		this.ministerioSocial.establecerNacimientos(trabajadoresFaltantes);
	}

	private void terminarPeriodo() {
		// TODO Auto-generated method stub
		capital+=this.ministerioIndustria.calculamosProduccionPeriodica();
		capital-=pagarCostesFabricacion();
		this.ministerioHacienda.generarPresupuesto(this.ministerioSocial.getMenoresSize(), this.ministerioSocial.getAncianosSize(), 
				this.ministerioIndustria.getTrabajadoresSize(), this.ministerioIndustria.getParados());
		this.ministerioHacienda.establecerPorcentajes(capital);
		capital-=this.ministerioHacienda.getTotal();
		envejecer();
	}

	private void envejecer() {
		
		
	}

	

	private long pagarCostesFabricacion() {
		// TODO Auto-generated method stub
		return 0;
	}

	private long calculamosProduccionPeriodica() {
		// TODO Auto-generated method stub
		return 0;
	}
}
