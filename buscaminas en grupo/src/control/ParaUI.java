package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.TableroAleatorio;
import vista.Botonera;
import vista.UI;

public class ParaUI extends UI {

	private Controlador controlador;
	private ActionListener actionListener;
	private TableroAleatorio tablero = new TableroAleatorio(Dificultad.medio.getLongitud(), 7);

	public ParaUI() {
		super();
		controlador = new Controlador();
		this.preparameLaBotonera();
		getBtnIniciar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Densidad densidad = (Densidad) getCmbDensidad().getSelectedItem();
				Dificultad dificultad = (Dificultad) getCmbDificultad().getSelectedItem();
				controlador.iniciarJuego(dificultad, densidad);
//				desveladorController = new DesveladorController(tablero);
//				marcadorController = new MarcadorController(tablero);
//				Botonera botonera = new Botonera(lado, desveladorController, marcadorController);
				botonera.setVisible(true);
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
				Coordenada coordenada2 = botonera.getCoordenada(boton);
				int minasAlrededor = tablero.getCasilla(coordenada2).getMinasAlrededor();
				boton.setText(String.valueOf(minasAlrededor));

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
