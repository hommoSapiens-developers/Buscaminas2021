package ensayoUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.Tablero;
import modelo.TableroAleatorio;
import vista.Botonera;
import javax.swing.JTextField;

public class EnsayoBotonera extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private TableroAleatorio tablero = new TableroAleatorio(Dificultad.medio.getLongitud(), 5);
	private Botonera botonera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnsayoBotonera frame = new EnsayoBotonera();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EnsayoBotonera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		textField = new JTextField();
		textField.setColumns(10);
		botonera = new Botonera(Dificultad.medio.getLongitud());
		contentPane.add(botonera, BorderLayout.CENTER);
		asociarBotones();
	}

	private void asociarBotones() {
		for (int i = 0; i < this.botonera.getAlto(); i++) {
			for (int j = 0; j < this.botonera.getAncho(); j++) {
				Coordenada coordenada = new Coordenada(i, j);
				botonera.getButton(coordenada).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton boton = (JButton) e.getSource();
						Coordenada coordenada2 = botonera.getCoordenada(boton);
						int minasAlrededor = tablero.getCasilla(coordenada2).getMinasAlrededor();
						boton.setText(String.valueOf(minasAlrededor));
					}
				});
				;
			}
		}
	}
}
