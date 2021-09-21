package compra;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BusquedaProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	DefaultTableModel modelo;
	private JTextField textField;
	CompraAbmProceso model=new CompraAbmProceso();
	int fila=-1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BusquedaProducto dialog = new BusquedaProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BusquedaProducto() {
		setTitle("JAVACONTROL Versión 1.0");
		setBounds(100, 100, 619, 375);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "B\u00FAsqueda Producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 583, 318);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 563, 214);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {

				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					System.out.println("se presiono entre");
					fila = table.getSelectedRow();                 
			        if (fila > -1){
			        	String verfi=existevalor(String.valueOf(table.getValueAt(fila, 0)));
			        	if (verfi.equals("SI")) {
							JOptionPane.showMessageDialog(BusquedaProducto.this, "EL PRODUCTO YA SE SELECCIONO", "PRODUCTO",JOptionPane.ERROR_MESSAGE);
						}else{
				        	CompraAbm.codigo_producto=String.valueOf(table.getValueAt(fila, 0));
				        	CompraAbm.cod_barra_producto=String.valueOf(table.getValueAt(fila, 1));
				        	CompraAbm.descripcion_producto=String.valueOf(table.getValueAt(fila, 2));
				        	CompraAbm.cantidad_producto=String.valueOf(table.getValueAt(fila, 3));
				        	CompraAbm.precio_producto=String.valueOf(table.getValueAt(fila, 4));
				        	CompraAbm.subtotal_producto=String.valueOf(table.getValueAt(fila, 5));
				        	System.out.println("cantidad_producto->"+CompraAbm.cantidad_producto+" precio_producto->"+CompraAbm.precio_producto);
				        	CompraAbm.activar_actualizacion=2;
				            dispose();
						}
			         }
				}else{
					System.out.println("no fue enter");
				}
			
			}
		});
		modelo=new DefaultTableModel();
		table.setModel(modelo);
		modelo.addColumn("Codigo");
		modelo.addColumn("Cod/Barra");
		modelo.addColumn("Nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Cant/Inicial");
		modelo.addColumn("Precio/Venta");
		
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 63, 343, 23);
		panel.add(textField);
		
		JLabel lblIngreseProducto = new JLabel("Ingrese Producto:");
		lblIngreseProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIngreseProducto.setBounds(10, 37, 188, 23);
		panel.add(lblIngreseProducto);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buscar("SELECT id_producto,cod_barra,nombre,cant_inicial,precio_venta,descripcion FROM producto WHERE nombre LIKE '"+textField.getText()+"' '%'");
			}
		});
		btnBuscar.setBounds(361, 62, 212, 23);
		panel.add(btnBuscar);
		ConfigurarTabla();
	}
	private void ConfigurarTabla(){
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		
		table.getColumnModel().getColumn(3).setPreferredWidth(0);
		table.getColumnModel().getColumn(3).setMinWidth(0);
		table.getColumnModel().getColumn(3).setMaxWidth(0);
		
		table.getColumnModel().getColumn(5).setPreferredWidth(0);
		table.getColumnModel().getColumn(5).setMinWidth(0);
		table.getColumnModel().getColumn(5).setMaxWidth(0);
		
	}
	public void Buscar(String sql){
		while (modelo.getRowCount()>0) {
			modelo.removeRow(0);
		}
		modelo=model.BuscarProducto(modelo, sql);
	}
	public String existevalor(String valor){
		String dato="NO";
		String[] array=null;
		if (CompraAbm.arrayproducto==null) {
			array=new String[0];
		}else{
			array=CompraAbm.arrayproducto;
		}
		for (int i = 0; i < array.length; i++) {
			if(array[i].equals(valor)){
				dato="SI";
			}
		}
		return dato;
	}
}
