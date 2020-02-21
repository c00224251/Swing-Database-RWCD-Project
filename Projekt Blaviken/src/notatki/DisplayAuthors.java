package notatki;

//Displaying the contents of the Authors table .
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DisplayAuthors
{

	// database URL
	static final String DATABASE_URL = "jdbc:mysql://localhost/db";

	public static void main(String args[])
	{

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try
		{
			// establish connection to database
			connection = DriverManager.getConnection(DATABASE_URL, "root", "password");

			// create Statement for querying database
			statement = connection.createStatement();

			// query database
			resultSet = statement.executeQuery("SELECT column1, column2, column3 FROM Table");

			// process query results
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			System.out.println("Authors Table of Books Database:\n");
			for (int i = 1; i <= numberOfColumns; i++)
				System.out.print(metaData.getColumnName(i) + "\t");
			System.out.println();
			while (resultSet.next())
			{
				for (int i = 1; i <= numberOfColumns; i++)
					System.out.print(resultSet.getObject(i) + "\t\t");
				System.out.println();
			}
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		} finally
		{
			try
			{
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception exception)
			{
				exception.printStackTrace();
			}
		}
	} // end main
} // end class