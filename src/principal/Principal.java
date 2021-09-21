package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import producto.ProductoAbm;
import proveedor.ProveedorAbm;
import compra.CompraAbm;
import acceso.AccesoAbm;
import ayuda.Acerca;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		super("JAVACONTROL - VERSION 1.0");
		setType(Type.POPUP);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAcceso = new JMenu("Acceso");
		menuBar.add(mnAcceso);
		
		JMenuItem mntmReferencialAcceso = new JMenuItem("Referencial Acceso");
		mntmReferencialAcceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccesoAbm JFrame= new AccesoAbm(Principal.this, true);
				//AccesoAbm JFrame= new AccesoAbm();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
			}
		});
		mnAcceso.add(mntmReferencialAcceso);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int eleccion = JOptionPane.showConfirmDialog(Principal.this, "¿Desea salir de JAVACONTROL?","SALIR",JOptionPane.INFORMATION_MESSAGE);
		        if ( eleccion == 0) {
		            System.exit(0);
		        } 
			}
		});
		mnAcceso.add(mntmSalir);
		
		JMenu mnReferencial = new JMenu("Referencial");
		menuBar.add(mnReferencial);
		
		JMenuItem mntmProveedor = new JMenuItem("Proveedor");
		mntmProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProveedorAbm JFrame= new ProveedorAbm(Principal.this, true);
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
			}
		});
		mnReferencial.add(mntmProveedor);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mnReferencial.add(mntmCliente);
		
		JMenuItem mntmProducto = new JMenuItem("Producto");
		mntmProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProductoAbm JFrame= new ProductoAbm(Principal.this, true);
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
			}
		});
		mnReferencial.add(mntmProducto);
		
		JMenu mnMovimiento = new JMenu("Movimiento");
		menuBar.add(mnMovimiento);
		
		JMenuItem mntmCompra = new JMenuItem("Compra");
		mntmCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Compra JFrame= new Compra(Principal.this, true);
				CompraAbm JFrame= new CompraAbm();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
			}
		});
		mnMovimiento.add(mntmCompra);
		
		//JMenuItem mntmVenta = new JMenuItem("Venta");
		//mnMovimiento.add(mntmVenta);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de..");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Acerca JFrame = new Acerca(Principal.this, true);
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
