package WIP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test1connection
	{
		static Connection getConnection()
			{
				Connection con = null;
				String url = "jdbc:mysql://localhost:3306/PROJ3KT?useSSL=false"; //insecure connection
				String user = "PROJ3KT";
				String password = "projekt"; //password set at installation
				try //use try to make sure connection turns off when app quits
					{
						con = DriverManager.getConnection(url, user, password); //establish a connection to the database using getConnection()
					} catch (SQLException ex) // in case of exception, log error. Display it in terminal.
					{
						Logger.getLogger(test1app.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
					}
				return con;
			}
	}
