package ensayoUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import modelo.Coordenada;
import modelo.Dificultad;
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
				botonera.getButton(coordenada).addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						if (e.getButton() == 1) {
							System.out.println("boton izquierdo");
							JButton boton = (JButton) e.getSource();
							Coordenada coordenada = botonera.getCoordenada(boton);
							tablero.desvelarCasilla(coordenada);
						}
						if (e.getButton() == 3) {
							System.out.println("boton derecho");
							JButton boton = (JButton) e.getSource();
							Coordenada coordenada2 = botonera.getCoordenada(boton);
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
				});
				;
			}
		}
	}
}