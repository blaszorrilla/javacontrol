package acceso;

import java.awt.BorderLayout;
import java.awt.KeyboardFocusManager;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

public class AccesoAbm extends JDialog {

	private final JPanel contentPane = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JTextArea textField_3 = new JTextArea();
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	JButton btnNuevo = new JButton("Nuevo");
	JButton btnGuardar = new JButton("Guardar");
	JButton btnBuscar = new JButton("Buscar");
	JButton btnModificar = new JButton("Modificar");
	JButton btnEliminar = new JButton("Eliminar");
	JButton btnCancelar = new JButton("Cancelar");
	JComboBox comboBox = new JComboBox();
	JCheckBox checkBox = new JCheckBox("");
	
	static String codigo_acceso;		// atributo para pasar codigo
	static String ci_acceso;			// atributo para pasar codigo
	static String nombre_acceso;		// atributo para pasar codigo
	static String apellido_acceso;		// atributo para pasar codigo
	static String direccion_acceso;		// atributo para pasar codigo
	static String email_acceso;			// atributo para pasar codigo
	static String rol_acceso;			// atributo para pasar codigo
	static String usu_acceso;			// atributo para pasar codigo
	static String pass_acceso;			// atributo para pasar codigo
	static String estado_acceso;		// atributo para pasar codigo
	
	static int activar_actualizacion=0;		// atributo para pasar codigo
	
