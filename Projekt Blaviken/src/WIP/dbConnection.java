package WIP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

public class dbConnection
	{
		public static void main(String[] args)
			{
				
				String url = "localhost:port/nazwa bazy danych?unsecure SSL";
				String user = "C00224251@itcarlow.ie";
				String password = "1234567"; //password used at installation
				String query = "SELECT VERSION()";
				// establish a connection to the database using getConnection()
				try (Connection con = DriverManager.getConnection(url, user, password);
						Statement st = con.createStatement(); //creates a statement object for sending SQL Statements
						ResultSet rs = st.executeQuery(query);) //Executes the SQL Statement, returns 
																//ResultSet object(data returned by statement)
					{	// ResultSet selects row 0 (nothing)
						if (rs.next()) // moves selection to row 1
							{ //retrieves value of row 1
								System.out.print(rs.getString(1));

							}
					} catch (SQLException ex) // in case of exception, log error in terminal
					{								// class name
						Logger lgr = Logger.getLogger(dbConnection.class.getName());
						lgr.log(Level.SEVERE, ex.getMessage(), ex);
					}
			}
	}
