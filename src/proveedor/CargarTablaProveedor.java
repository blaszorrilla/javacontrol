package proveedor;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import configuracion.Conexion;

public class CargarTablaProveedor {
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
	    		 PreparedStatement pstm = con.getConnection().prepareStatement("SELECT COUNT(1) AS total FROM proveedor WHERE razon LIKE '%' '"+dato+"' '%' ");
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
	           PreparedStatement pstm = con.getConnection().prepareStatement("SELECT id_proveedor,ruc,razon,nomape,direccion,telefono,email FROM proveedor WHERE razon like '%' '"+dato+"' '%'");
	           ResultSet res = pstm.executeQuery();
	           int i = 0;
	           while(res.next()){
	              String estCodigo = res.getString(1);
	              String estRuc = res.getString(2);
	              String estRazon = res.getString(3);
	              String estNomape = res.getString(4);
	              String estDireccion = res.getString(5);
	              String estTelefono = res.getString(6);
	              String estEmail = res.getString(7);
	              
	              data[i][0] = estCodigo;            
	              data[i][1] = estRuc;            
	              data[i][2] = estRazon;
	              data[i][3] = estNomape;
	              data[i][4] = estDireccion;
	              data[i][5] = estTelefono;
	              data[i][6] = estEmail;	              
	              i++;
	           }
	           res.close();
	            }catch(SQLException e){
	           System.out.println(e);
	      }
	      return data;
	   }


}
