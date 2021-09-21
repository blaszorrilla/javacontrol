package configuracion;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {

	public Test() throws SQLException {
		// TODO Auto-generated constructor stub
		Connection con= Conexion.getConnection();
		con.close();
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Test t=new Test();
	}

}
