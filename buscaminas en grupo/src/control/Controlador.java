package control;


import javax.swing.JButton;


import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.GestionDatos;

public class Controlador {
	private GestionDatos gestion;
	
	public Controlador() {
		super();
		gestion=new GestionDatos();
	}	
	public boolean marcarCasilla(Coordenada coordenada) {
		return gestion.marcarCasilla(coordenada);
	}
	
	public void desvelarCasilla(Coordenada coordenada) {
		gestion.desvelarCasilla(coordenada);
	}
	public void crearTablero(Dificultad dificultad, Densidad densidad) {
		gestion.crearTablero(dificultad, densidad);

  }
}