package control;

import javax.swing.JButton;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.TableroAleatorio;
import vista.Botonera;

public class Controlador {
	private TableroAleatorio tableroAleatorio;
	
	public void dameValores(Densidad densidad, Dificultad dificultad) {

	}
	
	//del para ui llama a control y le entra el boton 
	public boolean marcarCasilla(Coordenada coordenada) {
		return tableroAleatorio.marcarCasilla(coordenada);
	}
	
	private void desvelarCasilla(Coordenada coordenada) {
		tableroAleatorio.desvelarCasilla(coordenada);
	}
}
