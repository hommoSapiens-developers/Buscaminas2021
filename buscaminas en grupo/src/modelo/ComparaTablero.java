package modelo;

import ensayoUI.PruebaPanelOopciones;

public class ComparaTablero {
	private static boolean[][] casillas;
	TableroAleatorio tableroAleatorio;
	
	public static void main(String[] args) {
		Coordenada coordenada = new Coordenada(1, 3);
		tableroMarcadas(5,coordenada);
		
	}

	public static boolean tableroMarcadas(int lado, Coordenada coordenada) {
		casillas = new boolean[lado][lado];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				casillas[i][j] = false;
			}
		}

		int Y = coordenada.getPosY();
		int X = coordenada.getPosX();

		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				if (casillas[i][j] == casillas[X][Y]) {
					if (casillas[i][j] == false) {
						casillas[i][j] = true;
						System.out.println("true");
						return true;
					}else {
						System.out.println("false");
						return false;
					}
				}
			}
		}

		return casillas != null;
	}
	
}
