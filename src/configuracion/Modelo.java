package configuracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Modelo {
	public String Nuevo(String sql){
		String valor="";
		Connection con= Conexion.getConnection();	//	Se crea el obejto de conexion
		PreparedStatement pstm = null;				//	Se instancia el objeto para el envio de la consulta
		try {
			pstm = con.prepareStatement(sql);
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
	public void guardar(String sql){
		Connection con= Conexion.getConnection();
		Statement sts=null;
		try {
			sts= con.createStatement(); 
			sts.executeUpdate(sql);
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
	public DefaultTableModel BuscarAcceso(DefaultTableModel modelo,String sql){
		Connection con= Conexion.getConnection();	//	Se crea el obejto de conexion
		PreparedStatement pstm = null;				//	Se instancia el objeto para el envio de la consulta
		try {
			pstm = con.prepareStatement(sql);
			ResultSet rs= pstm.executeQuery();		//	Se ejecuta el procedimiento, Recibiendo los resultados 
													// en el objeto resulset	
			while(rs.next()){							// Se recorre cada registro recuperado
				Object[] object =new Object[10];
				object[0] = rs.getString(1);
				object[1] = rs.getString(2);
				object[2] = rs.getString(3);
				object[3] = rs.getString(4);
				object[4] = rs.getString(5);
				object[5] = rs.getString(6);
				object[6] = rs.getString(7);
				object[7] = rs.getString(8);
				object[8] = rs.getString(9);
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
