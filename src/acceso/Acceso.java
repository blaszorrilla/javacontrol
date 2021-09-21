package acceso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import principal.Principal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;

public class Acceso extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceso frame = new Acceso();
					frame.setLocationRelativeTo(null);
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
	public Acceso() {
		setTitle("Acceso - JAVACONTROL");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Acceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.control);
		panel.setBounds(10, 11, 381, 158);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(20, 116, 215, 2);
		panel.add(separator);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(20, 43, 72, 14);
		panel.add(lblUsuario);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(102, 40, 120, 20);
		panel.add(textField);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(20, 71, 72, 14);
		panel.add(lblContrasea);
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		textField_1.setBounds(102, 68, 120, 20);
		panel.add(textField_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Acceso.class.getResource("/imagenes/logo.png")));
		label.setBounds(245, 11, 131, 144);
		panel.add(label);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(Acceso.this, "Ingrese al Sistema","JavaControl", JOptionPane.INFORMATION_MESSAGE);
				AccesoProceso n1=new AccesoProceso();
				String existe=n1.Ingresar(textField.getText(), textField_1.getText());
				if(existe.equals("NO")){
					JOptionPane.showMessageDialog(Acceso.this, "Error - Datos Incorrectos","JavaControl - Error", JOptionPane.ERROR_MESSAGE);
					textField.requestFocus();
				}else{
					Principal JFrame = new Principal();
					JFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					JFrame.setVisible(true);
					Acceso.this.setVisible(false);
					JFrame.setDefaultCloseOperation (WindowConstants.DO_NOTHING_ON_CLOSE);
					
					JFrame.addWindowListener(new WindowAdapter(){
					    public void windowClosing(WindowEvent we){
					        int eleccion = JOptionPane.showConfirmDialog(null, "Desea salir de JAVACONTROL?","SALIR",JOptionPane.INFORMATION_MESSAGE);
					        if ( eleccion == 0) {
					            System.exit(0);
					        }  
					    }
					});
				}

			}
		});
		btnIngresar.setFont(new Font("Arial", Font.BOLD, 10));
		btnIngresar.setBounds(205, 180, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Arial", Font.BOLD, 10));
		btnSalir.setBounds(294, 180, 97, 23);
		contentPane.add(btnSalir);
	}
}
