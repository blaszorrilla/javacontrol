package producto;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import configuracion.Conexion;

	public class ProductoAbmProceso {
		public String mensaje_proceso="";
		public String elemento_acceso="";
		public String tipo_proceso="";
		public String Nuevo(){
			String valor="";
			Connection con= Conexion.getConnection();
			PreparedStatement pstm = null;
			try {
				pstm = con.prepareStatement("SELECT IFNULL(MAX(id_producto),0)+1 AS codigo FROM producto");
				ResultSet rs= pstm.executeQuery();
				if(rs.next()){
					valor=rs.getString(1);
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}finally{
				System.out.println( "cierra conexion a la base de datos - Todo se guardo con exito" );    
	            try {
	                if(pstm!=null) pstm.close();                
	                if(con!=null) con.close();
	            } catch (SQLException ex) {
	                System.err.println( ex.getMessage() );    
	            }
			}
			return valor;
		}
		public void guadar(String codigo,String cod_barra,String nombre,String descripcion,String cantidad,String precio){
			Connection con= Conexion.getConnection();
			Statement sts=null;
			try {
				sts= con.createStatement(); //,ci,nombre,apellido,direccion,email,rol,usu,pass,estado
				sts.executeUpdate("INSERT INTO producto(id_producto,cod_barra,nombre,descripcion,cant_inicial,precio_venta) VALUES"
						+ "("+codigo+",'"+cod_barra+"','"+nombre+"','"+descripcion+"','"+cantidad+"','"+precio+"')");
			} catch (SQLException e) {
				// TODO: handle exception
				System.err.println(e.getMessage());
			}finally{
				System.out.println( "cierra conexion a la base de datos - Todo se guardo con exito" );    
	            try {
	                if(sts!=null) sts.close();                
	                if(con!=null) con.close();
	            } catch (SQLException ex) {
	                System.err.println( ex.getMessage() );    
	            }
			}
		}
		public void modificar(String codigo,String cod_barra,String nombre,String descripcion,String cantidad,String precio){
			Connection con= Conexion.getConnection();
			Statement sts=null;
			try {
				sts= con.createStatement(); //,ci,nombre,apellido,direccion,email,rol,usu,pass,estado
				sts.executeUpdate("UPDATE producto SET cod_barra='"+cod_barra+"',nombre='"+nombre+"',descripcion='"+descripcion+"',cant_inicial='"+cantidad+"',precio_venta='"+precio+"' WHERE id_producto="+codigo);
			} catch (SQLException e) {
				// TODO: handle exception
				System.err.println(e.getMessage());
			}finally{
				System.out.println( "cierra conexion a la base de datos - Todo se guardo con exito" );    
	            try {
	                if(sts!=null) sts.close();                
	                if(con!=null) con.close();
	            } catch (SQLException ex) {
	                System.err.println( ex.getMessage() );    
	            }
			}
		}
		public void eliminar(String codigo){
			Connection con= Conexion.getConnection();
			Statement sts=null;
			try {
				sts= con.createStatement(); //,ci,nombre,apellido,direccion,email,rol,usu,pass,estado
				sts.executeUpdate("DELETE FROM producto WHERE id_producto="+codigo);
			} catch (SQLException e) {
				// TODO: handle exception
				System.err.println(e.getMessage());
			}finally{
				System.out.println( "cierra conexion a la base de datos - Todo se guardo con exito" );    
	            try {
	                if(sts!=null) sts.close();                
	                if(con!=null) con.close();
	            } catch (SQLException ex) {
	                System.err.println( ex.getMessage() );    
	            }
			}
		}
		public String ValidarCampos(String codigo,String cod_barra,String nombre,String cantidad,String precio){
			String valor="NO";
			if(cod_barra.equals("")){
				valor="SI";
				mensaje_proceso="DEBE INGRESAR CÓD./BARRA";
				elemento_acceso="cod_barra";
			}else{
				if(nombre.equals("")){
					valor="SI";
					mensaje_proceso="DEBE INGRESAR NOMBRE";
					elemento_acceso="nombre";
				}else{
					if(cantidad.equals("")){
						valor="SI";
						mensaje_proceso="DEBE INGRESAR CANT./INICIAL";
						elemento_acceso="cantidad";
					}else{
						if(precio.equals("")){
							valor="SI";
							mensaje_proceso="DEBE INGRESAR PRECIO/VENTA";
							elemento_acceso="precio";
						}else{
							if(codigo.equals("0")){
								tipo_proceso="NUEVO";
							}else{
								tipo_proceso="MODIFICAR";
							}
						}	
					}
				}
			}
			return valor;
		}
		public DefaultTableModel BuscarAcceso(DefaultTableModel modelo,String sql){
			Connection con= Conexion.getConnection();	//	Se crea el obejto de conexion
			PreparedStatement pstm = null;				//	Se instancia el objeto para el envio de la consulta
			try {
				pstm = con.prepareStatement(sql);
				ResultSet rs= pstm.executeQuery();		//	Se ejecuta el procedimiento, Recibiendo los resultados 
														// en el objeto resulset	
				while(rs.next()){							// Se recorre cada registro recuperado
					Object[] object =new Object[6];
					object[0] = rs.getString(1);
					object[1] = rs.getString(2);
					object[2] = rs.getString(3);
					object[3] = rs.getString(4);
					object[4] = rs.getString(5);
					object[5] = rs.getString(6);
					modelo.addRow(object);				//	Se obtiene cada valor del resulset		
				}
			} catch (SQLException e) {					//	Excepción de sentencias y mysql
				// TODO: handle exception
				System.err.println( e.getMessage() ); 
			}finally{
				System.out.println( "cierra conexion a la base de datos" );    
	            try {
	                if(pstm!=null) pstm.close();                
	                if(con!=null) con.close();
	            } catch (SQLException ex) {
	                System.err.println( ex.getMessage() );    
	            }
			}
			return modelo;
		}
}
