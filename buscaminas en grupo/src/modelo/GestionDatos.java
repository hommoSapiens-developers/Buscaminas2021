package modelo;

public class GestionDatos {
	
	private TableroAleatorio tAleatorio;

	public GestionDatos(){
		super();
		
	}
	public void crearTablero(int dificultad, int densidad) {
		tAleatorio = new TableroAleatorio(dificultad,generaMinasTablero(dificultad, densidad));
		
	}
	
	public int generaMinasTablero(int tamano, int NumMinas) {
		
		return ((tamano*tamano)*NumMinas/100);
	}
	
//
//	public boolean marcarCasilla(Coordenada coordenada) {
//		return tAleatorio.marcarCasilla(coordenada);
//	}
//	
//	public void desvelarCasilla(Coordenada coordenada) {
//		tAleatorio.desvelarCasilla(coordenada);
//	}
}
