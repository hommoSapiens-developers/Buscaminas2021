package vista;

import java.awt.GridLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import modelo.Coordenada;
import modelo.TableroAleatorio;

public class Botonera extends JPanel {

	private JButton botones[][];
	private TableroAleatorio tablero;
	
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
				this.botones[i][j].addMouseListener(miMouseAdapter);
			}
		}
	}
	
	/**
	 * Events for the Buttons.
	 */
	MouseAdapter miMouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			if (e.getButton() == 1) {
				System.out.println("boton izquierdo");
				JButton boton = (JButton) e.getSource();
				Coordenada coordenada = getCoordenada(boton);
				tablero.desvelarCasilla(coordenada);
			}
			if (e.getButton() == 3) {
				System.out.println("boton derecho");
				JButton boton = (JButton) e.getSource();
				Coordenada coordenada2 = getCoordenada(boton);
				if (tablero.marcarCasilla(coordenada2)) {
					boton.setText("X");
				}
			}
			if (tablero.perderPartida()) {
				tablero.mostrarTableroDesvelado();
			}else {
				tablero.ganarPartida();
			}
		}
	};

	public JButton getButton(Coordenada coordenada) {
		return this.botones[coordenada.getPosX()][coordenada.getPosY()];
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

	public int getAlto() {
		return botones.length;
	}

	public int getAncho() {
		return botones[0].length;
	}

}
