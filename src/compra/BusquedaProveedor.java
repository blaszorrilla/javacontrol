package compra;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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

public class BusquedaProveedor extends JDialog {

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
			BusquedaProveedor dialog = new BusquedaProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BusquedaProveedor() {
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
			        	CompraAbm.codigo_proveedor=String.valueOf(table.getValueAt(fila, 0));
			        	CompraAbm.ruc_proveedor=String.valueOf(table.getValueAt(fila, 1));
			        	CompraAbm.razon_proveedor=String.valueOf(table.getValueAt(fila, 2));
			        	CompraAbm.telefono_proveedor=String.valueOf(table.getValueAt(fila, 3));
				        CompraAbm.activar_actualizacion=1;
			            dispose();
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
		
		JLabel label = new JLabel("Ingrese Raz\u00F3n Social:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 37, 188, 23);
		panel.add(label);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buscar("SELECT id_proveedor,ruc,razon,telefono FROM proveedor WHERE razon LIKE '"+textField.getText()+"' '%'");
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
		
		table.getColumnModel().getColumn(4).setPreferredWidth(0);
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getColumnModel().getColumn(4).setMaxWidth(0);
		
		table.getColumnModel().getColumn(5).setPreferredWidth(0);
		table.getColumnModel().getColumn(5).setMinWidth(0);
		table.getColumnModel().getColumn(5).setMaxWidth(0);
	}
	public void Buscar(String sql){
		while (modelo.getRowCount()>0) {
			modelo.removeRow(0);
		}
		modelo=model.BuscarProveedor(modelo, sql);
	}
}
