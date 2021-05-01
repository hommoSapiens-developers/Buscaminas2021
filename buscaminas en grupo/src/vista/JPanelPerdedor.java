package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import modelo.Densidad;
import modelo.Dificultad;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.FlowLayout;
import java.awt.Point;

public class JPanelPerdedor extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanelPerdedor() {
		setBounds(new Rectangle(0, 100, 0, 0));
						setLayout(new GridLayout(0, 1, 0, 0));
						JLabel lblNewLabel = new JLabel("¡Has perdido!");
						lblNewLabel.setVisible(true);
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
						lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
						add(lblNewLabel);
	}
}
