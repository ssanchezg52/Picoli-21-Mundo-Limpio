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
	MinisterioHacienda ministerioHacienda;
	MinisterioIndustria ministerioIndustria;
	MinisterioSocial ministerioSocial;

	public Estado(long demanda) {
		this.ministerioHacienda = new MinisterioHacienda();
		this.ministerioIndustria = new MinisterioIndustria();
		this.ministerioSocial = new MinisterioSocial();
		this.ministerioSocial.establecerNacimientos(demanda/potenciaTrabajador);
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
		capital+=this.ministerioIndustria.calculamosProduccionPeriodica(potenciaTrabajador);
		capital-=pagarCostesFabricacion();
		this.ministerioHacienda.generarPresupuesto(this.ministerioSocial.getMenoresSize(), this.ministerioSocial.getAncianosSize(), 
				this.ministerioIndustria.getTrabajadoresSize(), this.ministerioIndustria.getParados());
		this.ministerioHacienda.establecerPorcentajes(capital);
		capital-=this.ministerioHacienda.getTotal();
		envejecer();
	}

	private void envejecer() {
		this.ministerioSocial.alimentarMenores(this.ministerioHacienda.getCantidadMenores());
		this.ministerioSocial.alimentarAncianos(this.ministerioHacienda.getCantidadAncianos());
		this.ministerioSocial.alimentarTrabajadores(this.ministerioHacienda.getCantidadTrabajadores(),this.ministerioIndustria.getTrabajadores());
		this.ministerioSocial.alimentarParados(this.ministerioHacienda.getCantidadParados(), this.ministerioIndustria.getParadosSer());
	}

	private long pagarCostesFabricacion() {
		// TODO Auto-generated method stub
		return 0;
	}
}
