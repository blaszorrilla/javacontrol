package AbmAcceso;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import configuracion.Conexion;
import configuracion.Modelo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarDatos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable table;
	DefaultTableModel modelo;
	Modelo model=new Modelo();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscarDatos dialog = new BuscarDatos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscarDatos() {
		setBounds(100, 100, 608, 426);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblIngreseRaznSocial = new JLabel("Ingrese Raz\u00F3n Social:");
		lblIngreseRaznSocial.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIngreseRaznSocial.setBounds(10, 11, 222, 27);
		contentPanel.add(lblIngreseRaznSocial);
		
		textField = new JTextField();
		textField.setBounds(10, 37, 329, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 572, 265);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		modelo =new DefaultTableModel();
		
		
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		modelo.addColumn("Codigo");
		modelo.addColumn("CI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Razón Social");
		modelo.addColumn("Razón Social");
		modelo.addColumn("Razón Social");
		modelo.addColumn("Razón Social");
		modelo.addColumn("Razón Social");
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buscar("SELECT id_acceso,ci,nombre,apellido,direccion,email,usu,pass,estado FROM acceso WHERE nombre LIKE '"+textField.getText()+"' '%'");
			}
		});
		btnBuscar.setBounds(351, 36, 89, 23);
		contentPanel.add(btnBuscar);
		habilitartabla();
	}
	public void Buscar(String sql){
		while (modelo.getRowCount()>0) {
			modelo.removeRow(0);
		}
		modelo=model.BuscarAcceso(modelo, sql);
	}
	public void habilitartabla(){
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
		
	}
}
