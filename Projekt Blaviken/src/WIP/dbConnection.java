package WIP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbConnection
	{
		public static void main(String[] args)
			{
				
				String url = "jdbc:mysql://78.153.200.61:3306/PROJ3KT?useSSL=false";
				String user = "PROJ3KT";
				String password = "projekt"; //password used at installation
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
