package modelo;

public class GestionDatos {
	private TableroAleatorio tAleatorio;


	public boolean marcarCasilla(Coordenada coordenada) {
		return tAleatorio.marcarCasilla(coordenada);
	}
	
	public void desvelarCasilla(Coordenada coordenada) {
		tAleatorio.desvelarCasilla(coordenada);
	}
	public void crearTablero(Dificultad dificultad, Densidad densidad) {
	tAleatorio=new	TableroAleatorio(dificultad.getLongitud(),tAleatorio.minasDensidad(dificultad, densidad));
		
	}
	
}
