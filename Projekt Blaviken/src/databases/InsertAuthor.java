package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertAuthor
{

	public static void main(String[] args)
	{

		// database URL
		final String DATABASE_URL = "jdbc:mysql://localhost/books";

		Connection connection = null;
		Statement statement = null;
		String firstname = "ITC";
		String lastname = "Carlow";

		try
		{

			// establish connection to database
			connection = DriverManager.getConnection(DATABASE_URL, "root", "password");

			// create Statement for querying database
			statement = connection.createStatement();

			// Insert Data into database
			// statement.executeUpdate("INSERT INTO Authors (FirstName, LastName)" + "
			// VALUES" + "('"+firstname+"', '"+lastname+"')");
			PreparedStatement pstat = connection
					.prepareStatement("INSERT INTO Authors (FirstName, LastName) VALUES (?,?)");
			pstat.setString(1, firstname);
			pstat.setString(2, lastname);
			pstat.executeUpdate();

		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		} finally
		{
			try
			{
				statement.close();
				connection.close();
			} catch (Exception exception)
			{
				exception.printStackTrace();
			}
		}
	} // end main
} // end class