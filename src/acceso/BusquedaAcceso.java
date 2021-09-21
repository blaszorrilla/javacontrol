package acceso;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class BusquedaAcceso extends JDialog {

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
			BusquedaAcceso dialog = new BusquedaAcceso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BusquedaAcceso() {
		setBounds(100, 100, 574, 377);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(10, 11, 538, 320);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblBsquedaDeAcceso = new JLabel("B\u00FAsqueda de Acceso");
				lblBsquedaDeAcceso.setFont(new Font("Arial", Font.BOLD, 14));
				lblBsquedaDeAcceso.setBounds(10, 0, 154, 23);
				panel.add(lblBsquedaDeAcceso);
			}
			{
				JSeparator separator = new JSeparator();
				separator.setForeground(Color.LIGHT_GRAY);
				separator.setBounds(10, 21, 518, 2);
				panel.add(separator);
			}
			
			
			scrollPane.setBounds(10, 72, 518, 237);
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
					        System.out.println("valores8 -> "+table.getValueAt(fila, 7));	//	Obtengo ci
					        System.out.println("valores9 -> "+table.getValueAt(fila, 8));	//	Obtengo ci
					        System.out.println("valores10 -> "+table.getValueAt(fila, 9));	//	Obtengo ci
					        
					        AccesoAbm.codigo_acceso=String.valueOf(table.getValueAt(fila, 0));
					        AccesoAbm.ci_acceso=String.valueOf(table.getValueAt(fila, 1));
					        AccesoAbm.nombre_acceso=String.valueOf(table.getValueAt(fila, 2));
					        AccesoAbm.apellido_acceso=String.valueOf(table.getValueAt(fila, 3));
					        AccesoAbm.direccion_acceso=String.valueOf(table.getValueAt(fila, 4));
					        AccesoAbm.email_acceso=String.valueOf(table.getValueAt(fila, 5));
					        AccesoAbm.rol_acceso=String.valueOf(table.getValueAt(fila, 6));
					        AccesoAbm.usu_acceso=String.valueOf(table.getValueAt(fila, 7));
					        AccesoAbm.pass_acceso=String.valueOf(table.getValueAt(fila, 8));
					        AccesoAbm.estado_acceso=String.valueOf(table.getValueAt(fila, 9));
					        AccesoAbm.activar_actualizacion=1;
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
						"", "C.I.Nº", "Nombre", "Apellido", "", "","","","",""
				}
			));
			ConfigurarTabla();
			scrollPane.setViewportView(table);
			{
				JLabel lblIngreseCin = new JLabel("Ingrese Nombre y Apellido:");
				lblIngreseCin.setBounds(10, 24, 165, 14);
				panel.add(lblIngreseCin);
			}
			{
				textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(10, 41, 343, 20);
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
		CargarTablaAcceso pp= new CargarTablaAcceso();
		Object[][] dtPer;
        String[] columNames = {"", "C.I.Nº", "Nombre", "Apellido", "", "","","","",""};//Para modificar las cabeceras a la grilla
        // se utiliza la funcion
        if(textField.getText().equals("")){
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"", "C.I.Nº", "Nombre", "Apellido", "", "","","","",""
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
		
		table.getColumnModel().getColumn(7).setPreferredWidth(0);
		table.getColumnModel().getColumn(7).setMinWidth(0);
		table.getColumnModel().getColumn(7).setMaxWidth(0);
		
		table.getColumnModel().getColumn(8).setPreferredWidth(0);
		table.getColumnModel().getColumn(8).setMinWidth(0);
		table.getColumnModel().getColumn(8).setMaxWidth(0);
		
		table.getColumnModel().getColumn(9).setPreferredWidth(0);
		table.getColumnModel().getColumn(9).setMinWidth(0);
		table.getColumnModel().getColumn(9).setMaxWidth(0);
	}
}
