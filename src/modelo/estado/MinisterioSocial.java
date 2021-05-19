package modelo.estado;

import java.util.ArrayList;
import java.util.Iterator;

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
	//TODO PAGOS
	
	

}
