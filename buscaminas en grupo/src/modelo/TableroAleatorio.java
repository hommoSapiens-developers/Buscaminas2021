package modelo;

import java.util.ArrayList;
import utiles.Utiles;

public class TableroAleatorio extends Tablero {
	private Casilla[][] casillas;

	// Constructor aleatorio
	public TableroAleatorio(int lado, int minas) {
		super(lado);
		ArrayList<Coordenada> posiciones = generaAleatorio(minas, lado);
		disponerTablero(posiciones);
	}

	// constructor no aleatorio
	public TableroAleatorio(int lado, ArrayList<Coordenada> posiciones) {
		super(lado);
		disponerTablero(posiciones);
	}

	private void disponerTablero(ArrayList<Coordenada> posiciones) {
		colocarMinas(posiciones);
		contarMinasAlrededor(posiciones);
	}

	public boolean marcarCasilla(Coordenada coordenada) {
		Casilla casilla = getCasilla(coordenada);
		return casilla.setMarca();
	}

	public void desvelarCasilla(Coordenada coordenada) {

		Casilla casillaActual = getCasilla(coordenada);

		desvelarCasillaVelada(coordenada, casillaActual, coordenada.getPosX(), coordenada.getPosY());
		desvelarCasillasAlrededorDesvelada(coordenada, casillaActual, coordenada.getPosX(), coordenada.getPosY());
	}

	public boolean isDentroLimites(Coordenada alrededor) {
		return alrededor.getPosX() >= 0 && alrededor.getPosX() < casillas.length && alrededor.getPosY() >= 0
				&& alrededor.getPosY() < casillas.length;
	}

	public void desvelarCasillasAlrededorDesvelada(Coordenada coordenada, Casilla casillaActual, int posX, int posY) {
		if (!casillaActual.isVelada() && !casillaActual.isMarcada()) {
			int casillasMarcadas = 0;

			for (int i = posX - 1; i <= posX + 1; i++) {
				for (int j = posY - 1; j <= posY + 1; j++) {
					Coordenada coordenadaRecorrido = new Coordenada(i, j);
					if (isDentroLimites(coordenadaRecorrido) && !coordenada.equals(coordenadaRecorrido)
							&& getCasilla(coordenadaRecorrido).isMarcada()) {
						casillasMarcadas++;
					}
				}
			}
			if (casillasMarcadas == casillaActual.getMinasAlrededor()) {
				for (int i = posX - 1; i <= posX + 1; i++) {
					for (int j = posY - 1; j <= posY + 1; j++) {
						Coordenada coordenadaRecorrido = new Coordenada(i, j);
						if (isDentroLimites(coordenadaRecorrido) && getCasilla(coordenadaRecorrido).isVelada()
								&& !coordenada.equals(coordenadaRecorrido)) {
							desvelarCasilla(coordenadaRecorrido);
						}
					}
				}
			}

		}
	}

	public void desvelarCasillaVelada(Coordenada coordenada, Casilla casillaActual, int posX, int posY) {
		if (casillaActual.isVelada() && !casillaActual.isMarcada()) {
			casillaActual.setVelada(false);

			for (int i = posX - 1; i <= posX + 1; i++) {
				for (int j = posY - 1; j <= posY + 1; j++) {
					Coordenada coordenadaRecorrido = new Coordenada(i, j);
					if (isDentroLimites(coordenadaRecorrido) && casillaActual.getMinasAlrededor() == 0
							&& !coordenada.equals(coordenadaRecorrido) && !casillaActual.isMina()) {
						desvelarCasilla(coordenadaRecorrido);
					}
				}
			}
		}
	}

	public void contarMinasAlrededor(ArrayList<Coordenada> posiciones) {

		int longitud = 8;

		for (Coordenada coordenada : posiciones) {
			for (int i = 0; i < longitud; i++) {

				int[] casillasAlrededor = Utiles.damePosicionAlrededor(i);

				Coordenada miCordenada = new Coordenada(coordenada.getPosX() + casillasAlrededor[0],
						coordenada.getPosY() + casillasAlrededor[1]);
				if (miCordenada.getPosX() >= 0 && miCordenada.getPosY() >= 0 && miCordenada.getPosX() < getAlto()
						&& miCordenada.getPosY() < getAlto() && !getCasilla(miCordenada).isMina()) {

					getCasilla(miCordenada).incrementaUnaMinaAlrededor();
				}
			}

		}
	}

	private void colocarMinas(ArrayList<Coordenada> posiciones) {
		for (Coordenada coordenada : posiciones) {
			ponerMina(coordenada);
		}
	}

	private void ponerMina(Coordenada coordenada) {
		getCasilla(coordenada).setMina(true);
	}

	public ArrayList<Coordenada> generaAleatorio(int minas, int longitud) {
		assert minas > 0 && longitud > 0;
		assert minas < longitud * longitud;
		ArrayList<Coordenada> coordenadas = new ArrayList<Coordenada>();
		for (int i = 0; i < minas; i++) {
			Coordenada coord;
			do {
				coord = dameCoordenada(longitud);
			} while (existeCoord(coord, coordenadas));
			coordenadas.add(coord);
		}
		return coordenadas;
	}

	private Coordenada dameCoordenada(int lado) {
		return new Coordenada(Utiles.dameNumero(lado), Utiles.dameNumero(lado));
	}

	private boolean existeCoord(Coordenada coord, ArrayList<Coordenada> coordenadas) {
		for (int i = 0; i < coordenadas.size(); i++) {
			if (coord.equals(coordenadas.get(i))) {
				return true;
			}
		}
		return false;
	}

	public boolean perderPartida() {
		boolean bandera = false;
		
		for (int i = 0; i < casillas.length && !bandera; i++) {
			for (int j = 0; j < casillas.length && !bandera; j++) {
				Coordenada coordenadaActual = new Coordenada(i, j);
				if (this.getCasilla(coordenadaActual).isMina() && !this.getCasilla(coordenadaActual).isVelada()) {
					bandera = true;
				}
			}
		}
		if (bandera) {
			for (int k = 0; k < casillas.length; k++) {
				for (int h = 0; h < casillas.length; h++) {
					getCasilla(new Coordenada(k, h)).setVelada(false);
				}
			}
		}
		return bandera;
	}

	public void mostrarTableroDesvelado() {
		
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				Coordenada cordenadaActual = new Coordenada(i, j);
				if (getCasilla(cordenadaActual).isVelada()) {
					getCasilla(cordenadaActual).setVelada(false);
				}

			}
		}
	}

	public boolean ganarPartida() {
		boolean bandera = true;

		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				Coordenada cordenadaActual = new Coordenada(i, j);
				if (getCasilla(cordenadaActual).isVelada() && getCasilla(cordenadaActual).isMina()
						&& !getCasilla(cordenadaActual).isMarcada()) {
					bandera = false;
				}
				if (getCasilla(cordenadaActual).isVelada() && !getCasilla(cordenadaActual).isMina()) {
					bandera = false;
				}
				if (!getCasilla(cordenadaActual).isVelada() && getCasilla(cordenadaActual).isMina()) {
					bandera = false;
				}
			}
		}
		return bandera;
	}
}