	/**
	 * Launch the application.
	 */
	public String codigo="0";
	private JPasswordField passwordField;
/*
	public static void main(String[] args) {
		try {
			AccesoAbm dialog = new AccesoAbm();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the frame.
	 */
	public AccesoAbm(java.awt.Frame parent,boolean modal) {
		super(parent, modal);
//	public AccesoAbm(){
		setTitle("Gestión de Acceso");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 612, 418);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
			//textField.setText(codigo);
				if(activar_actualizacion==1){
					actualizar_interfaz();
					ManejoBotones(false, false, true, true, true, true);
					AccesoAbm.activar_actualizacion=0;
				}	
			}
		});
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		{
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registro Acceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.control);
		panel.setBounds(10, 11, 573, 329);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCin = new JLabel("C.I.N\u00BA.:");
		lblCin.setBounds(10, 34, 72, 14);
		panel.add(lblCin);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 59, 72, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 84, 72, 14);
		panel.add(lblApellido);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 109, 72, 14);
		panel.add(lblDireccin);
		
		JLabel lblTelfono = new JLabel("E-mail:");
		lblTelfono.setBounds(10, 188, 72, 14);
		panel.add(lblTelfono);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(10, 215, 72, 14);
		panel.add(lblRol);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 240, 72, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 265, 72, 14);
		panel.add(lblContrasea);
		
		JLabel lblActivo = new JLabel("Activo:");
		lblActivo.setBounds(10, 290, 72, 14);
		panel.add(lblActivo);
		
		textField = new JTextField();
		textField.setBounds(92, 31, 120, 20);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();
				if(textField.getText().length()>=10) evt.consume();
				if((car<'0' || car>'9')) evt.consume();
			}
		});
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();    
				if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE))
				{
				   evt.consume();
				}
				if (textField_1.getText().length()<60)
				   {char letra;
				    letra=(evt.getKeyChar()+"").toUpperCase().charAt(0);
				    evt.setKeyChar(letra);}
				else
				   {evt.consume();}
			
			}
		});
		textField_1.setBounds(92, 56, 299, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();    
				if((car<'a' || car>'z') && (car<'A' || car>'Z')
				   && (car!=(char)KeyEvent.VK_SPACE))
					//
				{
				   evt.consume();
				}
				if (textField_2.getText().length()<60)
				   {char letra;
				    letra=(evt.getKeyChar()+"").toUpperCase().charAt(0);
				    evt.setKeyChar(letra);}
				else
				   {evt.consume();}
			}
		});
		textField_2.setBounds(92, 81, 299, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent evt) {
				if (textField_4.getText().length()<100)
				   {char letra;
				    letra=(evt.getKeyChar()+"").charAt(0);
				    evt.setKeyChar(letra);}
				else
				   {evt.consume();}
			}
		
		});
		textField_4.setBounds(92, 185, 299, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {  
				if (textField_5.getText().length()<20)
				   {char letra;
				    letra=(evt.getKeyChar()+"").charAt(0);
				    evt.setKeyChar(letra);}
				else
				   {evt.consume();}
			}
		
		});
		textField_5.setBounds(92, 237, 215, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JPasswordField();
		textField_6.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent evt) {
				if (textField_6.getText().length()<20)
				   {char letra;
				    letra=(evt.getKeyChar()+"").charAt(0);
				    evt.setKeyChar(letra);}
				else
				   {evt.consume();}
			}
		
		});
		textField_6.setBounds(92, 262, 215, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		checkBox.setBackground(SystemColor.control);
		checkBox.setForeground(Color.BLACK);
		checkBox.setBounds(88, 287, 21, 23);
		panel.add(checkBox);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ADMINISTRADOR", "ENCARGADO/COMPRA", "ENCARGADO/VENTA"}));
		comboBox.setBounds(92, 212, 215, 20);
		panel.add(comboBox);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AccesoAbm.class.getResource("/imagenes/java1.png")));
		label.setBounds(433, 34, 130, 245);
		panel.add(label);
		textField_3.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent evt) {
				if (textField_3.getText().length()<100)
				   {char letra;
				    letra=(evt.getKeyChar()+"").toUpperCase().charAt(0);
				    evt.setKeyChar(letra);}
				else
				   {evt.consume();}
			
			}
		});
		
		textField_3.setBackground(Color.WHITE);
		textField_3.setLineWrap(true);
		textField_3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField_3.setBounds(92, 105, 299, 78);
		textField_3.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
		textField_3.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);
		panel.add(textField_3);
		
		JLabel label_1 = new JLabel("(*)");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(219, 34, 29, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("(*)");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(396, 59, 29, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("(*)");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(396, 84, 29, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("(*)");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(317, 215, 29, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("(*)");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(317, 240, 29, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("(*)");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(317, 265, 29, 14);
		panel.add(label_6);
		
		JLabel lblCamposObligatorios = new JLabel("(*) Campos Obligatorios");
		lblCamposObligatorios.setBounds(427, 304, 136, 14);
		panel.add(lblCamposObligatorios);
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManejoBotones(false,true,false,false,false,true);
				ManejoTexto(true,"SI");
				
			}
		});
		
		
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 10));
		btnNuevo.setBounds(87, 351, 81, 23);
		contentPane.add(btnNuevo);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BusquedaAcceso b=new BusquedaAcceso();
				b.setModal(true);
				b.setLocationRelativeTo(null);
				b.setVisible(true);
			}
		});
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 10));
		btnBuscar.setBounds(251, 351, 81, 23);
		contentPane.add(btnBuscar);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManejoBotones(false,true,false,false,false,true);
				ManejoTexto(true, "NO");
			}
		});
		
		btnModificar.setFont(new Font("Arial", Font.BOLD, 10));
		btnModificar.setBounds(333, 351, 87, 23);
		contentPane.add(btnModificar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManejoBotones(true,false,true,false,false,true);
				ManejoTexto(false,"SI");
			}
		});
		
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 10));
		btnCancelar.setBounds(502, 351, 81, 23);
		contentPane.add(btnCancelar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccesoAbmProceso n=new AccesoAbmProceso();
				int i=JOptionPane.showConfirmDialog(AccesoAbm.this, "¿DESEA ELIMINAR ESTE REGISTRO?","ELIMINAR",JOptionPane.INFORMATION_MESSAGE);
				if(i==0){
					n.eliminar(codigo);
					codigo="0";
					ManejoBotones(true,false,true,false,false,true);
					ManejoTexto(false,"SI");
				}
			
			}
		});
		
		btnEliminar.setBounds(421, 351, 81, 23);
		contentPane.add(btnEliminar);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 10));
		btnGuardar.setBounds(170, 351, 81, 23);
		contentPane.add(btnGuardar);
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				AccesoAbmProceso n=new AccesoAbmProceso();
				String chec="";
				if(checkBox.isSelected()==true){chec="ACTIVO";}else{chec="INACTIVO";}
				String verif=n.ValidarCampos(codigo, textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), String.valueOf(comboBox.getSelectedItem()), textField_5.getText(), textField_6.getText(), chec);
				if(verif.equals("SI")){
					JOptionPane.showMessageDialog(AccesoAbm.this, n.mensaje_proceso);
					aplicarfoco(n.elemento_acceso);
				}else{
					int i=JOptionPane.showConfirmDialog(AccesoAbm.this, "¿DESEA GUARDAR ESTOS DATOS?","GUARDAR",JOptionPane.INFORMATION_MESSAGE);
					if(i==0){
						if(n.tipo_proceso.equals("MODIFICAR")){
							n.modificar(codigo, textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), String.valueOf(comboBox.getSelectedItem()), textField_5.getText(), textField_6.getText(), chec);
							ManejoBotones(true,false,true,false,false,true);
							ManejoTexto(false,"SI");
							codigo="0";
						}else{
							codigo=n.Nuevo();
							n.guadar(codigo, textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), String.valueOf(comboBox.getSelectedItem()), textField_5.getText(), textField_6.getText(), chec);
							ManejoBotones(true,false,true,false,false,true);
							ManejoTexto(false,"SI");
							codigo="0";
						}
					}
				}

			}
		});
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 10));
		ManejoBotones(true,false,true,false,false,true);
		ManejoTexto(false,"SI");
	}
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
		textField_5.setEditable(n1);
		textField_6.setEditable(n1);
		comboBox.setEnabled(n1);
		checkBox.setEnabled(n1);
		textField.requestFocus();
		if(n1==true){
			textField_3.setBackground(Color.WHITE);
		}else{
			textField_3.setBackground(SystemColor.control);
		}
		if(limpiar=="SI"){
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"ADMINISTRADOR", "ENCARGADO/COMPRA", "ENCARGADO/VENTA"}));
			checkBox.setSelected(false);
		}
	}
	private void actualizar_interfaz(){
		codigo=codigo_acceso;
		textField.setText(ci_acceso);
		textField_1.setText(nombre_acceso);
		textField_2.setText(apellido_acceso);
		textField_3.setText(direccion_acceso);
		textField_4.setText(email_acceso);
		comboBox.setSelectedItem(rol_acceso);
		textField_5.setText(usu_acceso);
		textField_6.setText(pass_acceso);
		
		if(estado_acceso.equals("ACTIVO")){
			checkBox.setSelected(true);
		}else{
			checkBox.setSelected(false);
		}
	}
	private void aplicarfoco(String valor){
		if(valor.equals("ci")){
			textField.requestFocus();
		}else{
			if(valor.equals("nombre")){
				textField_1.requestFocus();
			}else{
				if(valor.equals("apellido")){
					textField_2.requestFocus();
				}else{
					if(valor.equals("usu")){
						textField_5.requestFocus();
					}else{
						if(valor.equals("pass")){
							textField_6.requestFocus();
						}else{
							
						}
					}
				}
			}
		}
	}
}
