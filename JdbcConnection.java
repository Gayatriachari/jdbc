package preparedStaJDBC;
import java.sql.*;

public class JdbcConnection {
    private JdbcConnection() {
    	
    }
	public static Connection getJdbcConnection() throws SQLException { 
		Connection connection=null;
		
		String url="jdbc:mysql://localhost:3306/enterprice_java"; 
		String user="root";
		String password="Achari@2001"; 
		connection=DriverManager.getConnection(url, user, password);
		if(connection!=null) 
		    return connection;
		return connection;
   } 
   public static void jdbsClose(ResultSet resultSet, Statement statement,Connection connection) throws SQLException {
	   if(resultSet!=null)
		   resultSet.close(); 
	   if(statement!=null)
		   statement.close();
	   if(connection!=null)
		   connection.close(); 
	   System.out.println("Thankyou! Application terminated.");
   }

}
