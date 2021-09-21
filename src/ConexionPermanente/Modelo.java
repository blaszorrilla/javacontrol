package ConexionPermanente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo {
	public void Filtro(String sql,Connection con){
			PreparedStatement pstm = null;
			try {
				pstm = con.prepareStatement(sql);
				ResultSet rs= pstm.executeQuery();
				while(rs.next()){
					System.out.println("valor-> "+rs.getString(1));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage() );   
			}finally{
				System.out.println( "cierra conexion a la base de datos" );    
	            try {
	                if(pstm!=null) pstm.close();                
	           } catch (SQLException ex) {
	                System.err.println( ex.getMessage() );    
	            }
			}
	}
}
