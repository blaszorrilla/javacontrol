package producto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProductoAbm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	JButton btnNuevo = new JButton("Nuevo");
	JButton btnGuardar = new JButton("Guardar");
	JButton btnBuscar = new JButton("Buscar");
	JButton btnModificar = new JButton("Modificar");
	JButton btnEliminar = new JButton("Eliminar");
	JButton btnCancelar = new JButton("Cancelar");
	
	static String codigo_producto;		// atributo para pasar codigo
	static String cod_barra_producto;		// atributo para pasar codigo
	static String nombre_producto;		// atributo para pasar codigo
	static String descripcion_producto;		// atributo para pasar codigo
	static String cantidad_producto;		// atributo para pasar codigo
	static String precio_producto;		// atributo para pasar codigo
	
	public String codigo="0";
	static int activar_actualizacion=0;		// atributo para pasar codigo
	BusquedaProducto b=null;
	/**
	 * Launch the application.
	 */
/*
	public static void main(String[] args) {
		try {
			ProductoAbm dialog = new ProductoAbm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public ProductoAbm(java.awt.Frame parent,boolean modal) {
		super(parent, modal);
		setTitle("Gestión Producto");
		setBounds(100, 100, 682, 349);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				if(activar_actualizacion==1){
					actualizar_interfaz();
					ManejoBotones(false, false, true, true, true, true);
					ProductoAbm.activar_actualizacion=0;
				}	
			}
		});
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registro Producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 646, 253);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(149, 28, 197, 20);
		panel.add(textField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ProductoAbm.class.getResource("/imagenes/java1.png")));
		label.setBounds(493, 11, 144, 245);
		panel.add(label);
		
		JLabel label_1 = new JLabel("(*) Campos Obligatorios");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(501, 230, 136, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("(*)");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(434, 28, 29, 14);
		panel.add(label_2);
		
		JLabel lblCdbarra = new JLabel("C\u00F3d./Barra:");
		lblCdbarra.setBounds(10, 34, 130, 14);
		panel.add(lblCdbarra);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(149, 50, 275, 20);
		panel.add(textField_1);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 56, 130, 14);
		panel.add(lblNombre);
		
		JLabel label_4 = new JLabel("(*)");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(434, 50, 29, 14);
		panel.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(149, 72, 275, 20);
		panel.add(textField_2);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 78, 130, 14);
		panel.add(lblDescripcin);
		
		JLabel label_6 = new JLabel("(*)");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(434, 72, 29, 14);
		panel.add(label_6);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(149, 93, 275, 20);
		panel.add(textField_3);
		
		JLabel lblCantinicial = new JLabel("Cant./Inicial");
		lblCantinicial.setBounds(10, 99, 130, 14);
		panel.add(lblCantinicial);
		
		JLabel label_8 = new JLabel("(*)");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setBounds(434, 93, 29, 14);
		panel.add(label_8);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(149, 115, 275, 20);
		panel.add(textField_4);
		
		JLabel lblPrecioventa = new JLabel("Precio/Venta:");
		lblPrecioventa.setBounds(10, 121, 130, 14);
		panel.add(lblPrecioventa);
		
		JLabel label_10 = new JLabel("(*)");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_10.setBounds(434, 115, 29, 14);
		panel.add(label_10);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManejoBotones(false,true,false,false,false,true);
				ManejoTexto(true,"SI");
			}
		});
		
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 10));
		btnNuevo.setEnabled(true);
		btnNuevo.setBounds(160, 275, 81, 23);
		contentPanel.add(btnNuevo);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ProductoAbmProceso n=new ProductoAbmProceso();
				String verif=n.ValidarCampos(codigo, textField.getText(), textField_1.getText(), textField_3.getText(), textField_4.getText());
				if(verif.equals("SI")){
					JOptionPane.showMessageDialog(ProductoAbm.this, n.mensaje_proceso);
					aplicarfoco(n.elemento_acceso);
				}else{
					int i=JOptionPane.showConfirmDialog(ProductoAbm.this, "¿DESEA GUARDAR ESTOS DATOS?","GUARDAR",JOptionPane.INFORMATION_MESSAGE);
					if(i==0){
						if(n.tipo_proceso.equals("MODIFICAR")){
							n.modificar(codigo, textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText());
							ManejoBotones(true,false,true,false,false,true);
							ManejoTexto(false,"SI");
							codigo="0";
						}else{
							codigo=n.Nuevo();
							n.guadar(codigo, textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText());
							ManejoBotones(true,false,true,false,false,true);
							ManejoTexto(false,"SI");
							codigo="0";
						}
					}
				}

			
			}
		});
		
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 10));
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(243, 275, 81, 23);
		contentPanel.add(btnGuardar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(b instanceof BusquedaProducto){
					//	b=new BusquedaProveedor();
						b.setModal(true);
						b.setLocationRelativeTo(null);
						b.setVisible(true);
					}else{
						b=new BusquedaProducto();
						b.setModal(true);
						b.setLocationRelativeTo(null);
						b.setVisible(true);
				}
			}
		});
		
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 10));
		btnBuscar.setEnabled(true);
		btnBuscar.setBounds(324, 275, 81, 23);
		contentPanel.add(btnBuscar);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManejoBotones(false,true,false,false,false,true);
				ManejoTexto(true, "NO");
			}
		});
		
		btnModificar.setFont(new Font("Arial", Font.BOLD, 10));
		btnModificar.setEnabled(false);
		btnModificar.setBounds(406, 275, 87, 23);
		contentPanel.add(btnModificar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ProductoAbmProceso n=new ProductoAbmProceso();
				int i=JOptionPane.showConfirmDialog(ProductoAbm.this, "¿DESEA ELIMINAR ESTE REGISTRO?","ELIMINAR",JOptionPane.INFORMATION_MESSAGE);
				if(i==0){
					n.eliminar(codigo);
					codigo="0";
					ManejoBotones(true,false,true,false,false,true);
					ManejoTexto(false,"SI");
				}
			}
		});
		
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 10));
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(494, 275, 81, 23);
		contentPanel.add(btnEliminar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManejoBotones(true,false,true,false,false,true);
				ManejoTexto(false,"SI");
			}
		});
		
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 10));
		btnCancelar.setEnabled(true);
		btnCancelar.setBounds(575, 275, 81, 23);
		contentPanel.add(btnCancelar);
	}
	private void ManejoBotones(boolean n,boolean g,boolean b,boolean m,boolean e,boolean c){
		btnNuevo.setEnabled(n);
		btnGuardar.setEnabled(g);
		btnBuscar.setEnabled(b);
		btnModificar.setEnabled(m);
		btnEliminar.setEnabled(e);
		btnCancelar.setEnabled(c);
	}
	private void ManejoTexto(boolean n1,String limpiar){
		textField.setEditable(n1);
		textField_1.setEditable(n1);
		textField_2.setEditable(n1);
		textField_3.setEditable(n1);
		textField_4.setEditable(n1);
		textField.requestFocus();
		if(limpiar=="SI"){
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
		}
	}
	private void actualizar_interfaz(){
		codigo=codigo_producto;
		textField.setText(cod_barra_producto);
		textField_1.setText(nombre_producto);
		textField_2.setText(descripcion_producto);
		textField_3.setText(cantidad_producto);
		textField_4.setText(precio_producto);
//		ManejoTexto(true, "NO");
		ManejoBotones(false,false,false,true,true,true);
	}
	private void aplicarfoco(String valor){
		if(valor.equals("cod_barra")){
			textField.requestFocus();
		}else{
			if(valor.equals("nombre")){
				textField_1.requestFocus();
			}else{
				if(valor.equals("cantidad")){
					textField_3.requestFocus();
				}else{
					if(valor.equals("precio")){
						textField_4.requestFocus();
					}else{
						
					}
				}
			}
		}
	}
	
}
