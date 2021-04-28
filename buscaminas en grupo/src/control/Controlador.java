package control;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.TableroAleatorio;

public class Controlador {
	private TableroAleatorio TableroAleatorio;
	private Densidad densidad;
	private Dificultad dificultad;

	public Controlador() {
		super();
		TableroAleatorio = new TableroAleatorio(this.dificultad.getLongitud(),
				this.densidad.CalculaMinasDensidad(dificultad, densidad));
	}

	public boolean marcarCasilla(Coordenada coordenada) {
		return TableroAleatorio.marcarCasilla(coordenada);
	}

	public void desvelarCasilla(Coordenada coordenada) {
		TableroAleatorio.desvelarCasilla(coordenada);
	}

	public TableroAleatorio iniciarJuego(Dificultad dificultad, Densidad densidad) {
		return new TableroAleatorio(dificultad.getLongitud(), densidad.CalculaMinasDensidad(dificultad, densidad));
	}
}