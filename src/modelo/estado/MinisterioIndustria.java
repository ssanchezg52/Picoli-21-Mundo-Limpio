package modelo.estado;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

import modelo.ser.Adulto;
import modelo.ser.Ser;

//Se encarga de los trabajadores y parados
//porque se encarga de contratar y despedir
public class MinisterioIndustria {

	private final Stack<Ser> trabajadores = new Stack<>();
	private final ArrayDeque<Ser> parados = new ArrayDeque<>();
	
	public void contratar(long trabajadoresNecesarios) {
		for (int i = 0; i < trabajadoresNecesarios; i++) {
			Ser ser = this.parados.pop();
			this.trabajadores.push(ser);
		}
	}
	
	public void despedir(long trabajadoresNecesarios) {
		for (int i = 0; i < trabajadoresNecesarios; i++) {
			Ser ser = this.trabajadores.pop();
			this.parados.push(ser);
		}
		
	}
	
	public long getProduccionPotencial(int potenciaTrabajador) {
		return (trabajadores.size() + parados.size()) * potenciaTrabajador;
	}
	
	public ArrayList<Adulto> getParados() {
		//NEED TEST
		ArrayList<Adulto> adultoParados = new ArrayList<Adulto>();
		for (Ser ser : parados) {
			adultoParados.add((Adulto)ser.getComportamiento());
			
		}
		return adultoParados;
	}
	
	public ArrayDeque<Ser> getParadosSer() {
		return this.parados;
	}
	
	public long getTrabajadoresSize() {
		return this.trabajadores.size();
	}
	
	public long calculamosProduccionPeriodica(int potenciaTrabajador) {
		return trabajadores.size() * potenciaTrabajador;
	}

	public Stack<Ser> getTrabajadores() {
		return trabajadores;
	}
}
