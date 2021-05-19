package modelo.estado;

import java.util.ArrayList;

import modelo.ser.Adulto;
import modelo.ser.Ser;

//Se encarga de los trabajadores y parados
//porque se encarga de contratar y despedir
public class MinisterioIndustria {

	private final ArrayList<Ser> trabajadores = new ArrayList<>();
	private final ArrayList<Ser> parados = new ArrayList<>();
	
	public void contratar(long trabajadoresNecesarios) {
		for (int i = 0; i < trabajadoresNecesarios; i++) {
			this.trabajadores.add(this.parados.get(i));
			this.parados.remove(i);
		}
	}
	
	public void despedir(long trabajadoresNecesarios) {
		for (int i = 0; i < trabajadoresNecesarios; i++) {
			this.parados.add(this.trabajadores.get(i));
			this.trabajadores.remove(i);
		}
		
	}
	
	public long getProduccionPotencial(int potenciaTrabajador) {
		return trabajadores.size() * potenciaTrabajador;
	}
	
	public ArrayList<Adulto> getParados() {
		//NEED TEST
		ArrayList<Adulto> adultoParados = new ArrayList<>();
		for (Ser ser : parados) {
			adultoParados.add((Adulto)ser.getComportamiento());
			
		}
		return adultoParados;
	}
	
	public long getTrabajadoresSize() {
		return this.trabajadores.size();
	}
	
	public long calculamosProduccionPeriodica() {
		// TODO Auto-generated method stub
		return 0;
	}
}
