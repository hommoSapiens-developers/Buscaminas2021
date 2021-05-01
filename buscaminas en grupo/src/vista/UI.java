package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import modelo.Densidad;
import modelo.Dificultad;

public class UI extends JFrame {
	
	private JPanel contentPane;
	public JPanelOpciones jPanelOpciones;
	public JPanelGanador JPanelGanador;
	public JPanelPerdedor JPanelPerdedor;
	public Botonera botonera;
	
	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);		
		jPanelOpciones=new JPanelOpciones();
		contentPane.add(jPanelOpciones, BorderLayout.SOUTH);
	}
	
	public void addBotonera(int tamano) {
		botonera = new Botonera(tamano);
		contentPane.add(botonera, BorderLayout.CENTER);
		botonera.setVisible(false);		
		jPanelOpciones.setVisible(false);
	}
	
	public void addGanarPartida() {
		JPanelGanador = new JPanelGanador();
		contentPane.add(JPanelGanador, BorderLayout.SOUTH);
		botonera.setEnabled(false);
	}
	
	public void addPerderPartida() {
		JPanelPerdedor = new JPanelPerdedor();
		contentPane.add(JPanelPerdedor, BorderLayout.SOUTH);
		botonera.setEnabled(false);
	}

	public void tomaValores(Densidad densidad, Dificultad dificultad) {
		System.out.println(densidad+" "+dificultad);
		
	}

	public JButton getBtnIniciar() {
		return jPanelOpciones.getBtnIniciar();
	}

	public JComboBox getCmbDificultad() {
		return jPanelOpciones.getCmbDificultad();
	}

	public JComboBox getCmbDensidad() {
		return jPanelOpciones.getCmbDensidad();
	}

}
