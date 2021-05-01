package control;

import modelo.Coordenada;
import modelo.GestionDatos;

public class Controlador {
	private GestionDatos gestion;

	public Controlador() {
		gestion = new GestionDatos();

	}

	public void creaTablero(int tamano, int numMinas) {
		this.gestion.crearTablero(tamano, numMinas);
	}
	
	public boolean ganarPartida() {
		return gestion.ganarPartida();
	}
	
	public boolean perderPartida() {
		return gestion.perderPartida();
	}
}