package proveedor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ProveedorAbm extends JDialog {


	private final JPanel contentPane = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JTextArea textField_3 = new JTextArea();
	private JTextField textField_4;
	private JTextField textField_5;

	JButton btnNuevo = new JButton("Nuevo");
	JButton btnGuardar = new JButton("Guardar");
	JButton btnBuscar = new JButton("Buscar");
	JButton btnModificar = new JButton("Modificar");
	JButton btnEliminar = new JButton("Eliminar");
	JButton btnCancelar = new JButton("Cancelar");
	
	static String codigo_acceso;		// atributo para pasar codigo
	static String ruc_acceso;			// atributo para pasar codigo
	static String razon_acceso;			// atributo para pasar codigo
	static String nomape_acceso;		// atributo para pasar codigo
	static String direccion_acceso;		// atributo para pasar codigo
	static String telefono_acceso;		// atributo para pasar codigo
	static String email_acceso;			// atributo para pasar codigo
	
	static int activar_actualizacion=0;		// atributo para pasar codigo
	
	BusquedaProveedor b=null;
	
	/**
	 * Launch the application.
	 */
	public String codigo="0";
	private JPasswordField passwordField;

/*	public static void main(String[] args) {
		try {
			ProveedorAbm dialog = new ProveedorAbm();
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
//	public ProveedorAbm(java.awt.Frame parent,boolean modal) {
//		super(parent, modal);
	public ProveedorAbm(java.awt.Frame parent,boolean modal) {
		super(parent, modal);	
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Gestión Proveedor");
		setBounds(100, 100, 683, 373);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				if(activar_actualizacion==1){
					actualizar_interfaz();
					ManejoBotones(false, false, true, true, true, true);
					ProveedorAbm.activar_actualizacion=0;
				}	
			}
		});
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		{
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 647, 277);
		panel.setBorder(new TitledBorder(null, "Registro Proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.control);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCin = new JLabel("R.U.C.:");
		lblCin.setBounds(10, 34, 72, 14);
		panel.add(lblCin);
		
		JLabel lblNombre = new JLabel("Raz\u00F3n Social:");
		lblNombre.setBounds(10, 59, 94, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Nombre y Apellido:");
		lblApellido.setBounds(10, 84, 110, 14);
		panel.add(lblApellido);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 109, 72, 14);
		panel.add(lblDireccin);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(10, 188, 72, 14);
		panel.add(lblTelfono);
		
		JLabel lblRol = new JLabel("E-mail:");
		lblRol.setBounds(10, 215, 72, 14);
		panel.add(lblRol);
		
		textField = new JTextField();
		textField.setBounds(130, 28, 120, 20);
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
				if((car<'a' || car>'z') && (car<'A' || car>'Z')
				   && (car!=(char)KeyEvent.VK_SPACE))
					//
				{
				   evt.consume();
				}
				if (textField_1.getText().length()<70)
				   {char letra;
				    letra=(evt.getKeyChar()+"").toUpperCase().charAt(0);
				    evt.setKeyChar(letra);}
				else
				   {evt.consume();}
			
			}
		});
		textField_1.setBounds(130, 53, 299, 20);
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
				if (textField_2.getText().length()<70)
				   {char letra;
				    letra=(evt.getKeyChar()+"").toUpperCase().charAt(0);
				    evt.setKeyChar(letra);}
				else
				   {evt.consume();}
			}
		});
		textField_2.setBounds(130, 78, 299, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent evt) {
				if (textField_4.getText().length()<20)
				   {char letra;
				    letra=(evt.getKeyChar()+"").charAt(0);
				    evt.setKeyChar(letra);}
				else
				   {evt.consume();}
			}
		
		});
		textField_4.setBounds(130, 182, 299, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {  
				if (textField_5.getText().length()<100)
				   {char letra;
				    letra=(evt.getKeyChar()+"").charAt(0);
				    evt.setKeyChar(letra);}
				else
				   {evt.consume();}
			}
		
		});
		textField_5.setBounds(130, 209, 215, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ProveedorAbm.class.getResource("/imagenes/java1.png")));
		label.setBounds(493, 21, 144, 245);
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
		textField_3.setBounds(130, 102, 299, 78);
		textField_3.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
		textField_3.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);
		panel.add(textField_3);
		
		JLabel label_1 = new JLabel("(*)");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(257, 31, 29, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("(*)");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(434, 56, 29, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("(*)");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(434, 81, 29, 14);
		panel.add(label_3);
		
		JLabel lblCamposObligatorios = new JLabel("(*) Campos Obligatorios");
		lblCamposObligatorios.setBounds(501, 252, 136, 14);
		panel.add(lblCamposObligatorios);
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNuevo.setBounds(161, 299, 81, 23);
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManejoBotones(false,true,false,false,false,true);
				ManejoTexto(true,"SI");
				
			}
		});
		
		
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btnNuevo);
		btnBuscar.setBounds(325, 299, 81, 23);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(b instanceof BusquedaProveedor){
				//	b=new BusquedaProveedor();
					b.setModal(true);
					b.setLocationRelativeTo(null);
					b.setVisible(true);
				}else{
					b=new BusquedaProveedor();
					b.setModal(true);
					b.setLocationRelativeTo(null);
					b.setVisible(true);
				}
				
			//	BusquedaProveedor b=new BusquedaProveedor();
			//	b.setModal(true);
			//	b.setLocationRelativeTo(null);
			//	b.setVisible(true);
			}
		});
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btnBuscar);
		btnModificar.setBounds(407, 299, 87, 23);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManejoBotones(false,true,false,false,false,true);
				ManejoTexto(true, "NO");
			}
		});
		
		btnModificar.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btnModificar);
		btnCancelar.setBounds(576, 299, 81, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManejoBotones(true,false,true,false,false,true);
				ManejoTexto(false,"SI");
			}
		});
		
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btnCancelar);
		btnEliminar.setBounds(495, 299, 81, 23);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProveedorAbmProceso n=new ProveedorAbmProceso();
				int i=JOptionPane.showConfirmDialog(ProveedorAbm.this, "¿DESEA ELIMINAR ESTE REGISTRO?","ELIMINAR",JOptionPane.INFORMATION_MESSAGE);
				if(i==0){
					n.eliminar(codigo);
					codigo="0";
					ManejoBotones(true,false,true,false,false,true);
					ManejoTexto(false,"SI");
				}
			
			}
		});
		contentPane.add(btnEliminar);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 10));
		btnGuardar.setBounds(244, 299, 81, 23);
		contentPane.add(btnGuardar);
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				ProveedorAbmProceso n=new ProveedorAbmProceso();
				String verif=n.ValidarCampos(codigo, textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText());
				if(verif.equals("SI")){
					JOptionPane.showMessageDialog(ProveedorAbm.this, n.mensaje_proceso);
					aplicarfoco(n.elemento_acceso);
				}else{
					int i=JOptionPane.showConfirmDialog(ProveedorAbm.this, "¿DESEA GUARDAR ESTOS DATOS?","GUARDAR",JOptionPane.INFORMATION_MESSAGE);
					if(i==0){
						if(n.tipo_proceso.equals("MODIFICAR")){
							n.modificar(codigo, textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText());
							ManejoBotones(true,false,true,false,false,true);
							ManejoTexto(false,"SI");
							codigo="0";
						}else{
							codigo=n.Nuevo();
							n.guadar(codigo, textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText());
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
		}
	}
	private void actualizar_interfaz(){
		codigo=codigo_acceso;
		textField.setText(ruc_acceso);
		textField_1.setText(razon_acceso);
		textField_2.setText(nomape_acceso);
		textField_3.setText(direccion_acceso);
		textField_4.setText(telefono_acceso);
		textField_5.setText(email_acceso);
	//	ManejoTexto(true, "NO");
		ManejoBotones(false,false,false,true,true,true);
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
						
					}
				}
			}
		}
	}
}
