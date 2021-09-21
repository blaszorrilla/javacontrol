package AbmAcceso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import configuracion.Modelo;

public class Acceso extends JDialog {

	private final JPanel contentPane = new JPanel();
//	private JPanel contentPane2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	JComboBox comboBox = new JComboBox();
	JCheckBox checkBox = new JCheckBox("");
	
	JButton btnNuevo = new JButton("Nuevo");
	JButton btnGuardar = new JButton("Guardar");
	JButton btnBuscar = new JButton("Buscar");
	JButton btnModificar = new JButton("Modificar");
	JButton btnEliminar = new JButton("Eliminar");
	JButton btnCancelar = new JButton("Cancelar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Acceso dialog = new Acceso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Acceso() {
		setBounds(100, 100, 595, 416);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n de Acceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 558, 317);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(141, 24, 228, 20);
		panel.add(textField);
		
		JLabel label = new JLabel("Cedula:");
		label.setBounds(10, 24, 126, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Nombre y Apellido:");
		label_1.setBounds(10, 59, 126, 14);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(141, 59, 228, 20);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("Direcci\u00F3n:");
		label_2.setBounds(10, 87, 126, 14);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(141, 87, 228, 20);
		panel.add(textField_2);
		
		JLabel label_3 = new JLabel("Tel\u00E9fono:");
		label_3.setBounds(10, 123, 126, 14);
		panel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(141, 123, 228, 20);
		panel.add(textField_3);
		
		JLabel label_4 = new JLabel("E-mail:");
		label_4.setBounds(10, 151, 126, 14);
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(141, 151, 228, 20);
		panel.add(textField_4);
		
		JLabel label_5 = new JLabel("Rol:");
		label_5.setBounds(10, 187, 126, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Usuario:");
		label_6.setBounds(10, 212, 126, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Contrase\u00F1a:");
		label_7.setBounds(10, 248, 126, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Activo:");
		label_8.setBounds(10, 287, 126, 14);
		panel.add(label_8);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ADMINISTRADOR", "ENCARGADO/COMPRA", "ENCARGADO/VENTA"}));
		comboBox.setBounds(141, 182, 228, 20);
		panel.add(comboBox);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(141, 209, 228, 20);
		panel.add(textField_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(141, 245, 228, 20);
		panel.add(passwordField);
		
		
		checkBox.setBounds(141, 287, 30, 23);
		panel.add(checkBox);
		btnNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Habilitar_botones(false, true, false, false, false, true);
				hablitar_TXT(true);
			}
		});
		
		
		btnNuevo.setBounds(10, 336, 89, 23);
		contentPane.add(btnNuevo);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String chequeo="";
				if(checkBox.isSelected()==true){
					chequeo="ACTIVO";
				}else{
					chequeo="INACTIVO";
				}
				String valorcombo=String.valueOf(comboBox.getSelectedItem());
				Modelo n= new Modelo();
				String codigo=n.Nuevo("SELECT IFNULL(MAX(id_acceso),0)+1 AS codigo FROM acceso ");
				n.guardar("INSERT INTO acceso(id_acceso,ci,nombre,apellido,direccion,email,rol,usu,pass,estado) "
+ "VALUES('"+codigo+"','"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_4.getText()+"','"+valorcombo+"','"+textField_5.getText()+"','"+passwordField.getText()+"','"+chequeo+"')");
			}
		});
		
		
		btnGuardar.setBounds(104, 336, 89, 23);
		contentPane.add(btnGuardar);
		
		
		btnBuscar.setBounds(203, 336, 89, 23);
		contentPane.add(btnBuscar);
		
		
		btnModificar.setBounds(296, 336, 89, 23);
		contentPane.add(btnModificar);
		
		
		btnEliminar.setBounds(388, 336, 89, 23);
		contentPane.add(btnEliminar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Habilitar_botones(true, false, true, false, false, true);
				Limpiar_TXT();
				hablitar_TXT(false);
			}
		});
		
		
		btnCancelar.setBounds(479, 336, 89, 23);
		contentPane.add(btnCancelar);
		
		Habilitar_botones(true, false, true, false, false, true);
		Limpiar_TXT();
		hablitar_TXT(false);
	}
	public void Habilitar_botones(boolean n,boolean g,boolean b,boolean m,boolean e,boolean c){
		btnNuevo.setEnabled(n);
		btnGuardar.setEnabled(g);
		btnBuscar.setEnabled(b);
		btnModificar.setEnabled(m);
		btnEliminar.setEnabled(e);
		btnCancelar.setEnabled(c);
		
	}
	
	public void Limpiar_TXT(){
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		passwordField.setText("");
		checkBox.setSelected(false);
		comboBox.setSelectedIndex(0);
	}
	
	public void hablitar_TXT(boolean n){
		textField.setEnabled(n);
		textField_1.setEnabled(n);
		textField_2.setEnabled(n);
		textField_3.setEnabled(n);
		textField_4.setEnabled(n);
		textField_5.setEnabled(n);
		passwordField.setEnabled(n);
		checkBox.setEnabled(n);
		comboBox.setEnabled(n);
	}
}
