package acceso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import configuracion.Conexion;

public class AccesoProceso {
	public String id_acceso="";
	public String ci="";
	public String nombre="";
	public String apellido="";
	public String rol="";
	
	public String Ingresar(String usu,String pass){
		String valor="";
		Connection con= Conexion.getConnection();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement("SELECT id_acceso,ci,nombre,apellido,rol FROM acceso WHERE usu='"+usu+"' AND pass='"+pass+"'");
			ResultSet rs= pstm.executeQuery();
			if(rs.next()){						
				valor="SI";
				id_acceso=rs.getString(1);
				ci=rs.getString(2);
				nombre=rs.getString(3);
				apellido=rs.getString(4);
				rol=rs.getString(5);
			}else{
				valor="NO";
			}
		} catch (SQLException e) {				
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
}
