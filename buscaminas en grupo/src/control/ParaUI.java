package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Densidad;
import modelo.Dificultad;
import vista.UI;

public class ParaUI extends UI {

	private Controlador controlador;
	private ActionListener actionListener;

	public ParaUI() {
		super();
		controlador = new Controlador();
		getBtnIniciar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Densidad densidad = (Densidad) getCmbDensidad().getSelectedItem();
				Dificultad dificultad = (Dificultad) getCmbDificultad().getSelectedItem();
				controlador.creaTablero(dificultad.getLongitud(), densidad.getPorcentaje());
				addBotonera(dificultad.getLongitud());
				botonera.setVisible(true);
				//esto da fallo seria para cambiar el ui de forma
//				if (controlador.ganarPartida()) {
//					addGanarPartida();
//				}
//				if (controlador.perderPartida()) {
//					addPerderPartida();
//				}
			}
		});
		
	}
	
	private void preparameLaBotonera() {
		this.actionListenerBotonera();
		this.addEventosBotonera();

	}

	private void actionListenerBotonera() {
		this.actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton boton = (JButton) e.getSource();
//				Coordenada coordenada2 = botonera.getCoordenada(boton);
//				int minasAlrededor = tablero.getCasilla(coordenada2).getMinasAlrededor();
//				boton.setText(String.valueOf(minasAlrededor));

			}
		};

	}

	private void addEventosBotonera() {
		Component[] boton = this.botonera.getComponents();
		for (Component component : boton) {
			((JButton) component).addActionListener(this.actionListener);
		}
	}
}
