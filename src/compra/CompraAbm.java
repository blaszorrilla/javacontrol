package compra;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JSeparator;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompraAbm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTextField textField_6;
	JButton btnNuevo = new JButton("Nuevo");
	JButton btnGuardar = new JButton("Guardar");
	JButton btnBuscar = new JButton("Buscar");
	JButton btnAnular = new JButton("Anular");
	JButton btnCancelar = new JButton("Cancelar");
	
	JButton btnAgregar = new JButton("Agregar");
	JButton btnBorrar = new JButton("Borrar");
	JButton btnModificar = new JButton("Modificar");
	
	JButton btnProveedor = new JButton("...");
	
	public String codigo="0";
	static int activar_actualizacion=0;		// atributo para pasar codigo
	
	//	Pasar Datos Proveedor
	static String codigo_proveedor;
	static String ruc_proveedor;
	static String razon_proveedor;
	static String telefono_proveedor;
	
	//	Pasar Producto
	static String posicion_producto;
	static String codigo_producto;
	static String cod_barra_producto;
	static String descripcion_producto;
	static String cantidad_producto;
	static String precio_producto;
	static String subtotal_producto;
	
	BusquedaProveedor VentanaProveedor=null;
	BusquedaProducto VentanaProducto=null;
	ModificarProducto VentanaModificarP=null;
	
	DefaultTableModel modelo;
	
	static String[] arrayproducto=null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CompraAbm dialog = new CompraAbm();
			dialog.setLocationRelativeTo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
