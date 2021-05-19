package modelo.estado;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.ser.Ser;

//Se encargad de gestionar menores,ancianos y parados
// se encarga del pago de estos sectores
public class MinisterioSocial {
	private final ArrayList<Ser> menores = new ArrayList<>();
	private final ArrayList<Ser> ancianos = new ArrayList<>();
	
	private void naceSer() {
		this.menores.add(new Ser());

	}
	
	public void establecerNacimientos(long trabajadoresFaltantes) {
		for (int i = 0; i < trabajadoresFaltantes; i++) {
			naceSer();
		}
		
	}
	
	
	

}
