package proveedor;

	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;

	public class BusquedaProveedor extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTable table;
		private JTextField textField;
		int fila=-1;
		JScrollPane scrollPane = new JScrollPane();
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
			setBounds(100, 100, 574, 377);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			{
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(null, "B\u00FAsqueda de Proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.setBackground(SystemColor.control);
				panel.setBounds(10, 11, 538, 320);
				contentPanel.add(panel);
				panel.setLayout(null);
				
				
				scrollPane.setBounds(10, 82, 518, 227);
				panel.add(scrollPane);
				
				table = new JTable();
				table.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {
						if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
							System.out.println("se presiono entre");
							fila = table.getSelectedRow();                 
					        if (fila > -1){  
					            System.out.println("valores1 -> "+table.getValueAt(fila, 0));	//	Obtengo codigo
						        System.out.println("valores2 -> "+table.getValueAt(fila, 1));	//	Obtengo ci
						        System.out.println("valores3 -> "+table.getValueAt(fila, 2));	//	Obtengo ci
						        System.out.println("valores4 -> "+table.getValueAt(fila, 3));	//	Obtengo ci
						        System.out.println("valores5 -> "+table.getValueAt(fila, 4));	//	Obtengo ci
						        System.out.println("valores6 -> "+table.getValueAt(fila, 5));	//	Obtengo ci
						        System.out.println("valores7 -> "+table.getValueAt(fila, 6));	//	Obtengo ci
						        
						        ProveedorAbm.codigo_acceso=String.valueOf(table.getValueAt(fila, 0));
						        ProveedorAbm.ruc_acceso=String.valueOf(table.getValueAt(fila, 1));
						        ProveedorAbm.razon_acceso=String.valueOf(table.getValueAt(fila, 2));
						        ProveedorAbm.nomape_acceso=String.valueOf(table.getValueAt(fila, 3));
						        ProveedorAbm.direccion_acceso=String.valueOf(table.getValueAt(fila, 4));
						        ProveedorAbm.telefono_acceso=String.valueOf(table.getValueAt(fila, 5));
						        ProveedorAbm.email_acceso=String.valueOf(table.getValueAt(fila, 6));
						        ProveedorAbm.activar_actualizacion=1;
					            dispose();
					         }
						}else{
							System.out.println("no fue enter");
						}
					}
				});
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"", "R.U.C.", "Razón Social", "Nombre y Apellido", "", "",""
					}
				));
				ConfigurarTabla();
				scrollPane.setViewportView(table);
				{
					JLabel lblIngreseCin = new JLabel("Ingrese Razón Social:");
					lblIngreseCin.setFont(new Font("Tahoma", Font.BOLD, 14));
					lblIngreseCin.setBounds(10, 35, 156, 14);
					panel.add(lblIngreseCin);
				}
				{
					textField = new JTextField();
					textField.setColumns(10);
					textField.setBounds(10, 52, 343, 20);
					textField.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent evt) {  
							if (textField.getText().length()<60)
							   {char letra;
							    letra=(evt.getKeyChar()+"").toUpperCase().charAt(0);
							    evt.setKeyChar(letra);}
							else
							   {evt.consume();}
						}
						@Override
						public void keyReleased(KeyEvent arg0) {
						//
							ActualizarTabla();
								textField.setText(textField.getText().toUpperCase());
						//
						}
					});
					panel.add(textField);
				}
			}
		}
		private void ActualizarTabla(){
			CargarTablaProveedor pp= new CargarTablaProveedor();
			Object[][] dtPer;
	        String[] columNames = {"", "R.U.C.", "Razón Social", "Nombre y Apellido", "", "",""};//Para modificar las cabeceras a la grilla
	        // se utiliza la funcion
	        if(textField.getText().equals("")){
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"", "R.U.C.", "Razón Social", "Nombre y Apellido", "", "",""
					}
				));
				System.out.println("no hay datos");
	        }else{
	        	dtPer = pp.getDatos(textField.getText());
	            
	            // se colocan los datos en la tabla
	            DefaultTableModel datos = new DefaultTableModel(dtPer,columNames);     
	            table.setModel(datos);
	            //ajustamos tamaño de la celda ID
	            //TableColumn columna = table.getColumn("Codigo");        
	            //columna.setPreferredWidth(50);
	            //columna.setMinWidth(10);
	            //columna.setMaxWidth(30);
	            System.out.println("si hay datos");
	        }
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
			
			table.getColumnModel().getColumn(6).setPreferredWidth(0);
			table.getColumnModel().getColumn(6).setMinWidth(0);
			table.getColumnModel().getColumn(6).setMaxWidth(0);
			
			
		}
}
