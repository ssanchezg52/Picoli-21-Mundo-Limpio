package modelo.estado;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import modelo.ser.Ser;

//Se encargad de gestionar menores,ancianos y parados
// se encarga del pago de estos sectores
public class MinisterioSocial {
	private final ArrayList<Ser> menores = new ArrayList<>();
	private final ArrayList<Ser> ancianos = new ArrayList<>();
	
	public void naceSer() {
		this.menores.add(new Ser());
	}
	
	public void establecerNacimientos(long cantidad) {
		for (int i = 0; i < cantidad; i++) {
			naceSer();
		}
		
	}
	
	public long getMenoresSize() {
		return this.menores.size();
	}
	
	public long getAncianosSize() {
		return this.ancianos.size();
	}
	
	public ArrayList<Ser> getMenores() {
		return menores;
	}

	public ArrayList<Ser> getAncianos() {
		return ancianos;
	}

	public void alimentarMenores(long sueldo) {
		for (Ser ser : menores) {
			ser.vivir((int) (sueldo / this.getMenoresSize()));
		}
		
	}

	public void alimentarAncianos(long sueldo) {
		for (Ser ser : ancianos) {
			ser.vivir((int) (sueldo / this.getAncianosSize()));
		}
		
	}

	public void alimentarParados(long sueldo, ArrayDeque<Ser> parados) {
		for (Ser ser : parados) {
			ser.vivir((int) (sueldo / parados.size()));
		}
		
	}

	public void alimentarTrabajadores(long sueldo, Stack<Ser> trabajadores) {
		for (Ser ser : trabajadores) {
			ser.vivir((int) (sueldo / trabajadores.size()));
		}
		
	}
	
	

}
