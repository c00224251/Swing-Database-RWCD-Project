package notatki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteAuthor
{

	public static void main(String[] args)
	{
		// database URL
		final String DATABASE_URL = "jdbc:mysql://localhost/books";

		String firstname = "Lisa";
		Connection connection = null;
		Statement statement = null;

		try
		{

			// establish connection to database
			connection = DriverManager.getConnection(DATABASE_URL, "root", "password");

			// create Statement for querying database
			statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM Authors WHERE FirstName='" + firstname + "' ");

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