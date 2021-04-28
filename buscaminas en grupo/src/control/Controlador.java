package control;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.GestionDatos;
import modelo.TableroAleatorio;

public class Controlador {
	private GestionDatos gestion;
//	private TableroAleatorio TableroAleatorio;

	public Controlador() {
		gestion = new GestionDatos();

	}

	public void creaTablero(int tamano, int numMinas) {
		this.gestion.crearTablero(tamano, numMinas);
	}

//		TableroAleatorio = new TableroAleatorio(this.dificultad.getLongitud(),
//				this.densidad.CalculaMinasDensidad(dificultad, densidad));

//	public boolean marcarCasilla(Coordenada coordenada) {
//		return TableroAleatorio.marcarCasilla(coordenada);
//	}

//	public void desvelarCasilla(Coordenada coordenada) {
//		TableroAleatorio.desvelarCasilla(coordenada);
//	}

//	public TableroAleatorio iniciarJuego(Dificultad dificultad, Densidad densidad) {
//		return new TableroAleatorio(dificultad.getLongitud(), densidad.CalculaMinasDensidad(dificultad, densidad));
//	}
}