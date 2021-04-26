package modelo;

import java.util.ArrayList;
import utiles.Utiles;

public class TableroAleatorio extends Tablero {

	//Constructor aleatorio
	public TableroAleatorio(int lado, int minas) {
		super(lado);
		ArrayList<Coordenada> posiciones = generaAleatorio(minas, lado);
		disponerTablero(posiciones);
	}
	
	public boolean marcarCasilla(Coordenada coordenada) {
		Casilla casilla = getCasilla(coordenada);
		return casilla.setMarca();
	}
	
	//constructor no aleatorio
	public TableroAleatorio(int lado,ArrayList<Coordenada> posiciones) {
		super(lado);
		disponerTablero(posiciones);
	}
	private void disponerTablero(ArrayList<Coordenada> posiciones) {
		colocarMinas(posiciones);
		contarMinasAlrededor(posiciones);
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
//		long inicio = System.currentTimeMillis();
		ArrayList<Coordenada> coordenadas = new ArrayList<Coordenada>();
		for (int i = 0; i < minas; i++) {
			Coordenada coord;
			do {
				coord = dameCoordenada(longitud);
			} while (existeCoord(coord, coordenadas));
			coordenadas.add(coord);
		}
//		 long fin = System.currentTimeMillis();
//		 System.out.println("en milis "+(fin-inicio));
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
}
