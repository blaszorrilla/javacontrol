package proveedor;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import configuracion.Conexion;

	public class ProveedorAbmProceso {
		public String mensaje_proceso="";
		public String elemento_acceso="";
		public String tipo_proceso="";
		public String Nuevo(){
			String valor="";
			Connection con= Conexion.getConnection();
			PreparedStatement pstm = null;
			try {
				pstm = con.prepareStatement("SELECT IFNULL(MAX(id_proveedor),0)+1 AS codigo FROM proveedor");
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
		public void guadar(String codigo,String ruc,String razon,String nomape,String direccion,String telefono,String email){
			Connection con= Conexion.getConnection();
			Statement sts=null;
			try {
				sts= con.createStatement(); //,ci,nombre,apellido,direccion,email,rol,usu,pass,estado
				sts.executeUpdate("INSERT INTO proveedor(id_proveedor,ruc,razon,nomape,direccion,telefono,email) VALUES"
						+ "("+codigo+",'"+ruc+"','"+razon+"','"+nomape+"','"+direccion+"','"+telefono+"','"+email+"')");
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
		public void modificar(String codigo,String ruc,String razon,String nomape,String direccion,String telefono,String email){
			Connection con= Conexion.getConnection();
			Statement sts=null;
			try {
				sts= con.createStatement(); //,ci,nombre,apellido,direccion,email,rol,usu,pass,estado
				sts.executeUpdate("UPDATE proveedor SET ruc='"+ruc+"',razon='"+razon+"',nomape='"+nomape+"',direccion='"+direccion+"',telefono='"+telefono+"',email='"+email+"' WHERE id_proveedor="+codigo);
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
				sts.executeUpdate("DELETE FROM proveedor WHERE id_proveedor="+codigo);
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
		public String ValidarCampos(String codigo,String ruc,String razon,String nomape,String direccion,String telefono,String email){
			String valor="NO";
			if(ruc.equals("")){
				valor="SI";
				mensaje_proceso="DEBE INGRESAR R.U.C.";
				elemento_acceso="ci";
			}else{
				if(razon.equals("")){
					valor="SI";
					mensaje_proceso="DEBE INGRESAR RAZON SOCIAL";
					elemento_acceso="nombre";
				}else{
					if(nomape.equals("")){
						valor="SI";
						mensaje_proceso="DEBE INGRESAR NOMBRE Y APELLIDO";
						elemento_acceso="apellido";
					}else{
						if(codigo.equals("0")){
							tipo_proceso="NUEVO";
						}else{
							tipo_proceso="MODIFICAR";
						}
					}
				}
			}
			return valor;
		}
}