//	public Compra(java.awt.Frame parent,boolean modal) {
//	super(parent, modal);

	public CompraAbm() {
		setTitle("Gestión de Compra");
		setBounds(100, 100, 690, 545);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				if(activar_actualizacion==1){
					actualizar_interfaz();
			//		ManejoBotones(false, false, true, true, true, false, false, false, false);
					CompraAbm.activar_actualizacion=0;
				}else{
					if(activar_actualizacion==2){
						actualizar_interfaz_producto();
				//		ManejoBotones(false, false, true, true, true, false, false, false, false);
						CompraAbm.activar_actualizacion=0;
					}else{
						if(activar_actualizacion==3){
							actualizar_producto();
					//		ManejoBotones(false, false, true, true, true, false, false, false, false);
							System.out.println("paso aqui");
							CompraAbm.activar_actualizacion=0;
						}
					}
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Gesti\u00F3n de Compra", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.control);
		panel.setBounds(10, 11, 653, 455);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n de Compra", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(10, 23, 314, 104);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(92, 25, 155, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNroCompra = new JLabel("Nro Compra:");
		lblNroCompra.setBounds(10, 28, 72, 14);
		panel_1.add(lblNroCompra);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(92, 48, 155, 20);
		panel_1.add(textField_1);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 51, 72, 14);
		panel_1.add(lblFecha);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(92, 73, 155, 20);
		panel_1.add(textField_2);
		
		JLabel lblNroBoleta = new JLabel("Nro. Boleta:");
		lblNroBoleta.setBounds(10, 76, 72, 14);
		panel_1.add(lblNroBoleta);
		
		JLabel lblAaaammdd = new JLabel("AAAA-MM-DD");
		lblAaaammdd.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblAaaammdd.setBounds(250, 51, 64, 14);
		panel_1.add(lblAaaammdd);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Informaci\u00F3n de Proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.control);
		panel_2.setBounds(334, 23, 311, 104);
		panel.add(panel_2);
		
		JLabel lblRuc = new JLabel("R.U.C.:");
		lblRuc.setBounds(10, 28, 72, 14);
		panel_2.add(lblRuc);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(108, 25, 167, 20);
		panel_2.add(textField_3);
		
		JLabel lblRaznSocial = new JLabel("Raz\u00F3n Social:");
		lblRaznSocial.setBounds(10, 50, 88, 14);
		panel_2.add(lblRaznSocial);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(108, 47, 193, 20);
		panel_2.add(textField_4);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(10, 76, 72, 14);
		panel_2.add(lblTelfono);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(108, 73, 193, 20);
		panel_2.add(textField_5);
		btnProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(VentanaProveedor instanceof BusquedaProveedor){
					//	b=new BusquedaProveedor();
					VentanaProveedor.setModal(true);
					VentanaProveedor.setLocationRelativeTo(null);
					VentanaProveedor.setVisible(true);
					}else{
						VentanaProveedor=new BusquedaProveedor();
						VentanaProveedor.setModal(true);
						VentanaProveedor.setLocationRelativeTo(null);
						VentanaProveedor.setVisible(true);
				}
			}
		});
		
		btnProveedor.setBounds(274, 25, 26, 19);
		panel_2.add(btnProveedor);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(10, 138, 635, 2);
		panel.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 189, 635, 235);
		panel.add(scrollPane);
		
		table = new JTable();
		modelo=new DefaultTableModel();
		table.setModel(modelo);
		modelo.addColumn("ID");
		modelo.addColumn("Cód./Barra");
		modelo.addColumn("Producto");
		modelo.addColumn("Cant.");
		modelo.addColumn("Precio");
		modelo.addColumn("Subtotal");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		scrollPane.setViewportView(table);
		
		textField_6 = new JTextField();
		textField_6.setBounds(520, 425, 125, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotal.setBounds(473, 428, 48, 14);
		panel.add(lblTotal);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arrayproducto= new String[modelo.getRowCount()];
				for (int i = 0; i < modelo.getRowCount(); i++) {
					arrayproducto[i]=String.valueOf(table.getValueAt(i, 0));
				}
				if(VentanaProducto instanceof BusquedaProducto){
					VentanaProducto.setModal(true);
					VentanaProducto.setLocationRelativeTo(null);
					VentanaProducto.setVisible(true);
					}else{
						VentanaProducto=new BusquedaProducto();
						VentanaProducto.setModal(true);
						VentanaProducto.setLocationRelativeTo(null);
						VentanaProducto.setVisible(true);
				}
				
			}
		});
		
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 10));
		btnAgregar.setBounds(399, 155, 81, 23);
		panel.add(btnAgregar);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int fila = table.getSelectedRow();                 
		        if (fila > -1){ 
					posicion_producto=String.valueOf(table.getSelectedRow());
					codigo_producto=String.valueOf(modelo.getValueAt(table.getSelectedRow(), 0));
					cod_barra_producto=String.valueOf(modelo.getValueAt(table.getSelectedRow(), 1));
					descripcion_producto=String.valueOf(modelo.getValueAt(table.getSelectedRow(), 2));
					cantidad_producto=String.valueOf(modelo.getValueAt(table.getSelectedRow(), 3));
					precio_producto=String.valueOf(modelo.getValueAt(table.getSelectedRow(), 4));
					if(VentanaModificarP instanceof ModificarProducto){
						//	b=new BusquedaProveedor();
						VentanaModificarP.setModal(true);
						VentanaModificarP.setLocationRelativeTo(null);
						VentanaModificarP.setVisible(true);
						}else{
							VentanaModificarP=new ModificarProducto();
							VentanaModificarP.setModal(true);
							VentanaModificarP.setLocationRelativeTo(null);
							VentanaModificarP.setVisible(true);
					}
				
				}else{
					JOptionPane.showMessageDialog(CompraAbm.this, "DEBE SELECCIONAR EL DATO QUE DESEA MODIFICAR");
				}
			}
		});
		
		btnModificar.setFont(new Font("Arial", Font.BOLD, 10));
		btnModificar.setBounds(480, 155, 81, 23);
		panel.add(btnModificar);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int fila = table.getSelectedRow();                 
		        if (fila > -1){
					int i=JOptionPane.showConfirmDialog(CompraAbm.this, "¿DESEA BORRAR ESTE REGISTRO?","BORRAR",JOptionPane.INFORMATION_MESSAGE);
					if(i==0){
						modelo.removeRow(table.getSelectedRow());
					}
				}else{
					JOptionPane.showMessageDialog(CompraAbm.this, "DEBE SELECCIONAR EL DATO QUE DESEA BORRAR");
				}
			}
		});
		
		btnBorrar.setFont(new Font("Arial", Font.BOLD, 10));
		btnBorrar.setBounds(562, 155, 81, 23);
		panel.add(btnBorrar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompraAbmProceso m= new CompraAbmProceso();
				m.guadar(textField.getText(), codigo_proveedor," 1", textField_1.getText(), textField_2.getText(), "NO");
				
				for (int i = 0; i < modelo.getRowCount(); i++) {
					System.out.println(i);
					m.guadar_detalle(textField.getText(), String.valueOf(modelo.getValueAt(i, 0)), String.valueOf(modelo.getValueAt(i, 3)), String.valueOf(modelo.getValueAt(i, 4)));
				}
			}
		});
		

		btnGuardar.setFont(new Font("Arial", Font.BOLD, 10));
		btnGuardar.setBounds(338, 477, 81, 23);
		contentPanel.add(btnGuardar);
		

		btnBuscar.setFont(new Font("Arial", Font.BOLD, 10));
		btnBuscar.setBounds(419, 477, 81, 23);
		contentPanel.add(btnBuscar);
		
		btnAnular.setFont(new Font("Arial", Font.BOLD, 10));
		btnAnular.setBounds(501, 477, 81, 23);
		contentPanel.add(btnAnular);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManejoBotones(true,false,true,false,true,false,false,false,false);
				ManejoTexto(false, "SI");
				while(table.getRowCount()>0){
					modelo.removeRow(0);
				}
				
			}
		});
		
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 10));
		btnCancelar.setBounds(582, 477, 81, 23);
		contentPanel.add(btnCancelar);
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompraAbmProceso v=new CompraAbmProceso();
				ManejoBotones(false, true, false, false, true, true, true, true, true);
				ManejoTexto(true, "SI");
				
				textField.setText(v.Nuevo());
			}
		});
		btnNuevo.setBounds(251, 477, 88, 23);
		contentPanel.add(btnNuevo);
		
