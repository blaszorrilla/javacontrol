package configuracion;
/*
 * Conexion a la Base de Datos
 * */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {		
   private final static String bd = "javacontrol";						//	Aqui Definimos la Base de Datos
   private final static String login = "root";							//	Aqui Definimos el usuario de la Base de Datos
   private final static String password = "1234";						//	Aqui Definimos la contraseña de la Base de Datos
   private final static String url = "jdbc:mysql://localhost/"+bd;		//	Aqui Definimos nuestro Servidor
    
   public static Connection getConnection(){
      try{
         Class.forName("com.mysql.jdbc.Driver");         
         Connection conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("Conectado a la base de datos ["+bd+"]");
         }
         return conn;
      }catch(SQLException e){
        // System.err.println(e.getMessage());
         System.out.println("Conexion Fallida");
      }catch(ClassNotFoundException e){
         System.err.println(e.getMessage());
         System.out.println("Conexion Fallida");
      }finally{
    	  System.out.println("Conexion Realizada");
      }
      return null;
   }
}