import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServerConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionUrl = "jdbc:sqlserver://DESKTOP-VJQQFEF;database=AdventureWorks2022;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true";
		Connection connection = DriverManager.getConnection(connectionUrl);
		String query ="select p.FirstName,p.LastName, pp.PhoneNumber, p.PersonType from [Person].[PersonPhone] pp\r\n"
				+ "Join [Person].[Person] p On pp.BusinessEntityID= p.BusinessEntityID";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet results = statement.executeQuery();
		//System.out.println("FirstName" + "   " + "LastName" + "          " + "PhoneNumber");
		int count=0;
		while (results.next()) {
			String s= results.getString("PhoneNumber");
			s.substring(2,s.length());
		System.out.println(results.getString("FirstName") 
			+"     "+results.getString("LastName")+"     "+ s);
			//results.getInt("PhoneNumber");
		count++;
		}
		System.out.println(count);
	}

}
