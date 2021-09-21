package acceso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.BitSet;

import configuracion.Conexion;

public class AccesoAbmProceso {
	public String mensaje_proceso="";
	public String elemento_acceso="";
	public String tipo_proceso="";
	public String Nuevo(){
		String valor="";
		Connection con= Conexion.getConnection();	//	Se crea el obejto de conexion
		PreparedStatement pstm = null;				//	Se instancia el objeto para el envio de la consulta
		try {
			pstm = con.prepareStatement("SELECT IFNULL(MAX(id_acceso),0)+1 AS codigo FROM acceso");
			ResultSet rs= pstm.executeQuery();		//	Se ejecuta el procedimiento, Recibiendo los resultados 
													// en el objeto resulset
			
			while(rs.next()){							// Se recorre cada registro recuperado
				valor=rs.getString(1);				//	Se obtiene cada valor del resulset
			}
		} catch (SQLException e) {					//	Excepción de sentencias y mysql
			// TODO: handle exception
		}finally{
			System.out.println( "cierra conexion a la base de datos" );    
            try {
                if(pstm!=null) pstm.close();                
                if(con!=null) con.close();
            } catch (SQLException ex) {
                System.err.println( ex.getMessage() );    
            }
		}
		return valor;
	}
	public void guadar(String codigo,String ci,String nombre,String apellido,String direccion,String email,String rol,String usu,String pass,String estado){
		Connection con= Conexion.getConnection();
		Statement sts=null;
		try {
			sts= con.createStatement(); //,ci,nombre,apellido,direccion,email,rol,usu,pass,estado
			sts.executeUpdate("INSERT INTO acceso(id_acceso,ci,nombre,apellido,direccion,email,rol,usu,pass,estado) VALUES"
					+ "("+codigo+",'"+ci+"','"+nombre+"','"+apellido+"','"+direccion+"','"+email+"','"+rol+"','"+usu+"','"+pass+"','"+estado+"')");
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
	public void modificar(String codigo,String ci,String nombre,String apellido,String direccion,String email,String rol,String usu,String pass,String estado){
		Connection con= Conexion.getConnection();
		Statement sts=null;
		try {
			sts= con.createStatement(); //,ci,nombre,apellido,direccion,email,rol,usu,pass,estado
			sts.executeUpdate("UPDATE acceso SET ci='"+ci+"',nombre='"+nombre+"',apellido='"+apellido+"',direccion='"+direccion+"',email='"+email+"',rol='"+rol+"',usu='"+usu+"',pass='"+pass+"',estado='"+estado+"' WHERE id_acceso="+codigo);
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
			sts.executeUpdate("DELETE FROM acceso WHERE id_acceso="+codigo);
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
	public String ValidarCampos(String codigo,String ci,String nombre,String apellido,String direccion,String email,String rol,String usu,String pass,String estado){
		String valor="NO";
		if(ci.equals("")){
			valor="SI";
			mensaje_proceso="DEBE INGRESAR CI";
			elemento_acceso="ci";
		}else{
			if(nombre.equals("")){
				valor="SI";
				mensaje_proceso="DEBE INGRESAR NOMBRE";
				elemento_acceso="nombre";
			}else{
				if(apellido.equals("")){
					valor="SI";
					mensaje_proceso="DEBE INGRESAR APELLIDO";
					elemento_acceso="apellido";
				}else{
					if(usu.equals("")){
						valor="SI";
						mensaje_proceso="DEBE INGRESAR USUARIO";
						elemento_acceso="usu";
					}else{
						if(pass.equals("")){
							valor="SI";
							mensaje_proceso="DEBE INGRESAR PASSWORD";
							elemento_acceso="pass";
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
		}
		return valor;
	}
}
