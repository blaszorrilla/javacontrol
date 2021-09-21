package ayuda;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

public class Acerca extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
/*
	public static void main(String[] args) {
		try {
			Acerca dialog = new Acerca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public Acerca(java.awt.Frame parent,boolean modal) {
		super(parent, modal);	
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 447, 440);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnCursoAvanzadoDe = new JTextPane();
		txtpnCursoAvanzadoDe.setEditable(false);
		txtpnCursoAvanzadoDe.setText("Curso Avanzado de Programaci\u00F3n en Java Swing \r\n\r\nJavaControl nace a partir del curso organizado por el CEII en conjunto con la Universidad Tecnol\u00F3gica Intercontinental sede Encarnaci\u00F3n, impulsando la programaci\u00F3n en lenguaje java, con interacci\u00F3n a la base de datos MySQL. Permitiendo manipular datos de forma din\u00E1mica y ayudando como demo para un proyecto inicial.");
		txtpnCursoAvanzadoDe.setBounds(10, 201, 414, 126);
		contentPanel.add(txtpnCursoAvanzadoDe);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Acerca de JavaControl", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 179);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Acerca.class.getResource("/imagenes/logo.png")));
		label.setBounds(10, 11, 145, 154);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Acerca.class.getResource("/imagenes/ceii_1.png")));
		label_1.setBounds(170, 27, 234, 138);
		panel.add(label_1);
	}
}