//		ManejoBotones(true,false,true,false,true,false,false,false,false);
		ManejoTexto(false, "SI");
		ManejoBotones(true, false, true, false, true, false, false, false, false);
	}
	private void ManejoBotones(boolean n,boolean g,boolean b,boolean an,boolean c,boolean a,boolean m,boolean e,boolean p){
		btnNuevo.setEnabled(n);
		btnGuardar.setEnabled(g);
		btnBuscar.setEnabled(b);
		btnAnular.setEnabled(an);
		btnCancelar.setEnabled(c);
		
		btnAgregar.setEnabled(a);
		btnModificar.setEnabled(m);
		btnBorrar.setEnabled(e);
		
		btnProveedor.setEnabled(p);
	}
	private void ManejoTexto(boolean n1,String limpiar){
		textField.setEditable(false);
		textField_1.setEditable(n1);
		textField_2.setEditable(n1);
		textField_3.setEditable(false);
		textField_4.setEditable(false);
		textField_5.setEditable(false);
		textField_6.setEditable(false);
		textField_1.requestFocus();
		if(limpiar=="SI"){
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
		}
	}
	private void actualizar_interfaz(){
		codigo=codigo_proveedor;
		textField_3.setText(ruc_proveedor);
		textField_4.setText(razon_proveedor);
		textField_5.setText(telefono_proveedor);
//		ManejoTexto(true, "NO");
//		ManejoBotones(true,false,true,false,true,true,false,false,false);
	}
	public void actualizar_interfaz_producto(){
		Object[] object =new Object[6];
		object[0] = codigo_producto;
		object[1] = cod_barra_producto;
		object[2] = descripcion_producto;
		object[3] = cantidad_producto;
		object[4] = precio_producto;
		object[5] = Integer.parseInt(cantidad_producto)*Integer.parseInt(precio_producto);
		modelo.addRow(object);
	}
	public void actualizar_producto(){
		System.out.println("cantidad_producto->"+cantidad_producto);
		System.out.println("precio_producto->"+precio_producto);
		modelo.setValueAt(cantidad_producto, table.getSelectedRow(), 3);
		modelo.setValueAt(precio_producto, table.getSelectedRow(), 4);
		modelo.setValueAt(Integer.parseInt(cantidad_producto)*Integer.parseInt(precio_producto), table.getSelectedRow(), 5);
		table.setModel(modelo);
	}
}
