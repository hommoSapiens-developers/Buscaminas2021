package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.TableroAleatorio;
import vista.UI;

public class ParaUI extends UI {

	private Controlador controlador;
	private ActionListener actionListener;
	private TableroAleatorio tablero = new TableroAleatorio(Dificultad.medio.getLongitud(), 7);
	
	public ParaUI() {
		super();
		controlador=new Controlador();
		this.preparameLaBotonera();
		// leyes de demeter
		// para solucionar esto es crear metodos delegados
//		jPanelOpciones.btnIniciar.addActionListener(l);
		getBtnIniciar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Densidad densidad = (Densidad) getCmbDensidad().getSelectedItem();
				System.out.println(densidad);
				Dificultad dificultad = (Dificultad) getCmbDificultad().getSelectedItem();
				System.out.println(dificultad.getLongitud());
				controlador.crearTablero(dificultad,densidad);
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
		Component[]boton = this.botonera.getComponents();
		for (Component component : boton) {
			((JButton)component).addActionListener(this.actionListener);
		}
	}
//	private void visualizaBotonera() {
//		Component[] boton = this.botonera.getComponents();
//		for (Component component : boton) {
//			((JButton) component).setVisible(true);
//		}
		
//	}

}
