package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import modelo.Coordenada;

public class Botonera extends JPanel {

	private JButton botones[][];

	/**
	 * Create the panel.
	 */
	public Botonera(int lado) {
		this.botones = new JButton[lado][lado];
		this.setLayout(new GridLayout(lado, lado, 0, 0));
		for (int i = 0; i < lado; i++) {
			for (int j = 0; j < lado; j++) {
				this.botones[i][j] = new JButton();
				this.add(this.botones[i][j]);
			}
		}
	}

	public JButton getButton(Coordenada coordenada) {
		return this.botones[coordenada.getPosX()][coordenada.getPosY()];
	}

	public int getAlto() {
		return botones.length;
	}

	public int getAncho() {
		return botones[0].length;
	}

	public Coordenada getCoordenada(JButton boton) {
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[0].length; j++) {
				if (botones[i][j] == boton) {
					return new Coordenada(i, j);
				}
			}
		}
		return null;
	}
}
