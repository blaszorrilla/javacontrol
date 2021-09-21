package acceso;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import configuracion.Conexion;

public class CargarTablaAcceso {
	public Object [][] getDatos(String dato){ //es un metodo de tipo array que yo creo y puede tener cualquier nombre
		Conexion con=new Conexion();//se crea un objeto de coneccion a la base de datos
	      int registros = 0;
	      //obtenemos la cantidad de registros existentes en la tabla
	      try{ 
	    	  /**Se crea una variable donde se prepara la consulta
	    	   * Tipo del objeto PreparedStatement
	    	   * Se inicializa la variable conectando a la BD y preparando la consulta sql
	    	   * Se ejecuta la consulta y se guarda en un objeto de tipo resulset
	    	   * Del Objeto resulset se quita el resultado de la consulta en una variable
	    	   * Se cierra el Objeto resulset  */
	    	 if(dato.equals("")){
	    		 //JOptionPane.showMessageDialog(null, "no hay datos");
	    		 
	    	 }else{
	    		 PreparedStatement pstm = con.getConnection().prepareStatement("SELECT COUNT(1) as total FROM acceso WHERE nombre LIKE '%' '"+dato+"' '%' OR apellido LIKE '%' '"+dato+"' '%'");
		    	 ResultSet res = pstm.executeQuery();
		         res.next();
		         registros = res.getInt("total");
		         res.close();
	    	 }
	    	 
	      }catch(SQLException e){
	    	  /**Si ocurre un error con la coneccion*/
	         System.out.println(e);
	      }
	      
	      //Se crea un objeto de array bidimensional cuyo tamaño es la cantidad de registro de la BD y la cantidad de columnas de la tabla.
	      Object[][] data = new String[registros][10];  
	      //realizamos la consulta sql y llenamos los datos en "Object"
	        try{
	           PreparedStatement pstm = con.getConnection().prepareStatement("SELECT id_acceso,ci,nombre,apellido,direccion,email,rol,usu,pass,estado FROM acceso WHERE nombre like '%' '"+dato+"' '%' OR apellido like '%' '"+dato+"' '%'");
	           ResultSet res = pstm.executeQuery();
	           int i = 0;
	           while(res.next()){
	              String estCodigo = res.getString(1);
	              String estCi = res.getString(2);
	              String estNombre = res.getString(3);
	              String estApellido = res.getString(4);
	              String estDireccion = res.getString(5);
	              String estEmail = res.getString(6);
	              String estRol = res.getString(7);
	              String estUsu = res.getString(8);
	              String estPass = res.getString(9);
	              String estEstado = res.getString(10);
	              
	              data[i][0] = estCodigo;            
	              data[i][1] = estCi;            
	              data[i][2] = estNombre;
	              data[i][3] = estApellido;
	              data[i][4] = estDireccion;
	              data[i][5] = estEmail;
	              data[i][6] = estRol;
	              data[i][7] = estUsu;
	              data[i][8] = estPass;
	              data[i][9] = estEstado;
	              
	              i++;
	           }
	           res.close();
	            }catch(SQLException e){
	           System.out.println(e);
	      }
	      return data;
	   }


}
