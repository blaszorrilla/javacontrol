package compra;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	static String posicion;
	static String codigo;
	static String cod_barra;
	static String producto;
	static String cantidad;
	static String precio;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarProducto dialog = new ModificarProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarProducto() {
		setBounds(100, 100, 450, 228);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				posicion=CompraAbm.posicion_producto;
				textField.setText(CompraAbm.cod_barra_producto);
				textField_1.setText(CompraAbm.descripcion_producto);
				textField_2.setText(CompraAbm.cantidad_producto);
				textField_3.setText(CompraAbm.precio_producto);
				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Modificar Producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 135);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdbarra = new JLabel("C\u00F3d./Barra:");
		lblCdbarra.setBounds(10, 35, 129, 14);
		panel.add(lblCdbarra);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(10, 60, 129, 14);
		panel.add(lblProducto);
		
		JLabel lblPrecio = new JLabel("Cantidad:");
		lblPrecio.setBounds(10, 85, 129, 14);
		panel.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Precio:");
		lblCantidad.setBounds(10, 110, 129, 14);
		panel.add(lblCantidad);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(132, 32, 244, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(132, 57, 244, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(132, 82, 244, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(132, 107, 244, 20);
		panel.add(textField_3);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompraAbm.posicion_producto=posicion;
//				CompraAbm.cod_barra_producto=cod_barra;
//				CompraAbm.descripcion_producto=producto;
				CompraAbm.cantidad_producto=textField_2.getText();
				CompraAbm.precio_producto=textField_3.getText();
				CompraAbm.activar_actualizacion=3;
	            dispose();
			}
		});
		btnAgregar.setBounds(335, 157, 89, 23);
		contentPanel.add(btnAgregar);
	}
}
